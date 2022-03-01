package lb.spring.repositories;

import lb.spring.entities.Pickup;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PickupRepository extends PagingAndSortingRepository<Pickup,Integer> {
 @Query("select p from Pickup p where p.id.lead_time=0 AND p.id.stat_stay=1")
    List<Pickup> findByLeadTime(Pageable pageable);

}
