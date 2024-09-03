package com.example.demo.entity.wcm.domain.enumeration.mail;

public enum MailDescription {

    //계약 관련자 관련
    NOTICE_MANAGER("해당 계약서의 프로젝트 수행자로 등록되어 안내드립니다. 해당 계약을 확인하세요."),
    NOTICE_READER("해당 계약서의 프로젝트 열람자로 등록되어 안내드립니다. 계약을 확인하세요."),
    NOTICE_INSPECTOR("해당 계약서의 프로젝트 열람자로 등록되어 안내드립니다. 계약을 확인하세요"),

    //계약 리뷰 관련
    REQUEST_REVIEW("해당 계약서의 리뷰어로 등록되어 안내드립니다. 계약을 확인하고 리뷰하세요."),
    REQUEST_RE_REVIEW("해당 계약서가 수정되었습니다. 계약을 확인하고 재리뷰 하세요."),
    REQUEST_REJECT_STEP2("해당 계약서가 반려되었습니다. 종결함에서 반려된 계약서를 확인하세요."),
    REQUEST_REJECT_STEP3("해당 계약서가 반려되었습니다. 리뷰 프로세스가 재진행됩니다. 리뷰를 확인하여 계약서를 수정해보세요."),

    //계약 상태 관련
    NOTICE_WITHDRAW("해당 계약서가 기안자로부터 회수되어 계약이 진행이 종료되었습니다."),
    NOTICE_END("해당 계약서가 리뷰 완료되지 않고 마감되었습니다. 계약을 확인하세요."),
    NOTICE_CLOSE("해당 계약서가 종결되었습니다. 계약을 확인하세요."),
    NOTICE_EXECUTE("해당 계약서의 리뷰가 모두 완료 및 확정되어 이행단계로 이동되었습니다. 해당 계약을 확인하세요."),
    NOTICE_UPDATE("해당 계약서가 수정되었습니다. 계약을 확인하세요."),

    NOTICE_REVIEW_FINISH("해당 계약서의 리뷰가 완료되었습니다. 계약을 확인하세요");

    private final String mailDescription;

    public String getMailDescriptionToString() {
        return mailDescription;
    }

    MailDescription(String mailType) {
        this.mailDescription = mailType;
    }

}
