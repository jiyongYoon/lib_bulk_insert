package com.example.demo.entity.wcm.domain;

import com.example.demo.entity.wcm.domain.string.TableName;
import jakarta.persistence.*;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableName.USER_CONTACT,
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","contact_id"}))
public class UserContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_contact_id")
    private Long id;


    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "contact_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contact contact;

}

