package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.enumeration.ContractHistoryStatus;
import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.CONTRACT_HISTORY)
public class ContractHistory extends Timestamped implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_history_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    private String historyVersion;

    private String historyComment;

    private Boolean minorChange;

    private String updateUser;

    @Enumerated(EnumType.STRING)
    private ContractHistoryStatus historyStatus;

    private Boolean isDeleted; // 삭제여부 -> 노출 근거

    private Boolean isLatest;

    @Column(columnDefinition = "text")
    private String updateDetails; // 달라진 내용

    @Column(columnDefinition = "text")
    private String contractDetails; // 계약서 전체 내용

    @Column
    private Integer currentStepOrder; // 현재 진행중인 스텝 순서

    @Column
    private Integer totalStepOrder; // 전체 진행되어야 할 스텝 갯수

    @Column
    private Integer currentReviewOrder; // 현재 진행중인 스텝의 리뷰 순서

    @PrePersist
    void prePersist() {
        this.isLatest = (this.isLatest == null ? true : this.isLatest);
    }

}
