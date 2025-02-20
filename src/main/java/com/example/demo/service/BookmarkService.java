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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class BookmarkService {
    @Autowired
    private BookmarkRepository bookmarkRepository;
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private PlaceRepository placeRepository;

    @Transactional
    public Bookmark save(User user, BookmarkDto bookmarkDto) {
        Place place = placeRepository.findById(bookmarkDto.getPlaceId()).orElseThrow(() -> new IllegalArgumentException("장소를 찾을 수 없습니다."));
        Folder folder=folderRepository.findById(bookmarkDto.getFolderId()).orElseThrow(() -> new IllegalArgumentException("저장 목록을 찾을 수 없습니다."));

        Bookmark bookmark = Bookmark.creteBookmark(bookmarkDto, user, place, folder);

        return bookmarkRepository.save(bookmark);
    }
}
