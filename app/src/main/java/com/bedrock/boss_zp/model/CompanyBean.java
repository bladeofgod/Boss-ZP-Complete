package com.bedrock.boss_zp.model;

public class CompanyBean {

    String name;
    String icon;
    String location;
    String attributes;
    String wantedDetail;

    public CompanyBean(){}

    public CompanyBean(String name, String icon, String location, String attributes, String wantedDetail) {
        this.name = name;
        this.icon = icon;
        this.location = location;
        this.attributes = attributes;
        this.wantedDetail = wantedDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getWantedDetail() {
        return wantedDetail;
    }

    public void setWantedDetail(String wantedDetail) {
        this.wantedDetail = wantedDetail;
    }
}
