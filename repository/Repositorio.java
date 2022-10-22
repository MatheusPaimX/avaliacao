package repository;
import java.util.*;
import java.util.stream.Collectors;

import model.Datas;
import model.Produto;
import model.Venda;

import static java.util.stream.Collectors.toList;


public class Repositorio{
        
        private List<Produto> produtos = new ArrayList<>();
        private List<Venda> vendas = new ArrayList<>();
        private List<Datas> datas = new ArrayList<>();
        
        public void adicionarProduto(Produto produto){
                 produtos.add(produto);
                
            
        }

        public void adicionarVenda(Venda venda){
            vendas.add(venda); 
        
        }

        public void adicionarData(Datas data){
            datas.add(data);
        }

        public Produto buscarProduto(String nome){
            verificarProdutos();
            for (Produto produto : produtos) {
                if (produto.getNome().equals(nome)) {
                    return produto;
                } 
            }throw new NullPointerException("Não existe este produto no sistema");
            
        }

        public void listarVendas(){
             
        for (Venda v : vendas) {
            System.out.println(v);
        }relatorioPrecosDeVendas(vendas);
    }

        public void listarProdutos(){
             verificarProdutos();
             for (Produto p : produtos) {
                 System.out.println(p);
                 
             }relatorioPrecos(produtos);
    }

    
        public void verificarProdutos(){
           if (produtos.isEmpty()) {
               throw new NullPointerException("Não existe nenhum produto no sistema.");
           }
       }

       public void retirarDoEstoque(String produtoVendido, int quantidadeVendida ){
            for (Produto p : produtos) {
                if(p.getNome().equals(produtoVendido)){
                    int estoque = p.getQuantidadeEmEstoque()-quantidadeVendida;
                    p.setQuantidadeEmEstoque(estoque);
                }
                
            }

        

        
       }

       public void filtrarVendasPorHorario(){
        vendas.stream().filter(v -> v.getData().getDataInicio().compareTo(v.getData().getDataFinal()) >= 0)
         .collect(toList()); 
         mostrarTodasAsVendas();
     }

     public void mostrarTodasAsVendas(){
        Map<Datas, List<Venda>> todasAsVendas = vendas.stream().collect(Collectors.groupingBy(Venda::getData));
      
        todasAsVendas.entrySet().forEach(item -> { 
            System.out.println("\n" + item.getKey() + ":");
            item.getValue().forEach(System.out::println);
            relatorioPrecosDeVendas(item.getValue());
        });
    }


       

       public void relatorioPrecos(List<Produto> produtosRelatorios){
            DoubleSummaryStatistics precos = produtosRelatorios.stream().collect(Collectors.summarizingDouble((Produto::getValor))); 
            System.out.printf( "Valor Máximo: %.1f - Valor Mínimo: %.1f - Valor médio: %.1f\n", 
            precos.getMax(), precos.getMin(), precos.getAverage()); 
    }

    public void relatorioPrecosDeVendas(List<Venda> vendasRelatorio){
        DoubleSummaryStatistics vendas = vendasRelatorio.stream().collect(Collectors.summarizingDouble((Venda::getValorProduto))); 
        System.out.printf( "Valor Máximo: %.1f - Valor Mínimo: %.1f - Valor médio: %.1f\n", 
        vendas.getMax(), vendas.getMin(), vendas.getAverage()); 
}

    

        
}