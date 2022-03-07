package lb.spring.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import lb.spring.entities.FileDB;



@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}