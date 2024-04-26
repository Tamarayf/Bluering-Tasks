package com.example.task1bluering.DTO;

import lombok.Data;

import java.sql.Date;
@Data
public class UsersDTO {
    private Integer userId;
    private String usernames;
    private String password;
    private String dateofbirth;
}
