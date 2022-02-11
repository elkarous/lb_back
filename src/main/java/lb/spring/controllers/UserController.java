package lb.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.databind.ObjectMapper;

import lb.spring.dto.ResetPassword;
import lb.spring.dto.UserDto;
import lb.spring.entities.FileDB;
import lb.spring.repositories.FileDBRepository;
import lb.spring.services.FileStorageService;
import lb.spring.services.JwtUtil;
import lb.spring.services.PasswordServices;
import lb.spring.services.UserService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import javax.mail.MessagingException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordServices passwordServices;
	@Autowired
	FileStorageService fileStorageService ;
	@Autowired
	FileDBRepository fileDBRepository ;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/resetPassword")
    public void resetPassword(@RequestBody ResetPassword resetPassword) {
        String token = resetPassword.getToken();
        if (!jwtUtil.isTokenExpired(token)) {
            String email = jwtUtil.extractUsername(token);
            passwordServices.resetPassword(resetPassword, email);
        } else throw new RuntimeException("Token rxpired");

    }

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendHtmlEmail(@RequestBody String email) throws MessagingException {
        passwordServices.sendEmail(email);
        return ResponseEntity.ok("email send");
    }

    @PostMapping
    public UserDto addUser(@RequestPart(value = "userDto") String userDto,
            @RequestPart(value = "image", required = false) MultipartFile file) throws IOException {
    	UserDto user = new ObjectMapper().readValue(userDto,UserDto.class);
    	FileDB image=fileStorageService.store(file);
    	user.setImage(image);
    	return userService.addUser(user);
    }

    @PutMapping
    public UserDto updateUser(@RequestPart(value = "userDto") String userDto,
            @RequestPart(value = "image", required = false) MultipartFile file) throws IOException{
    	UserDto user = new ObjectMapper().readValue(userDto,UserDto.class);
    	FileDB image=fileStorageService.store(file);
    	user.setImage(image);
        return userService.updateUser(user);
    }
    @PostMapping("/add")
    public UserDto addUserWithoutImage(@RequestBody UserDto userDto) {
    	return userService.addUser(userDto);
    }
    @PutMapping("/update")
    public UserDto updateUserWithoutImage(@RequestBody UserDto userDto) {
    	return userService.updateUser(userDto);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable(name = "id") long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/getByEmail")
    public UserDto getUserByEmail(@RequestBody String email) {
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") long id) {
        userService.deleteUser(id);
    }
 
   
}
