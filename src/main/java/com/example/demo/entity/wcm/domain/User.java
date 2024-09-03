package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.enumeration.UserRole;
import com.example.demo.entity.wcm.domain.string.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serializable;
import java.time.Instant;

@DynamicInsert
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.USER)
public class User extends Timestamped implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;


    @Column(length = 200, unique = true)
    private String userEmail;

    @JsonIgnore
    @Column(name = "user_password")
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;  // 'ADMIN', 'USER'

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_tel")
    private String userTel;
    @Column(name = "user_description")
    private String userDescription;

    @Column(name = "user_position")
    private String userPosition;

    @ColumnDefault("true")
    private Boolean firstLogin;

    @ColumnDefault("false")
    private Boolean deletedUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @ColumnDefault("false")
    private Boolean isAutoConfirm;

    String uuid;

    Instant resetDate;

    @PrePersist
    public void prePersist() {
        this.deletedUser = (this.deletedUser == null) ? false : this.deletedUser;
    }

}
