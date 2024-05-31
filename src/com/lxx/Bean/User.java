package com.lxx.Bean;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L; // 防止序列化版本不兼容

    private Integer id;
    private String uId;
    private String name;
    private String phone;
    private Integer age;
    private String sex;
    private String jobName;
    private String education;
    private String schoolName;
    private String username;
    private String password;
    private String hobby;

    public User() {}

    public User(String uId, String name, String phone, Integer age, String sex, String jobName, String education, String schoolName, String username, String password, String hobby) {
        this.uId = uId;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
        this.jobName = jobName;
        this.education = education;
        this.schoolName = schoolName;
        this.username = username;
        this.password = password;
        this.hobby = hobby;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
