package com.takeo.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.entity.UserEntity;
import com.takeo.repo.UserRepository;
import com.takeo.binding.User;
import com.takeo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserRepository userRepo;

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		UserEntity entity = new UserEntity();

		BeanUtils.copyProperties(user, entity);
		UserEntity usr = userRepo.save(entity);
		if (usr != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<User> getAllUsers() {
		List<UserEntity> entityRecords = userRepo.findAll();
		List<User> allUsers = new ArrayList<>();

		for (UserEntity entity : entityRecords) {
			User u = new User();
			BeanUtils.copyProperties(entity, u);
			allUsers.add(u);
		}
		return allUsers;
	}

	@Override
	public boolean updateUser(User usr) {
		UserEntity entity = new UserEntity();

		System.out.println(usr.getUno() + "\t" + usr.getUname() + "\t" + usr.getUemail() + "\t" + usr.getUpassword()
				+ "\t" + usr.getUaddress());
		BeanUtils.copyProperties(usr, entity);

		System.out.println(entity.getUno() + entity.getUname() + "\t" + "\t" + entity.getUemail() + "\t"
				+ entity.getUpassword() + "\t" + entity.getUaddress());
		UserEntity savedEntity = userRepo.save(entity);

		boolean flag = false;
		if (savedEntity.getUno() != 0)
			flag = true;
		return flag;
	}

	@Override
	public void deleteUser(int id) {
		userRepo.deleteById(id);

	}

	@Override
	public User getUserById(int id) {
		User usr = null;
		Optional<UserEntity> findById = userRepo.findById(id);
		if (findById.isPresent()) {
			UserEntity entity = findById.get();
			usr = new User();
			BeanUtils.copyProperties(entity, usr);
		}
		return usr;
	}

	@Override
	public User getUserByUName(String name) {
		// TODO Auto-generated method stub
		List<UserEntity> entityRecords = userRepo.findAll();
		User u = new User();
		for (UserEntity entity : entityRecords) {
			if (entity.getUname() == name) {

				BeanUtils.copyProperties(entity, u);

			}

		}
		return u;
	}

	@Override
	public User getUserByUEmail(String email) {
		// TODO Auto-generated method stub
		List<UserEntity> entityRecords = userRepo.findAll();
		User u = new User();
		for (UserEntity entity : entityRecords) {
			if (entity.getUemail() == email) {

				BeanUtils.copyProperties(entity, u);

			}

		}
		return u;
	}

	@Override
	public boolean checkUserByEmailandPass(String email, String pass) {
		boolean flag = false;
		List<UserEntity> entityRecords = userRepo.findAll();
		User u = new User();
		for (UserEntity entity : entityRecords) {
			if (entity.getUemail().equals( email) && entity.getUpassword().equals(pass)) 
			{
			//	BeanUtils.copyProperties(entity, u);
				flag = true;
			}

		}
		return flag;
	}
}
