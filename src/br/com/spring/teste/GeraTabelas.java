package br.com.spring.teste;

import br.com.spring.dao.SQLAdapterDAO;
import br.com.spring.domain.SQLAdapter;
import br.com.spring.exception.DAOException;

public class GeraTabelas {

    public static void main(String[] args) {
        new GeraTabelas().geraUsuario();
    }

    public void geraUsuario() {
        SQLAdapter sqlAdapter = new SQLAdapter(" DROP TABLE IF EXISTS usuario CASCADE;" + ""
                                               + " CREATE TABLE usuario("
                                               + "    id SERIAL NOT NULL,"
                                               + "    username CHARACTER VARYING(32),"
                                               + "    senha CHARACTER VARYING(128),"
                                               + "    nome_primeiro CHARACTER VARYING(256),"
                                               + "    nome_ultimo CHARACTER VARYING(256),"
                                               + "    CONSTRAINT pk_id_usuario PRIMARY KEY (id),"
                                               + "    CONSTRAINT unique_usuario_username UNIQUE (username)"
                                               + " );");
        try {
            new SQLAdapterDAO().executeSQL(sqlAdapter);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
