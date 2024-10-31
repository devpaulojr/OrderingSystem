package model.entities;

import model.exception.DomainException;

public class ElectronicProduct extends Product{

    private String sistemaOperacional;
    private Double potenciaEletrica;

    public ElectronicProduct(){
        super();
    }

    public ElectronicProduct(String nomeProduto, Double precoProduto, String sistemaOperacional,
                             Double potenciaEletrica) throws DomainException{
        super(nomeProduto, precoProduto);

        if(precoProduto < 0){
            throw new DomainException("Preço do produto é negativo!!");
        }

        if(potenciaEletrica < 0){
            throw new DomainException("Potência de eletricidade negativo!!");
        }

        this.sistemaOperacional = sistemaOperacional;
        this.potenciaEletrica = potenciaEletrica;
    }

    public String getSistemaOperacional(){
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional){
        this.sistemaOperacional = sistemaOperacional;
    }

    public Double getPotenciaEletrica(){
        return potenciaEletrica;
    }

    public void setPotenciaEletrica(Double potenciaEletrica){
        this.potenciaEletrica = potenciaEletrica;
    }

    @Override
    public String toString()  {
        StringBuilder sb = new StringBuilder();

        sb.append("Caracteristicas do produto eletrônico:" + "\n"
        + "Sistema operacional: " + getSistemaOperacional() + "\n"
        + "Potência eletrica: " + String.format("%.1f", getPotenciaEletrica()) + " W");

        return sb.toString();
    }
}
