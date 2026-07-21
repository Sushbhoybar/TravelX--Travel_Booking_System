package com.busbooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busbooking.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmailAndPasswordHash(String em,String pass);
	List<User> findAll();
}
