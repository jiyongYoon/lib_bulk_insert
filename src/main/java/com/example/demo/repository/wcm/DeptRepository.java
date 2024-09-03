package com.example.demo.repository.wcm;

import com.example.demo.entity.wcm.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Long> {
}
