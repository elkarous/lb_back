package lb.spring.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class NationalityRequest {
    private String camping;
    private Date startDate;
    private  Date endDate ;
}
