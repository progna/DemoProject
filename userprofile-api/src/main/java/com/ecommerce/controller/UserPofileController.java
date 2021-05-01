package com.ecommerce.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.pojo.UserProfileVO;
import com.ecommerce.service.UserProfileService;

@RestController
public class UserPofileController {
	@Autowired
	UserProfileService userProfileService;
	
	@GetMapping(value="/getUserDetails/{id}")
	public UserProfileVO getUserInfo(@PathVariable int id ) {		
		return userProfileService.getUserById(id); 
	}
	
	@PostMapping(value="/insertUserDetails")
	public String getUserInfo(@RequestBody UserProfileVO userProfile) {		
		
		return userProfileService.updateOrInsertUserProfile(userProfile);
	}
}
