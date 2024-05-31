package com.lxx.Bean;

public class WorkExperience {
    private int id;
    private int uId;
    private String companyName;
    private String jobName;
    private String startTime;
    private String endTime;
    private String describes;
    private String address;

    // 默认构造函数
    public WorkExperience() {}

    // 带参数的构造函数
    public WorkExperience(int uId, String companyName, String jobName, String startTime,
                         String endTime, String describes, String address) {
        this.uId = uId;
        this.companyName = companyName;
        this.jobName = jobName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.describes = describes;
        this.address = address;
    }

    // Getter and Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUId() {
        return uId;
    }

    public void setUId(int uId) {
        this.uId = uId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
