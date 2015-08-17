package br.com.spring.mapper.object;

import br.com.spring.exception.DAOException;

public interface SpringDBMapper {

    public void generateTables() throws DAOException;

    public void deployTriggers() throws DAOException;

    public void populateTables() throws DAOException;
}
