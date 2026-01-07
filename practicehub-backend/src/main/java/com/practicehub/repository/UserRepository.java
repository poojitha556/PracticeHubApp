package com.practicehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practicehub.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
