import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entitiesenum.OrderStatus;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //input dados cliente

        System.out.println("Digite os dados do cliente");

        System.out.print("Digite o nome do cliente: ");
        String nomecliente = sc.nextLine();

        System.out.print("Digite o email do cliente: ");
        String emailCliente = sc.next();

        System.out.print("Digite a data de aniversario do cliente: ");
        String dataAniversarioCliente = sc.next();

        Client client = new Client(nomecliente, emailCliente, sdf.parse(dataAniversarioCliente));

        // input dados pedido

        System.out.println("\n");

        System.out.print("Digite o Status do pedido: ");
        String statusPedido = sc.next();
        OrderStatus orderStatus = OrderStatus.valueOf(statusPedido);

        System.out.print("Digite a quantidade de produtos: ");
        Integer quantProd = sc.nextInt();

        Order order = new Order(new Date(), orderStatus, client);

        //input dados list item

        int quantidadeLinha = 1;
        for(int line = 0;line < quantProd; line++){

            System.out.println("\n");

            System.out.println("Digite o " + quantidadeLinha + "° Item do produto geral");

            System.out.print("Digite o nome do produto: ");
            sc.nextLine();
            String nome = sc.nextLine();

            System.out.print("Digite o preço do produto: ");
            Double preco = sc.nextDouble();

            System.out.print("Digite a quantidade do produto: ");
            Integer quantidade = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantidade, preco, new Product(nome, preco));

            order.addItem(orderItem);

            quantidadeLinha++;

        }

        //output geral

        System.out.println("\n");

        System.out.println(order);

        sc.close();

    }
}