import java.util.ArrayList;
import java.io.Serializable;
import java.util.*;
import java.io.*;
import java.time.*;

public class Empresa extends Entidade implements Serializable{
    Menu menu = new Menu();
    Fatura fat = new Fatura();
    private ArrayList<String> activ;
    private int ffiscal;
    Scanner in = new Scanner(System.in);
    
    
    public Empresa(){
        super();
        this.activ = new ArrayList<String>(0);
        this.ffiscal = 1;        
    }
    
    public Empresa(int nif, String email, String nome, String morada, String password,ArrayList<String> actividade, int ffiscalorFiscal){
        super(nif, email, nome, morada, password);
        this.activ = new ArrayList<String>(actividade.size());
        for(String i: actividade)
            this.activ.add(i);
        this.ffiscal = ffiscalorFiscal;
    }
    
        public Empresa(Empresa e){
        super(e);
        this.activ = e.getActiv();
        this.ffiscal = e.getFFiscal();
    }
    
    public ArrayList<String> getActiv(){
        ArrayList<String> atividade = new ArrayList<String>(this.activ.size());
        for(String s: this.activ)
            atividade.add(s);
        return atividade;
    }
    
    public int getFFiscal(){ return this.ffiscal;}
    
    public void setActiv(ArrayList<String> novoActiv){
        this.activ.clear();
        this.activ = new ArrayList<String>(novoActiv.size());
        for(String s: novoActiv)
            this.activ.add(s);
    }
    
    public void setFFiscal(int novoffiscal){ this.ffiscal = novoffiscal; }
    
    public boolean equals (Object o){
        if(this==o) return true;
        if((o==null) || this.getClass() != o.getClass()) return false;
        Empresa i = (Empresa) o;
        return super.equals(o) &&
                this.activ.equals(i.getActiv()) &&
                this.ffiscal == i.getFFiscal();
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(super.toString());
        sb.append("Atividade: " +this.activ+ "\n");
        sb.append("Factor fiscal: " +this.ffiscal+ "\n");
        
        return sb.toString();
    }
    
    public Empresa clone(){
        return new Empresa(this);
    }
    
    public void out(Object o){
        System.out.println(o.toString());
    }
    
    public void criarFatura(){
        Scanner in = new Scanner(System.in);
        LocalDate now = LocalDate.now();
        menu.clear();
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t1 Nome da empresa: " +this.getNome());
        out("\n\t2 Data da despesa: " +now);
        out("\n\t3 Nif do Cliente: ");
        int nifCliente = in.nextInt();
        menu.clear();
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t1 Nome da empresa: " +this.getNome());
        out("\n\t2 Data da despesa: " +now);
        out("\n\t3 Nif do Cliente: " +nifCliente);
        out("\n\t4 Breve descriçao da despesa: ");
        String descriçao = in.next();
        menu.clear();
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t1 Nome da empresa: " +this.getNome());
        out("\n\t2 Data da despesa: " +now);
        out("\n\t3 Nif do Cliente: " +nifCliente);
        out("\n\t4 Breve descriçao da despesa: "+descriçao);
        out("\n\t5 Natureza da despesa: " +this.getActiv());
        out("\n\t6 Valor da despesa: ");
        double valor = in.nextDouble();
        menu.clear();
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t1 Nome da empresa: " +this.getNome());
        out("\n\t2 Data da despesa: " +now);
        out("\n\t3 Nif do Cliente: " +nifCliente);
        out("\n\t4 Breve descriçao da despesa: "+descriçao);
        out("\n\t5 Natureza da despesa: " +this.getActiv());
        out("\n\t6 Valor da despesa: " +valor);
        
        Fatura fat = new Fatura(this.getNif(),this.getNome(),now,nifCliente,descriçao,valor);
    }
}