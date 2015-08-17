package br.com.spring.dao;

import java.util.List;

import br.com.spring.domain.Usuario;
import br.com.spring.exception.DAOException;
import br.com.spring.mapper.object.UsuarioMapper;

public class UsuarioDAO extends GenericDAO implements UsuarioMapper {

    public UsuarioDAO() {
        super();
    }

    public UsuarioDAO(org.apache.ibatis.session.SqlSession session) {
        super();
        this.session = session;
    }

    public static void main(String[] args) throws Exception {
        Usuario usuario = new UsuarioDAO().getUsuarioPorId(1L);
        System.out.println(usuario.getId() + " - " + usuario.getUsername());
    }

    @Override
    public Long fixSerialTable() {
        Long retorno = null;
        try {
            UsuarioMapper usuarioMapper = session.getMapper(UsuarioMapper.class);
            retorno = usuarioMapper.fixSerialTable();
            session.commit();
        } catch (Exception e) {
            new DAOException(e, "fixSerialTable()").printStackTrace();
        }
        return retorno;
    }

    @Override
    public Usuario getUsuarioPorId(Long id) throws DAOException {
        try {
            UsuarioMapper usuarioMapper = session.getMapper(UsuarioMapper.class);
            return usuarioMapper.getUsuarioPorId(id);
        } catch (Exception e) {
            throw new DAOException(e, "getUsuarioPorId(" + id + ")");
        }
    }

    @Override
    public void insertUsuario(Usuario usuario) throws DAOException {
        try {
            UsuarioMapper usuarioMapper = session.getMapper(UsuarioMapper.class);
            usuarioMapper.insertUsuario(usuario);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            fixSerialTable();
            throw new DAOException(e, "insertUsuario(" + usuario + ")");
        }
    }

    @Override
    public List<Usuario> getListUsuarios() throws DAOException {
        try {
            UsuarioMapper usuarioMapper = session.getMapper(UsuarioMapper.class);
            return usuarioMapper.getListUsuarios();
        } catch (Exception e) {
            throw new DAOException(e, "getListUsuarios()");
        }
    }

    @Override
    public void updateUsuario(Usuario usuario) throws DAOException {
        try {
            UsuarioMapper usuarioMapper = session.getMapper(UsuarioMapper.class);
            usuarioMapper.updateUsuario(usuario);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw new DAOException(e, "updateUsuario(" + usuario + ")");
        }
    }

    @Override
    public void deleteUsuario(Long id) throws DAOException {
        try {
            UsuarioMapper usuarioMapper = session.getMapper(UsuarioMapper.class);
            usuarioMapper.deleteUsuario(id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw new DAOException(e, "deleteUsuario(" + id + ")");
        }
    }
}
