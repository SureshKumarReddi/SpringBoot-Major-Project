package com.suresh.serviceimpl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.suresh.bindings.UserRequest;
import com.suresh.entities.RegisterUser;
import com.suresh.repository.UserRepository;
import com.suresh.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserRepository repo;

	@Override
	public String saveUser(UserRequest request) {

		String response = restTemplate.getForObject("https://ssa-web-api.herokuapp.com/state/" + request.getSsn(),
				String.class);

		if ("Kentucky".equals(response)) {
			RegisterUser entity = new RegisterUser();
			BeanUtils.copyProperties(request, entity);

			repo.save(entity);
			int generateRegistrationNumber = generateRegistrationNumber();

			String s = "AR" + generateRegistrationNumber;
			return s;
		} else {
			return "Citizen is not belongs to Kentucky state. sorry unable to store your data in our database";
		}
	}

	private int generateRegistrationNumber() {

		Random random = new Random();
		return random.nextInt(999);
	}

	@Override
	public List<RegisterUser> getAllUsers() {
		 
		return repo.findAll();
	}

}
