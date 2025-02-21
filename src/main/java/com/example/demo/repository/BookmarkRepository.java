package com.example.demo.repository;

import com.example.demo.entity.Bookmark;
import com.example.demo.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

    List<Bookmark> findByFolder(Folder folder);
}
