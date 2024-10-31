import model.entities.*;

import model.entitiesenum.OrderStatus;
import model.exception.DomainException;
import java.text.ParseException;

import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);


        ArrayList<OrderItem> orderItemArrayList = new ArrayList<>();
        ArrayList<Order> orderArrayList = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Order order = null;
        try {
            //Entrada de dados (Cliente)

            System.out.println("Digite os dados do cliente");

            System.out.print("Digite o nome do cliente: ");
            String nomecliente = sc.nextLine();

            System.out.print("Digite o email do cliente: ");
            String emailCliente = sc.next();

            System.out.print("Digite a data de aniversario do cliente: ");
            Date dataAniversarioCliente = sdf.parse(sc.next());

            Client client = new Client(nomecliente, emailCliente, dataAniversarioCliente);

            System.out.println("\n");

            // Entrada de dados (Pedido)

            System.out.println();

            System.out.print("Digite o Status do pedido: ");
            String statusPedido = sc.next();
            OrderStatus orderStatus = OrderStatus.valueOf(statusPedido);

            System.out.print("Digite a quantidade de produtos: ");
            int quantProd = sc.nextInt();

            order = new Order(new Date(), orderStatus, client);

            int quantidadeLinha = 1;
            for (int line = 0; line < quantProd; line++) {

                System.out.println("\n");

                //Entrada de dados (Items)

                System.out.println("Digite o " + quantidadeLinha + "° Item do produto geral");

                System.out.print("Produto eletrônico ou comsumivel [E/C]: ");
                char consumivel_Eletronico = sc.next().toUpperCase().charAt(0);

                System.out.print("Digite o nome do produto: ");
                sc.nextLine();

                String nomeProduto = sc.nextLine();

                System.out.print("Digite o preço do produto: R$ ");
                Double precoProduto = sc.nextDouble();

                System.out.print("Digite a quantidade do produto: ");
                Integer quantidadeProduto = sc.nextInt();

                if (consumivel_Eletronico == 'E') {

                    System.out.print("Digite o sistema operacional do aparelho: ");
                    sc.nextLine();
                    String sistemaOperacional = sc.nextLine();

                    System.out.print("Digite a potência eletrica do aparelho [W]: ");
                    Double potenciaEletrica = sc.nextDouble();

                    OrderItem orderItem = new OrderItem(quantidadeProduto, precoProduto,
                            new ElectronicProduct(nomeProduto, precoProduto, sistemaOperacional, potenciaEletrica));

                    orderArrayList.add(order);
                    orderItemArrayList.add(orderItem);

                } else {

                    System.out.print("Digite o peso liquido do produto [ml]: ");
                    Double pesoLiquido = sc.nextDouble();

                    System.out.print("Digite a data de vencimento do produto: ");
                    Date dataVencimento = sdf.parse(sc.next());

                    OrderItem orderItem = new OrderItem(quantidadeProduto, precoProduto,
                            new ConsumableProduct(nomeProduto, precoProduto, pesoLiquido, dataVencimento));

                    orderArrayList.add(order);
                    orderItemArrayList.add(orderItem);
                }

                quantidadeLinha++;
            }

        } catch (DomainException error) {
            System.out.println("\n");
            System.out.println("Error - " + error.getMessage());
        }
        catch (ParseException error) {
            System.out.println("\n");
            System.out.println("Error - Date");
        }
        catch (RuntimeException error) {
            System.out.println("Error - não inspecionado");
        }
        finally {
            sc.close();
        }

        //Saida do código final

        System.out.println("\n");
        int interromper = 0;
        for (Order x : orderArrayList) {

            if (interromper > 0) {
                break;
            } else {
                System.out.println(x);
                System.out.println("\n");
                interromper++;
            }
        }

        for (OrderItem x : orderItemArrayList) {
            System.out.println(x);
            System.out.println("\n");
        }

        Double soma = 0.0;
       for (OrderItem x : orderItemArrayList){
           soma += x.totalItem();
       }

       System.out.println("Valor total dos item(s): " + soma);
    }
}