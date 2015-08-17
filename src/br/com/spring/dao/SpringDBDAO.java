package br.com.spring.dao;

import br.com.spring.exception.DAOException;
import br.com.spring.mapper.object.SpringDBMapper;

public class SpringDBDAO extends GenericDAO implements SpringDBMapper {

    public SpringDBDAO() {
        super();
    }

    public SpringDBDAO(org.apache.ibatis.session.SqlSession session) {
        super();
        this.session = session;
    }

    public static void main(String[] args) throws Exception {
        new SpringDBDAO().generateTables();
    }

    public final void generateDatabase() throws DAOException {
        try {
            generateTables();
            deployTriggers();
            populateTables();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateTables() throws DAOException {
        try {
            SpringDBMapper springDBMapper = session.getMapper(SpringDBMapper.class);
            springDBMapper.generateTables();
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        }
    }

    @Override
    public void deployTriggers() throws DAOException {
        try {
            SpringDBMapper springDBMapper = session.getMapper(SpringDBMapper.class);
            springDBMapper.deployTriggers();
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        }
    }

    @Override
    public void populateTables() throws DAOException {
        try {
            SpringDBMapper springDBMapper = session.getMapper(SpringDBMapper.class);
            springDBMapper.populateTables();
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        }
    }
}
