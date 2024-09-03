package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.enumeration.ContractStatus;
import com.example.demo.entity.wcm.domain.enumeration.ContractStepType;
import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.Instant;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.CONTRACT)
public class Contract extends Timestamped implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id", nullable = false)
    @JsonProperty(value = "id")
    private Long id;

    // 기안자
    @JoinColumn(name = "user_id")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // 탬플릿
    @JoinColumn(name = "template_id")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private TemplateContract templateContract;

    // 회사
    @JoinColumn(name = "company_id")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    // 연락처
    @JoinColumn(name = "contact_id")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Contact contact;

    // 계약명
    @Column(length = 200)
    @JsonProperty(value = "name")
    private String contractName;

    // 사업특이사항
    @Column(columnDefinition = "text")
    @JsonProperty(value = "details")
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
    @JsonProperty(value = "date")
    private String contractDate;

    // 매출금액
    @Column(length = 200)
    @JsonProperty(value = "amount")
    private String contractAmount;

    // 계약시작
    @Column(length = 200)
    @JsonProperty(value = "startDate")
    private Instant startDate;

    // 계약만료
    @Column(length = 200)
    @JsonProperty(value = "endDate")
    private Instant endDate;

    // 사용안함
    @Column(length = 200)
    private Instant expectedDateOfIssuanceOfInvoice;

    // 사용안함
    @Column(length = 200)
    private Instant dueDateOfReceive;

    // 사용안함
    @Column(length = 200)
    private Instant dueDateOfSend;

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

    @PrePersist
    void prePersist() {
        this.isDeleted = this.isDeleted != null && this.isDeleted;
    }

}
