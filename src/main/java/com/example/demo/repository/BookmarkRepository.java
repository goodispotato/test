package com.example.demo.repository;

import com.example.demo.entity.Bookmark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends CrudRepository<Bookmark, Integer> {

}
