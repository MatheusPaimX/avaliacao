package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Venda {
    
    private LocalDate dataDaVenda;
    private Produto produtoVendido;
    private int quantidadeVendida;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Datas data;
    private Double valorProduto;
    private Double valorUnidade;
    private String produtoNome;

    
    public Venda(String dataDaVenda, String produtoNome, int quantidadeVendida) {
        setDataDaVenda(dataDaVenda);
        this.produtoNome = produtoNome;
        this.quantidadeVendida = quantidadeVendida;
        setProdutoVendido(produtoVendido);
    }

    public Double getValorUnidade() {
        return valorProduto/produtoVendido.getQuantidadeEmEstoque();
    }

    public void setValorUnidade(Double valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public Datas getData() {
        return data;
    }



    public void setData(Datas data) {
        this.data = data;
    }


    public LocalDate getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(String dataDaVenda) {
        this.dataDaVenda = LocalDate.parse(dataDaVenda, dtf);
    }

    public Produto getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(Produto produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public Double getValorProduto() {
        return produtoVendido.getValor();
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    String barras = "------------------------------------------------\n";

    @Override
    public String toString() {
        return "Data \t \t Produto \t Quantidade \t + Valor por Unidade \t Valor Total\n" + barras + "\n" + dataDaVenda + "\t \t" + produtoVendido + "\t" + quantidadeVendida + "\t" + valorUnidade +"\t" + valorProduto + "\n" + barras;
    }

    
    
    
    

    
}
