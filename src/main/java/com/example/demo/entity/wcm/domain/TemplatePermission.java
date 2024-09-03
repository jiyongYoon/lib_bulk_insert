package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.string.TableName;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.TEMPLATE_PERMISSION)
public class TemplatePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Long id;


    @JoinColumn(name = "template_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TemplateContract templateContract;

    @JoinColumn(name = "dept_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Dept dept;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column
    private boolean isAllView;
    @Column
    private String workspaceCode;


}
