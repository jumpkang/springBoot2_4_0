package com.jumpfrog.springBoot.dynamicReflect.config;

import javassist.Modifier;
import lombok.Data;

@Data
public class MethodDefinition {
    private String resultType = "void";
    private String accessFlag = "public";
    private String name;
    private String[] parameters;
}
