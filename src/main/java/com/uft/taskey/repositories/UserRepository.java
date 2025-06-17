package com.uft.taskey.repositories;

import com.uft.taskey.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
