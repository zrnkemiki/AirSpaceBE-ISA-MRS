package com.smv.AirSpace.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.smv.AirSpace.model.User;
import com.smv.AirSpace.model.UserStatus;
import com.smv.AirSpace.model.UserType;



public interface UserRepository extends Repository<User, Long> {

	
	User findByUsername(String username);

	User findById(Long id);

	User findByUsernameAndPassword(String username, String password);

	List<User> findByUserTypeAndUserStatus(UserType userType, UserStatus userStatus);
	
	List<User> findAll();

	User findByUsernameAndUserStatus(String username, UserStatus userStatus);

	User save(User user);

	void deleteAll(); 
	
	User findByuuid(String uuid);
	
	
}
