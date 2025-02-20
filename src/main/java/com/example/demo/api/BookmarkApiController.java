package com.example.demo.api;

import com.example.demo.dto.BookmarkDto;
import com.example.demo.entity.Bookmark;
import com.example.demo.service.BookmarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BookmarkApiController {

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping("/bookmarks")
    public ResponseEntity<Bookmark> save(@RequestBody BookmarkDto bookmarkDto) {
        Bookmark saved = bookmarkService.save(bookmarkDto);
        return (saved!=null) ?
                ResponseEntity.status(HttpStatus.OK).body(saved) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
