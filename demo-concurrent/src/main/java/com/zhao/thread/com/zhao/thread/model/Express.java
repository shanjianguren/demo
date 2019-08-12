package com.zhao.thread.com.zhao.thread.model;

public class Express {

    private String site ="jingzhou";
    private Integer km=100;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Express(String site, Integer km) {
        this.site = site;
        this.km = km;
    }
}
