package workshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import workshop.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByUsername(String username);
}
