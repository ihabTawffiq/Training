package com.example.demo.services.impl;

import com.example.demo.DemoApplication;
import com.example.demo.dao.FileDataRepository;
import com.example.demo.dto.ApiResponse;
import com.example.demo.entities.FileData;
import com.example.demo.handlers.ResponseHandler;
import com.example.demo.services.FileDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileDataServiceImpl implements FileDataService {

    private final FileDataRepository fileDataRepository;
    private final ResponseHandler responseHandler;
    private static final Logger logger = LogManager.getLogger(FileDataServiceImpl.class);


    public FileDataServiceImpl(FileDataRepository fileDataRepository, ResponseHandler responseHandler) {
        this.fileDataRepository = fileDataRepository;
        this.responseHandler = responseHandler;
    }

    @Override
    public ApiResponse<FileData> save(FileData fileData) {
        try {
            fileDataRepository.save(fileData);
            logger.info("Adding New File With Email : "+fileData.getMail());
            return responseHandler.reportSuccess(200,"File Added Successfully",fileData);
        }catch (Error | Exception e){
            logger.error(e.getLocalizedMessage());
            return responseHandler.reportFailure(500,"File Not Added",fileData);
        }

    }

    @Override
    public ApiResponse<FileData> findById(Long fileDataId) {
        try {
            logger.info("Finding File By Id : "+fileDataId);
            return responseHandler.reportSuccess(200,
                    "File Retrieved Successfully",
                    fileDataRepository.findById(fileDataId));
        }catch (Error | Exception e){
            logger.error(e.getLocalizedMessage());
            return responseHandler.reportFailure(404,
                    "File Not Found",
                    fileDataId);
        }
    }

    @Override
    public ApiResponse<Integer> deleteById(Long fileDataId) {
        try {

            logger.info("Deleting File By Id : "+fileDataId);
            return responseHandler.reportSuccess(200
                    ,"File Deleted Successfully"
                    ,fileDataRepository.deleteById(fileDataId));

        }catch (Error | Exception e){
            logger.error(e.getLocalizedMessage());
            return responseHandler.reportFailure(500,"File Not Deleted",fileDataId);
        }
    }

    @Override
    public ApiResponse<List<FileData>> findAll() {
        try {

            logger.info("Finding All Files");
            return responseHandler.reportSuccess(200
                    ,"All Filed Retrieved Successfully"
                    ,fileDataRepository.findAll());

        }catch (Error | Exception e){
            logger.error(e.getLocalizedMessage());
            return responseHandler.reportFailure(500,"Files Not Found",null);
        }
    }
}
