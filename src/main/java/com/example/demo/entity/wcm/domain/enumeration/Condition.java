package com.example.demo.entity.wcm.domain.enumeration;


public enum Condition {
    WRITER("writer"),
    CONTRACT_NAME("contract_name"),
    COMPANY("company"),
    ALL("all"); // 검색 조건이 없는 경우 default 값.
    private final String text;

    Condition(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
