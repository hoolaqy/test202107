package com.yunhong.test;

import com.yunhong.dao.CityDao;
import com.yunhong.domain.City;
import com.yunhong.util.SqlSessionUtil;
import com.yunhong.vo.CityAndCountryVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test2 {
    public static void main(String[] args) {

        CityDao cityDao = SqlSessionUtil.getSession().getMapper(CityDao.class);

        //1.测试：parameterType
//        City c = cityDao.select1(55);
//        System.out.println(c);

        //3.测试姓名为WANGG，人口为1200的城市
        //绝对不可以同时为SQL语句传递多个参数
//        List<City> cList= cityDao.select3("WANGG",1200);
//        for (City c : cList){
//            System.out.println(c);
//        }

        //如果我们要为SQL传递多个参数，我们应该将这个参数封装到一个domain对象中，
        //或者是打包到一个map集合中

        //4.测试：parameterType，使用domain为参数 City c
//        City c = new City();
//        c.setPopulation(1200);
//        c.setName("WANGg");
//        List<City> cList = cityDao.select3(c);
//        for (City c1 : cList){
//            System.out.println(c1);
//        }


        //5.测试：parameterType，使用map为参数
        //姓名为WANGG，人口为1200的城市
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","WANGG");
//        map.put("population",1200);
//        List<City> cList = cityDao.select5(map);
//        for (City c:cList){
//            System.out.println(c);
//        }

/*       总结：
           在实际项目开发中，使用domain引用类型或使用map集合类型都可以为SQL语句同时传递多个参数
           一般情况下，我们是用domain就可以了
           当domain不符合需求的情况下，我们一定要考虑使用map来传递多个参数

            在实际项目开发中，一定要学会使用为SQL传值的几种方式
            但是对于在<select>中的parameterType属性，我们一般都是省略不写的
*/
        //测试7.like模糊查询  方式1：使用${}
//        List<City> cityList = cityDao.select7("z");
//        for (City c: cityList)
//        {
//            System.out.println(c);
//
//        }

        //测试8：like模糊查询 方式2：使用#{}  了解
//        List<City> cityList = cityDao.select8("%z%");
//        for (City c: cityList)
//        {
//            System.out.println(c);
//
//        }

        //测试9：like模糊查询 方式2：使用#{}
//        List<City> cityList = cityDao.select9("z");
//        for (City c: cityList)
//        {
//            System.out.println(c);
//
//        }

        //测试10：resultType 返回String类型
        //需求：查询出编号为200的城市名
//        String name = cityDao.select10(20);
//        System.out.println(name);

        //测试11：resultType 返回String类型集合
        //需求：查询出所有城市名
//        List<String> nameList = cityDao.select11();
//        for (String name:nameList){
//            System.out.println(name);
//        }
        //测试12：resultType 返回int类型
        //查询出表中一共有多少条记录
//        int total = cityDao.select12();
//        System.out.println(total);



        //测试13：resultType 返回map类型
        /*
        <select id="", resultType="City">
            select * from city
        </select>

        当我们执行SQL语句之后，通过查询得到的结果id name countrycode等
        根据返回值类型，会自动为我们创建一个对象，又该对象将查询的结果封装起来
        City c1 = new City();
        c1.setID();
        c1.setName();

        当查询出第二条记录，根据返回值类型，再次创建出一个对象，封装第二条记录的值
        City c2 = new City();
        c2.setID();
        c2.setName();

        ......
        多条记录封装称为多个City对象
        系统会自动创建出一个一个List集合来保存这些对象
        List<City> cList = new ArrayList<>();
        cList.add(c1);
        cList.add(c2);

        ......

        --------------------------------------------
        <select id="", resultType="Map">
            select * from city
        </select>

        当我们执行SQL语句之后，通过查询得到的结果id name countrycode等
        根据返回值类型，会自动为我们创建一个对象，又该对象将查询的结果保存起来
        Map<String,Object> map1 = new Map<String,Object>();
        map1.put("id",01);
        map1.put("name","WANGG");

        当查询出第二条记录，根据返回值类型，再次创建出一个对象，保存第二条记录的值
        Map<String,Object> map2 = new Map<String,Object>();
        map2.put("id",02);
        map2.put("name","WANGG");

        ......

        多条记录封装称为多个Map对象
        系统会自动创建出一个一个List集合来保存这些Map对象
        List<Map<String,Object>> mapList = new ArrayList<>();
        mapList.add(map1);
        mapList.add(map2);

        ......


         */

        /*
            对于SQL查询的结果，使用domain来封装结果方便，为什么还用使用map
            因为对于查询的结果，很多情况下，使用domain封装不了，所以我们会使用map来保存结果

            例如：
                需求：根据姓名分组，查询出每一个District的城市数量

                select
                district,count(*)
                from city
                group by district

                对于以上查询结果，使用domain不能封装查询结果，因为没有count属性

                使用返回map一定可以保存查询得到的结果

         */
//        List<Map<String,Object>> mapList = cityDao.select14();
//        for(Map<String,Object> map:mapList){
//
//            Set<String> set = map.keySet();
//            for (String key:set){
//                System.out.println(key +":"+ map.get(key));
//                 }
//            System.out.println("----------------------------");
//
//
//        }


        //测试15：resultType 当数据库表字段名称与domain类属性名称不一致时的处理
        //方式1：SQL语句中对字段起别名，对应domain类的属性

//        List<City> cityList = cityDao.select15();
//        for (City c:cityList){
//
//            System.out.println(c);
//        }


        //测试16：resultType 当数据库表字段名称与domain类属性名称不一致时的处理
        //方式2：使用resultMap

//        List<City> cityList = cityDao.select16();
//        for (City c:cityList){
//
//            System.out.println(c);
//        }


        //测试17：动态SQL where标签结合if标签
//        City c= new City();
//        c.setName("y");
//        c.setDistrict("a");
//        List<City> cityList = cityDao.select17(c);
//        for (City c1:cityList){
//            System.out.println(c1);
//        }

        //测试18：动态SQL foreach标签
//        String strArr[]= {"Tsingdao","JMo","WANGG"};
//        List<City> cityList = cityDao.select18(strArr);
//        for (City c1:cityList){
//            System.out.println(c1);
//        }


        //测试19：SQL片段
//        City c = cityDao.select19(100);
//        System.out.println(c);

        //测试20：多表联查 查询出城市名字和国家名字
//        List<Map<String,Object>> mapList = cityDao.select20();
//        for(Map<String,Object> m:mapList){
//            Set<String> set = m.keySet();
//            for (String key:set){
//                System.out.println(key +':'+ m.get(key));
//            }
//            System.out.println("----------------------------");
//        }

        //测试21：多表联查 查询出城市和国家的所有信息，加VO Value Object
        /*
        在实际项目开发中，如果需要为前端展现的数据，使用一个domain类型不足以表现出这些数据
        这时我们可以考虑使用两种技术实现：
        分别为：
            使用map以及使用vo
        例如我们现在的需求
        查询出城市和国家的所有的信息
        得到的结果使用城市的domain或者国家的domain都不能够封装这些结果

        所以我们可以使用map去保存这些结果
        同时我们可以使用VO类保存这些信息
        VO指的是我们需要创建出一个类，这类中的属性是完全由我们自己去定义，属性会保存所有需要展现的信息
        例如我们本例中，可以使用VO来封装所有与城市和国家相关的信息

        VO
            city
            country
         */
//        List<CityAndCountryVo> voList = cityDao.select21();
//        for(CityAndCountryVo vo:voList){
//            System.out.println(vo);
//        }


        //测试22：查询出带有字母t的城市和国家所有信息

//        List<CityAndCountryVo> voList = cityDao.select22("t");
//        for(CityAndCountryVo vo:voList){
//            System.out.println(vo);
//        }

        /*
        实际项目开发中，如果要为前端同时提供多组值，那么我们应该使用map还是VO呢
        如果前端的需求重复率不高，那我们选择临时使用map就行
        如果前端对于该需求的重复率比较高，那么我们可以创建一个VO类来使用，非常方便
         */



    }
}
