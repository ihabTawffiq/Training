package com.example.demo.services;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entities.FileData;

import java.util.List;

public interface FileDataService {
    ApiResponse<FileData> save(FileData fileData);
    ApiResponse<FileData>  findById(Long fileDataId);
    ApiResponse<Integer>  deleteById(Long fileDataId);
    ApiResponse<List<FileData>> findAll();
}
