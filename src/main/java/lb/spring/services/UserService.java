package lb.spring.services;


import lb.spring.dto.StatUser;
import lb.spring.dto.UserDto;


import lb.spring.entities.Camping;
import lb.spring.entities.Region;
import lb.spring.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.mail.MessagingException;
import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto addUser(UserDto user) throws MessagingException;

    UserDto updateUser(UserDto user);

    UserDto getUserById(String id);

    List<Region> getRegion();

    List<Camping> getCampingByRegion(String region);

    List<UserDto> getAllUsers();

    void deleteUser(String email);

    UserDto getUserByEmail(String email);

    void updatePassword(UserDto user, String newPassword);

    StatUser getStat();

    void resetPassword(String id, String password);

    List<UserEntity> getAllByRole();


    List<UserEntity> getAllAgentByRegion(String region);
}
