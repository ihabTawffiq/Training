package com.example.demo.dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T> {
    private Integer statusCode;
    private Boolean success;
    private String message;
    private T data;
}
