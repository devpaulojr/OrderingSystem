package model.entities;

import model.exception.DomainException;

public class OrderItem {

    private Integer quantidadeItem;
    private Double precoItem;

    private Product product;
    private OrderItem orderItem;

    public OrderItem(){
    }

    public OrderItem(Integer quantidadeItem, Double precoItem, Product product) throws DomainException{

        if(precoItem < 0){
            throw new DomainException("valor do item(s) negativo!!");
        }
        if(quantidadeItem < 0){
            throw new DomainException("quantidade de item(s) negativo!!");
        }

        this.quantidadeItem = quantidadeItem;
        this.precoItem = precoItem;
        this.product = product;
    }

    public OrderItem getOrderItem(){
        return orderItem;
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

    public Double subTotalItem(){
        return quantidadeItem * precoItem;
    }

    public Double totalItem(){
        Double soma = 0.0;
        soma += subTotalItem();
        return soma;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Sumário do pedido:" + "\n");
        sb.append("nome: " + getProduct().getNomeProduto() + "\n"
        + "preço: " + getProduct().getPrecoProduto() + "\n"
        + "id estabelecimento: " + getProduct().getIdEstabelecimento() + "\n"
        + product + "\n"
        + "Subtotal item(s): " + subTotalItem());

        return sb.toString();
    }

}
