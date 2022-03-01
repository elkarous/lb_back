package lb.spring.repositories;

import lb.spring.dto.Nationality;
import lb.spring.entities.ExtractResaCamp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ResCampRepository  extends PagingAndSortingRepository<ExtractResaCamp,Long> {
    @Query("select e.pays as name , SUM( case when e.stat_stay=1 then e.los else 0 end )as value from ExtractResaCamp e where e.datein between '2020-11-01' and '2021-10-31' and e.campingCode= :camping group by e.pays ")
    List<Nationality> countReservation(@Param("camping")String camping );

}
