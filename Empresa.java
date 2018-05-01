<<<<<<< HEAD
import java.util.*;

=======
>>>>>>> 80b5a65ca9d47f0f8869d8b03c7e21b9e133201f
public class Empresa{
    private int nif;
    private String email;
    private String nome;
    private String morada;
    private String password;
<<<<<<< HEAD
    ArrayList<String> activ; // Atividades em que a empresa se enquadra
=======
    private String[] activ; // Atividades em que a empresa se enquadra
>>>>>>> 80b5a65ca9d47f0f8869d8b03c7e21b9e133201f
    private int fact; // Factor p/ calculo fiscal
    
    public Empresa(){
        this.nif=0;
        this.email="ND";
        this.nome="ND";
        this.morada="ND";
        this.password="";
<<<<<<< HEAD
        this.activ = new ArrayList<String>(0);
        this.fact = 1;        
    }
    public Empresa(int nif, String email, String nome, String morada, String password ,ArrayList<String> actividade, int factorFiscal){
=======
        this.activ = new String[0];
        this.fact = 1;        
    }
    public Empresa(int nif, String email, String nome, String morada, String password ,String[] actividade, int factorFiscal){
>>>>>>> 80b5a65ca9d47f0f8869d8b03c7e21b9e133201f
        this.nif = nif;
        this.email=email;
        this.nome=nome;
        this.morada=morada;
        this.password=password;
        this.activ = actividade;
        this.fact = factorFiscal;
    }
    public Empresa(Empresa i){
        this.nif = i.getNif();
        this.email = i.getEmail();
        this.nome = getNome();
        this.morada = getMorada();
        this.password = getPassword();
        this.activ = i.getActiv();
        this.fact = i.getFact();
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
<<<<<<< HEAD
    public ArrayList<String> getActiv(){
=======
    public String[] getActiv(){
>>>>>>> 80b5a65ca9d47f0f8869d8b03c7e21b9e133201f
        return this.activ;
    }
    public int getFact(){
        return this.fact;
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
<<<<<<< HEAD
    public void setActiv(ArrayList<String> novoActiv){
=======
    public void setActiv(String[] novoActiv){
>>>>>>> 80b5a65ca9d47f0f8869d8b03c7e21b9e133201f
        this.activ = novoActiv;
    }
    public void setFact(int novoFact){
        this.fact = novoFact;
    }
    public boolean equals (Object o){
        if(this==o) return true;
        if((o==null) || this.getClass() != o.getClass()) return false;
        Empresa i = (Empresa) o;
        return  this.nif == i.getNif() &&
                this.email.equals(i.getEmail()) &&
                this.nome.equals(i.getNome()) &&
                this.morada.equals(i.getMorada()) &&
                this.password.equals(i.getPassword()) &&
                this.activ == i.getActiv() &&
                this.fact == i.getFact();
            }
    public Empresa clone(){
        return new Empresa(this);
    }
}
        