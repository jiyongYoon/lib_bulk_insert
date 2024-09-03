package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.COST_ANALYSIS)
public class CostAnalysis extends Timestamped implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cost_analysis_id", nullable = false)
    private Long id;

    @JoinColumn(name = "contract_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contract contract;

    @JoinColumn(name = "company_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    private String type;

    private String item;

    private Long quantity;

    private BigDecimal price;

    private BigDecimal totalPrice;

    private String currencyType;

    private String remark;

    private Instant orderDate;

    private Boolean isDeleted;


    @PrePersist
    private void prePersist() {
        this.price = this.price == null ? BigDecimal.ZERO : this.price;
        this.quantity = this.quantity == null ? 1L : this.quantity;
        this.totalPrice = this.price.multiply(new BigDecimal(this.quantity));
    }

    @PreUpdate
    private void preUpdate() {
        this.price = this.price == null ? BigDecimal.ZERO : this.price;
        this.quantity = this.quantity == null ? 1L : this.quantity;
        this.totalPrice = this.price.multiply(new BigDecimal(this.quantity));
    }
}
