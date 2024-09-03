package com.example.demo.entity.wcm.domain;


import com.example.demo.entity.wcm.domain.enumeration.ReviewStepType;
import com.example.demo.entity.wcm.domain.string.TableName;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.TEMPLATE_REVIEW_STEP)
public class TemplateReviewStep extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_step_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id")
    private TemplateContract templateContract;


    @Where(clause = "is_deleted = false")
    @OneToMany(fetch =FetchType.LAZY, mappedBy = "templateReviewStep")
    private List<TemplateReviewer> templateReviewerList;

    @Enumerated(EnumType.STRING)
    private ReviewStepType reviewStepType;
    private Integer stepOrder;



}
