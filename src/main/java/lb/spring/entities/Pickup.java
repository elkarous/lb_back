package lb.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pickup")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pickup {
    @Id
    @Column(name = "camping_id")
    private int camping_id;
    @Column(name = "hebergement")
    private int hebergement;
    @Column(name = "stat_stay")
    private int stat_stay;
    @Column(name = "bkg_date")
    private Date bkg_date;
    @Column(name = "lead_time")
    private int lead_time;
    @Column(name = "ca")
    private BigDecimal ca;
    @Column(name = "nuits")
    private int nights;
    @Column(name = "resa")
    private int resa;


}
