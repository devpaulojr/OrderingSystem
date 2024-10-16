package entities;

import entitiesenum.OrderStatus;
import entities.Product;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Order {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date momentoAtual;
    private OrderStatus status;

    private Client client;
    private Product product;
    private OrderItem orderItem;

    List<OrderItem> items = new ArrayList<>(); //inicializada

    public Order(){
    }

    public Order(Date momentoAtual, OrderStatus status, Client client){
        this.momentoAtual = momentoAtual;
        this.status = status;
        this.client = client;
    }

    public Date getMomentoAtual(){
        return momentoAtual;
    }

    public void setMomentoAtual(Date momentoAtual){
        this.momentoAtual = momentoAtual;
    }

    public OrderStatus getStatus(){
        return status;
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

    public Client getClient(){
        return client;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public List<OrderItem> getItems(){
        return items;
    }

    public void setItems(List<OrderItem> items){
        this.items = items;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderItem getOrderItem(){
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem){
        this.orderItem = orderItem;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double totalItem(){
        Double soma = 0.0;
        for(OrderItem linha : items){
            soma += linha.subTotalItem();
        }
        return soma;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ORDER SUMMARY:" + "\n");
        sb.append("Order moment: " + momentoAtual + "\n");
        sb.append("OrderStatus :" + status + "\n");
        sb.append("Client :" + client.getNomeCliente() + " - " + sdf.format(client.getDiaAniversarioCliente()) + " - " + client.getEmailCliente() + "\n");

        sb.append("Order items:" + "\n");
        for(OrderItem x : items){
            sb.append(x.getProduct().getNomeProduto() + " - $"
                    + x.getProduct().getPrecoProduto() + ", Quantidade - "
                    + ", indentificação do produto - " + x.getProductIndenfication().idProduto
                    + ", categoria do produto - " +  x.getProductIndenfication().getCategoriaProduto()
                    + x.getQuantidadeItem() + ", subtotal - $"
                    + x.subTotalItem() + "\n");
        }

        sb.append("\n");
        sb.append("Total price: $ ");
        sb.append(String.format("%.2f", totalItem()));


        return sb.toString();

    }
}