package com.ecommerce.service;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.dao.UserProfileRepository;
import com.ecommerce.entity.UserProfileEO;
import com.ecommerce.pojo.UserProfileVO;

@Service
public class UserProfileService {

	@Autowired
	UserProfileRepository userProfile;

	public UserProfileVO getUserById(int id) {
		UserProfileVO userProfileObj = new UserProfileVO();
		Optional<UserProfileEO> userProfileEoOpObj = userProfile.findById(id);

		if (userProfileEoOpObj.isPresent()) {
			BeanUtils.copyProperties(userProfileEoOpObj.get(), userProfileObj);
		}

		return userProfileObj;
	}

	public String updateOrInsertUserProfile(UserProfileVO userProfileObj) {

		try {
			UserProfileEO user = null;
			if (userProfileObj.getId() == null) {
				user = new UserProfileEO();
				copyProperties(user, userProfileObj);
			} else {
				Optional<UserProfileEO> userProfileEoOpObj = userProfile.findById(userProfileObj.getId());
				if (userProfileEoOpObj.isPresent()) {
					user = userProfileEoOpObj.get();
					copyProperties(user, userProfileObj);
				}
			}

			userProfile.save(user);

		} catch (Exception e) {
			e.printStackTrace();
			return "Failed";
		}

		return "Success";
	}

	private void copyProperties(UserProfileEO user, UserProfileVO userProfileObj) {
		user.setName(userProfileObj.getName());
		user.setGender(userProfileObj.getGender());
		user.setLocation(userProfileObj.getLocation());
	}

}
