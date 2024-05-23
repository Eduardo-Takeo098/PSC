package com.GraphiFlow.project_PSC.entities.enums;

public enum ProjectStatus {

    WAITING_DELIVERY(1),
    SHIPPED(2),
    DELIVERED(3),
    CANCELED(4);

    private int code;

    private ProjectStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ProjectStatus valueOf(int code) {
        for (ProjectStatus value : ProjectStatus.values())  {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código inválido" + code);
    }
}
