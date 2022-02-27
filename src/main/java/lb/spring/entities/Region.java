package lb.spring.entities;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="DefRegion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    @Column(name = "RegionId", nullable = false)
    private Long id;
    @Column(name = "RegionLbl")
    private String region;
    @Column(name = "RegionDesc")
    private String regionDescription;

}
