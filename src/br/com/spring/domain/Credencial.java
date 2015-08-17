package br.com.spring.domain;

import java.io.Serializable;

public class Credencial implements Serializable {

    private static final long serialVersionUID = 8138365696251271212L;
    private Long id;
    private Sistema sistema;
    private Usuario usuario;
    private String login;
    private String senha;
    private String observacao;
    private Boolean excluido;

    public Credencial() {
        super();
    }

    @Override
    public String toString() {
        return "Credencial [id=" + id
               + ", sistema=" + sistema
               + ", usuario=" + usuario
               + ", login=" + login
               + ", senha=" + senha
               + ", observacao=" + observacao
               + ", excluido=" + excluido + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Boolean getExcluido() {
        return excluido;
    }

    public void setExcluido(Boolean excluido) {
        this.excluido = excluido;
    }
}
