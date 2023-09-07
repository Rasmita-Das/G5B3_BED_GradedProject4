package com.gl.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.employee.model.DomainUserDetails;
import com.gl.employee.repository.UserJpaRepository;

@Service
public class DomainUserDetailsService implements UserDetailsService {

	@Autowired
	private UserJpaRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userRepository.findByUsername(username).map(DomainUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid username"));

	}

}
