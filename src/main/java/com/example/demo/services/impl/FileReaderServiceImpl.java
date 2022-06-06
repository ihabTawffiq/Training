package com.example.demo.services.impl;

import com.example.demo.services.FileReaderService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public BufferedReader readFile(String filePath) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath));
    }
}
