
import java.time.LocalDate;

public class Fatura implements java.io.Serializable{
    private int nifEmitente;
    private String desigEmitente;
    private LocalDate data;
    private int nifCliente;
    private String descricao;
    private double valor;
    private String actividade;
    
    public Fatura(){
        this.nifEmitente = 0;
        this.desigEmitente = "";
        this.data = LocalDate.of(2018,1,1);
        this.nifCliente = 0;
        this.descricao = "";
        this.valor = 0.0;
        this.actividade = "";
    }
    
    public Fatura(int nif, String designacao, LocalDate data, int nifCliente, String descricao, double valor, String act){
        this.nifEmitente = nif;
        this.desigEmitente = designacao;
        this.data = data;
        this.nifCliente = nifCliente;
        this.descricao = descricao;
        this.valor = valor;
        this.actividade = act;
    }
    
    public Fatura(Fatura f){
        this.nifEmitente = f.getNIFEmitente();
        this.desigEmitente = f.getDEmitente();
        this.data = f.getData();
        this.nifCliente = f.getNIFCliente();
        this.descricao = f.getDescricao();
        this.valor = f.getValor();
        this.actividade = f.getActiv();
    }
    
    public int getNIFEmitente(){ return this.nifEmitente; }
    
    public String getDEmitente(){ return this.desigEmitente; }
    
    public LocalDate getData(){ return this.data; }
    
    public int getNIFCliente(){ return this.nifCliente; }
    
    public String getDescricao(){ return this.descricao; }
    
    public double getValor(){ return this.valor; }
    
    public String getActiv() {return this.actividade;}
    
    public void setNIFEmitente(int novoNIF){ this.nifEmitente = novoNIF; }
    
    public void setDEmitente(String novaDesig){ this.desigEmitente = novaDesig; }
    
    public void setData(LocalDate data){ this.data = data; }
    
    public void setNIFCliente(int nifCLiente){ this.nifCliente = nifCLiente; }
    
    public void setDescricao(String descricao){ this.descricao = descricao; }
    
    public void setValor(double valor) {this.valor = valor;}
    
    public void setActiv(String activ) {this.actividade = activ;}
    
    
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
                this.valor == f.getValor() &&
        		this.actividade.equals(f.getActiv());
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("NIF Emitente: " +this.nifEmitente+ "\n");
        sb.append("Designacao do Emitente: " +this.desigEmitente+ "\n");
        sb.append("Data: " +this.data+ "\n");
        sb.append("NIF do Cliente: " +this.nifCliente+ "\n");
        sb.append("Descriçao: " +this.descricao + "\n");
        sb.append("Actividade: " + this.actividade + "\n");
        sb.append("Valor: " +this.valor+ "\n");
        
        return sb.toString();
    }
    
    public Fatura clone(){
        return new Fatura(this);
    }
    
    public void total(){//total facturado por uma empresa num determinado período
    }
    
    
}
