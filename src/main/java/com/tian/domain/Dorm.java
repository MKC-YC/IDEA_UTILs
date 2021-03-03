package com.tian.domain;

import java.util.List;

public class Dorm {
    private Integer dormid;
    private Integer apartmentid;
    private boolean door;
    private boolean lamp;
    private boolean bed;
    private boolean watertap;
    private boolean shower;
    private boolean toilet;
    private String comment;

    private List<Student> students;

    private List<EvaRecord> evaRecords;

    public Integer getDormid() {
        return dormid;
    }

    public void setDormid(Integer dormid) {
        this.dormid = dormid;
    }

    public Integer getApartmentid() {
        return apartmentid;
    }

    public void setApartmentid(Integer apartmentid) {
        this.apartmentid = apartmentid;
    }

    public boolean isDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    public boolean isLamp() {
        return lamp;
    }

    public void setLamp(boolean lamp) {
        this.lamp = lamp;
    }

    public boolean isBed() {
        return bed;
    }

    public void setBed(boolean bed) {
        this.bed = bed;
    }

    public boolean isWatertap() {
        return watertap;
    }

    public void setWatertap(boolean watertap) {
        this.watertap = watertap;
    }

    public boolean isShower() {
        return shower;
    }

    public void setShower(boolean shower) {
        this.shower = shower;
    }

    public boolean isToilet() {
        return toilet;
    }

    public void setToilet(boolean toilet) {
        this.toilet = toilet;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<EvaRecord> getEvaRecords() {
        return evaRecords;
    }

    public void setEvaRecords(List<EvaRecord> evaRecords) {
        this.evaRecords = evaRecords;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "dormid=" + dormid +
                ", apartmentid=" + apartmentid +
                ", door=" + door +
                ", lamp=" + lamp +
                ", bed=" + bed +
                ", watertap=" + watertap +
                ", shower=" + shower +
                ", toilet=" + toilet +
                ", comment='" + comment + '\'' +
                ", students=" + students +
                ", evaRecords=" + evaRecords +
                '}';
    }
}
