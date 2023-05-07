package com.meriem.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meriem.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername (String username);
}
