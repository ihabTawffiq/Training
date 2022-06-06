package com.example.demo.services;

import com.example.demo.dao.FileDataRepository;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entities.FileData;
import com.example.demo.services.FileDataService;
import org.hibernate.mapping.Any;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.when;



@RunWith(SpringRunner.class)
@SpringBootTest
public class FIleDataServiceUnitTest {
    @Autowired
    private FileDataService fileDataService;


    @MockBean
    private FileDataRepository fileDataRepository;

    @Test
    public void saveFileSuccessScenario(){
        FileData expectedResult = FileData
                .builder()
                .name("Test From Unit Test 2")
                .mobile("01111222333")
                .mail("test@test.com")
                .creationDate(new Date())
                .build();

        Mockito.when(fileDataRepository.save(expectedResult))
                .thenReturn(expectedResult);

        FileData actuallyResult = fileDataService.save(expectedResult).getData();

        Assert.assertEquals(expectedResult.getMail(),actuallyResult.getMail());
        Assert.assertEquals(expectedResult.getName(),actuallyResult.getName());
        Assert.assertEquals(expectedResult.getMobile(),actuallyResult.getMobile());
        Assert.assertEquals(expectedResult.getCreationDate(),actuallyResult.getCreationDate());
    }


    @Test
    public void getFileByIdSuccessScenario(){
        FileData expectedResult = FileData
                .builder()
                .name("Test From Unit Test Find By Id")
                .mobile("01111222333")
                .mail("test@test.com")
                .creationDate(new Date())
                .build();

        Mockito.when(fileDataRepository.findById(12L))
                .thenReturn(expectedResult);

        FileData actuallyResult = fileDataService.findById(12L).getData();

        Assert.assertEquals(expectedResult,actuallyResult);
    }
}



































