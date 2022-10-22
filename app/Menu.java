package app;
import java.util.*;

import model.Datas;
import model.Produto;
import model.Venda;
import repository.Repositorio;


public class Menu {
    
    private int opcao;
    Scanner leia = new Scanner(System.in);
    Repositorio repositorio = new Repositorio();    
    
    public void menuPrincipal(){
        do {
            clear();
            System.out.println("1- Incluir produto");
            System.out.println("2- Consultar produto");
            System.out.println("3- Listagem de produtos");
            System.out.println("4- Vendas por períodos");
            System.out.println("5- Realizar venda");
            System.out.println("0- Sair");
            opcao = leia.nextInt();
            leia.nextLine();
            clear();

            
                
            
            switch (opcao) {
                case 1:
                System.out.println("*****Incluir Produtos*****");
                System.out.println("Digite o código do Produto: ");
                String codigo = leia.nextLine();
                System.out.println("Diga o nome do Produto: ");
                String nome = leia.nextLine();
                System.out.println("Digite o valor do Produto: ");
                Double valor = leia.nextDouble();
                leia.nextLine();
                System.out.println("Digite a quantidade em Estoque: ");
                int quantidade = leia.nextInt();
                
                repositorio.adicionarProduto(new Produto(codigo, nome, valor, quantidade));
                System.out.println("Produto adicionado com sucesso");
                voltarMenu();
             
                    break;
            
                case 2:
                    System.out.println("*****Consultar Produtos*****");
                    repositorio.verificarProdutos();
                    System.out.println("Digite o nome do produto que quer procurar: ");
                    String nomeProduto = leia.nextLine();
                    
                        Produto produto = repositorio.buscarProduto(nomeProduto);
                        System.out.println(produto);
                        voltarMenu();
                    
                    break;
                case 3:   
                System.out.println("*****Listagem de Produtos*****"); 
                    repositorio.listarProdutos();

                    
                        voltarMenu();

                    
                    break;
                case 4:
                
                System.out.println("*****Vendas por Período*****");
                System.out.println("Digite a Data Inicial: ");
                String dataInicial = leia.nextLine();
                System.out.println("Digite a data Final: ");
                String dataFinal = leia.nextLine();
                repositorio.adicionarData(new Datas(dataInicial, dataFinal));

                    repositorio.filtrarVendasPorHorario();
                
                    break;

                case 5:
                    System.out.println("*****Realizar Vendas*****");
                    System.out.println("Digite a data da venda: [DD/MM/AAAA]");
                    String dataDaVenda = leia.nextLine();
                    System.out.println("Digite o produto vendido: ");
                    String produtoVendido = leia.nextLine();
                    System.out.println("Digite a quantidade vendida: ");
                    int quantidadeDeVenda = leia.nextInt();
                    
                    
                    leia.nextLine();
                    repositorio.adicionarVenda(new Venda(dataDaVenda, produtoVendido, quantidadeDeVenda)); 
                    repositorio.retirarDoEstoque(produtoVendido, quantidadeDeVenda);

                    System.out.println("Venda concluída com sucesso!");
                    voltarMenu();

                    
                    break;


                case 0:
                    break;

                default:
                    voltarMenu();
                    break;
            
                }

            
            
        } while (opcao!=0);
            leia.close();
    }

    


    public void voltarMenu(){
        System.out.println("Aperte Enter para retornar ao Menu");
        leia.nextLine();
    }

    public void clear(){
        System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
