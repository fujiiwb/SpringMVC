package br.com.spring.domain;

import java.io.Serializable;

public class Sistema implements Serializable {

    private static final long serialVersionUID = 2618107703974581944L;
    private Long id;
    private String nome;
    private String observacao;
    private Boolean excluido;

    public Sistema() {
        super();
    }

    @Override
    public String toString() {
        return "Sistema [id=" + id + ", nome=" + nome + ", observacao=" + observacao + ", excluido=" + excluido + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
