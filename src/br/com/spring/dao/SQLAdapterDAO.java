package br.com.spring.dao;

import br.com.spring.domain.SQLAdapter;
import br.com.spring.exception.DAOException;
import br.com.spring.mapper.object.SQLAdapterMapper;

public class SQLAdapterDAO extends GenericDAO implements SQLAdapterMapper {

    public SQLAdapterDAO() {
        super();
    }

    public SQLAdapterDAO(org.apache.ibatis.session.SqlSession session) {
        super();
        this.session = session;
    }

    @Override
    public void executeSQL(SQLAdapter sqlAdapter) throws DAOException {
        try {
            SQLAdapterMapper sQLAdapterMapper = session.getMapper(SQLAdapterMapper.class);
            sQLAdapterMapper.executeSQL(sqlAdapter);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw new DAOException(e, "executeSQL(" + sqlAdapter + ")");
        }
    }

    @Override
    public Object executeSQL_Object(SQLAdapter sqlAdapter) throws DAOException {
        try {
            SQLAdapterMapper sQLAdapterMapper = session.getMapper(SQLAdapterMapper.class);
            Object retorno = sQLAdapterMapper.executeSQL_Object(sqlAdapter);
            session.commit();
            return retorno;
        } catch (Exception e) {
            session.rollback();
            throw new DAOException(e + "executeSQL_Object(" + sqlAdapter + ")");
        }
    }

    @Override
    public Long executeSQL_Long(SQLAdapter sqlAdapter) throws DAOException {
        try {
            SQLAdapterMapper sQLAdapterMapper = session.getMapper(SQLAdapterMapper.class);
            Long retorno = sQLAdapterMapper.executeSQL_Long(sqlAdapter);
            session.commit();
            return retorno;
        } catch (Exception e) {
            session.rollback();
            throw new DAOException(e, "executeSQL_Long(" + sqlAdapter + ")");
        }
    }
}
