package lb.spring.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DefHotel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Camping {
    @Id
    @Column(name = "HotelId")
    private int id;
    @Column(name = "HotelCode", length = 10)
    private String code;
    @Column(name = "HotelName", length = 40)
    private String name;
    @Column(name = "HotelDec", length = 40)
    private String campDescription;
    @Column(name = "Longitude")
    private BigDecimal longitude;
    @Column(name = "Latitude")
    private BigDecimal latitude;
    @Column(name = "Address", length = 100)
    private String address;
    @Column(name = "IsoCountry", length = 2)
    private String country;
    @Column(name = "CreationDate")
    private Date creationDate;
    @Column(name = "EditionDate")
    private Date editionDate;
    @Column(name = "Status")
    private boolean status;
    @Column(name = "NbStars")
    private int nbStars;
    @Column(name = "CreatedBy", length = 45)
    private String createdBy;
    @Column(name = "OpeningDate")
    private Date openingDate;
    @Column(name = "ClosingDate")
    private Date closingDate;
    @Column(name = "HotelType")
    private String campType;
    @ManyToOne
    @JoinColumn(name = "RegionId")
    private Region region;
    @OneToOne
    @JoinColumn(name = "ImageId")
    private FileDB image;

}
