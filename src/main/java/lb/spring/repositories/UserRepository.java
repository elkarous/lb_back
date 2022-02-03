package lb.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lb.spring.entities.UserEntity;

@Repository
public interface UserRepository extends  JpaRepository<UserEntity,Long>{
public UserEntity findByEmail(String email);
public UserEntity findByResetPasswordToken(String token);
}
