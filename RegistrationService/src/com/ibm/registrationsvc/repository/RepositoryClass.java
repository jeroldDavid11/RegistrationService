package com.ibm.registrationsvc.repository;

import java.util.HashMap;
import java.util.Map;

import com.ibm.registrationsvc.dto.User;

public class RepositoryClass {
	
	private static Map<Long, User> users = new HashMap<>();
	
	public static Map<Long, User> getUsers()
	{
		return users;
	}
}
