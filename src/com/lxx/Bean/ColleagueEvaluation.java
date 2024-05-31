package com.lxx.Bean;

import java.io.Serializable;

public class ColleagueEvaluation implements Serializable {
    private static final long serialVersionUID = 1L; // 防止序列化版本不兼容

    private Integer id;
    private Integer uid;
    private String companyName;
    private String leader;
    private String describes;

    public ColleagueEvaluation() {}

    public ColleagueEvaluation(Integer uid, String companyName, String leader, String describes) {
        this.uid = uid;
        this.companyName = companyName;
        this.leader = leader;
        this.describes = describes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getDescribe() {
        return describes;
    }

    public void setDescribe(String describe) {
        this.describes = describes;
    }
}
