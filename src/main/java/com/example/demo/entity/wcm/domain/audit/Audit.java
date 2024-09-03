package com.example.demo.entity.wcm.domain.audit;

import com.example.demo.entity.wcm.domain.User;
import com.example.demo.entity.wcm.domain.string.TableName;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = TableName.AUDIT)
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Long targetId;

    @Enumerated(EnumType.STRING)
    private AuditEventType auditEventType;

    private String method;
    private String endPoint;
    private String locale;
    private String relationEntity;
    private Instant executeDate;
    private String message;
}
