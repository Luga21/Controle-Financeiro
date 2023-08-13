package br.financeiro.java;

public class Lancamento {
    private String descricao;
    private String data;
    private double valor;
    
    public Lancamento() {}

    public Lancamento(String descricao, String data, double valor) {
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
