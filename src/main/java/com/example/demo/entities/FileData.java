package com.example.demo.entities;

import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class FileData {
    private Long id;
    private String name;
    private String mobile;
    private String mail;
    private Date creationDate;

}
