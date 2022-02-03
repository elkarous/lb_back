package lb.spring.services;



import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lb.spring.dto.ResetPassword;
import lb.spring.dto.UserDto;

@Service
public class PasswordServices {
@Autowired
UserService userService;
@Autowired
public JavaMailSender emailSender;
@Autowired
JwtUtil jwtUtil;


public UserDto resetPassword(ResetPassword resetPassword,String email) {
	UserDto user= userService.getUserByEmail(email);
	user.setPassword(resetPassword.getPassword());
	 userService.updateUser(user);
	
	return user;
	
}

public String sendEmail(String email) throws MessagingException {
	 UserDto user = userService.getUserByEmail(email);
	 if(user!=null) {
		 
	
	  MimeMessage message = emailSender.createMimeMessage();

      boolean multipart = true;
      
      MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
      
      String htmlMsg = "<h3>Forgot password</h3>"
   		   +"<h2>Password:</h2><url>"+"http://localhost:4200/resetPassword/"+ jwtUtil.generateTokenByEmail(email)+"</url>"
              +"<img src='src/images/logo.png'>";
      
      message.setContent(htmlMsg, "text/html");
      
      helper.setTo(email);
      
      helper.setSubject("Password");
      
      
  
      this.emailSender.send(message);
	 } 
      return "Email Sent!";
}
}
