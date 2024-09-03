package com.example.demo.entity.wcm.domain.enumeration;

public enum RoleType {
    CREATOR("Creator", "기안자"),
    //리뷰어 (합의자 + 결재자)
    REVIEWER("Reviewer", "리뷰어"),
    READER("Reader", "열람자"),
    INSPECTOR("Inspector", "공람자"),
    MANAGER("Manager", "수행자");

    private final String roleType;

    private final String roleTypeKR;

    RoleType(String roleType, String roleTypeKR) {
        this.roleTypeKR = roleTypeKR;
        this.roleType = roleType;
    }

    public String getRoleTypeKR() {
        return roleTypeKR;
    }

    public String getRoleType() {
        return roleType;
    }

    public static RoleType of(String roleType) {
        for (RoleType type : RoleType.values()) {
            if (roleType.equals(type.getRoleType())) {
                return type;
            }
        }
        return null;
    }
}