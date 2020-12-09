package com.jumpfrog.springBoot.dynamicReflect.config;

import lombok.Data;

@Data
public class FieldDefinition {
    private String type;
    private String name;
    private String modifier = "public";
    private Object defaultValue;

}
