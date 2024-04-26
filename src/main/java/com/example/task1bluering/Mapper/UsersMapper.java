package com.example.task1bluering.Mapper;
import com.example.task1bluering.DTO.UsersDTO;
import com.example.task1bluering.Entity.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper


public interface UsersMapper {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    UsersDTO usersEntityToUsersDTO(UsersEntity usersEntity);
    UsersEntity  usersDTOToUsersEntity ( UsersDTO usersDTO);



}
