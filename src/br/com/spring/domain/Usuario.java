package br.com.spring.domain;

import java.io.Serializable;

public class Usuario implements Serializable {

    private static final long serialVersionUID = -4834021889470470172L;
    private Long id;
    private String username;
    private String senha;
    private String nome;
    private String sobrenome;
    private Boolean excluido;

    public Usuario() {
        super();
    }

    @Override
    public String toString() {
        return "Usuario ["
               + "id=" + id + ","
               + " username=" + username + ","
               + " senha=" + senha + ","
               + " nome=" + nome + ","
               + " sobrenome=" + sobrenome + ","
               + " excluido=" + excluido
               + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Boolean getExcluido() {
        return excluido;
    }

    public void setExcluido(Boolean excluido) {
        this.excluido = excluido;
    }
}
