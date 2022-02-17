package com.example.demo;

import lb.spring.dto.UserDto;
import lb.spring.entities.UserEntity;
import lb.spring.services.UserService;
import lb.spring.services.UserServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(classes = UserServiceImp.class)
@RunWith(SpringRunner.class)
public class UserServiceTests  {
    @Autowired
    UserService userService;

    @Test
    public void testAddUser() {
        UserDto userDto=new UserDto();
       assertNotNull( userService.addUser(userDto));
    }

    @Test
    public void testUpdateUser() {
        UserDto userDto=new UserDto();
        assertNotNull(userService.addUser(userDto));
    }

    @Test
    public void testGetUserById() {
        assertNotNull(userService.getUserById(16) );

    }

    @Test
    public void getAllUsers() {

    }

    @Test
    public void deleteUser() {

    }

    @Test
    public void getUserByEmail() {

    }

    @Test
    public void updatePassword() {

    }

    @Test
    public void loadUserByUsername() {

    }
}
