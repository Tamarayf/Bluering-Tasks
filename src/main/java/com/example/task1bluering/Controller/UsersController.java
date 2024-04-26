package com.example.task1bluering.Controller;

import com.example.task1bluering.DTO.UsersDTO;
import com.example.task1bluering.Entity.UsersEntity;
import com.example.task1bluering.Service.UsersService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;


    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @PostMapping("/")
    public Apiresponse createUser(@RequestBody UsersDTO usersDTO) {
        UsersEntity createdUser = usersService.createUser(usersDTO);
        return new Apiresponse(true, "User created successfully", createdUser.getUserId());
    }

    @PatchMapping("/{userId}")
    public Apiresponse updateUsers(@PathVariable Integer userId, @RequestBody Map<String, Object> updateFields) {
        try {
            usersService.updateUsers(userId, updateFields);
            return new Apiresponse(true, "User updated successfully", userId);
        } catch (ResourceNotFoundException e) {
            return new Apiresponse(false, "User not found with id: " + userId, null);
        }
    }



    @GetMapping("/")
    public List<UsersDTO> getUsers() {
        return usersService.getUsers();
    }

    @GetMapping("/{userId}")
    public Apiresponse getOneUser(@PathVariable Integer userId) {
        UsersDTO userDTO = usersService.getOneUser(userId);
        if (userDTO != null) {
            return new Apiresponse(true, "User found", userDTO);
        } else {
            return new Apiresponse(false, "User not found", null);
        }
    }


    @DeleteMapping("/{userId}")
    public Apiresponse deleteUser(@PathVariable Integer userId) {
        Integer deletedUserId = usersService.deleteUser(userId);
        if (deletedUserId != null) {
            return new Apiresponse(true, "User deleted successfully", deletedUserId);
        } else {
            return new Apiresponse(false, "User not found with id: " + userId);
        }
    }
}
