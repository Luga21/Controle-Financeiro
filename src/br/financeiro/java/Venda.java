package br.financeiro.java;

public class Venda {
    private String descricao;
    private String data;
    private double valor;
    private Pessoa comprador;

    public Venda() {}
    public Venda(String descricao, String data, double valor, Pessoa comprador) {
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.comprador = comprador;
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

    public Pessoa getComprador() {
        return comprador;
    }

    public void setComprador(Pessoa comprador) {
        this.comprador = comprador;
    }
}
