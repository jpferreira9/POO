import java.util.*;
<<<<<<< HEAD
import java.time.LocalDate;

public class Fatura extends Empresa {
 
    private LocalDate data;
    private int nifCliente;
    private String descriçao;
    private double valor;
    
    public Fatura(){
        super();
        this.data = LocalDate.of(2018,1,1);
        this.nifCliente = 0;
        this.descriçao = "";
        this.valor = 0.0;
    }
    
    public Fatura(int nif,String email,String nome,String morada,String password,ArrayList<String> actividade,int ffiscalorFiscal,LocalDate data,int nifCliente,String descriçao,double valor){
        super(nif,email, nome, morada, password,actividade,ffiscalorFiscal);
        this.data = data;
        this.nifCliente = nifCliente;
        this.descriçao = descriçao;
        this.valor = valor;
    }
    
    public Fatura(Fatura f){
        super(f);
        this.data = f.getData();
        this.nifCliente = f.getnifCliente();
        this.descriçao = f.getDescriçao();
        this.valor = f.getValor();
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

    public Fatura clone(){
        return new Fatura(this);
=======
import java.time.*;

public class Fatura{
    public void imprime(){ //criar fatura de venda
    }
    
    public void editar(){ //associar/editar classificação de actividade
    }
    
    public void lista(){//obter a listagem das faturas da empresa, ordenada por data ou valor
    }
    
    public void cliente(){//obter a listagem das faturas de um cliente, ordenada por data ou valor
    }
    
    public void total(){//total facturado por uma empresa num determinado período
>>>>>>> 80b5a65ca9d47f0f8869d8b03c7e21b9e133201f
    }
}