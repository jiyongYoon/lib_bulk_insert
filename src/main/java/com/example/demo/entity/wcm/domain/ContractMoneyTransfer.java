package com.example.demo.entity.wcm.domain;


import com.example.demo.entity.wcm.domain.enumeration.ContractTransferType;
import com.example.demo.entity.wcm.domain.string.TableName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.Instant;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@DynamicInsert
@Entity
@Table(name = TableName.CONTRACT_MONEY_TRANSFER)
public class ContractMoneyTransfer extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_transfer_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @Enumerated(EnumType.STRING)
    private ContractTransferType depositType;

    @Column
    private Instant date;
    @Column
    private int installment;
    @Column
    private String ratio;

    @Column
    private String title;
    @Column
    private String remark;

    @Column
    @ColumnDefault(value = "false")
    private Boolean isDeleted;

}
