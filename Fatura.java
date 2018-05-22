import java.util.*;
import java.time.LocalDate;

public class Fatura implements java.io.Serializable{
    private int nifEmitente;
    private String desigEmitente;
    private LocalDate data;
    private int nifCliente;
    private String descricao;
    private String atividade;
    private double valor;
    
    public Fatura(){
        this.nifEmitente = 0;
        this.desigEmitente = "";
        this.data = LocalDate.of(2018,1,1);
        this.nifCliente = 0;
        this.descricao = "";
        this.atividade = "";
        this.valor = 0.0;
    }
    
    public Fatura(int nif, String designaçao, LocalDate data, int nifCliente, String descricao, String activ, double valor){
        this.nifEmitente = nif;
        this.desigEmitente = designaçao;
        this.data = data;
        this.nifCliente = nifCliente;
        this.descricao = descricao;
        this.atividade = activ;
        this.valor = valor;
    }
    
    public Fatura(Fatura f){
        this.nifEmitente = f.getNIFEmitente();
        this.desigEmitente = f.getDEmitente();
        this.data = f.getData();
        this.nifCliente = f.getNIFCliente();
        this.descricao = f.getDescricao();
        this.atividade = f.getAtividade();
        this.valor = f.getValor();
    }
    
    public int getNIFEmitente(){ return this.nifEmitente; }
    
    public String getDEmitente(){ return this.desigEmitente; }
    
    public LocalDate getData(){ return this.data; }
    
    public int getNIFCliente(){ return this.nifCliente; }
    
    public String getDescricao(){ return this.descricao; }
    
    public String getAtividade(){ return this.atividade; }
    
    public double getValor(){ return this.valor; }
    
    public void setNIFEmitente(int novoNIF){ this.nifEmitente = novoNIF; }
    
    public void setDEmitente(String novaDesig){ this.desigEmitente = novaDesig; }
    
    public void setData(LocalDate novaData){ this.data = novaData; }
    
    public void setNIFCliente(int novoCliente){ this.nifCliente = novoCliente; }
    
    public void setdescricao(String novaDesc){ this.descricao = novaDesc; }
    
    public void setAtividade(String novaAtiv){ this.atividade = novaAtiv;}
    
    public void setValor(Double novoValor){ this.valor = novoValor; }
    
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
                this.descricao.equals(f.getDescricao()) &&
                this.atividade.equals(f.getAtividade()) &&
                this.valor == f.getValor();
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("NIF Emitente: " +this.nifEmitente+ "\n");
        sb.append("Designacao do Emitente: " +this.desigEmitente+ "\n");
        sb.append("Data: " +this.data+ "\n");
        sb.append("NIF do Cliente: " +this.nifCliente+ "\n");
        sb.append("Descricao: " +this.descricao+ "\n");
        sb.append("Atividade: " +this.atividade+ "\n");
        sb.append("Valor: " +this.valor+ "\n");
        
        return sb.toString();
    }
    
    public Fatura clone(){
        return new Fatura(this);
    }
}