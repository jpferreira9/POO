import java.util.ArrayList;


public class Individual implements java.io.Serializable{
    private int nif;
    private String email;
    private String nome;
    private String morada;
    private String password;
    private int agregado;
    private ArrayList<Integer> nifAgregado;
    private double coef;
    
    public Individual(){
        this.nif = 0;
        this.password = "";
        this.nome = "";
        this.email = "";
        this.morada = "";
        this.agregado = 0;
        this.nifAgregado = new ArrayList<Integer>(0);
        this.coef = 0;
    }
    
    public Individual (int nif, String password, String email, String nome, String morada ,int agreg , ArrayList<Integer> na, double coef){
        this.nif = nif;
        this.password = password;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.agregado = agreg;
        this.coef = coef;
        this.nifAgregado = new ArrayList<Integer>(na.size());
        for(Integer i: na)
            this.nifAgregado.add(i);
    }
    
    public Individual (Individual i){
        this.nif = i.getNif();
        this.password = i.getPassword();
        this.nome = i.getNome();
        this.email = i.getEmail();
        this.morada = i.getMorada();
        this.agregado = i.getAgreg();
        this.nifAgregado = i.getNifAgreg();
        this.coef = i.getCoef();
    }
    
    
    public int getNif(){ return this.nif; }
    
    public String getPassword(){ return this.password; }
    
    public String getNome(){ return this.nome; }
    
    public  String getEmail(){ return this.email; }
    
    public String getMorada(){ return this.morada; }
    
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
    
    public void setNif (int novoNif){ this.nif = novoNif; }
    
    public void setEmail (String novoEmail){ this.email = novoEmail; }
    
    public void setNome (String novoNome){ this.nome = novoNome; }
    
    public void setMorada (String novaMorada){ this.morada = novaMorada; }
    
    public void setPassword (String novaPass){ this.password = novaPass; }
    
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
        return this.nif == i.getNif() &&
               this.email.equals(i.getEmail()) &&
               this.nome.equals(i.getNome()) &&
               this.morada.equals(i.getMorada()) &&
               this.password.equals(i.getPassword()) &&
               this.agregado == i.getAgreg() && 
               this.nifAgregado.equals(i.getNifAgreg()) &&
               this.coef == i.getCoef();
    }
    

    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("NIF: " +this.nif+ "\n");
        sb.append("Password: "+this.password+ "\n");
        sb.append("Nome: "+this.nome+ "\n");
        sb.append("Morada: " +this.morada+ "\n");
        sb.append("Email: " +this.email+ "\n");
        sb.append("Nr de pessoas no agregado: "+this.agregado+ "\n");
        sb.append("NIF do agegado: " +this.nifAgregado+ "\n");
        sb.append("Coeficiente fiscal: " +this.coef+ "\n");
        
        return sb.toString();
    }
   
    public Individual clone(){
        return new Individual(this);
    }
}
        
    

