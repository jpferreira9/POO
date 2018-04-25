import java.util.ArrayList;

public class Empresa extends Entidade{
    private ArrayList<String> activ;
    private int ffiscal;
    
    public Empresa(){
        super();
        this.activ = new ArrayList<String>(0);
        this.ffiscal = 1;
    }
    
    public Empresa(int nif, String email, String nome, String morada, String pass, ArrayList<String> actividade, int ffiscalorFiscal){
        super(nif, email, nome, morada, pass);
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
    
    
}
        