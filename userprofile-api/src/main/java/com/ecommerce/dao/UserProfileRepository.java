package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.UserProfileEO;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEO, Integer> { 

}
