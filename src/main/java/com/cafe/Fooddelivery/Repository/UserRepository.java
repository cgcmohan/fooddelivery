package com.cafe.Fooddelivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.Fooddelivery.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
