package com.example.demo.repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
    //특정 카테고리명을 가진 장소 조회
    @Query("SELECT p FROM Place p JOIN p.categories c WHERE c.categoryName IN :categoryNames GROUP BY p HAVING COUNT(DISTINCT c) = :size")
    List<Place> findByCategoryNames(@Param("categoryNames") List<String> categoryNames, @Param("size") long size);



}
