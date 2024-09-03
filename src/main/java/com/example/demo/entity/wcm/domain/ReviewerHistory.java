package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.enumeration.OriginType;
import com.example.demo.entity.wcm.domain.enumeration.ReviewStatus;
import com.example.demo.entity.wcm.domain.enumeration.ReviewStepType;
import com.example.demo.entity.wcm.domain.enumeration.ReviewType;
import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.REVIEWER_HISTORY)
public class ReviewerHistory extends Timestamped implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewer_history_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_history_id")
    private ContractHistory contractHistory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Dept dept;

    private Boolean isChecked;

    private Instant checkedTime;

    private String reviewComment;

    @Enumerated(EnumType.STRING)
    private OriginType originType;

    @Enumerated(EnumType.STRING)
    private ReviewStepType reviewStepType; //합의 ,결제

    @Enumerated(EnumType.STRING)
    private ReviewStatus reviewStatus;

    @Enumerated(EnumType.STRING)
    private ReviewType reviewType; // 부서, 개인
    private Integer stepOrder; // 단계순서
    private Integer reviewOrder; // 단계별 리뷰순서


}
