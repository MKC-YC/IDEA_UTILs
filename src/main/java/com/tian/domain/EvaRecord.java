package com.tian.domain;

import java.util.List;

public class EvaRecord {
    private Integer evaRecordid;
    private String title;
    private String content;
    private List<Dorm> dorms;

    @Override
    public String toString() {
        return "EvaRecord{" +
                "evaRecordid=" + evaRecordid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dorms=" + dorms +
                '}';
    }

    public Integer getEvaRecordid() {
        return evaRecordid;
    }

    public void setEvaRecordid(Integer evaRecordid) {
        this.evaRecordid = evaRecordid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Dorm> getDorms() {
        return dorms;
    }

    public void setDorms(List<Dorm> dorms) {
        this.dorms = dorms;
    }
}
