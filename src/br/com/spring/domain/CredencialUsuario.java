package br.com.spring.domain;

import java.io.Serializable;

public class CredencialUsuario implements Serializable {

    private static final long serialVersionUID = -8583748649523837491L;
    private Credencial credencial;
    private Usuario usuario;

    public CredencialUsuario() {
        super();
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
