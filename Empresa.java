import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Empresa implements java.io.Serializable{
    private int nif;
    private String email;
    private String nome;
    private String morada;
    private String password;
    private ArrayList<String> activ;
    private int ffiscal;
    
    Menu menu = new Menu();
    public void out(Object o){
        System.out.println(o);
    }
    
    
    public Empresa(){
        this.nif = 0;
        this.password = "";
        this.nome = "";
        this.email = "";
        this.morada = "";
        this.activ = new ArrayList<String>(0);
        this.ffiscal = 1;
    }
    
    public Empresa(int nif, String pass, String nome, String email, String morada, ArrayList<String> actividade, int fFiscal){
        this.nif = nif;
        this.password = pass;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.setActiv(actividade);
        this.ffiscal = fFiscal;
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
    
    public ArrayList<String> getActiv(){
        ArrayList<String> atividade = new ArrayList<String>(this.activ.size());
        for(String s: this.activ)
            atividade.add(s);
        return atividade;
    }
    
    public int getFFiscal(){ return this.ffiscal;}
    
    
    public void setNif (int novoNif){ this.nif = novoNif; }
    
    public void setEmail (String novoEmail){ this.email = novoEmail; }
    
    public void setNome (String novoNome){ this.nome = novoNome; }
       
    public void setMorada (String novaMorada){ this.morada = novaMorada; }
    
    public void setPassword (String novaPass){ this.password = novaPass; }
    
    public void setActiv(ArrayList<String> novoActiv){
        this.activ = new ArrayList<String>(novoActiv.size());
        for(String s: novoActiv)
            this.activ.add(s);
    }
    
    public void setFFiscal(int novoffiscal){ this.ffiscal = novoffiscal; }
    
    public boolean equals (Object o){
        if(this==o) return true;
        if((o==null) || this.getClass() != o.getClass()) return false;
        Empresa e = (Empresa) o;
        return this.nif == e.getNif() &&
               this.email.equals(e.getEmail()) &&
               this.nome.equals(e.getNome()) &&
               this.morada.equals(e.getMorada()) &&
               this.password.equals(e.getPassword()) &&
               this.activ.equals(e.getActiv()) &&
               this.ffiscal == e.getFFiscal();
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("NIF: " +this.nif+ "\n");
        sb.append("Nome: "+this.nome+ "\n");
        sb.append("Morada: " +this.morada+ "\n");
        sb.append("Email: " +this.email+ "\n");
        sb.append("Password: "+this.password+ "\n");
        sb.append(super.toString());
        sb.append("Atividade: " +this.activ+ "\n");
        sb.append("Factor fiscal: " +this.ffiscal+ "\n");
        
        return sb.toString();
    }
    
    public Empresa clone(){
        return new Empresa(this);
    }
    
    //ver se funciona
    public Fatura criarFatura(){
        LocalDate now = LocalDate.now();
        Scanner input = new Scanner(System.in);
                
        menu.clear();
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t Nome da empresa: " +this.getNome());
        out("\n\t Data da despesa: " +now);
        out("\n\t Nif do Cliente: ");
        int nifCliente = input.nextInt();
        menu.clear();
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t Nome da empresa: " +this.getNome());
        out("\n\t Data da despesa: " +now);
        out("\n\t Nif do Cliente: " +nifCliente);
        out("\n\t Breve descriçao da despesa: ");
        String descricao = input.next();
        menu.clear();
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t Nome da empresa: " +this.getNome());
        out("\n\t Data da despesa: " +now);
        out("\n\t Nif do Cliente: " +nifCliente);
        out("\n\t Breve descriçao da despesa: "+descricao);
        out("\n\t Natureza da despesa: ");
        String act = "";
        act = select_activ(act);
        menu.clear();
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t Nome da empresa: " +this.getNome());
        out("\n\t Data da despesa: " +now);
        out("\n\t Nif do Cliente: " +nifCliente);
        out("\n\t Breve descriçao da despesa: "+descricao);
        out("\n\t Natureza da despesa: " + act);
        out("\n\t Valor da despesa: ");
        double valor = input.nextDouble(); 
        menu.clear();
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t Nome da empresa: " +this.getNome());
        out("\n\t Data da despesa: " +now);
        out("\n\t Nif do Cliente: " +nifCliente);
        out("\n\t Breve descriçao da despesa: "+descricao);
        out("\n\t Natureza da despesa: " + act);
        out("\n\t Valor da despesa: " + valor);
        
        Fatura fat = new Fatura(this.getNif(), this.getNome(), now, nifCliente, descricao, act, valor);        
        
        System.out.println(fat.toString());
        return fat;
    }
    
    
    public String select_activ(String activ){
        menu.menu_ativs();
        Scanner in = new Scanner(System.in);
        while(true){
            switch(in.nextInt()){
                case 1:
                    activ = "Cabeleireiros";                
                    return activ;
                case 2:
                    activ = "Despesas Familiares";
                    return activ;
                case 3:
                    activ = "Educação";
                    return activ;
                case 4:
                    activ = "Habitação";
                    return activ;
                case 5:
                    activ = "Lares";
                    return activ;
                case 6:
                    activ = "Passes Mensais";
                    return activ;
                case 7:
                    activ = "Reparações Automóvel";
                    return activ;
                case 8:
                    activ = "Reparações Motorizadas";
                    return activ;
                case 9:
                    activ = "Restauração e Alojamento";
                    return activ;
                case 10:
                    activ = "Saúde";
                    return activ;
                case 11:
                    activ = "Veterinários";
                    return activ;
                case 12:
                    activ = "Outros";
                    return activ;
                case 0:
                    return activ;
                default:
                    out("Opção inválida");
                    break;
            }
        }
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
                String act = f.getAtividade();
                menu.impFat(i+1,x,n,dT,nC,desc,v,act);
            }
        }
    }
    
    
    /**
     * Imprime atividades da Empresa
     */
    public void imprimeActivs(){
        for(String s: this.activ)
            System.out.println(" * "+s);
    }
    
}
        