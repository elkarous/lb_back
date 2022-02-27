package lb.spring.controllers;


import lb.spring.dto.StatUser;
import lb.spring.entities.*;
import lb.spring.exceptions.ApiResponseException;

import lb.spring.repositories.CampingRepository;
import lb.spring.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.databind.ObjectMapper;

import lb.spring.dto.ResetPassword;
import lb.spring.dto.UserDto;
import lb.spring.services.FileStorageService;
import lb.spring.services.JwtUtil;
import lb.spring.services.PasswordServices;
import lb.spring.services.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    FileStorageService fileStorageService;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    CampingRepository campingRepository;
    @Autowired
    RegionRepository regionRepository;
    @PostMapping("/resetPassword")
    public void resetPassword(@RequestBody ResetPassword resetPassword) {
        String token = resetPassword.getToken();
        if (Boolean.TRUE.equals(jwtUtil.isTokenExpired(token))) {
            String email = jwtUtil.extractUsername(token);
            passwordServices.resetPassword(resetPassword, email);
        } else throw new ApiResponseException("Token expired");

    }

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendHtmlEmail(@RequestBody String email) throws MessagingException {
        passwordServices.sendEmail(email);
        return ResponseEntity.ok("email send");
    }

    @PostMapping
    @ResponseBody
    public UserDto addUser(@RequestPart(value = "userDto") String userRequest,
                           @RequestPart(value = "image", required = false) MultipartFile file) throws IOException, ApiResponseException, MessagingException {
        UserDto userDto = new ObjectMapper().readValue(userRequest, UserDto.class);

        FileDB image = fileStorageService.store(file);
        userDto.setImage(image);
if (userDto.getRole()== Role.ADMIN){
    Optional<Region> region=regionRepository.findById(userDto.getRegion().getId());
    if(region.isPresent()) {
        userDto.setRegion(region.get());
    }
}
if(userDto.getRole()== Role.AGENT){
    Optional<Camping> camping=campingRepository.findById(userDto.getCamping().getId());
    if(camping.isPresent()) {
        userDto.setCamping(camping.get());
    }
}
        return userService.addUser(userDto);
    }

    @PutMapping
    public UserDto updateUser(@RequestPart(value = "userDto") String userDto,
                              @RequestPart(value = "image", required = false) MultipartFile file) throws IOException {
        UserDto user = new ObjectMapper().readValue(userDto, UserDto.class);
        FileDB image = fileStorageService.store(file);
        user.setImage(image);
        return userService.updateUser(user);
    }

    @PostMapping("/add")
    public UserDto addUserWithoutImage(@RequestBody UserDto userDto) throws MessagingException {
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
    @GetMapping("/region")
    public List<Region> getAllRegions() {
        return userService.getRegion();
    }
    @GetMapping("/camping/{region}")
    public List<Camping> getCampingByRegion(@PathVariable("region" )String region) {
        return userService.getCampingByRegion(region);
    }
    @GetMapping("/stat")
    public StatUser getStatistic() {
        return userService.getStat();
    }
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable(name = "id") String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/getByEmail")
    public UserDto getUserByEmail(@RequestBody String email) {
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") String id) {
        userService.deleteUser(id);
    }
@PostMapping("/reset/{id}")
    public void reset(@PathVariable(name = "id") String id,@RequestBody String password){
        userService.resetPassword(id,password);
}
    @GetMapping("agent/{region}")
    public List<UserEntity> getAllAgentByRegion(@PathVariable(name = "region") String region) {
        return userService.getAllAgentByRegion(region);
    }
    @GetMapping("role")
    public List<UserEntity> getAllUserByRole() {
        return userService.getAllByRole();
    }

}
