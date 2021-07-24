package com.yunhong.util;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {

    //构造器私有化
    private SqlSessionUtil(){}

    private static SqlSessionFactory sqlSessionFactory;

    //static在类方法执行之前优先执行，且只执行一次
    static {

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

    }

    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();


    //取得SqlSession对象
    public static SqlSession getSession(){

        SqlSession session = t.get();
        if (session==null){

            session = sqlSessionFactory.openSession();

            t.set(session);

        }

        return session;
    }

    //关闭SqlSession对象
    public static void myClose(SqlSession session){

        if(session!=null){

            session.close();

            //这句必须加，非常容易忘
            t.remove();
        }
    }

}
