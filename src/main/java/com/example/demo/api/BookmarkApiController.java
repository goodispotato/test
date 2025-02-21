package com.example.demo.api;

import com.example.demo.dto.BookmarkDto;
import com.example.demo.entity.Bookmark;
import com.example.demo.entity.User;
import com.example.demo.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookmarkApiController {
    @Autowired
    private BookmarkService bookmarkService;
    @Autowired
    private JwtTokenProvider jwtUtil;



    @PostMapping("/bookmarks")
    public ResponseEntity<Bookmark> save(@RequestHeader("Authorization") String token, @RequestBody BookmarkDto bookmarkDto) {

        String jwt = token.substring(7);
        String email = jwtUtil.extractEmail(jwt);

        User user = userService.findByUserEmail(emial).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 유저를 찾을 수 없습니다."));

        Bookmark saved = bookmarkService.save(user, bookmarkDto);
        return (saved!=null) ?
                ResponseEntity.status(HttpStatus.OK).body(saved) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 좋아요 취소
    @DeleteMapping("/bookmarks/{id}")
    public ResponseEntity<Bookmark> delete(@PathVariable Integer id) {
        Bookmark deleted = bookmarkService.delete(id);
        return (deleted!=null)?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() : //북마크가 있다면 삭제됐으니 no content
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); //북마크가 없다면 삭제 못했다는 뜻
    }
}
