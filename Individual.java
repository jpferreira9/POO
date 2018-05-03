import java.util.ArrayList;


public class Individual extends Entidade{
    private int agregado;
    private ArrayList<Integer> nifAgregado;
    private float coef;
    private int cod;
    
    public Individual(){
        super();
        this.agregado = 0;
        this.nifAgregado = new ArrayList<Integer>(0);
        this.coef = 0;
        this.cod = 0;
    }
    
    
    public Individual (int nif, String email, String nome, String morada, String password ,int agreg , ArrayList<Integer> na, float coef, int cod){
        super(nif, email, nome, morada, password);
        this.agregado = agreg;
        this.coef = coef;
        this.cod = cod;
        this.nifAgregado = new ArrayList<Integer>(na.size());
        for(Integer i: na)
            this.nifAgregado.add(i);
    }
    
    public Individual (Individual i){
        super(i);
        this.agregado = i.getAgreg();
        this.nifAgregado = i.getNifAgreg();
        this.coef = i.getCoef();
        this.cod = i.getCod();
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
    
    public float getCoef(){
        return this.coef;
    }
    
    public int getCod(){
        return this.cod;
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
    
    public void setCoef(float novoCoef){
        this.coef = novoCoef;
    }
    
    public void setCod(int novoCod){
        this.cod = novoCod;
    }
    
    public boolean equals (Object o ){
        if (this == o) return true;
        if ((o == null) || this.getClass() != o.getClass()) return false;
        Individual i = (Individual) o ;       
        return super.equals(o) &&
               this.agregado == i.getAgreg() && 
               this.nifAgregado.equals(i.getNifAgreg()) &&
               this.coef == i.getCoef() &&
               this.cod == i.getCod();
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
        
    

