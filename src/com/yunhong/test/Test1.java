package com.yunhong.test;

import com.yunhong.domain.City;
import com.yunhong.service.CityService;
import com.yunhong.service.Impl.CityServiceImpl;
import com.yunhong.util.ServiceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        //CityService cs = new CityServiceImpl();
        CityService cs = (CityService) ServiceFactory.getService(new CityServiceImpl());

//        测试添加操作
//        City c = new City();
//        c.setId(10000);
//        c.setName("WANGG");
//        c.setCode("CHN");
//        c.setDistrict("West-China");
//        c.setPopulation(1200);
//        cs.save(c);

        //测试查询ID查单条操作
//        City c = cs.getById(4081);
//        System.out.println(c);

        //查询所有
        List<City> cList = cs.getAll();
        for (City c:cList) {
            System.out.println(c);
        }

    }

}
