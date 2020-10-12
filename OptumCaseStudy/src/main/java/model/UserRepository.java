package model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value ="Select * FROM User WHERE firstName = ?1 AND lastName = ?2", nativeQuery = true)
	List<User> findByUserName(String firstName, String lastName);
}
