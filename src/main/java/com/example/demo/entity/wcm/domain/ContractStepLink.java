package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.CONTRACT_LINK)
public class ContractStepLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_link_id", nullable = false)
    @JsonProperty(value = "id")
    private Long id;

    @JoinColumn(name = "contract_from_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contract from;

    @JoinColumn(name = "contract_to_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contract to;
    @Column
    private String description;
}
