package com.yunhong.service;

import com.yunhong.domain.City;

import java.util.List;

public interface CityService {

    public City getById(int id);

    public void save(City c);

    List<City> getAll();
}
