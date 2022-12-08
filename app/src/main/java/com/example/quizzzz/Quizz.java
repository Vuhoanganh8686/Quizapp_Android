package com.example.quizzzz;

public class Quizz {
    private String mon;
    private  String level;
    private int scd;
    private long time;

    public Quizz(String mon, String level, int scd, long time) {
        this.mon = mon;
        this.level = level;
        this.scd = scd;
        this.time = time;
    }

    public Quizz() {

    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getScd() {
        return scd;
    }

    public void setScd(int scd) {
        this.scd = scd;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
