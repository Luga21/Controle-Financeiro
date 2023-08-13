package br.financeiro.java;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

public class ControleFinanceiro {
    private List<Lancamento> receitas;
    private List<Lancamento> despesas;
    private List<Venda> vendas;
    List<Pessoa> pessoas;
    private List<Produto> produtos;

    public ControleFinanceiro() {
        receitas = new ArrayList<>();
        despesas = new ArrayList<>();
        vendas = new ArrayList<>();
        pessoas = new ArrayList<>();
        produtos = new ArrayList<>();
    }

    public void adicionarReceita(String descricao, String data, double valor) {
        Lancamento receita = new Lancamento(descricao, data, valor);
        receitas.add(receita);
    }

    public void adicionarDespesa(String descricao, String data, double valor) {
        Lancamento despesa = new Lancamento(descricao, data, valor);
        despesas.add(despesa);
    }

   
    public void adicionarVenda(String descricao, String data, double valor, Pessoa comprador) {
        Venda venda = new Venda(descricao, data, valor, comprador);
        vendas.add(venda);
        adicionarReceita(descricao, data, valor); 
    }

    public void cadastrarPessoa(String nome, String cpf, String endereco) {
        Pessoa pessoa = new Pessoa(nome, cpf, endereco);
        pessoas.add(pessoa);
    }

    public void cadastrarProduto(String nome, String descricao, double valor) {
        Produto produto = new Produto(nome, descricao, valor);
        produtos.add(produto);
    }
    
    public double calcularSaldo() {
        double receitaTotal = 0;
        double despesaTotal = 0;

        for (Lancamento receita : receitas) {
            receitaTotal += receita.getValor();
        }

        for (Lancamento despesa : despesas) {
            despesaTotal += despesa.getValor();
        }

        return receitaTotal - despesaTotal;
    }

    //Método para mostrar o histórico de receitas
    public void exibirReceitas() {
        for (Lancamento receita : receitas) {
            System.out.println("Descrição: " + receita.getDescricao());
            System.out.println("Data: " + receita.getData());
            System.out.println("Valor: " + receita.getValor());
            System.out.println("------------------------");
        }
    }

    //Método para mostrar o histórico de despesas
    public void exibirDespesas() {
        for (Lancamento despesa : despesas) {
            System.out.println("Descrição: " + despesa.getDescricao());
            System.out.println("Data: " + despesa.getData());
            System.out.println("Valor: " + despesa.getValor());
            System.out.println("------------------------");
        }
    }

    //Método para mostrar o histórico de vendas
    public void exibirVendas() {
        for (Venda venda : vendas) {
            System.out.println("Descrição: " + venda.getDescricao());
            System.out.println("Data: " + venda.getData());
            System.out.println("Valor: " + venda.getValor());
            System.out.println("Comprador: " + venda.getComprador().getNome());
            System.out.println("------------------------");
        }
    }
    
    public void exibirProdutos() {
        System.out.println("Cadastro de Produtos:");
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Valor: R$" + produto.getValor());
            System.out.println("------------------------");
        }
    }
    
    public void exibirPessoas() {
        System.out.println("Cadastro de Pessoas:");
        for (Pessoa pessoa : pessoas) {
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("CPF: " + pessoa.getCpf());
            System.out.println("Endereço: " + pessoa.getEndereco());
            System.out.println("------------------------");
        }
    }
    
    public void salvarDados(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            //Salvar informações de Pessoas
            writer.write("=== Pessoas ===\n");
            for (Pessoa pessoa : pessoas) {
                writer.write("Nome: " + pessoa.getNome() + "\n");
                writer.write("CPF: " + pessoa.getCpf() + "\n");
                writer.write("Endereço: " + pessoa.getEndereco() + "\n");
                writer.write("------------------------\n");
            }

            //Salvar informações de Produtos
            writer.write("=== Produtos ===\n");
            for (Produto produto : produtos) {
                writer.write("Nome: " + produto.getNome() + "\n");
                writer.write("Descrição: " + produto.getDescricao() + "\n");
                writer.write("Valor: " + produto.getValor() + "\n");
                writer.write("------------------------\n");
            }

            //Salvar informações de Receitas
            writer.write("=== Receitas ===\n");
            for (Lancamento receita : receitas) {
                writer.write("Descrição: " + receita.getDescricao() + "\n");
                writer.write("Data: " + receita.getData() + "\n");
                writer.write("Valor: " + receita.getValor() + "\n");
                writer.write("------------------------\n");
            }

            //Salvar informações de Despesas
            writer.write("=== Despesas ===\n");
            for (Lancamento despesa : despesas) {
                writer.write("Descrição: " + despesa.getDescricao() + "\n");
                writer.write("Data: " + despesa.getData() + "\n");
                writer.write("Valor: " + despesa.getValor() + "\n");
                writer.write("------------------------\n");
            }

            //Salvar informações de Vendas
            writer.write("=== Vendas ===\n");
            for (Venda venda : vendas) {
                writer.write("Descrição: " + venda.getDescricao() + "\n");
                writer.write("Data: " + venda.getData() + "\n");
                writer.write("Valor: " + venda.getValor() + "\n");
                writer.write("Comprador: " + venda.getComprador().getNome() + "\n");
                writer.write("------------------------\n");
            }

            System.out.println("Dados salvos com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os dados no arquivo: " + nomeArquivo);
            e.printStackTrace();
        }
    }
    
    
}
