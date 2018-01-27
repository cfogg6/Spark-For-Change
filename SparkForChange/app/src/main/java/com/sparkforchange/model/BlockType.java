package com.sparkforchange.model;

/**
 * Created by Nancy on 01/27/2018.
 */

public enum BlockType {
    CHARITY_TO_USER(0), USER_TO_COMPANY(1), COMPANY_TO_CHARITY(2);

    private final int ordinal;

    BlockType(int ordinal) {
        this.ordinal = ordinal;
    }

    public int getOrdinal() {
        return ordinal;
    }
}
