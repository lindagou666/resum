package com.lxx.Bean;

public class Skill {
    private int id;
    private Integer uId;
    private String name;
    private String proficiency;

    // 默认构造函数
    public Skill() {}

    // 带参数的构造函数
    public Skill(Integer uId, String name, String proficiency) {
        this.uId = uId;
        this.name = name;
        this.proficiency = proficiency;
    }

    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }
}
