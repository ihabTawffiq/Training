package com.example.demo.dao;

import com.example.demo.DemoApplication;
import com.example.demo.entities.FileData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import java.util.List;

@Repository
public class FileDataRepositoryImpl implements FileDataRepository{
    private static final String INSERT_FILE_DATA_QUERY="INSERT INTO FILE_DATA_TEST(CREATION_DATE,MAIL,MOBILE,NAME) values(?,?,?,?)";
    private static final String GET_ONE_FILE_DATA_QUERY="SELECT * FROM FILE_DATA_TEST WHERE ID=?";
    private static final String DELETE_ONE_FILE_DATA_QUERY="DELETE FROM FILE_DATA_TEST WHERE ID=?";
    private static final String GET_ALL_FILES_DATA_QUERY="SELECT * FROM FILE_DATA_TEST";

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LogManager.getLogger(FileDataRepositoryImpl.class);


    public FileDataRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public FileData save(FileData fileData) {
        try {
            int result  = jdbcTemplate.update(INSERT_FILE_DATA_QUERY,
                    fileData.getCreationDate(),
                    fileData.getMail(),
                    fileData.getMobile(),
                    fileData.getName());
            if (result==1)
            {
                logger.info("File Data Saved with Email : "+fileData.getMail());
            }else {
                logger.error("File Not Added !");
            }
            return fileData;
        }catch (Error | Exception e){
            logger.error(e.getLocalizedMessage());
            return null;
        }

    }

    @Override
    public FileData findById(Long fileDataId) {
        try {
            logger.info("Finding File By Id : "+ fileDataId);
            return jdbcTemplate.queryForObject(GET_ONE_FILE_DATA_QUERY,(rs, rowNum) -> {
                return FileData
                        .builder()
                        .id(rs.getLong("ID"))
                        .mail(rs.getString("MAIL"))
                        .creationDate(rs.getDate("CREATION_DATE"))
                        .mobile(rs.getString("MOBILE"))
                        .name(rs.getString("NAME"))
                        .build();
            },fileDataId);
        }catch (Error | Exception e){
            logger.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Integer deleteById(Long fileDataId) {
        try {
            logger.info("Deleting File By Id : "+ fileDataId);
            return jdbcTemplate.update(DELETE_ONE_FILE_DATA_QUERY,fileDataId);
        }catch (Error | Exception e){
            logger.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<FileData> findAll() {
        try {
            logger.info("Finding All Files");
            return jdbcTemplate.query(GET_ALL_FILES_DATA_QUERY,(rs, rowNum) -> {
                return FileData
                        .builder()
                        .id(rs.getLong("ID"))
                        .mail(rs.getString("MAIL"))
                        .creationDate(rs.getDate("CREATION_DATE"))
                        .mobile(rs.getString("MOBILE"))
                        .name(rs.getString("NAME"))
                        .build();
            });
        }catch (Error | Exception e){
            logger.error(e.getLocalizedMessage());
            return null;
        }
    }
}
