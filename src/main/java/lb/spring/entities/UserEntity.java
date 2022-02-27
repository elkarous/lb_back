package lb.spring.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(length = 50)
    private String firstName;
    @Column( length = 50)
    private String lastName;

    @Column( length = 50)
    private String phone;
    @Column( length = 50)
    private String gender;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Date creationDate;
    @OneToOne(cascade = CascadeType.ALL)
    private FileDB image;
    @ManyToOne
    private Region region;
    @ManyToOne
    private Camping camping;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean isBlocked=false;



}
