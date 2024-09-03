package com.example.demo.entity.wcm.domain.enumeration;

public enum ContractHistoryStatus {

    HISTORY("History"),
    HISTORY_TEMPORARY_SAVE("TemporarySave");
    private final String status;

    ContractHistoryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
