package com.example.task1bluering.Service;

import com.example.task1bluering.DTO.UsersDTO;
import com.example.task1bluering.Entity.UsersEntity;

import java.util.List;
import java.util.Map;



public interface UsersService {
       UsersEntity createUser(UsersDTO usersDTO);

        void updateUsers(Integer userId, Map<String, Object> entityDto);

        List<UsersDTO> getUsers();

        UsersDTO getOneUser(Integer userId) ;

        Integer deleteUser(Integer userId);


}
