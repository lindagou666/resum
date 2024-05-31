package com.lxx.Bean;


public class Honor {
    private int id;
    private int uid;
    private String honor;
    private String time;

    public Honor() {}

    public Honor(int uid, String honor, String time) {
        this.uid = uid;
        this.honor = honor;
        this.time = time;
    }

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

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
