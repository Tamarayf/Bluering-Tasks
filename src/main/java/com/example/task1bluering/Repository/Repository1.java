package com.example.task1bluering.Repository;


import com.example.task1bluering.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface Repository1 extends JpaRepository<UsersEntity,Integer> {
}
