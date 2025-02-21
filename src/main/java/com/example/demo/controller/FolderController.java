package com.example.demo.controller;

import com.example.demo.entity.Bookmark;
import com.example.demo.entity.Folder;
import com.example.demo.repository.FolderRepository;
import com.example.demo.service.FolderService;
import com.example.demo.service.BookmarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
public class FolderController {
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private FolderService folderService;
    @Autowired
    private BookmarkService bookmarkService;

    @GetMapping("/folders")
    public String showFolders(Model model) {
        //1. 모든 폴더 데이터 가져오기
        List<Folder> folderEntityList = folderService.showFolders();
        //2. 모델에 데이터 등록하기
        model.addAttribute("folderList",folderEntityList);
        //3. 뷰 페이지 설정
        return "";
    }

    @GetMapping("/folders/{id}")
    public String showBookmarks(@PathVariable int id, Model model) {
        //1. id 조회해 데이터 가져오기
        Folder folderEntity = folderRepository.findById(id).orElse(null);
        List<Bookmark> bookmarksDtos = bookmarkService.showBookmarksInFolder(id);
        //2. 모델에 데이터 등록
        model.addAttribute("folder",folderEntity);
        model.addAttribute("bookmarkDtos",bookmarksDtos);
        //3. 뷰 페이지 반환
        return "";
    }
}
