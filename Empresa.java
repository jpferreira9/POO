import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
    
public class Empresa extends Entidade implements java.io.Serializable{
    private ArrayList<String> activ;
    private double ffiscal;

    Menu menu = new Menu();
        public void out(Object o){
        System.out.println(o);
    }
    
    
    public Empresa(){
        super();
        this.activ = new ArrayList<String>(0);
        this.ffiscal = 0.0;
    }
        
    public Empresa(int nif, String pass, String nome, String email, String morada, ArrayList<String> actividade, double fFiscal){
        super(nif, pass, nome, email, morada);
        this.setActiv(actividade);
        this.ffiscal = fFiscal;
    }
        
    public Empresa(Empresa e){
        super(e);
        this.activ = e.getActiv();
        this.ffiscal = e.getFFiscal();
    
    }
        
    public ArrayList<String> getActiv(){
        ArrayList<String> atividade = new ArrayList<String>(this.activ.size());
        for(String s: this.activ)
            atividade.add(s);
        return atividade;
    }
        
    public double getFFiscal(){ return this.ffiscal;}

        
    public void setActiv(ArrayList<String> novoActiv){
        this.activ = new ArrayList<String>(novoActiv.size());
        for(String s: novoActiv)
            this.activ.add(s);
    }
        
    public void setFFiscal(double novoffiscal){ this.ffiscal = novoffiscal; }
        
    public boolean equals (Object o){
        if(this==o) return true;
        if((o==null) || this.getClass() != o.getClass()) return false;
        Empresa e = (Empresa) o;
        return super.equals(e) &&
                this.activ.equals(e.getActiv()) &&
                this.ffiscal == e.getFFiscal();
    }
        
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(super.toString());
        sb.append("Atividade: " +this.activ+ "\n");
        sb.append("Factor fiscal: " +this.ffiscal+ "\n");
        
        return sb.toString();
    }
        
    public Empresa clone(){
        return new Empresa(this);
    }
        
    public boolean nifValido(int x){
        int z = x/100000000;
        if(x == 1234 || (z > 0.9 && z < 10 && (z < 3|| z >= 5 || z < 7 || z >= 8))) return true;
        else return false;
    }

    public Fatura criarFatura(){
        LocalDate now = LocalDate.now();
        Scanner input = new Scanner(System.in);
        
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t Nome da empresa: " +this.getNome());
        out("\n\t Data da despesa: " +now);
        out("\n\t Nif do Cliente: ");
        int nifCliente = input.nextInt();
        while(!nifValido(nifCliente)){
            out("NIF invalido, tente novamente");
            nifCliente = input.nextInt();
        }
        menu.clear();
        out("\n\t\tCriar fatura de venda");
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t Nome da empresa: " +this.getNome());
        out("\n\t Data da despesa: " +now);
        out("\n\t Nif do Cliente: " +nifCliente);
        out("\n\t Breve descriçao da despesa: ");
        String descricao = input.nextLine();
        descricao = input.nextLine();
        menu.clear();
        out("\n\t\tCriar fatura de venda");
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t Nome da empresa: " +this.getNome());
        out("\n\t Data da despesa: " +now);
        out("\n\t Nif do Cliente: " +nifCliente);
        out("\n\t Breve descriçao da despesa: "+descricao);
        out("\n\t Natureza da despesa: ");
        String act = "Pendente";
        if(this.getActiv().size()==1){
            act = this.getActiv().get(0);
        }
        menu.clear();
        out("\n\t\tCriar fatura de venda");
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t Nome da empresa: " +this.getNome());
        out("\n\t Data da despesa: " +now);
        out("\n\t Nif do Cliente: " +nifCliente);
        out("\n\t Breve descriçao da despesa: "+descricao);
        out("\n\t Natureza da despesa: " + act);
        out("\n\t Valor da despesa: ");
        double valor = input.nextDouble();
        menu.clear();
        out("\n\t\tCriar fatura de venda");
        out("\n\t NIF da empresa:" +this.getNif());
        out("\n\t Nome da empresa: " +this.getNome());
        out("\n\t Data da despesa: " +now);
        out("\n\t Nif do Cliente: " +nifCliente);
        out("\n\t Breve descriçao da despesa: "+descricao);
        out("\n\t Natureza da despesa: " + act);
        out("\n\t Valor da despesa: " + valor);
        
        Fatura fat = new Fatura(this.getNif(), this.getNome(), now, nifCliente, descricao, act, valor, this.getFFiscal());        
        
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
                double ded = f.getDeducao();
                menu.impFat(i+1,x,n,dT,nC,desc,v,act,ded);
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

    public void imprimeTotal(int nr ,double total, double deduzido){
        String num = String.format("%04d", nr);
        int nif = this.getNif();
        String nome = this.getNome();
        String designacao = nome.substring(0, Math.min(nome.length(), 10));
        while(designacao.length()<10) {
            designacao += " ";
        }
        out( num+ "  | " +designacao+ " | " +nif+ " | " +deduzido+"€  / " +total+"€");
        out("-----------------------------------------------------------------------------------");
    }
}
