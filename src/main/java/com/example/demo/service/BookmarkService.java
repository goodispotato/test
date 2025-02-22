package com.example.demo.service;


import com.example.demo.dto.BookmarkDto;
import com.example.demo.entity.User;
import com.example.demo.repository.BookmarkRepository;
import com.example.demo.repository.FolderRepository;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.entity.Bookmark;
import com.example.demo.entity.Folder;
import com.example.demo.entity.Place;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;
    @Autowired
    private  FolderRepository folderRepository;

    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private UserRepository userRepository;

    public Bookmark save(BookmarkDto bookmarkDto) {
        User user= userRepository.findById(bookmarkDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));
        Place place = placeRepository.findById(bookmarkDto.getPlaceId()).orElseThrow(() -> new IllegalArgumentException("장소를 찾을 수 없습니다."));
        Folder folder=folderRepository.findById(bookmarkDto.getFolderId()).orElseThrow(() -> new IllegalArgumentException("저장 목록을 찾을 수 없습니다."));

        Bookmark bookmark = Bookmark.createBookmark(bookmarkDto, user, place, folder);

        return bookmarkRepository.save(bookmark);
    }

    public Bookmark delete(Integer id) {
        Bookmark target = bookmarkRepository.findById(id).orElse(null);

        if (target == null) {
            return null;
        }

        bookmarkRepository.delete(target);
        return target;
    }

    //저장 목록 내역 화면
    public List<Bookmark> showBookmarksInFolder(Integer folderId){
        Folder folder = folderRepository.findById(folderId).orElse(null);
        if(folder.getFolderId() == null){
            throw new IllegalArgumentException("없는 폴더입니다.");
        }
        return bookmarkRepository.findByFolder(folder);
    }
}
