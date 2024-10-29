import model.entities.*;

import model.entitiesenum.OrderStatus;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //input dados cliente

        try{
            System.out.println("Digite os dados do cliente");

            System.out.print("Digite o nome do cliente: ");
            String nomecliente = sc.nextLine();

            System.out.print("Digite o email do cliente: ");
            String emailCliente = sc.next();

            System.out.print("Digite a data de aniversario do cliente: ");
            Date dataAniversarioCliente = sdf.parse(sc.next());

            Client client = new Client(nomecliente, emailCliente, dataAniversarioCliente);

            // input dados pedido

            System.out.println("\n");

            System.out.print("Digite o Status do pedido: ");
            String statusPedido = sc.next();
            OrderStatus orderStatus = OrderStatus.valueOf(statusPedido);

            System.out.print("Digite a quantidade de produtos: ");
            Integer quantProd = sc.nextInt();

            Order order = new Order(new Date(), orderStatus, client);

            //input dados dos items

            int quantidadeLinha = 1;
            int quantidadeEspaco = 0;
            for(int line = 0;line < quantProd; line++) {

                System.out.println("\n");

                System.out.println("Digite o " + quantidadeLinha + "° Item do produto geral");

                System.out.print("Produto eletrônico ou comsumivel [E/C]: ");
                char consumivel_Eletronico = sc.next().toUpperCase().charAt(0);

                System.out.print("Digite o nome do produto: ");

                if (quantidadeEspaco == 0) {
                    sc.nextLine();
                    quantidadeEspaco++;
                }
                String nomeProduto = sc.nextLine();

                System.out.print("Digite o preço do produto: R$ ");
                Double precoProduto = sc.nextDouble();

                System.out.print("Digite a quantidade do produto: ");
                Integer quantidadeProduto = sc.nextInt();

                if(consumivel_Eletronico == 'E'){

                    System.out.print("Digite o sistema operacional do aparelho: ");
                    String sistemaOperacional = sc.nextLine();

                    System.out.print("Digite a potência eletrica do aparelho: ");
                    Double potenciaEletrica = sc.nextDouble();

                    OrderItem orderItem = new OrderItem(quantidadeProduto, precoProduto,
                            new ElectronicProduct(nomeProduto, precoProduto, sistemaOperacional, potenciaEletrica));

                }
                else{

                    System.out.print("Digite o peso liquido do produto: ");
                    Double pesoLiquido = sc.nextDouble();

                    System.out.print("Digite a data de vencimento do produto: ");
                    Date dataVencimento = sdf.parse(sc.next());

                    OrderItem orderItem = new OrderItem(quantidadeProduto, precoProduto,
                            new ConsumableProduct(nomeProduto, precoProduto, pesoLiquido, dataVencimento));
                }


                quantidadeLinha++;

            }
        }
        catch (ParseException error){
            System.out.println("Error - data");
        }


        sc.close();

    }
}