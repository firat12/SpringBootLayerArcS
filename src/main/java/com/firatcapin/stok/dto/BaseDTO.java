package com.firatcapin.stok.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {
    private String message;
    private  Boolean status;
}
