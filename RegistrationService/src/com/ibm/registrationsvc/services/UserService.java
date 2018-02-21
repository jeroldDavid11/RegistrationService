package com.ibm.registrationsvc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.registrationsvc.dto.User;
import com.ibm.registrationsvc.repository.RepositoryClass;

public class UserService {

	private Map<Long, User> users = RepositoryClass.getUsers();
	
	public List<User> getAllUsers()
	{
		return new ArrayList<User>(users.values());
	}
	
	public User findUserById(int userId)
	{
		return users.get((long) userId);
	}
	
	public User addUser(User newUser)
	{
		newUser.setId(users.size() + 1);
		users.put((long) newUser.getId(), newUser);
		return newUser;
	}
	
	public void updateUser(User user)
	{
		users.put((long) user.getId(), user);
	}
	
	public void deleteUser(long userId)
	{
		users.remove(userId);
	}
}
