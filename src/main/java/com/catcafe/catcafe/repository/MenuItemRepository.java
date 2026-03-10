package com.catcafe.catcafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catcafe.catcafe.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {}
