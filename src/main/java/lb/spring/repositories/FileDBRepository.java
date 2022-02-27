package lb.spring.repositories;


import lb.spring.entities.Camping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lb.spring.entities.FileDB;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}