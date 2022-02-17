package lb.spring.services;



import lb.spring.dto.UserDto;
import lb.spring.entities.UserEntity;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
 UserDto addUser(UserDto user);
 UserDto updateUser(UserDto user);
 UserDto getUserById(long id);
 List<UserDto> getAllUsers();
 void deleteUser(long id);
 UserDto getUserByEmail(String email);
void updatePassword(UserEntity user, String newPassword);
}
