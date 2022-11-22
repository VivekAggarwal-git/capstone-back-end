package com.vivekCapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivekCapstone.model.Recipient;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long>{
	
	

}
