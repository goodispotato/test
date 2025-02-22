package com.example.demo.controller;

import com.example.demo.entity.Place;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class SearchController {
    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("/place/search")
    public String searchPlaces(@RequestParam List<String> categories,Model model) {
        List<Place> places = placeRepository.findByCategoryNames(categories, categories.size());
        model.addAttribute("places", places);
        return "";
    }


}
