package com.suresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suresh.entities.RegisterUser;

public interface UserRepository extends JpaRepository<RegisterUser, Integer> {

}
