package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;



@Service
public class UserService {
	@Autowired
	private UserRepository urepo;

	public User getUserByNameV2(String username) {
		// TODO Auto-generated method stub
		return urepo.findByName(username);
	}
	public List<User> listAll(){
		return (List<User>) urepo.findAll();
	}
	
}
