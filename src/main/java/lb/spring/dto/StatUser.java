package lb.spring.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatUser {
    private long male;
    private long female;
    private long admin;
    private long agent;
    private long superAdmin;

}
