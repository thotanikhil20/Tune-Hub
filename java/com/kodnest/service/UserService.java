package com.kodnest.service;

import java.util.List;

import com.kodnest.entity.Song;
import com.kodnest.entity.User;

public interface UserService {

	void saveUser(User user);

	boolean emailExists(User user);

	boolean validUser(String email, String password);

	String getRole(String email);

	User getUser(String mail);

	void updateUser(User user);

	boolean isPremium(String email);





}