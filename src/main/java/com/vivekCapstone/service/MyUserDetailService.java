package com.vivekCapstone.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vivekCapstone.model.Users;
import com.vivekCapstone.repository.UsersRepository;


@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	UsersRepository URepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Users User = URepo.findById(email).get();
		return new User(User.getEmail(), User.getPassword(), new ArrayList<>());
	}
	
	
}
