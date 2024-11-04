package com.roczyno.demo2.repository;


import com.roczyno.demo2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
