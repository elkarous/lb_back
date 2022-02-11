package lb.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lb.spring.entities.UserEntity;

@Repository
public interface UserRepository extends  JpaRepository<UserEntity,Long>{
@Transactional
public UserEntity findByEmail(String email);
}
