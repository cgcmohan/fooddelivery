package com.cafe.Fooddelivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.Fooddelivery.Entity.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long>{

}
