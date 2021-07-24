package com.yunhong.dao;

import com.yunhong.domain.City;
import com.yunhong.vo.CityAndCountryVo;

import java.util.List;
import java.util.Map;

public interface CityDao {
    public City getById(int id);

    public void save(City c);

    List<City> getAll();

    City select1(int i);


    List<City> select3(City c);

    List<City> select5(Map<String, Object> map);

    List<City> select7(String z);

    List<City> select8(String z);

    List<City> select9(String z);

    String select10(int i);

    List<String> select11();

    int select12();

    List<Map<String, Object>> select14();

    List<City> select15();

    List<City> select16();

    List<City> select17(City c);

    List<City> select18(String[] strArr);

    City select19(int i);

    List<Map<String, Object>> select20();

    List<CityAndCountryVo> select21();

    List<CityAndCountryVo> select22(String t);
}
