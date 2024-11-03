package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String nomeCliente;
    private String emailCliente;
    private Date diaAniversarioCliente;

    public Client(){
    }

    public Client(String nomeCliente, String emailCliente, Date diaAniversarioCliente){
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.diaAniversarioCliente = diaAniversarioCliente;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente(){
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente){
        this.emailCliente = emailCliente;
    }

    public Date getDiaAniversarioCliente(){
        return diaAniversarioCliente;
    }

    public void setDiaAniversarioCliente(Date diaAniversarioCliente){
        this.diaAniversarioCliente = diaAniversarioCliente;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(getNomeCliente() + " - " + sdf.format(getDiaAniversarioCliente()) +
                " - " + getEmailCliente());

        return sb.toString();
    }
}
