package com.example.demo.entity.wcm.domain.enumeration.mail;

public enum MailTitle {

    //계약 관련자 관련
    NOTICE_MANAGER("[WCM: 수행 안내]"),
    NOTICE_READER("[WCM: 열람 안내]"),

    //계약 리뷰 관련
    REQUEST_REVIEW("[WCM: 리뷰 요청]"),
    REQUEST_RE_REVIEW("[WCM: 리뷰 재요청]"),

    //계약 상태 관련
    NOTICE_WITHDRAW("[WCM: 회수 안내]"),
    NOTICE_END("[WCM: 마감 안내]"),
    NOTICE_EXECUTE("[WCM: 이행 안내]"),
    NOTICE_UPDATE("[WCM: 변경 안내]")
    ;

    public String mailTitle;
    public String getMailTitle() {
        return mailTitle;
    }

    MailTitle(String mailTitle) {
        this.mailTitle = mailTitle;
    }

    public String toString(String projectName) {
        return "["+projectName+" : "+getMailTitle();
    }
}
