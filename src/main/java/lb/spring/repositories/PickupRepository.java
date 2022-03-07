package lb.spring.repositories;

import lb.spring.entities.Pickup;
import lb.spring.responses.CampStatResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface PickupRepository extends PagingAndSortingRepository<Pickup,Integer>, JpaSpecificationExecutor<Pickup> {
 @Query("select p from Pickup p where p.lead_time=0 AND p.stat_stay=1")
    List<Pickup> findByLeadTime(Pageable pageable);
    @Query("select distinct p.hebergement from Pickup p where p.camping_id= :campingId")
    List<Integer> getHebergementByCamping(@Param("campingId") int campingId  );
    @Query("select  p.camping_id as camping ,p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p  group by  p.camping_id ,p.stat_stay ")
    List<CampStatResponse>getAllCampStat();
   @Query("select  p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where p.camping_id= :camping group by p.camping_id , p.stat_stay ")
   List<CampStatResponse>getAllCampStat10(@Param("camping")int camping);
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where extract(month from p.bkg_date) in :months   group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat11(@Param("months") List<Integer> months);
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where p.bkg_date= :date group by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat12(@Param("date")Date date);
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where  p.hebergement= :hebergement group by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat14(@Param("hebergement")int hebergement);
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where extract(month from p.bkg_date) in :months  and p.hebergement= :hebergement  group by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat15(@Param("hebergement")int hebergement,@Param("months") List<Integer> months);
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where  p.bkg_date= :bkg_date  and p.hebergement= :hebergement  group by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat16(@Param("hebergement")int hebergement,@Param("bkg_date") Date bkg_date);
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where extract(year from p.bkg_date) = :year  group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat101(@Param("year") int year);
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where extract(month from p.bkg_date) = :month  group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat102(@Param("month") int month);
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where extract(dow from p.bkg_date) = :day  group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat104(@Param("day") int day );
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where  extract( month from p.bkg_date) = :month and extract(year from p.bkg_date) = :year  group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat103(@Param("year") int year,@Param("month") int month);
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where extract(year from p.bkg_date) = :year and extract(dow from p.bkg_date) = :day group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat105(@Param("year") int year,@Param("day") int day );
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where extract(month from p.bkg_date) = :month and extract(dow from p.bkg_date) = :day group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat106(@Param("month") int month,@Param("day") int day );
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where  extract(year from p.bkg_date) = :year and extract(month from p.bkg_date) = :month and extract(dow from p.bkg_date) = :day group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat107(@Param("year") int year,@Param("month") int month,@Param("day") int day );
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where extract(month from p.bkg_date) in :months and extract(year from p.bkg_date) = :year  group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat01101(@Param("year") int year,@Param("months") List<Integer> months);
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where extract(month from p.bkg_date) = :month  group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat01102(@Param("month") int month);
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where extract(dow from p.bkg_date) = :day  group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat01104(@Param("day") int day );
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where  extract( month from p.bkg_date) = :month and extract(year from p.bkg_date) = :year  group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat01103(@Param("year") int year,@Param("month") int month);
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where extract(year from p.bkg_date) = :year and extract(dow from p.bkg_date) = :day group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat01105(@Param("year") int year,@Param("day") int day );
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where extract(month from p.bkg_date) = :month and extract(dow from p.bkg_date) = :day group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat01106(@Param("month") int month,@Param("day") int day );
    @Query("select p.camping_id as camping , p.stat_stay as stat ,sum(p.nights) as reservation from Pickup p where  extract(year from p.bkg_date) = :year and extract(month from p.bkg_date) = :month and extract(dow from p.bkg_date) = :day group  by p.camping_id , p.stat_stay ")
    List<CampStatResponse>getAllCampStat01107(@Param("year") int year,@Param("month") int month,@Param("day") int day );
}
