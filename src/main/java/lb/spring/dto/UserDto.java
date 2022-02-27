package lb.spring.dto;


import java.util.Date;


import lb.spring.entities.Camping;
import lb.spring.entities.Region;
import lb.spring.entities.FileDB;
import lb.spring.entities.Role;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String gender;
    private String password;
    private String email;
    private Date creationDate;
    private FileDB image;
    private Region region;
    private Role role;
    private Camping camping;
    private Boolean isBlocked=false;



}
