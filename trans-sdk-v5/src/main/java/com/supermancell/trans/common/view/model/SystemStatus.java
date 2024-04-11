package com.supermancell.trans.common.view.model;

import lombok.Data;

@Data
public class SystemStatus {

    private Long id;
    private String title;
    private Long begin;
    private Long end;
    private String href;
    private Integer serviceType;
    private String state;
    private String scheDesc;
    private String env;
}
