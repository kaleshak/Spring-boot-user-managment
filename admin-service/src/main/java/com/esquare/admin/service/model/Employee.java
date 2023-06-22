package com.esquare.admin.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;
    private Long userId;
    private String assessment;
    private Date date;
    private String type;
}
