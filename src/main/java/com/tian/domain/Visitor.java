package com.tian.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Visitor {
    private String viname;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date vitime;
    private String telephone;
    private String remark;
    private Integer vid;

    @Override
    public String toString() {
        return "Visitor{" +
                "viname='" + viname + '\'' +
                ", vitime=" + vitime +
                ", telephone=" + telephone +
                ", remark='" + remark + '\'' +
                ", vid=" + vid +
                '}';
    }

    public String getViname() {
        return viname;
    }

    public void setViname(String viname) {
        this.viname = viname;
    }

    public Date getVitime() {
        return vitime;
    }

    public void setVitime(Date vitime) {
        this.vitime = vitime;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String  telephone) {
        this.telephone = telephone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }
}
