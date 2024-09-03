package com.example.demo.entity.wcm.domain.enumeration;

/**
 * TEMPLATE -> 탬플릿에서 등록된 유저 <br>
 * CONTRACT -> 계약서에서 작성자가 추가한 유저 <br>
 * MANAGER  -> 계약서 준비단계(STEP 1)에서 수행자로써 리뷰어 히스토리에 등록되는 유저
 */
public enum OriginType {
    TEMPLATE("Template"),
    CONTRACT("Contract"),
    MANAGER("Manager")
    ;

    private final String status;

    OriginType(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
