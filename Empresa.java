import java.time.LocalDate;
import java.util.*;


public class Empresa implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private int nif;
    private String email;
    private String nome;
    private String morada;
    private String password;
	private ArrayList<String> activ;
    private int ffiscal;
    
    Menu menu = new Menu();
    
    private ArrayList<Fatura> listaFaturas = new ArrayList<>();
    
    public Empresa(){
        this.nif = 0;
        this.password = "";
        this.nome = "";
        this.email = "";
        this.morada = "";
        this.activ = new ArrayList<String>(0);
        this.ffiscal = 1;
    }
    
    public Empresa(int nif, String pass, String nome, String email,  String morada,  ArrayList<String> actividade, int ffiscalorFiscal){
    	this.nif = nif;
        this.password = pass;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.setActiv(actividade);
        this.ffiscal = ffiscalorFiscal;        
    }
    
    public Empresa(Empresa e){
    	this.nif = e.getNif();
        this.password = e.getPassword();
        this.nome = e.getNome();
        this.email = e.getEmail();
        this.morada = e.getMorada();
        this.activ = e.getActiv();
        this.ffiscal = e.getFFiscal();
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
    
    public ArrayList<String> getActiv(){
        ArrayList<String> atividade = new ArrayList<String>(this.activ.size());
        for(String s: this.activ)
            atividade.add(s);
        return atividade;
    }
    
    public int getFFiscal(){ return this.ffiscal;}
    
    public void setActiv(ArrayList<String> novoActiv){
        this.activ = new ArrayList<String>(novoActiv.size());
        for(String s: novoActiv)
            this.activ.add(s);
    }
    
    public void setFFiscal(int novoffiscal){ this.ffiscal = novoffiscal; }
    
    public boolean equals (Object o){
        if(this==o) return true;
        if((o==null) || this.getClass() != o.getClass()) return false;
        Empresa i = (Empresa) o;
        return this.nif == i.getNif() &&
                this.email.equals(i.getEmail()) &&
                this.nome.equals(i.getNome()) &&
                this.morada.equals(i.getMorada()) &&
                this.password.equals(i.getPassword()) &&
                this.activ.equals(i.getActiv()) &&
                this.ffiscal == i.getFFiscal();
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("NIF: " +this.nif+ "\n");
        sb.append("Nome: "+this.nome+ "\n");
        sb.append("Morada: " +this.morada+ "\n");
        sb.append("Email: " +this.email+ "\n");
        sb.append("Password: "+this.password+ "\n");
        sb.append("Atividade: " +this.activ+ "\n");
        sb.append("Factor fiscal: " +this.ffiscal+ "\n");
        
        return sb.toString();
    }
    
    public Empresa clone(){
        return new Empresa(this);
    }
    
    public Fatura criarFatura(ArrayList<Fatura> f){
        LocalDate now = LocalDate.now();
        Scanner input = new Scanner(System.in);
                
        System.out.println("NIF do cliente");
        int nifCliente = input.nextInt();
        System.out.println("Descricao da fatura");
        String descricao = input.nextLine();
        descricao = input.nextLine();
        System.out.println("Valor da fatura");
        double valor = input.nextDouble();
        System.out.println("Actividade Associada");
        input.nextLine();
        String act = input.nextLine();
        
        Fatura fat = new Fatura(this.getNif(), this.getNome(), now, nifCliente, descricao, valor, act);
        listaFaturas.add(fat);        
        
        System.out.println(fat.toString());
        return fat;
    }
    
    public void imprimeActivs() {
    	for(String s: this.activ)
    		System.out.println(" * "+s);
    }
    
    public void imprimeFaturas(int x, ArrayList<Fatura> z) {
    	Fatura f = new Fatura();
    	menu.fatHeader();
    	for(int i=0;i<z.size();i++) {
    		f = z.get(i);
    		if(f.getNIFEmitente()==x);{
    			String n = f.getDEmitente();
    			int nC = f.getNIFCliente();
    			String desc = f.getDescricao();	
    			LocalDate dT = f.getData();
    			double v = f.getValor();
    			String act = f.getActiv();
    			menu.impFat(i+1,x,n,dT,nC,desc,v,act);
    		}
    	}
    }
    
    public void totalFaturado() {
    	
    }
    
    public void numFaturas(int x) {
    	
    }
}
        
