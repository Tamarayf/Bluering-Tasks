package com.example.task1bluering.Service;

import com.example.task1bluering.DTO.UsersDTO;
import com.example.task1bluering.Entity.UsersEntity;
import com.example.task1bluering.Mapper.UsersMapper;
import com.example.task1bluering.Repository.Repository1;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private Repository1 Repository2;

    @Autowired
    private UsersMapper mapper;


    public UsersEntity createUser(UsersDTO usersDTO) {
        UsersEntity usersEntity = mapper.usersDTOToUsersEntity(usersDTO);
        UsersEntity savedUser = Repository2.save(usersEntity);
        return savedUser;
    }


    public void updateUsers(Integer userId, Map<String, Object> entityDto) {
        UsersEntity entityToUpdate = Repository2.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with number: " + userId));
        updateEntity(entityDto, entityToUpdate, UsersEntity.class);
        Repository2.saveAndFlush(entityToUpdate);
    }

    public void updateEntity(Map<String, Object> entityDTO, Object entityToUpdate, Class entityToUpdateClass) {
        entityDTO.forEach((k, v) -> {
            try {
                Field field = FieldUtils.getField(entityToUpdateClass, k, true);
                if (field != null) {
                    field.setAccessible(true);
                    field.set(entityToUpdate, v);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace(); // Handle the exception as needed
            }
        });
    }

    public List<UsersDTO> getUsers() {
        List<UsersEntity> usersEntities = Repository2.findAll();
        return usersEntities.stream()
                .map(usersEntity -> mapper.usersEntityToUsersDTO(usersEntity))
                .collect(Collectors.toList());
    }


    public UsersDTO getOneUser(Integer userId) {
        Optional<UsersEntity> userEntityOptional = Repository2.findById(userId);
        if (userEntityOptional.isPresent()) {
            UsersEntity userEntity = userEntityOptional.get();
            return mapper.usersEntityToUsersDTO(userEntity);
        } else {
            return null;
        }
    }

    public Integer deleteUser(Integer userId) {
        UsersEntity userToDelete = Repository2.findById(userId).orElse(null);
        if (userToDelete != null) {
            Repository2.delete(userToDelete);
            return userId;
        } else {
            return null;
        }
    }
}




