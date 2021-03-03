package com.tian.domain;

public class Student {
    private Integer stuid;
    private String stupassword;
    private String stuname;
    private String gender;
    private Integer dormid;
    private String college;
    private String major;
    private String telephone;

    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", stupassword='" + stupassword + '\'' +
                ", stuname='" + stuname + '\'' +
                ", gender='" + gender + '\'' +
                ", dormid=" + dormid +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", telephone=" + telephone +
                '}';
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStupassword() {
        return stupassword;
    }

    public void setStupassword(String stupassword) {
        this.stupassword = stupassword;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getDormid() {
        return dormid;
    }

    public void setDormid(Integer dormid) {
        this.dormid = dormid;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String  getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
