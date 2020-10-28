package com.ab.consul.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private long natId;
    private String name;
    private String city;
}
