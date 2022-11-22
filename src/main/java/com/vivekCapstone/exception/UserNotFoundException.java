package com.vivekCapstone.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserNotFoundException extends Exception {

	private String message;
	
	
	
	
}
