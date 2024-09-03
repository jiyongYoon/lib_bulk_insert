package com.example.demo.entity.wcm.domain.enumeration;

import lombok.Getter;

public enum OptionType {
    TEXT("text"),
    TEXT_AREA("textArea"),
    DATE("date"),
    NUMBER("number"),
    CUSTOM_STATUS("customStatus"),
    ;

    @Getter
    private String type;

    OptionType(String type) {
        this.type = type;
    }

}