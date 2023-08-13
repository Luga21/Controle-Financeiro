package br.financeiro.java;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		 ControleFinanceiro controleFinanceiro = new ControleFinanceiro();
	        Scanner scanner = new Scanner(System.in);

	        int opcao = 0;

	        do {
	            System.out.println("====== Controle Financeiro ======");
	            System.out.println("1. Cadastrar Pessoa");
	            System.out.println("2. Cadastrar Produto");
	            System.out.println("3. Adicionar Receita");
	            System.out.println("4. Adicionar Despesa");
	            System.out.println("5. Adicionar Venda");
	            System.out.println("6. Relatório Geral");
	            System.out.println("7. Salvar Dados");
	            System.out.println("0. Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = scanner.nextInt();
	            scanner.nextLine(); //Limpeza do buffer do scanner

	            switch (opcao) {
	                case 1:
	                    System.out.print("Nome: ");
	                    String nome = scanner.nextLine();
	                    System.out.print("CPF: ");
	                    String cpf = scanner.nextLine();
	                    System.out.print("Endereço: ");
	                    String endereco = scanner.nextLine();
	                    controleFinanceiro.cadastrarPessoa(nome, cpf, endereco);
	                    System.out.println("Pessoa cadastrada com sucesso!");
	                    break;
	                case 2:
	                    System.out.print("Nome do produto: ");
	                    String nomeProduto = scanner.nextLine();
	                    System.out.print("Descrição do produto: ");
	                    String descricaoProduto = scanner.nextLine();
	                    System.out.print("Valor do produto: ");
	                    double valorProduto = scanner.nextDouble();
	                    controleFinanceiro.cadastrarProduto(nomeProduto, descricaoProduto, valorProduto);
	                    System.out.println("Produto cadastrado com sucesso!");
	                    break;
	                case 3:
	                    System.out.print("Descrição da receita: ");
	                    String descricaoReceita = scanner.nextLine();
	                    System.out.print("Data da receita: ");
	                    String dataReceita = scanner.nextLine();
	                    System.out.print("Valor da receita: ");
	                    double valorReceita = scanner.nextDouble();
	                    controleFinanceiro.adicionarReceita(descricaoReceita, dataReceita, valorReceita);
	                    System.out.println("Receita adicionada com sucesso!");
	                    break;
	                case 4:
	                    System.out.print("Descrição da despesa: ");
	                    String descricaoDespesa = scanner.nextLine();
	                    System.out.print("Data da despesa: ");
	                    String dataDespesa = scanner.nextLine();
	                    System.out.print("Valor da despesa: ");
	                    double valorDespesa = scanner.nextDouble();
	                    controleFinanceiro.adicionarDespesa(descricaoDespesa, dataDespesa, valorDespesa);
	                    System.out.println("Despesa adicionada com sucesso!");
	                    break;
	                case 5:
	                    System.out.print("Descrição da venda: ");
	                    String descricaoVenda = scanner.nextLine();
	                    System.out.print("Data da venda: ");
	                    String dataVenda = scanner.nextLine();
	                    System.out.print("Valor da venda: ");
	                    double valorVenda = scanner.nextDouble();
	                    System.out.print("Valor da venda: ");
	                    controleFinanceiro.adicionarVenda(descricaoVenda, dataVenda, valorVenda, controleFinanceiro.pessoas.get(0));;
	                    System.out.println("Venda adicionada com sucesso!");
	                    break;
	                case 6:
	                	System.out.println("\n====== Relatório pessoas cadastradas ======");
	                    controleFinanceiro.exibirPessoas();
	                    System.out.println("\n====== Relatório produtos cadastrados ======");
	                    controleFinanceiro.exibirProdutos();
	                    System.out.println("\n====== Relatório histórico de receitas ======");
	                    controleFinanceiro.exibirReceitas();
	                    System.out.println("\n====== Relatório histórico de despesas ======");
	                    controleFinanceiro.exibirDespesas();
	                    System.out.println("\n====== Relatório histórico de vendas ======");
	                    controleFinanceiro.exibirVendas();
	                    break;
	                case 7:
	                	
	                	controleFinanceiro.salvarDados("relatorio.txt");
	                	break;
	                case 0:
	                    System.out.println("Saindo...");
	                    break;
	                default:
	                    System.out.println("Opção inválida!");
	            }

	            System.out.println();
	        } while (opcao != 0);

	        scanner.close();
	    }
	
	}

