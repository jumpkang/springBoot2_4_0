package com.jumpfrog.springBoot.dynamicReflect.config;

import lombok.Data;

import java.util.List;

@Data
public class ClassDefinition {

    private String className;

    private List<FieldDefinition> fields;

    private List<MethodDefinition> methods;

}
