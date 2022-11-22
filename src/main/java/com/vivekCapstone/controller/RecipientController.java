package com.vivekCapstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivekCapstone.exception.RecipentNotFoundException;
import com.vivekCapstone.model.Recipient;
import com.vivekCapstone.repository.RecipientRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:8181", "http://localhost:3000"})
public class RecipientController {

	@Autowired
	private RecipientRepository recipientRepository;
	
	@PostMapping("/recipient")
	Recipient newRecipient(@RequestBody Recipient newRecipient) {
		return recipientRepository.save(newRecipient);
	}
	
	@GetMapping("/recipients")
	List<Recipient> getAllRecipients(){
		return recipientRepository.findAll();
	}
	
	@GetMapping("/recipient/{id}")
	Recipient getRecipientById(@PathVariable Long id) {
		return recipientRepository.findById(id)
				.orElseThrow(()->new RecipentNotFoundException(id));
	}
	
	@PutMapping("/recipient/{id}")
	Recipient updateRecipient(@RequestBody Recipient newRecipient,@PathVariable Long id) {
		return recipientRepository.findById(id)
				.map(recipient -> {
					recipient.setRname(newRecipient.getRname());
					recipient.setAcnum(newRecipient.getAcnum());
					recipient.setBcurrency(newRecipient.getBcurrency());
					recipient.setCountry(newRecipient.getCountry());
					recipient.setSwift(newRecipient.getSwift());
					recipient.setBic(newRecipient.getBic());
					return recipientRepository.save(recipient);
				}).orElseThrow(()->new RecipentNotFoundException(id));
	}
	
	@DeleteMapping("/recipient/{id}")
	String deleteRecipient(@PathVariable Long id) {
		if(!recipientRepository.existsById(id)) {
			throw new RecipentNotFoundException(id);
		}
		recipientRepository.deleteById(id);
		return ("Recipient with id" + id + " has been deleted..");
	}
	
	
	
	
	
}
