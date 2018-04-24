import java.util.ArrayList;

public class Individual extends Entidade{
    
    private int agregado;
    private ArrayList<Integer> nifAgregado;
    private float coef;
    private int cod;
    
    public Individual(){
        this.agregado = 0;
        this.nifAgregado = new ArrayList<Integer>(0);
        this.coef = 0;
        this.cod = 0;
    }
    
    
    public Individual (int agreg , int na, float coef, int cod){
        this.agregado = agreg;
        this.coef = coef;
        this.cod = cod;
        this.nifAgregado.clear();
        this.nigAregado = new ArrayList<Integer>(na.size());
        for(Integer i: na)
            this.nifAgregado.add(na.clone());
    }
    
    public Individual (Individual i){
        this.agregado = i.getAgreg();
        this.nifAgregado = i.getNifAgreg();
        this.coef = i.getCoef();
        this.cod = i.getCod();
    }
    
    public int getAgreg(){
        return this.agregado;
    }
    
    public int getNifAgreg(){
        return this.nifAgregado;
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
    
    public void setNifAgreg(int novoNifAgreg){
        this.nifAgregado = novoNifAgreg;
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
        return this.agregado == i.getAgreg() && 
               this.nifAgregado == i.getNifAgreg() &&
               this.coef == i.getCoef() &&
               this.cod == i.getCod();
    }
    
    public Individual clone(){
        return new Individual(this);
    }
}
        
    

