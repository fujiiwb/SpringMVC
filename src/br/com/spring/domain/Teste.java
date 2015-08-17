package br.com.spring.domain;

import java.io.Serializable;

public class Teste implements Serializable{

    private static final long serialVersionUID = 2945695693336997300L;
    private String aaaa;
    private String bbbb;

    public Teste() {
        super();
    }

    @Override
    public String toString() {
        return "Teste [aaaa=" + aaaa + ", bbbb=" + bbbb + "]";
    }

    public String getAaaa() {
        return aaaa;
    }

    public void setAaaa(String aaaa) {
        this.aaaa = aaaa;
    }

    public String getBbbb() {
        return bbbb;
    }

    public void setBbbb(String bbbb) {
        this.bbbb = bbbb;
    }
}
