package com.yunhong.vo;

public class CityAndCountryVo {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCregion() {
        return cregion;
    }

    public void setCregion(String cregion) {
        this.cregion = cregion;
    }

    public int getCpopulation() {
        return cpopulation;
    }

    public void setCpopulation(int cpopulation) {
        this.cpopulation = cpopulation;
    }

    //城市相关信息
    private int id;

    @Override
    public String toString() {
        return "CityAndCountryVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", ccode='" + ccode + '\'' +
                ", cname='" + cname + '\'' +
                ", cregion='" + cregion + '\'' +
                ", cpopulation=" + cpopulation +
                '}';
    }

    private String name;
    private String code;
    private String district;
    private int population;

    //国家相关信息
    private String ccode;
    private String cname;
    private String cregion;
    private int cpopulation;


}
