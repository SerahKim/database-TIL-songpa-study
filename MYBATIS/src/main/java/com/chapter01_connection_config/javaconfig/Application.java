package com.chapter01_connection_config.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.lang.reflect.Member;

// -------------------------- MYSQL 설정 시작 -------------------------------
public class Application {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    public static void main(String[] args) {
        /* DB 접속에 관한 환경 설정 */
        /*
        JdbcTransactionFactory : 수동 커밋
        ManagedTranscationFactory : 자동 커밋
        -------------------------------------
        PooledDataSource : ConnectionPool 사용
        UnPooledDataSource : ConnectionPool 미사용
        ConncectionPool : 커넥션을 미리 만들어 놓고 보관하는 POOL
        */
        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(DRIVER, URL, USER, PASSWORD)
        );

        /* 생성한 환경 설정 정보로 MyBatis 설정 객체 생성 */
        Configuration configuration = new Configuration(environment);

        /* 설정 객체에 매퍼 등록 */
        configuration.addMapper(Mapper.class);

        // -------------------------- MYSQL 설정 완료 -------------------------------

        // -------------------------- SqlSession 설정 시작 -------------------------------
        /*
        SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하지 위한 빌드 역할
        build() : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연결된 Stream을 매개변수로 전달하면
                  SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
        */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        /*
        openSession() : SqlSession 인터페이스 타입의 객체를 반환하는 메소드로 boolean 타입을 인자로 전달
        - false : Connection 인터페이스 타입 객체로 DML 수행 후 auto commit에 대한 옵션을 false로 지정 (권장)
        - true : Connection 인터페이스 타입 객체로 DML 수행 후 auto commit에 대한 옵션을 true로 지정
        */
        // JDBC의 Connection con = getConnection();과 같은 역할
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        // -------------------------- SqlSession 설정 완료 -------------------------------

        // -------------------------- Mapper 설정 시작(java 방식) -------------------------------
        /* getMapper() : Configuration에 등록된 매퍼를 동일 타입에 대해 반환하는 메소드 */
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        /* Mapper 인터페이스에 작성된 메소드를 호출하여 쿼리 실행 */
        java.util.Date date = mapper.selectSysDate();
        System.out.println(date);

        // -------------------------- SqlSession 자원 반납 -------------------------------
        sqlSession.close();
    }
}
