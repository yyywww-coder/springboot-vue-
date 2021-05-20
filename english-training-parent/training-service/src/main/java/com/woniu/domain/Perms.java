package com.woniu.domain;

import lombok.Data;

import java.util.List;

@Data
public class Perms {
    private Integer id;
    private String name;
    private String code;
    private String link;
    private Integer parentid;
    private String type;
    private String status;
    private String percode;
    private List<Perms> children;
}
