package com.vivekCapstone.service;

import java.util.List;

import com.vivekCapstone.exception.UserAlreadyExistException;
import com.vivekCapstone.exception.UserNotFoundException;
import com.vivekCapstone.model.Users;


public interface UsersService {

	public Users registerUser(Users Users) throws UserAlreadyExistException; //post request - save a user record
	public Users findUserbyemail(String email) throws UserNotFoundException; // get request - retrieve a record
	public List<Users> getAllUser(); //get request - to retrieve all records
	public Users deleteAUser(String email) throws UserNotFoundException ; //delete request
	public Users updateAUser(Users Users) throws UserNotFoundException ; // PUT - PATCH request
	
}
