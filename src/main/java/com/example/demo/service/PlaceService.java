package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Place;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.PlaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Place> searchPlacesByCategories(List<String> categoryNames) {
        return placeRepository.findByCategoryNames(categoryNames, categoryNames.size());
    }

}
