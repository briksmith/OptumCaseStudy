package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Consts;
import model.UserRepository;

@RestController
public class UserController {
	
	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping(value = "/")
	public List<User> indexPage() throws Exception {
		return getAllUsers();
	}
	
	@GetMapping(value = "/getAll")
	public List<User> getAll() throws Exception {
		return getAllUsers();
	}

	private List<User> getAllUsers() {
		List<User> users =  userRepository.findAll();
		return users;
	}

	@GetMapping(value = "/getByUserId/{id}")
	public User getUserByID(@PathVariable Long id)  {
		Optional<User> user = userRepository.findById(id);
		try {
			return user.get();
		} catch(NoSuchElementException e) {
			return Consts.MISSING_USER;
		}
	}
	
	@RequestMapping(value = "/deleteByUserId/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public void deleteUserByID(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping(value = "/getUsersByName/{firstName}/{lastName}")
	public List<User> getUserByName( @PathVariable String firstName, @PathVariable String lastName)
			throws Exception {
		List<User> foundUsers = userRepository.findByUserName(firstName, lastName);
		return foundUsers;
	}
	
	@RequestMapping(value ="/addUserNameOnly/{firstName}/{lastName}", method = {RequestMethod.GET, RequestMethod.POST})
	public User addUserNameOnly(@PathVariable Map<String, String> inputs) {
		String firstName = inputs.get(Consts.FIRST_NAME);
		String lastName = inputs.get(Consts.LAST_NAME);
		User user = new User(firstName, lastName);
		userRepository.save(user);
		return user;
	}
	
	@RequestMapping(value ="/addFullUser/{firstName}/{middleInitial}/{lastName}/{city}/{state}/{zip}/{phone}", method = {RequestMethod.GET, RequestMethod.POST})
	public User addFullUser(@PathVariable Map<String, String> inputs) {
		String firstName = inputs.get(Consts.FIRST_NAME);
		char middleI = inputs.get(Consts.MIDDLE_INITIAL) == null ? '\u0000' : inputs.get(Consts.MIDDLE_INITIAL).charAt(0);
		String lastName = inputs.get(Consts.LAST_NAME);
		String city = inputs.get(Consts.CITY);
		String state = inputs.get(Consts.STATE);
		String zip = inputs.get(Consts.ZIP);
		String phoneNumber = inputs.get(Consts.PHONE);
		User user = new User(firstName, middleI, lastName, city, state, zip, phoneNumber);
		userRepository.save(user);
		return user;
	}
	
}
