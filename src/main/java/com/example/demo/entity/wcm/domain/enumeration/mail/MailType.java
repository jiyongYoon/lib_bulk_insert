package com.example.demo.entity.wcm.domain.enumeration.mail;

public enum MailType {

    //계약 관련자 관련
    NOTICE_MANAGER("수행 안내"),
    NOTICE_READER("열람 안내"),
    NOTICE_INSPECTOR("공람 안내"),


    //계약 리뷰 관련
    REQUEST_REVIEW("리뷰 요청"),
    REQUEST_RE_REVIEW("리뷰 재요청"),


    //계약 상태 관련
    NOTICE_WITHDRAW("회수 안내"),
    NOTICE_END("마감 안내"),
    NOTICE_EXECUTE("이행 안내"),
    NOTICE_REJECT("반려 안내"),
    NOTICE_UPDATE("변경 안내"),
    NOTICE_CLOSE("종결 안내"),

    NOTICE_REVIEW_FINISH("리뷰 완료"),
    // 멘션
    NOTICE_MENTION("멘션 알림"),
    // 비밀번호 변경
    REQUEST_PASSWORD_RESET("비밀번호 변경 요청");

    private String mailType;

    public String getMailTypeToString() {
        return mailType;
    }

    MailType(String mailType) {
        this.mailType = mailType;
    }

    public String getMailSubjectWithContractName(String projectName, String contractName, String wsName) {
        return "[" + projectName + ": " + mailType + "] " + wsName + " 계약서 \"" + contractName + " \"";
    }

    public String getMailSubject(String projectName) {
        return "[" + projectName + ": " + mailType + "]";
    }

}
