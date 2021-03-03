package com.tian.domain;

import java.util.List;

public class Apartment {
    private Integer apartmentid;
    private Integer fee;
    private Integer maxoccupancy;

    private List<Dorm> dorms;

    public Integer getApartmentid() {
        return apartmentid;
    }

    public void setApartmentid(Integer apartmentid) {
        this.apartmentid = apartmentid;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }



    public List<Dorm> getDorms() {
        return dorms;
    }

    public void setDorms(List<Dorm> dorms) {
        this.dorms = dorms;
    }

    public Integer getMaxoccupancy() {
        return maxoccupancy;
    }

    public void setMaxoccupancy(Integer maxoccupancy) {
        this.maxoccupancy = maxoccupancy;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentid=" + apartmentid +
                ", fee=" + fee +
                ", maxoccupancy=" + maxoccupancy +
                ", dorms=" + dorms +
                '}';
    }

}
