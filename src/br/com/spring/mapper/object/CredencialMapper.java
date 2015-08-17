package br.com.spring.mapper.object;

import java.util.List;

import br.com.spring.domain.Credencial;
import br.com.spring.exception.DAOException;

public interface CredencialMapper {

    public Long fixSerialTable();

    public Credencial getCredencialPorId(Long id) throws DAOException;

    public List<Credencial> getListCredencial() throws DAOException;

    public void insertCredencial(Credencial credencial) throws DAOException;

    public void updateCredencial(Credencial credencial) throws DAOException;

    public void deleteCredencial(Long id) throws DAOException;
}
