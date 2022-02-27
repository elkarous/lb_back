package lb.spring.repositories;

import lb.spring.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.spring.entities.UserEntity;

import java.util.List;
@Repository
public interface UserRepository extends  JpaRepository<UserEntity,String>{
 @Transactional
 List<UserEntity> findAllByRole(Role role);
 @Transactional
 @Query("SELECT u FROM UserEntity u JOIN u.camping c  JOIN  c.region  r where r.region= :region")
 List<UserEntity> getUsersByRegion(@Param("region") String region);
@Transactional
 UserEntity findByEmail(String email);
 @Query("SELECT count(*) FROM UserEntity u where u.gender='female'")
 long countFemale();
 @Query("SELECT count(*) FROM UserEntity u where u.role='ADMIN' ")
 long countAdmin();
 @Query("SELECT u FROM UserEntity u where u.role='ADMIN' OR  u.role='SUPER_ADMIN'  ")
 @Transactional
 List<UserEntity> getUsersWithoutAgent();
 @Query("SELECT count(*) FROM UserEntity u where u.role='AGENT'")
 long countAgent();

}
