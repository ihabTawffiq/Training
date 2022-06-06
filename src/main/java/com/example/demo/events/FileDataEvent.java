package com.example.demo.events;

import com.example.demo.entities.FileData;
import com.example.demo.dao.FileDataRepository;
import com.example.demo.services.FileReaderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class FileDataEvent {

    private final FileDataRepository fileDataRepository;
    private final FileReaderService fileReaderService;

    @Value("${file.path}")
    private String filePath  ;

    final ExecutorService executor = Executors.newFixedThreadPool(5);

    public FileDataEvent(FileDataRepository fileDataRepository, FileReaderService fileReaderService) {
        this.fileDataRepository = fileDataRepository;
        this.fileReaderService = fileReaderService;
    }


    @EventListener
    public void readFileData(ApplicationReadyEvent event) throws IOException {
        BufferedReader reader = fileReaderService.readFile(filePath) ;
        reader.lines().forEach(line -> {
             executor.submit(() -> {
                String[] array = line.split(",");
                fileDataRepository.save(FileData.builder()
                        .name(array[1])
                        .mobile(array[2])
                        .mail(array[3])
                        .creationDate(new Date())
                        .build());
            });
        });
        reader.close();
    }
}
