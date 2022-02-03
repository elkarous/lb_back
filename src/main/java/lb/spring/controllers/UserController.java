package lb.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lb.spring.dto.ResetPassword;
import lb.spring.dto.UserDto;
import lb.spring.security.SecurityConstants;
import lb.spring.services.JwtUtil;
import lb.spring.services.PasswordServices;
import lb.spring.services.UserService;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
   UserService userService;
   @Autowired
   PasswordServices passwordServices;
  

@Autowired
JwtUtil jwtUtil; 

   @PostMapping("/resetPassword")
   public void resetPassword(@RequestBody ResetPassword resetPassword) {
	  String token=resetPassword.getToken();
	 if(!jwtUtil.isTokenExpired(token)){
		 String email = jwtUtil.extractUsername(token);
		 passwordServices.resetPassword(resetPassword, email);	 
	 }else throw new  RuntimeException("Token rxpired");
		

	  
	   
   }
   @PostMapping("/sendEmail")
   public ResponseEntity<String> sendHtmlEmail(@RequestBody String email) throws MessagingException {
	   passwordServices.sendEmail(email);
	 return  ResponseEntity.ok("email send");
   }

@PostMapping
public UserDto addUser(@RequestBody UserDto user) {
	return userService.addUser(user);
}
@PutMapping
public UserDto updateUser(@RequestBody UserDto user){
    return userService.updateUser(user);
}
@GetMapping
    public List<UserDto> getAllUsers(){
    return userService.getAllUsers();
}
@GetMapping("/{id}")
    public UserDto getUserById(@PathVariable(name = "id") long id ){
        return userService.getUserById(id);
    }
    @GetMapping("/getByEmail/{email}")
    public UserDto getUserByEmail(@PathVariable(name = "email") String email ){
        return userService.getUserByEmail(email);
    }
@DeleteMapping ("/{id}")
    public void deleteUser(@PathVariable(name="id")long id ){
    userService.deleteUser(id);
}

}
