package lb.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pickup")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pickup {
    @EmbeddedId
    private PickupPk id;
    @Column(name = "ca")
    private BigDecimal ca;
    @Column(name = "nuits")
    private int nights;
    @Column(name = "resa")
    private int resa;
}
