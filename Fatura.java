import java.time.LocalDate;
import java.util.ArrayList;

public class Fatura  {
    
    private int nifEmitente;
    private String nomeEmitente;
    private LocalDate data;
    private int nifCliente;
    private String descriçao;
    private double valor;
    Menu menu = new Menu();
    
    public Fatura(){
        this.nifEmitente = 0;
        this.nomeEmitente = "";
        this.data = LocalDate.of(2018,1,1);
        this.nifCliente = 0;
        this.descriçao = "";
        this.valor = 0.0;
    }
    
    public Fatura(int nifEmitente,String nomeEmitente,LocalDate data,int nifCliente,String descriçao,double valor){
        this.nifEmitente = nifEmitente;
        this.nomeEmitente = nomeEmitente;
        this.data = data;
        this.nifCliente = nifCliente;
        this.descriçao = descriçao;
        this.valor = valor;
    }
    
    public Fatura(Fatura f){
        this.nifEmitente = f.getNifEmitente();
        this.nomeEmitente = f.getNomeEmitente();
        this.data = f.getData();
        this.nifCliente = f.getnifCliente();
        this.descriçao = f.getDescriçao();
        this.valor = f.getValor();
    }
    
    public int getNifEmitente(){
        return this.nifEmitente;
    }
    
    public String getNomeEmitente(){
        return this.nomeEmitente;
    }
    
    public LocalDate getData(){
        return this.data;
    }
    
    public int getnifCliente(){
        return this.nifCliente;
    }
    
    public String getDescriçao(){
        return this.descriçao;
    }
    
    public double getValor(){
        return this.valor;
    }
    
    public void setData(LocalDate data){
        this.data = data;
    }
    
    public void setnifCliente(int nifCLiente){
        this.nifCliente = nifCliente;
    }
    
    public void setDescriçao(String descriçao){
        this.descriçao = descriçao;
    }
    
    public void imprime(){//criar fatura de venda  
    }
    
    public void editar(){ //associar/editar classificação de actividade
    }
    
    public void lista(){//obter a listagem das faturas da empresa, ordenada por data ou valor
    }
    
    public void cliente(){//obter a listagem das faturas de um cliente, ordenada por data ou valor
    }
    
    public void total(){//total facturado por uma empresa num determinado período
    }

    public Fatura clone(){
        return new Fatura(this);
    }
}
