package model.entities;

public class ProductIndenfication extends Product{

    protected Integer idProduto = 40028922;
    private String categoriaProduto;

    public ProductIndenfication(){
        super();
    }

    public ProductIndenfication(String nomeProduto, Double precoProduto, String categoriaProduto){
        super(nomeProduto, precoProduto);
        this.categoriaProduto = categoriaProduto;
    }

    public Integer getIdProduto(){
        return idProduto;
    }

    public String getCategoriaProduto(){
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto){
        this.categoriaProduto = categoriaProduto;
    }


}
