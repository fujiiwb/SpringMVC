package br.com.spring.Utilities;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;

public class PostgreConnection {

    private static final String CAMINHO_XML = "/mybatis-config.xml";
    private static SqlSessionFactory sessionFactorySpring;

    public static void main(String[] args) {
        System.out.println("Status: 0");
        new PostgreConnection();
        System.out.println("Status: 1");
    }

    static {
        System.out.println("[PostgreConnection] STATIC");
        try {
            InputStream input = Resources.getResourceAsStream(CAMINHO_XML);
            sessionFactorySpring = new SqlSessionFactoryBuilder().build(input);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    private static SqlSessionFactory buildSessionFactory() throws Exception {
        System.out.println("[PostgreConnection] PRIVATE");
        try {
            InputStream input = Resources.getResourceAsStream(CAMINHO_XML);
            sessionFactorySpring = new SqlSessionFactoryBuilder().build(input);
            return sessionFactorySpring;
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SqlSessionFactory getSessionFactory() throws Exception {
        if (sessionFactorySpring == null) {
            sessionFactorySpring = buildSessionFactory();
        }
        return sessionFactorySpring;
    }

    public static SqlSessionManager getSessionManager() throws Exception {
        if (sessionFactorySpring == null) {
            sessionFactorySpring = buildSessionFactory();
        }
//        sqlSessionManager.startManagedSession(org.apache.ibatis.session.ExecutorType.BATCH,
//                                              org.apache.ibatis.session.TransactionIsolationLevel.READ_UNCOMMITTED);
        return SqlSessionManager.newInstance(sessionFactorySpring);
    }
}
