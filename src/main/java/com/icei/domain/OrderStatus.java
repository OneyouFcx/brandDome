package com.icei.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class OrderStatus {
    private Integer statusId;
    @Excel(name = "订单状态", orderNum = "1")
    private String statusDec;

    private Integer parentId;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusDec() {
        return statusDec;
    }

    public void setStatusDec(String statusDec) {
        this.statusDec = statusDec;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}