package lb.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ExtractResaComp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExtractResaCamp {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "camping_code")
    private String campingCode;
    @Column(name = "pays",length=4)
    private String pays;
    @Column(name = "los")
    private int los;
    @Column(name = "datein")
    private Date datein;
    @Column(name="stat_stay")
    private int stat_stay;
}
