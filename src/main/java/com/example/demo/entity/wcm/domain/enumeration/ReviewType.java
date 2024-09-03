package com.example.demo.entity.wcm.domain.enumeration;

public enum ReviewType {
    USER("USER"),
    DEPT("DEPT");

    private final String reviewType;

    ReviewType(String reviewType) {
        this.reviewType = reviewType;
    }

    public String getReviewType() {
        return reviewType;
    }
}
