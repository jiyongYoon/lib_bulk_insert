package com.example.demo.repository.wcm;

import com.example.demo.entity.wcm.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
