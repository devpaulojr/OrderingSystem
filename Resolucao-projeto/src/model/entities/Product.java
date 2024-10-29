package model.entities;

public abstract class Product {

    private String nomeProduto;
    private Double precoProduto;
    private Integer idEstabelecimento = 40028922;

    public Product() {
    }

    public Product(String nomeProduto, Double precoProduto){
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
    }

    public String getNomeProduto(){
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto(){
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto){
        this.precoProduto = precoProduto;
    }

    public Integer getIdEstabelecimento(){
        return idEstabelecimento;
    }

    @Override
    public String toString() {
        return "nome: " + getNomeProduto() + "\n"
                + "preço: " + getPrecoProduto() + "\n"
                + "id estabelecimento: " + getIdEstabelecimento();
    }
}
