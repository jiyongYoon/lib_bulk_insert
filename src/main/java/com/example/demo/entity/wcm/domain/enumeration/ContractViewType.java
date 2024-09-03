package com.example.demo.entity.wcm.domain.enumeration;


public enum ContractViewType {


    MY_PROCESS("my-process"),
    MY_DONE("my-done"),
    MY_WITHDRAW("my-withdraw"),
    MY_TEMPORARY("my-temporary"),
    REVIEW_PROCESS("review-process"),
    REVIEW_MANAGER("review-manager"),
    REVIEW_DONE("review-done"),



    ;
    private final String text;

    ContractViewType(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}