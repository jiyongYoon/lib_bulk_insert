package com.example.demo.entity.wcm;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_contract")
public class Contract extends Timestamped implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id", nullable = false)
    private Long id;

    // 기안자
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // 회사
    @JoinColumn(name = "company_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    // 계약명
    @Column(length = 200)
    private String contractName;

    // 사업특이사항
    @Column(columnDefinition = "text")
    private String contractDetails;

    // 진행상태
    @Column(length = 200)
    private String status;

    // 탬플릿에 커스텀된 세부상태
    // (ex, 계약금액 제시, 최종 컨펌 확인중, 등등 조금 더 세부적인 사항들을 템플릿에서 미리 설정하고, 유저가 SELECT BOX에서 값을 선택하도록)
    @Column(length = 255)
    private String customStatus;

    // 기한
    private Integer deadLine;

    // 계약일자
    @Column(length = 200)
    private String contractDate;

    // 매출금액
    @Column(length = 200)
    private String contractAmount;

    // 계약시작
    @Column(length = 200)
    private Instant startDate;

    // 계약만료
    @Column(length = 200)
    private Instant endDate;

    // 매입 총 원가
    private String totalCost;

    // 매출 이익
    private String salesProfit;

    // 사용안함
    private String costAnalysis;

    // 삭제여부
    private Boolean isDeleted;

    // 계약 단계
    @Column
    @Enumerated(EnumType.STRING)
    private ContractStepType contractStepType;

    private String workspaceCode;
}