import java.util.ArrayList;

public class Empresa extends Entidade{
    
    private ArrayList<String> activ;
    private int ffiscal;
    
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
    
    public Empresa(Empresa i){
        super(i);
        this.activ = i.getActiv();
        this.ffiscal = i.getffiscal();
    }
   
    public ArrayList<String> getActiv(){
        ArrayList<String> actividade = new ArrayList<String>(this.activ.size());
        for(String s: this.activ)
            actividade.add(s);
        return actividade;
    }
    
    public int getffiscal(){
        return this.ffiscal;
    }
    
    public void setactiv(ArrayList<String> novoactiv){
        this.activ.clear();
        this.activ = new ArrayList<String>(novoactiv.size());
        for(String s: novoactiv)
            this.activ.add(s);
    }
    
    public void setffiscal(int novoffiscal){
        this.ffiscal = novoffiscal;
    }
    
    public boolean equals (Object o){
        if(this==o) return true;
        if((o==null) || this.getClass() != o.getClass()) return false;
        Empresa i = (Empresa) o;
        return  super.equals(o) &&
                this.activ == i.getActiv() &&
                this.ffiscal == i.getffiscal();
            }
    public Empresa clone(){
        return new Empresa(this);
    }
}
        