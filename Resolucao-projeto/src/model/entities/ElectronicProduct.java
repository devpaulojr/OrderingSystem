package model.entities;

public class ElectronicProduct extends Product{

    private String sistemaOperacional;
    private Double potenciaEletrica;

    public ElectronicProduct(){
        super();
    }

    public ElectronicProduct(String nomeProduto, Double precoProduto, String sistemaOperacional,
                             Double potenciaEletrica){
        super(nomeProduto, precoProduto);
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
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Caracteristicas do produto eletrônico:" + "\n"
        + "Sistema operacional: " + getSistemaOperacional() + "\n"
        + "Potência eletrica: " + getPotenciaEletrica());

        return sb.toString();
    }
}
