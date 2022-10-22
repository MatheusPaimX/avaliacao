package model;
public class Produto {
    String codigo;
    String nome;
    Double valor;
    int quantidadeEmEstoque;
    
    public Produto(String codigo, String nome, Double valor, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    
    String barras = "------------------------------------------------\n";

    @Override
    public String toString() {
        return "Código \t \t Nome \t Valor (R$) \t Estoque\n " + barras + "\n" + codigo + "\t \t" + nome + "\t" + valor + "\t \t" + quantidadeEmEstoque + "\n" + "\n" + barras;
    }

    

    

    

}
