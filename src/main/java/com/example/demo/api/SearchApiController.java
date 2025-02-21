package com.example.demo.api;

import com.example.demo.entity.Bookmark;
import com.example.demo.entity.Place;
import com.example.demo.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchApiController {
    @Autowired
    private PlaceService placeService;

    @GetMapping("/place/{search}")
    public ResponseEntity<List<Place>> searchPlaces(@PathVariable String search) {
        List<Place> searchedPlaces=placeService.searchPlacesByCategoryName(search);
        return ResponseEntity.status(HttpStatus.OK).body(searchedPlaces);
    }
}
