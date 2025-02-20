package com.example.demo.repository;

import com.example.demo.entity.Folder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface FolderRepository extends CrudRepository<Folder, Integer> {

    @Override
    ArrayList<Folder> findAll();
}
