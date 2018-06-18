import java.util.ArrayList;


public class Individual extends Entidade implements java.io.Serializable{
    private int agregado;
    private ArrayList<Integer> nifAgregado;
    private double coef;
    
    public Individual(){
        super();
        this.agregado = 0;
        this.nifAgregado = new ArrayList<Integer>(0);
        this.coef = 0;
    }
    
    public Individual (int nif, String password, String nome, String email, String morada ,int agreg , ArrayList<Integer> na, double coef){
        super(nif,password, nome, email, morada);
        this.agregado = agreg;
        this.coef = coef;
        this.nifAgregado = new ArrayList<Integer>(na.size());
        for(Integer i: na)
            this.nifAgregado.add(i);
    }
    
    public Individual (Individual i){
        super(i);
        this.agregado = i.getAgreg();
        this.nifAgregado = i.getNifAgreg();
        this.coef = i.getCoef();
    }
    
    public int getAgreg(){
        return this.agregado;
    }
    
    public ArrayList<Integer> getNifAgreg(){
        ArrayList<Integer> na = new ArrayList<Integer>(this.nifAgregado.size());
        for(Integer i: this.nifAgregado)
            na.add(i);
        return na;
    }
    
    public double getCoef(){
        return this.coef;
    }
    
    public void setAgreg(int novoAgreg){
        this.agregado = novoAgreg;
    }
    
    public void setNifAgreg(ArrayList<Integer> novoNifAgreg){
        this.nifAgregado.clear();
        this.nifAgregado = new ArrayList<Integer>(novoNifAgreg.size());
        for(Integer i: nifAgregado)
            this.nifAgregado.add(i);
    }
    
    public void setCoef(double novoCoef){
        this.coef = novoCoef;
    }
    
    public boolean equals (Object o ){
        if (this == o) return true;
        if ((o == null) || this.getClass() != o.getClass()) return false;
        Individual i = (Individual) o ;       
        return super.equals(i) &&
               this.agregado == i.getAgreg() && 
               this.nifAgregado.equals(i.getNifAgreg()) &&
               this.coef == i.getCoef();
    }
    

    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(super.toString());
        sb.append("Nr de pessoas no agregado: "+this.agregado+ "\n");
        sb.append("NIF do agegado: " +this.nifAgregado+ "\n");
        sb.append("Coeficiente fiscal: " +this.coef+ "\n");
        
        return sb.toString();
    }
   
    public Individual clone(){
        return new Individual(this);
    }
}
        
    

