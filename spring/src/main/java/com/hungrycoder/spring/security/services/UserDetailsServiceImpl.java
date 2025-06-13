package com.hungrycoder.spring.security.services;

import com.hungrycoder.spring.models.User; // Import User model
import com.hungrycoder.spring.repository.UserRepository; // Import UserRepository for user database operations
import org.springframework.beans.factory.annotation.Autowired; // Import for dependency injection
import org.springframework.security.core.userdetails.UserDetails; // Import UserDetails interface
import org.springframework.security.core.userdetails.UserDetailsService; // Import UserDetailsService interface
import org.springframework.security.core.userdetails.UsernameNotFoundException; // Import for handling user not found
import org.springframework.stereotype.Service; // Import for service annotation
import org.springframework.transaction.annotation.Transactional; // Import for transaction management


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired // Automatically injects UserRepository bean
	UserRepository userRepository;


	@Override
	@Transactional // Ensures that the method is transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Attempt to find the user by username
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		// Return UserDetails implementation for the found user
		return UserDetailsImpl.build(user);
	}
}
