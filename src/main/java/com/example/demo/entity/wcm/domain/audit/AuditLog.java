package com.example.demo.entity.wcm.domain.audit;

import lombok.*;

import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(AccessLevel.PROTECTED)
public class AuditLog {

    private Long userId;
    private Long targetId;
    private AuditEventType auditEventType;
    private String method;

    private String endPoint;

    private String locale;

    private String relationEntity;
    private Instant executeDate;

    private String message;
}
