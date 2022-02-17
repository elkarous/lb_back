package lb.spring.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class UserEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = true, length = 50)
    private String firstName;
    @Column(nullable = true, length = 50)
    private String lastName;
    @Column(nullable = true, length = 50)
    private String phone;
    @Column(nullable = true, length = 50)
    private String gender;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Date creationDate;
    @OneToOne( optional = true, cascade = CascadeType.ALL)
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

    public UserEntity(String password, String email) {
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

    @Enumerated
    private Role role;

    public UserEntity(long id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public UserEntity() {
        super();
    }

    public UserEntity(long id, String firstName, String lastName, String phone, String gender) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
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

    public UserEntity(long id, String firstName, String lastName, String phone, String gender, String password, String email, Date creationDate, FileDB image, Role role) {
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
