package com.kevinduran.parcial2.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.kevinduran.parcial2.models.entities.User;

public interface UserRepository extends ListCrudRepository<User, UUID> {
	User findByUsernameOrEmail(String username, String email);
	User findByCode(UUID code);
}
