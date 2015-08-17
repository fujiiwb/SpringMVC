package br.com.spring.mapper.object;

import br.com.spring.domain.SQLAdapter;
import br.com.spring.exception.DAOException;

public interface SQLAdapterMapper {

	public void executeSQL(SQLAdapter sqlAdapter) throws DAOException;
	
	public Object executeSQL_Object(SQLAdapter sqlAdapter) throws DAOException;
	
	public Long executeSQL_Long(SQLAdapter sqlAdapter) throws DAOException;
}
