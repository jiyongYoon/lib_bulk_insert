package com.example.demo.repository.wcm;

import com.example.demo.entity.wcm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
