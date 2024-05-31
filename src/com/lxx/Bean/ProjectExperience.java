package com.lxx.Bean;

public class ProjectExperience {
    private int id;
    private int uid;
    private String projectName;
    private String describes;

    // 默认构造函数
    public ProjectExperience() {}

    // 带参数的构造函数
    public ProjectExperience(int uid, String projectName, String describes) {
        this.uid = uid;
        this.projectName = projectName;
        this.describes = describes;
    }

    // Getter and Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
}
