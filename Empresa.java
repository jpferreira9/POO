public class Empresa extends Entidade{
    private String[] activ;
    private int fact;
    
    public Empresa(){
        this.activ = new String[0];
        this.fact = 1;        
    }
    public Empresa(String[] actividade, int factorFiscal){
        this.activ = actividade;
        this.fact = factorFiscal;
    }
    public Empresa(Empresa i){
        this.activ = i.getActiv();
        this.fact = i.getFact();
    }
    public String[] getActiv(){
        return this.activ;
    }
    public int getFact(){
        return this.fact;
    }
    public void setActiv(String[] novoActiv){
        this.activ = novoActiv;
    }
    public void setFact(int novoFact){
        this.fact = novoFact;
    }
    public boolean equals (Object o){
        if(this==o) return true;
        if((o==null) || this.getClass() != o.getClass()) return false;
        Empresa i = (Empresa) o;
        return this.activ == i.getActiv() &&
                this.fact == i.getFact();
            }
    public Empresa clone(){
        return new Empresa(this);
    }
}
        