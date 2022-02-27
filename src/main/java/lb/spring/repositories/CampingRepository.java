package lb.spring.repositories;

import lb.spring.entities.Camping;
import lb.spring.entities.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface CampingRepository extends JpaRepository<Camping,Integer> {
    @Transactional
    @Query("SELECT c FROM Camping c JOIN c.region r where r.region= :region")
    List<Camping> getCampingByRegion(@Param("region") String region);
    @Query("SELECT c FROM Camping c where c.id= :id")
    Camping getImage(@Param("id") int id);
}
