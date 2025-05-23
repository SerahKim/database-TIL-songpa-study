package com.chapter01_connection_config.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) {
        String resource = "chapter01_connection_config/xmlconfig/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(false);

            // selectOne : 조회할 값이 하나일 때 사용하는 메소드
            java.util.Date date = sqlSession.selectOne("mapper.selectSysdate");
            System.out.println("date = " + date);

            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
