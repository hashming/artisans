package com.duoduo.hashming.artisan.enums;

public enum CommetTypeEnum {
    QUESTION(1),
    COMMENT(2);
    private Integer type;

    public Integer getType() {
        return type;
    }

    CommetTypeEnum(Integer type) {
        this.type = type;
    }
}
