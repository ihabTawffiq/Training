package com.example.demo.handlers;

import com.example.demo.dto.ApiResponse;
import org.springframework.stereotype.Component;

@Component
public class ResponseHandler {
    public ApiResponse reportSuccess(Integer statusCode, String message , Object data){
        return ApiResponse
                .builder()
                .success(true)
                .statusCode(statusCode)
                .message(message)
                .data(data)
                .build();
    }
    public ApiResponse reportFailure(Integer statusCode, String message , Object data){
        return ApiResponse
                .builder()
                .success(false)
                .statusCode(statusCode)
                .message(message)
                .data(data)
                .build();
    }
}
