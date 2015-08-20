package br.com.spring.mapper.object;

import java.util.List;

import br.com.spring.domain.Usuario;
import br.com.spring.exception.DAOException;

public interface UsuarioMapper {

    public Long fixSerialTable();

    public Usuario getUsuarioPorId(Long id) throws DAOException;

    public void insertUsuario(Usuario usuario) throws DAOException;

    public List<Usuario> getListUsuarios() throws DAOException;

    public List<Usuario> getListUsuariosPorNome(String nome) throws DAOException;

    public void updateUsuario(Usuario usuario) throws DAOException;

    public void deleteUsuario(Long id) throws DAOException;
}
