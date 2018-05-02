import java.io.Serializable;

public class Entidade implements Serializable { 
    private int nif;
    private String email;
    private String nome;
    private String morada;
    private String password;

    public Entidade(){
        this.nif = 0;
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.password = "";
    }
    
    public Entidade (int nif, String email, String nome, String morada, String pass){
        this.nif = nif;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.password = pass;
    }
    
    public Entidade (Entidade e){
        this.nif = e.getNif();
        this.email = e.getEmail();
        this.nome = e.getNome();
        this.morada = e.getMorada();
        this.password = e.getPassword();
    }
    
    
    public int getNif(){ 
        return this.nif; 
    }
    
    public  String getEmail(){
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
    
    public void setNif (int novoNif){
        this.nif = novoNif;
    }
    
    public void setEmail (String novoEmail){
        this.email = novoEmail;
    }
    
    public void setNome (String novoNome){
        this.nome = novoNome;
    }
    
    public void setMorada (String novaMorada){
        this.morada = novaMorada;
    }
    
    public void setPassword (String novaPass){
        this.password = novaPass;
    }
    
    
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
        
        sb.append("NIF: ");
        sb.append(this.nif+"\n");
        sb.append("Email: ");
        sb.append(this.email+"\n");
        sb.append("Nome: ");
        sb.append(this.nome+"\n");
        sb.append("Morada: ");
        sb.append(this.morada+"\n");
        sb.append("Password: ");
        sb.append(this.password+"\n");
        
        return sb.toString();
    }
    
    
    public Entidade clone(){
        return new Entidade(this);
    }
}