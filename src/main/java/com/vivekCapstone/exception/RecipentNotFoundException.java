package com.vivekCapstone.exception;

public class RecipentNotFoundException extends RuntimeException{
	
	public RecipentNotFoundException(Long id) {
		super("could not find the recipient with id" + id);
	}
	

}
