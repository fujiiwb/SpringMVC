package br.com.spring.dao;

import java.util.List;

import br.com.spring.domain.Credencial;
import br.com.spring.exception.DAOException;
import br.com.spring.mapper.object.CredencialMapper;

public class CredencialDAO extends GenericDAO implements CredencialMapper {

    public CredencialDAO() {
        super();
    }

    public CredencialDAO(org.apache.ibatis.session.SqlSession session) {
        super();
        this.session = session;
    }

    @Override
    public Long fixSerialTable() {
        Long retorno = null;
        try {
            CredencialMapper credencialMapper = session.getMapper(CredencialMapper.class);
            retorno = credencialMapper.fixSerialTable();
            session.commit();
        } catch (Exception e) {
            new DAOException(e, "fixSerialTable()").printStackTrace();
        }
        return retorno;
    }

    @Override
    public Credencial getCredencialPorId(Long id) throws DAOException {
        try {
            CredencialMapper credencialMapper = session.getMapper(CredencialMapper.class);
            return credencialMapper.getCredencialPorId(id);
        } catch (Exception e) {
            throw new DAOException(e, "getCredencialPorId(" + id + ")");
        }
    }

    @Override
    public List<Credencial> getListCredencial() throws DAOException {
        try {
            CredencialMapper credencialMapper = session.getMapper(CredencialMapper.class);
            return credencialMapper.getListCredencial();
        } catch (Exception e) {
            throw new DAOException(e, "getListCredencial()");
        }
    }

    @Override
    public void insertCredencial(Credencial credencial) throws DAOException {
    }

    @Override
    public void updateCredencial(Credencial credencial) throws DAOException {
    }

    @Override
    public void deleteCredencial(Long id) throws DAOException {
    }
}
