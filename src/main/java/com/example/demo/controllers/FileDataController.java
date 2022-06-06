package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entities.FileData;
import com.example.demo.services.FileDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fileData")
public class FileDataController {

    private final FileDataService fileDataService;

    public FileDataController(FileDataService fileDataService) {
        this.fileDataService = fileDataService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<FileData>> findFileDataById(@PathVariable("id") Long id){
        return ResponseEntity.ok(fileDataService.findById(id));
    }
    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<FileData>>> findAllFilesData(){
        return ResponseEntity.ok(fileDataService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Integer>> deleteFileDataById(@PathVariable("id") Long id){
        return ResponseEntity.ok(fileDataService.deleteById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<FileData>> deleteFileDataById(@RequestBody FileData fileData){
        return ResponseEntity.ok(fileDataService.save(fileData));
    }
}
