package com.example.demo.entity.wcm.domain.audit;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AuditLogEvent {

    private Long userId;
    private Long targetId;
    private AuditEventType auditEventType;


    public AuditLogEvent(Long userId, AuditEventType auditEventType){
        this.userId=userId;
        this.targetId=null;
        this.auditEventType = auditEventType;
    }
    public AuditLogEvent(Long userId, Long targetId, AuditEventType auditEventType) {
        this.userId = userId;
        this.targetId = targetId;
        this.auditEventType = auditEventType;
        if (userId == null) {
            this.userId = targetId;
            this.targetId = null;
        }
    }
}
