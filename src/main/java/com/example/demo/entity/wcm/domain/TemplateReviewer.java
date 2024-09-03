package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.enumeration.ContractStepType;
import com.example.demo.entity.wcm.domain.enumeration.ReviewType;
import com.example.demo.entity.wcm.domain.enumeration.RoleType;
import com.example.demo.entity.wcm.domain.string.TableName;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.TEMPLATE_REVIEWER)
public class TemplateReviewer extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewer_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id")
    private TemplateContract templateContract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_step_id")
    private TemplateReviewStep templateReviewStep;

    @Enumerated(EnumType.STRING)
    private ReviewType reviewType;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Column
    @ColumnDefault("false")
    private Boolean isDeleted;

    @Column
    @Enumerated(EnumType.STRING)
    private ContractStepType contractStepType;

    @Column
    private Integer reviewOrder;
}
