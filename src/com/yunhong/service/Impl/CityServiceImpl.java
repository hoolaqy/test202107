package com.yunhong.service.Impl;

import com.yunhong.dao.CityDao;
import com.yunhong.domain.City;
import com.yunhong.service.CityService;
import com.yunhong.util.SqlSessionUtil;

import java.util.List;

public class CityServiceImpl implements CityService {

    private CityDao cityDao = SqlSessionUtil.getSession().getMapper(CityDao.class);



    @Override
    public City getById(int id) {
        City c = cityDao.getById(id);
        return c;
    }

    @Override
    public void save(City c) {

        cityDao.save(c);

    }

    @Override
    public List<City> getAll() {
        List<City> cList = cityDao.getAll();
        return cList;
    }
}
