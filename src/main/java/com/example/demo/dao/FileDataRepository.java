package com.example.demo.dao;

import com.example.demo.entities.FileData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDataRepository {

    FileData save(FileData fileData);
    FileData findById(Long fileDataId);
    Integer deleteById(Long fileDataId);
    List<FileData> findAll();
}
