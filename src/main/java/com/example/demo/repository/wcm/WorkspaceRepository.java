package com.example.demo.repository.wcm;

import com.example.demo.entity.wcm.domain.Dept;
import com.example.demo.entity.wcm.domain.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
}
