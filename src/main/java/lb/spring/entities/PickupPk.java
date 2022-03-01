package lb.spring.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class PickupPk implements Serializable {
    private static final long serialVersionUID = -7496466196003744518L;
    private int camping_id;
    private int hebergement;
    private int stat_stay;
    private Date bkg_date;
    private int lead_time;
}
