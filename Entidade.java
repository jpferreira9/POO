
public class Entidade{
    private int nif;
    private String email;
    private String nome;
    private String morada;
    private String password;

    public Entidade(){
        this.nif = 0;
        this.password = "";
        this.nome = "";
        this.email = "";
        this.morada = "";
    }
    
    public Entidade (int nif, String pass, String nome, String email, String morada){
        this.nif = nif;
        this.password = pass;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
    }
    
    public Entidade (Entidade e){
        this.nif = e.getNif();
        this.password = e.getPassword();
        this.nome = e.getNome();
        this.email = e.getEmail();
        this.morada = e.getMorada();
    }

    public int getNif(){ return this.nif; }
    
    public String getPassword(){ return this.password; }
    
    public String getNome(){ return this.nome; }
    
    public  String getEmail(){ return this.email; }
    
    public String getMorada(){ return this.morada; }
    
    public void setNif (int novoNif){ this.nif = novoNif; }
    
    public void setEmail (String novoEmail){ this.email = novoEmail; }
    
    public void setNome (String novoNome){ this.nome = novoNome; }
    
    public void setMorada (String novaMorada){ this.morada = novaMorada; }
    
    public void setPassword (String novaPass){ this.password = novaPass; }
    
    public boolean equals (Object o){
        if(this == o)
            return true;
        if ( o == null || this.getClass() != o.getClass() )
            return false;
        
        Entidade e = (Entidade) o;
        
        return this.nif == e.getNif() &&
               this.email.equals(e.getEmail()) &&
               this.nome.equals(e.getNome()) &&
               this.morada.equals(e.getMorada()) &&
               this.password.equals(e.getPassword());      
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("NIF: " +this.nif+ "\n");
        sb.append("Nome: "+this.nome+ "\n");
        sb.append("Morada: " +this.morada+ "\n");
        sb.append("Email: " +this.email+ "\n");
        sb.append("Password: "+this.password+ "\n");
        
        return sb.toString();
    }
    
    public Entidade clone(){
        return new Entidade(this);
    }
}
