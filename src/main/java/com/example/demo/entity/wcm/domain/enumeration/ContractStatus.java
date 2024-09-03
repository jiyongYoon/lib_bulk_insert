package com.example.demo.entity.wcm.domain.enumeration;


public enum ContractStatus {
    REVIEWING("Reviewing"), // 1, 2, 3 리뷰중
    CONFIRM("Confirm"), // 리뷰완료 (없어질 상태, 바로 3단계로 넘어가기 때문에)
    TEMPORARY_SAVE("TemporarySave"), // 1, 2 임시저장
    WITHDRAW("Withdraw"), // 1, 2 회수됨
    END("End"), // 2 기한만료
    EXECUTING("Executing"), // 3 이행중
    FINISH("Finish"), // 1(임시 -> 등록), 2(2 -> 3) 완료
    COMPLETE("Complete"), // 3 이행완료
    READY("Ready"), // 1 (1 -> 2로 넘어가서 임시저장인 상태)
    REJECT("Reject"), // 2 반려
    CLOSE("Close"), // 모든 단계에서 계약서 종결하기
    ;

    private final String status;

    ContractStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}