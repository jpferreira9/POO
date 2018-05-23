import java.util.ArrayList;

public class Individual{
    public int nif;
    public String email;
    public String nome;
    public String morada;
    public String password;
    public int agregado;
    public ArrayList<Integer> nifAgregado;
    public float coef;
    
    public Individual(){
        this.nif=0;
        this.email="ND";
        this.nome="ND";
        this.morada="ND";
        this.password="";
        this.agregado = 0;
        this.nifAgregado = new ArrayList<Integer>(0);
        this.coef = 0;
    }
    
    
    public Individual (int nif, String email, String nome, String morada, String password ,int agreg , ArrayList<Integer> na, float coef){
        this.nif = nif;
        this.email=email;
        this.nome=nome;
        this.morada=morada;
        this.password=password;
        this.agregado = agreg;
        this.coef = coef;
        this.nifAgregado.clear();
        this.nifAgregado = new ArrayList<Integer>(na.size());
        for(Integer i: na)
            this.nifAgregado.add(i);
    }
    
    public Individual (Individual i){
        this.nif = i.getNif();
        this.email = i.getEmail();
        this.nome = getNome();
        this.morada = getMorada();
        this.password = getPassword();
        this.agregado = i.getAgreg();
        this.nifAgregado = i.getNifAgreg();
        this.coef = i.getCoef();
    }
    
    public int getNif(){
        return this.nif;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getMorada(){
        return this.morada;
    }
    
    public String getPassword(){
        return this.password;
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
    
    public void setNif(int nif){
        this.nif = nif;
    }
    
    public void setEmail(String mail){
        this.email = mail;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setPassword(String pw){
        this.password = pw;
    }
    
    public void setMorada(String morada){
        this.morada = morada;
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
    
    public boolean equals (Object o ){
        if (this == o) return true;
        if ((o == null) || this.getClass() != o.getClass()) return false;
        Individual i = (Individual) o ;       
        return  this.nif == i.getNif() &&
                this.email.equals(i.getEmail()) &&
                this.nome.equals(i.getNome()) &&
                this.morada.equals(i.getMorada()) &&
                this.password.equals(i.getPassword()) &&
               this.agregado == i.getAgreg() && 
               this.nifAgregado.equals(i.getNifAgreg()) &&
               this.coef == i.getCoef();
    }
    
    public Individual clone(){
        return new Individual(this);
    }
}
        
    

