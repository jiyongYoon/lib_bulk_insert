package com.example.demo.entity.wcm;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serializable;
import java.time.Instant;

@DynamicInsert
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User extends Timestamped implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(length = 200, unique = true)
    private String userEmail;

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

    @ColumnDefault("false")
    private Boolean isAutoConfirm;

    String uuid;

    Instant resetDate;
}