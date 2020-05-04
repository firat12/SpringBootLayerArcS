package com.firatcapin.stok.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDetailDTO {
    private Long id;
    private String title;
    private String summary;
    private String description;
    private String year;
    private String email;
    private String phone;
    private Date createdTime;
    private Date updatedTime;
    private Boolean isActive;
}
