package model.entities;

public class OrderItem {

    private Integer quantidadeItem;
    private Double precoItem;

    private Product product;
    private ProductIndenfication productIndenfication;

    public OrderItem(){

    }

    public OrderItem(Integer quantidadeItem, Double precoItem, Product product, ProductIndenfication productIndenfication){
        this.quantidadeItem = quantidadeItem;
        this.precoItem = precoItem;
        this.product = product;
        this.productIndenfication = productIndenfication;
    }

    public Integer getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(Integer quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    public Double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(Double precoItem) {
        this.precoItem = precoItem;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public ProductIndenfication getProductIndenfication(){
        return productIndenfication;
    }
    

    public Double subTotalItem(){
        return quantidadeItem * precoItem;
    }
}
