package com.example.demo.service;


import com.example.demo.dto.BookmarkDto;
import com.example.demo.entity.Member;
import com.example.demo.repository.BookmarkRepository;
import com.example.demo.repository.FolderRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.entity.Bookmark;
import com.example.demo.entity.Folder;
import com.example.demo.entity.Place;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookmarkService {
    @Autowired
    private BookmarkRepository bookmarkRepository;
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private MemberRepository memberRepository;

    public Bookmark save(BookmarkDto bookmarkDto) {
        Member member = memberRepository.findById(bookmarkDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));
        Place place = placeRepository.findById(bookmarkDto.getPlaceId()).orElseThrow(() -> new IllegalArgumentException("장소를 찾을 수 없습니다."));
        Folder folder=folderRepository.findById(bookmarkDto.getFolderId()).orElseThrow(() -> new IllegalArgumentException("저장 목록을 찾을 수 없습니다."));

        Bookmark bookmark = Bookmark.creteBookmark(bookmarkDto, member, place, folder);

        return bookmarkRepository.save(bookmark);
    }
}
