package com.digimaster.controller;

import com.digimaster.entities.Order;
import com.digimaster.entities.User;
import com.digimaster.exceptions.UserNotFoundException;
import com.digimaster.repositories.UserRepository;
import com.digimaster.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/hateoas/users")
@Validated
public class UserHateoasController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	// getUserById
	@GetMapping("/{id}")
	public Resource<User> getUserById(@PathVariable("id") @Min(1) Long id) {

		try {
			Optional<User> userOptional =  userService.getUserById(id);
			User user = userOptional.get();
			Long userid = user.getUserid();
			Link selflink = ControllerLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
			user.add(selflink);
			Resource<User> finalResource = new Resource<User>(user);
			return finalResource;
			
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}

	}
	
	// getAllUsers Method
	@GetMapping
	public Resources<User> getAllUsers() throws UserNotFoundException {
		List<User> allusers = userService.getAllUsers();
		
		for(User user : allusers) {
			//Self Link 
			Long userid = user.getUserid();
			Link selflink = ControllerLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
			user.add(selflink);
			
			//Relationship link with getAllOrders
			Resources<Order> orders = ControllerLinkBuilder.methodOn(OrderHateoasController.class)
					.getAllOrders(userid);
			Link orderslink = ControllerLinkBuilder.linkTo(orders).withRel("all-orders");
			user.add(orderslink);
			
		}
		//Self link for getAllUsers
		Link selflinkgetAllUsers = ControllerLinkBuilder.linkTo(this.getClass()).withSelfRel();
		Resources<User> finalResources = new Resources<User>(allusers, selflinkgetAllUsers);
		return finalResources;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
