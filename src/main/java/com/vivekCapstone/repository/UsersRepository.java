package com.vivekCapstone.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vivekCapstone.model.Users;



@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

	@Query("SELECT u FROM Users u WHERE u.name = ?1")
	Users findByName(String name);

}
