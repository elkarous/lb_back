package lb.spring.repositories;

import lb.spring.responses.Nationality;
import lb.spring.entities.ExtractResaCamp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ResCampRepository  extends PagingAndSortingRepository<ExtractResaCamp,Long> {
    @Query("select e.pays as name , SUM( e.los )as value from ExtractResaCamp e where e.datein between :startDate and :endDate and e.stat_stay=1 and e.campingCode= :camping group by e.pays ")
    List<Nationality> countReservation(@Param("camping")String camping,@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
