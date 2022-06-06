package com.example.demo.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public interface FileReaderService {
    BufferedReader readFile(String filePath) throws FileNotFoundException;
}
