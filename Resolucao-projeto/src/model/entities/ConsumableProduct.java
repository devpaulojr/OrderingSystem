package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsumableProduct extends Product{

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Double pesoLiquido;
    private Date dataVencimento;

    public ConsumableProduct(){
        super();
    }

    public ConsumableProduct(String nomeProduto, Double precoProduto, Double pesoLiquido, Date dataVencimento){
        super(nomeProduto, precoProduto);
        this.pesoLiquido = pesoLiquido;
        this.dataVencimento = dataVencimento;
    }

    public Double getPesoLiquido(){
        return pesoLiquido;
    }

    public Date getDataVencimento(){
        return dataVencimento;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Caracteristicas do produto comsumível:" + "\n"
                + "Peso liquido: " + getPesoLiquido() + " ml" + "\n"
                + "Data de vencimento: " + sdf.format(getDataVencimento()));

        return sb.toString();
    }
}
