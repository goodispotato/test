package com.example.demo.controller;

import com.example.demo.entity.Place;
import com.example.demo.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class PlaceController {
    @Autowired
    private PlaceService placeService;
    // 정보 상세 페이지
    @GetMapping("/place/{id}")
    public String showPlaceDetail(@PathVariable Integer id,Model model) {
        Place place = placeService.showPlacePageById(id);
        model.addAttribute("place", place);
        return "";
    }
}
