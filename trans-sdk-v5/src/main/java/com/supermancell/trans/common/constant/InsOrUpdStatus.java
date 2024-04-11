package com.supermancell.trans.common.constant;

public enum InsOrUpdStatus {

    //0-有记录但没有更新 1-更新成功 2-新增
    NOTHING(0),
    UPDATE(1),
    INSERT(2),
    REMOVE(-1),
    ;

    private int v;

    InsOrUpdStatus(int v) {
        this.v = v;
    }

    public int v() {
        return v;
    }
}
