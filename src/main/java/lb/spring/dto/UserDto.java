package lb.spring.dto;


import java.util.Date;


import lb.spring.entities.FileDB;
import lb.spring.entities.Role;



public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String gender;
    private String password;
    private String email;
    private Date creationDate;
    private FileDB image;

    public FileDB getImage() {
        return image;
    }

    public void setImage(FileDB image) {
        this.image = image;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserDto(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Role role;


    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public UserDto() {
        super();
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserDto(long id, String firstName, String lastName, String phone, String gender, String password, String email, Date creationDate, FileDB image, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.email = email;
        this.creationDate = creationDate;
        this.image = image;
        this.role = role;
    }
}
