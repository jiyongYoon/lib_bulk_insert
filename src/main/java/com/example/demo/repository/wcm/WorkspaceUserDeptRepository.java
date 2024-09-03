package com.example.demo.repository.wcm;

import com.example.demo.entity.wcm.domain.Workspace;
import com.example.demo.entity.wcm.domain.WorkspaceUserDept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceUserDeptRepository extends JpaRepository<WorkspaceUserDept, Long> {
}
