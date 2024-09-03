package com.example.demo.entity.wcm.domain.audit;

import com.example.demo.entity.wcm.domain.string.TableName;

import static com.example.demo.entity.wcm.domain.string.TableName.CONTRACT;
import static com.example.demo.entity.wcm.domain.string.TableName.USER;

public enum AuditEventType {

    CREATE_CONTRACT("CREATE","%s번 사용자가 %s번 계약서를 생성했습니다.",CONTRACT),
    CREATE_POST_CONTRACT("CREATE","%S번 사용자가 %s번 이행 계약서를 생성했습니다.",CONTRACT),
    CREATE_PRE_CONTRACT("CREATE","%S번 사용자가 %s번 준비 계약서를 생성했습니다.",CONTRACT),

    CREATE_COMMENT("CREATE","%s번 사용자가 %s번 코멘트를 생성했습니다", TableName.CONTRACT_COMMENT),
    CONTRACT_REVIEW("REVIEW_CONFIRM", "%s번 사용자가 %s번 계약서를 리뷰하였습니다.",TableName.REVIEWER_HISTORY),

    CONTRACT_REVIEW_CANCEL("REVIEW_CANCEL","%s번 사용자가 %s 번 계약서 리뷰를 취소하였습니다",TableName.REVIEWER_HISTORY),
    CONTRACT_REVIEW_REJECT("REVIEW_REJECT","%s번 사용자가 %s 번 계약서를 반려하였습니다",TableName.REVIEWER_HISTORY),
    CREATE_COMPANY("CREATE","%s번 사용자가 %s번 회사를 생성했습니다", TableName.COMPANY),
    CREATE_CONTACT("CREATE","%s번 사용자가 %s번 연락처를 생성했습니다.",TableName.CONTACT),
    PUT_CONTRACT("PUT","%s번 사용자가 %s번 계약서를 수정했습니다.", CONTRACT),

    PUT_PRE_CONTRACT("PUT","%s번 사용자가 %s번 준비 계약서를 수정했습니다.",CONTRACT),
    PUT_POST_CONTRACT("PUT","%s번 사용자가 %s번 이행 계약서를 수정했습니다.",CONTRACT),
    PUT_COMPANY("PUT","%s번 사용자가 %s번 회사를 수정했습니다",TableName.COMPANY),
    PUT_CONTACT("PUT","%s번 사용자가 %s번 연락처를 수정했습니다.",TableName.CONTACT),
    USER_LOGIN("LOGIN","%s번 사용자가 로그인 하였습니다" ,USER ),
    USER_LOGOUT("LOGOUT","%s번 사용자가 로그아웃 하였습니다",USER);


    private String type;
    private String logText;
    private String relationEntity;

    AuditEventType(String type, String logText, String relationEntity) {
        this.type = type;
        this.logText = logText;
        this.relationEntity = relationEntity;
    }

    public String getType() {
        return this.type;
    }

    public String getRelationEntity() {
        return this.relationEntity;
    }

    public String getLogText() {
        return this.logText;
    }
}
