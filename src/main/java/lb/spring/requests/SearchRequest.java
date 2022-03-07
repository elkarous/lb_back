package lb.spring.requests;

import lombok.*;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    private int camping_id;
    private int hebergement;
    private String seasonType;
    private Date bkg_date;
    private int month;
    private int year;
    private int day ;

}
