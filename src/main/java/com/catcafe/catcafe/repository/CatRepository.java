package com.catcafe.catcafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catcafe.catcafe.model.Cat;

public interface CatRepository extends JpaRepository<Cat, Long> { }
