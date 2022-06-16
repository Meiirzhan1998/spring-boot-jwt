package com.javainuse.service;

import java.util.ArrayList;

import com.javainuse.model.UserEntity;
import com.javainuse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByLogin(login);
		if (user != null) {
			return new User(user.getLogin(), user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + login);
		}
	}
}