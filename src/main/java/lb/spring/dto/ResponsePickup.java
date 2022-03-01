package lb.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePickup {
    private String camping;
    private int reservation;
    private int annulation;
    private int reservationNette;
}
