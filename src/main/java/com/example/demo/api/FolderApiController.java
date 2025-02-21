package com.example.demo.api;

import com.example.demo.dto.FolderDto;
import com.example.demo.entity.Bookmark;
import com.example.demo.entity.Folder;
import com.example.demo.service.BookmarkService;
import com.example.demo.service.FolderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FolderApiController {

    @Autowired
    private FolderService folderService;
    @Autowired
    private BookmarkService bookmarkService;


    // 폴더 생성
    @PostMapping("/folders")
    public ResponseEntity<Folder> create(@RequestBody FolderDto folderDto) {
        Folder created =folderService.create(folderDto);
        return (created!=null)?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 폴더 삭제
    @DeleteMapping("/folders/{id}")
    public ResponseEntity<Folder> delete(@PathVariable Integer id) {
        Folder deleted = folderService.delete(id);
        return (deleted!=null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build():
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 폴더 이름 변경
    @PatchMapping("/folders/{id}")
    public ResponseEntity<Folder> update(@PathVariable Integer id, @RequestBody FolderDto folderDto) {
        Folder updated = folderService.update(id, folderDto);
        return (updated!=null)?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }






}
