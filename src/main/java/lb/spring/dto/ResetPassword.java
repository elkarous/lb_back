package lb.spring.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResetPassword {
private String token;
private String password;

}
