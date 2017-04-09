package com.ssm.model;

public class City {
    private int classId;
    private int classParentId;
    private String className;
    private int classType;

    public int getClassId() {
        return classId;
    }
    public void setClassId(int classId) {
        this.classId = classId;
    }
    public int getClassParentId() {
        return classParentId;
    }
    public void setClassParentId(int classParentId) {
        this.classParentId = classParentId;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public int getClassType() {
        return classType;
    }
    public void setClassType(int classType) {
        this.classType = classType;
    }
}
