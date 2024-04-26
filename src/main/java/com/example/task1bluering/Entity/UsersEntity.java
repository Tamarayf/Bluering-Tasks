package com.example.task1bluering.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "users", schema = "internship", catalog = "")
public class UsersEntity {
    @Id@Column(name = "UserId")
    private int userId;
    @Basic@Column(name = "usernames")
    private String usernames;
    @Basic@Column(name = "password")
    private String password;
    @Basic@Column(name = "dateofbirth")
    private String dateofbirth;

}
