package lb.spring.repositories;

import lb.spring.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {
    List<Region> findByRegion(String region);
}
