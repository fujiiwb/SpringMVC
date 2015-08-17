package br.com.spring.dao;

import org.apache.ibatis.session.SqlSession;

import br.com.spring.Utilities.PostgreConnection;

public class GenericDAO {

    protected SqlSession session = null;

    public final void sessionOpen() {
        try {
            session = PostgreConnection.getSessionFactory().openSession();
            session.getConnection().setAutoCommit(Boolean.FALSE);
        } catch (Exception e) {
            throw new NullPointerException(e.toString());
        }
    }

    public final void sessionClose() {
        if (session != null) {
            try {
                session.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session = null;
            }
        }
    }

    public final SqlSession getSession() {
        return session;
    }

    public final void setSession(SqlSession session) {
        this.session = session;
    }
}
