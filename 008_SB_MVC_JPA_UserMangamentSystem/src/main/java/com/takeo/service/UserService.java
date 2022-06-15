package com.takeo.service;

import java.util.List;

import com.takeo.binding.User;

public interface UserService {
	public boolean saveUser(User usr);

	public List<User> getAllUsers();

	public User getUserById(int id);

	public User getUserByUName(String name);
	
	public User getUserByUEmail(String email);
	public boolean checkUserByEmailandPass(String email, String pass);

	public boolean updateUser(User usr);

	public void deleteUser(int id);

}
