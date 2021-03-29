package com.example.demo.repository;

import java.util.Optional;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.JwtUser;




@Repository
public interface JwtUserRepository extends JpaRepository<JwtUser, Long> {

	Boolean existsByUserName(String userName);
	Optional<JwtUser> findByEmailUser(String emailUser);
	JwtUser findByid(long id);

}
