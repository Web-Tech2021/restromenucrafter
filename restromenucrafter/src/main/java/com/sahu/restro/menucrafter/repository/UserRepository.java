package com.sahu.restro.menucrafter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.restro.menucrafter.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByEmail(String email);

	public Optional<User> findByResetPasswordToken(String resetPasswordToken);

}
