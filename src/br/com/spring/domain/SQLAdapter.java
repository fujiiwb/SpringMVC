package br.com.spring.domain;

public class SQLAdapter {

    private String sql;

    @Override
    public String toString() {
        return "SQLAdapter [sql=" + sql + "]";
    }

    public SQLAdapter(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
