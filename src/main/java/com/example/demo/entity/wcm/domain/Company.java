package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;


@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = TableName.COMPANY)
public class Company extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    private Long id;

    @JoinColumn(name = "create_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User createUser;

    @JoinColumn(name = "update_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User updateUser;

    @Column(length = 50, nullable = false)
    private String companyName;

    @Column
    private String companyType;

    @Column
    private String companyRegNumber;

    @Column
    private String companyLocation;

    @Column
    private String companySector;

    @Column
    private String companySalesScale;

    @Column
    private String companyDescription;

    @Column
    @ColumnDefault("false")
    private Boolean isDeleted;


}
