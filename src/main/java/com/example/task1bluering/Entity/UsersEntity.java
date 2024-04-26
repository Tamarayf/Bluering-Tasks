package com.example.task1bluering.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Objects;


//import java.util.Date;


@Data
@Entity
@Table(name = "users", schema = "internship", catalog = "")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id@Column(name = "userId")
    private Integer userId;

    @Basic@Column(name = "usernames")
    private String usernames;


    @Basic@Column(name = "password")
    private String password;

    @Basic@Column(name = "dateofbirth")
    private String dateofbirth;


}
