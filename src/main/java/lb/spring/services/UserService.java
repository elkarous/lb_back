package lb.spring.services;



import lb.spring.dto.UserDto;
import lb.spring.entities.UserEntity;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
 public UserDto addUser (UserDto user);
 public UserDto updateUser (UserDto user);
 public UserDto getUserById (long id);
 public List<UserDto> getAllUsers ();
 public void deleteUser(long id);
 public UserDto getUserByEmail(String email);
void updateResetPasswordToken(String token, String email) throws RuntimeException;
UserEntity getByResetPasswordToken(String token);
void updatePassword(UserEntity user, String newPassword);
}
