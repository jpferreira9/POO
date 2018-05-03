import java.util.*;
import java.time.LocalDate;

public class Fatura{
    private int nifEmitente;
    private String desigEmitente;
    private LocalDate data;
    private int nifCliente;
    private String descriçao;
    private double valor;
    
    public Fatura(){
        this.nifEmitente = 0;
        this.desigEmitente = "";
        this.data = LocalDate.of(2018,1,1);
        this.nifCliente = 0;
        this.descriçao = "";
        this.valor = 0.0;
    }
    
    public Fatura(int nif, String designaçao, LocalDate data, int nifCliente, String descriçao, double valor){
        this.setNIFEmitente(nif);
        this.setDEmitente(designaçao);
        this.data = data;
        this.nifCliente = nifCliente;
        this.descriçao = descriçao;
        this.valor = valor;
    }
    
    public Fatura(Fatura f){
        this.nifEmitente = f.getNIFEmitente();
        this.desigEmitente = f.getDEmitente();
        this.data = f.getData();
        this.nifCliente = f.getNIFCliente();
        this.descriçao = f.getDescriçao();
        this.valor = f.getValor();
    }
    
    public int getNIFEmitente(){ return this.nifEmitente; }
    
    public String getDEmitente(){ return this.desigEmitente; }
    
    public LocalDate getData(){ return this.data; }
    
    public int getNIFCliente(){ return this.nifCliente; }
    
    public String getDescriçao(){ return this.descriçao; }
    
    public double getValor(){ return this.valor; }
    
    public void setNIFEmitente(int novoNIF){ this.nifEmitente = novoNIF; }
    
    public void setDEmitente(String novaDesig){ this.desigEmitente = novaDesig; }
    
    public void setData(LocalDate data){ this.data = data; }
    
    public void setNIFCliente(int nifCLiente){ this.nifCliente = nifCliente; }
    
    public void setDescriçao(String descriçao){ this.descriçao = descriçao; }
    
    public boolean equals(Object o){
        if(this == o) 
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Fatura f = (Fatura) o;
        return this.nifEmitente == f.getNIFEmitente() &&
                this.desigEmitente.equals(f.getDEmitente()) &&
                this.data.equals(f.getData()) &&
                this.nifCliente == f.getNIFCliente() &&
                this.descriçao.equals(f.getDescriçao()) &&
                this.valor == f.getValor();
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("NIF Emitente: " +this.nifEmitente+ "\n");
        sb.append("Designacao do Emitente: " +this.desigEmitente+ "\n");
        sb.append("Data: " +this.data+ "\n");
        sb.append("NIF do Cliente: " +this.nifCliente+ "\n");
        sb.append("Descriçao: " +this.descriçao+ "\n");
        sb.append("Valor: " +this.valor+ "\n");
        
        return sb.toString();
    }
    
    public Fatura clone(){
        return new Fatura(this);
    }
    
    public void imprime(){ //criar fatura de venda
    }
    
    public void editar(){ //associar/editar classificação de actividade
    }
    
    public void lista(){//obter a listagem das faturas da empresa, ordenada por data ou valor
    }
    
    public void cliente(){//obter a listagem das faturas de um cliente, ordenada por data ou valor
    }
    
    public void total(){//total facturado por uma empresa num determinado período
    }
    
    
}