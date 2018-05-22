import java.util.*;
import java.io.*;

public class Gestao implements java.io.Serializable{	
	
	private static final long serialVersionUID = 7612055511811556958L;
	Empresa emp = new Empresa();
    Individual ind = new Individual();
    Fatura fat = new Fatura();
    Menu menu = new Menu();
    
    Scanner in = new Scanner(System.in);
    
    ArrayList<Fatura> listaFaturas = new ArrayList<>();
    
    HashMap<Integer,String> users =  new HashMap<Integer,String>();
    HashMap<Integer,Empresa> dadosEmp = new HashMap<Integer,Empresa>();
    HashMap<Integer,Individual> dadosInd = new HashMap<Integer, Individual>();
    HashMap<Integer,ArrayList<Fatura>> dadosFat = new HashMap<Integer,ArrayList<Fatura>>();
      
    public void out(Object o){
        System.out.println(o.toString());
    }
    
    public boolean nifValido(int x){
        int z = x/100000000;
        if(x == 1234 || (z > 0.9 && z < 10 && (z < 3|| z >= 5 || z < 7 || z >= 8))) return true;
        else return false;
    }
    
    public void limparDados(){
        while(true){
            menu.limpaDados();
            switch(in.nextInt()){
                case 1:
                    out("\nDe certeza que pretende eliminar todos os dados (s/n)");
                    if(in.next().equals("s")){
                        resetUsers();
                        resetEmp();
                        resetIndiv();
                        resetFaturas();
                        menu.clear();
                        out("\n\n\n\t\t\t********** Dados eliminados! **********");
                        menu.pausar();
                    }
                    else{
                        menu.clear();
                        out("\n\n\tNenhuma alterçao efetuada");
                        menu.pausar();
                    }
                    return;
                    
                case 2:
                    out("\nDe certeza que pretende eliminar os dados Individuais (s/n)");
                    if(in.next().equals("s")){
                        resetIndiv();
                        menu.clear();
                        out("\n\n\n\t\t\t********** Dados eliminados! **********");
                        menu.pausar();
                    }
                    return;
                    
                case 3:
                    out("\nDe certeza que pretende eliminar os dados das Empresas (s/n)");
                    if(in.next().equals("s")){
                        resetEmp();
                        menu.clear();
                        out("\n\n\n\t\t\t********** Dados eliminados! **********");
                        menu.pausar();
                    }
                    return;
                    
                case 4:
                    out("\nDe certeza que pretende eliminar os dados das Faturas (s/n)");
                    if(in.next().equals("s")){
                        resetFaturas();
                        menu.clear();
                        out("\n\n\n\t\t\t********** Dados eliminados! **********");
                        menu.pausar();
                    }
                    return;
                
                case 0:
                    return;
                    
                default:
                    out("\nOPCAO INVALIDA!");
                    break;    
            }
        }
    }
    
    public void admin(){
       while(true){ 
            menu.admin();
            switch(in.nextInt()){
               case 1:
                    out("\nOS 10 CONTRIBUINTES COM MAIS DESPESAS:");
                    break;
               
               case 2:
                    out("\nQuantas empresas deseja verificar?");
                    int num = in.nextInt();
                    emp.numFaturas(num);
                    break;
                    
               case 3:
                    limparDados();
                    break;
                    
               case 4:
            	   testPrint(users);
            	   in.nextInt();
            	   break;
                    
               case 0:
                    return;
                    
               default:
                    out("\nOpção inválida!");
                    break;
            }
        }
    }
    
    public void individual(int x){
        while(true){
            menu.individual(x);
            switch(in.nextInt()){
                case 1:
                    out("\nLista de despesas:");
                    break;
                /* INCOMPLETO
                case 2: 
                    out("\nDEDUCAO FISCAL ACUMULADA:");
                    
                    out("\n\t"+dadosInd.get(x).getCoef());
                    in.nextInt();
                    break;
                */
                case 0:
                    return;
                    
                default:
                    out("\nOpção inválida!");
                    break;
            }
        }
    }
    
    public void empresa(int x){
        while(true){         
            menu.empresa(x);
            switch(in.nextInt()){
                case 1:
                    out("Nova fatura");
                    listaFaturas.add(dadosEmp.get(x).criarFatura(listaFaturas));
                    dadosFat.put(x, listaFaturas);
                    out("Fatura criada com sucesso");
                    saveFatura(dadosFat);
                    break;
                
                case 2:
                    out("\nASSOCIAR/EDITAR ATIVIDADE NA FATURA");
                    fat.editar();
                    break;
                    
                case 3:
                    out("\nLista de Faturas:");
                    listaFaturas = dadosFat.get(x);
                    emp.imprimeFaturas(x,listaFaturas);
                    break;
                    
                case 4:
                    out("\nINTRODUZIR NUMERO CONTRIBUINTE");
                    
                    out("\nINTRODUZIR DATA:");
                    fat.cliente();
                    break;
                    
                case 5:
                    out("\nINTRODUZIR DATA:");
                    
                    out("\nTOTAL FATURADO:");
                    emp.totalFaturado();
                    break;
                
                case 6:
                    menu.clear();
                    out("\nLista de atividades:\n");
                    emp.imprimeActivs();       
                    out("\n\n\n\n\n\t\tPrima qualquer número para sair");
                    in.nextInt();
                    
                case 0:
                    return;
                    
                default:
                    out("\nOpção inválida!");
                    break;
            }
        }
    }
    
    
    public void ativP1(ArrayList<String> ativs){
        menu.atividadesP1();
        while(true){
            switch(in.nextInt()){
                case 1:
                    ativs.add("Cabeleireiros");                
                    break;
                case 2:
                    ativs.add("Despesas Familiares");
                    break;
                case 3:
                    ativs.add("Educação");
                    break;
                case 4:
                    ativs.add("Habitação");
                    break;
                case 5:
                    ativs.add("Lares");
                    break;
                case 6:
                    ativs.add("Passes Mensais");
                    break;
                case 9:
                    ativP2(ativs);
                    break;
                case 0:
                    return;
                default:
                    out("Opção inválida");
                    break;
            }
        }
    }
    public void ativP2(ArrayList<String> ativs){
        menu.atividadesP2();
        while(true){
            switch(in.nextInt()){
                case 1:
                    ativs.add("Reparações Automóvel");
                    break;
                case 2:
                    ativs.add("Reparações Motorizadas");
                    break;
                case 3:
                    ativs.add("Restauração e Alojamento");
                    break;
                case 4:
                    ativs.add("Saúde");
                    break;
                case 5:
                    ativs.add("Veterinários");
                    break;
                case 6:
                    ativs.add("Outros");
                    break;
                case 9:
                    ativP1(ativs);
                    break;
                default:
                    out("Opção inválida");
                    break;
            }
        }
    }
    
    /**
     * Login e Registo de Entidades
     */
    public Gestao(){
            users.put(1234,"bolas");
            loadUsers();
            loadIndividual();
            loadEmpresa();
            loadFatura();
            while(true){    
                menu.login();                     
                switch(in.nextInt()){
                    case 1: // Login de utilizador 
                        out("\nIntroduza NIF: ");
                        int a = in.nextInt();
                        if(nifValido(a)==true){
                            if(users.containsKey(a) == true){
                               out("\nIntroduza password: ");
                               String pw = in.next();
                               if(users.get(a).equals(pw)){
                                   if(a == 1234){
                                       admin();
                                       menu.sair();
                                       return;
                                    }
                                   else if(a < 300000000){
                                       individual(a);
                                       menu.sair();
                                       return;
                                    }
                                   else if(a > 300000000){ 
                                       empresa(a);
                                       menu.sair();
                                       return;
                                    }
                               }
                               else {
                                   out("\nPassword incorrecta!");
                                   break;
                                }
                            }
                            else {
                                out("\nNIF não existe!");
                                break;
                            }        
                        }
                        else {
                            out("\nNIF inválido!");
                            break;
                        }
                                    
                    case 2: // Registar Utilizador
                        out("\nIntroduza NIF: ");
                        a = in.nextInt();
                        if(nifValido(a)==true){
                            boolean tipoI;
                            if(a<300000000)tipoI = true;
                            else tipoI = false;
                            boolean check = users.containsKey(a);
                            if(check == false) {
                                out("\nIntroduza password:");
                                String pw = in.next();
                                users.put(a,pw);
                                if(tipoI){ // DEFINIDO COMO INDIVIDUAL
                                    out("\nIntroduza o seu nome");
                                    String nom = in.nextLine();
                                    in.nextLine();
                                    out("\nIntroduza o seu e-mail");
                                    String mail = in.nextLine();
                                    out("\nIntroduza a sua morada");
                                    String morada = in.nextLine();
                                    out("\nIntroduza o numero de dependentes do agregado familiar");
                                    int depAgreg = in.nextInt();
                                    if(depAgreg>0) { 
                                    	out("Introduza os NIFs do agregado familiar");
                                    }
                                    
                                    ArrayList<Integer> nifAgregado = new ArrayList<Integer>();
                                    float coef = 1;
                                    while(depAgreg > 0){
                                        int y = in.nextInt();
                                        if(nifValido(y)==true){
                                            nifAgregado.add(y);
                                            depAgreg--;
                                            if(users.containsKey(y))
                                                coef += 1;
                                            else coef += 0.3;
                                        }
                                        else out("NIF inválido");
                                    }
                                    
                                    Individual indiv = new Individual(a,pw,nom,mail,morada,depAgreg,nifAgregado,coef,1);
                                    
                                    dadosInd.put(a,indiv);
                                    saveIndividual(dadosInd);
                                    
                                }
                                else { // DEFINIDO COMO EMPRESA
                                    out("\nIntroduza o nome da empresa");
                                    String nome = in.nextLine();
                                    nome = in.nextLine();
                                    out("\nIntroduza o seu e-mail");
                                    String mail = in.nextLine();
                                    out("\nIntroduza a sua morada");
                                    String morada = in.nextLine();
                                    
                                    ArrayList<String> ativs = new ArrayList<String>();
                                    ativP1(ativs);
                                    
                                    emp = new Empresa(a,pw, nome, mail, morada, ativs,1);
                                    
                                    dadosEmp.put(a,emp);
                                    saveEmpresa(dadosEmp);
                                }
                                out("\n\t\t***Registo efetuado***\n\n");
                                saveUsers(users);
                                break;
                                }
                            else{
                                out("\nNIF já existe!");
                                break;
                            }
                        }
                        else {
                            out("\nNIF inválido!");
                            break;
                        }                       
                    default:
                        out("\nOpção inválida!");
                        break;
                }
                out("\nPrima qualquer nº para continuar, 0 para sair:");
                if(in.nextInt() == 0) return;
            }
            
        }
    
    /**
     * Gravar os utilizadores criados em ficheiro,
     * para que seja possível retomar mais tarde a execução
     */
        
    public void saveUsers(HashMap<Integer,String> utilizadores){   
        try{
            File userList = new File("userList");
            FileOutputStream fos = new FileOutputStream(userList);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(utilizadores);
            oos.flush();
            oos.close();
            fos.close();
            out("Ficheiro userList guardado com sucesso");
        }
        catch(Exception e){
        	e.printStackTrace();
        	}
    }
        
    /**
     * Ler os utilizadores em ficheiro
     */
    
    public void loadUsers(){        
        try{
            File toRead = new File("userList");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            users = (HashMap<Integer,String>)ois.readObject();
            
            ois.close();
            fis.close();
        }
        catch(Exception e){
        	e.printStackTrace();
        }
    }
    
    /**
     * Apagar dados para login de utilizadores
     */
    
    public void resetUsers(){
        File userList = new File("userList");
        userList.delete();
    }
    
    /**
     * Apagar os Faturas guardadas
     */
    
    public void resetFaturas() {
    	File dadosFat = new File("dadosFat");
    	dadosFat.delete();
    	
    }
    
     /**
     * Gravar os dados dos NIF's Individuais criados em ficheiro,
     * para que seja possível retomar mais tarde a execução
     */
        
    public void saveIndividual(HashMap<Integer,Individual> indiv){   
        try{
            File indivList = new File("indivList");
            FileOutputStream fos = new FileOutputStream(indivList);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(indiv);
            oos.flush();
            oos.close();
            fos.close();
            out("Ficheiro indivList guardado com sucesso");
        }
        catch(Exception e){
        	e.printStackTrace();
        	}
    }	
    
    /**
     * Ler os dados do Individuais em ficheiro
     */
    
    public void loadIndividual(){        
        try{
            File toRead = new File("indivList");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            dadosInd = (HashMap<Integer,Individual>)ois.readObject();
            
            ois.close();
            fis.close();
        }
        catch(Exception e){
        	e.printStackTrace();
        }
    }
    
    /**
     * Apagar dados dos Individuais
     */
    
    public void resetIndiv(){
        File indivList = new File("indivList");
        indivList.delete();
    }
    
     /**
     * Gravar os dados dos NIF's de Empresas criadas em ficheiro,
     * para que seja possível retomar mais tarde a execução
     */
        
    public void saveEmpresa(HashMap<Integer,Empresa> empresa){   
        try{
            File empList = new File("empList");
            FileOutputStream fos = new FileOutputStream(empList);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(empresa);
            oos.flush();
            oos.close();
            fos.close();
            out("Ficheiro empList guardado com sucesso");
        }
        catch(Exception e){
        	e.printStackTrace();
        	}
    }
    
    /**
     * Ler os dados das Empresas em ficheiro
     */
    
    public void loadEmpresa(){        
        try{
            File toRead = new File("empList");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            dadosEmp = (HashMap<Integer,Empresa>)ois.readObject();
            
            ois.close();
            fis.close();
            out("empList carregado");
        }
        catch(Exception e){
        	e.printStackTrace();
        }
    }
    
    /**
     * Guardar Faturas em ficheiro 
     */
    public void saveFatura(HashMap<Integer,ArrayList<Fatura>> fat) {
            try{
                File fatList = new File("fatList");
                FileOutputStream fos = new FileOutputStream(fatList);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                
                oos.writeObject(fat);
                oos.flush();
                oos.close();
                fos.close();
                out("Ficheiro fatList guardado com sucesso");
            }
            catch(Exception e){
            	e.printStackTrace();
        	}
    }
    
    /**
	* Ler as Faturas guardadas em ficheiro
	*/
    public void loadFatura() {
    	 try{
             File toRead = new File("fatList");
             FileInputStream fis=new FileInputStream(toRead);
             ObjectInputStream ois=new ObjectInputStream(fis);
             
             dadosFat = (HashMap<Integer,ArrayList<Fatura>>)ois.readObject();
             
             ois.close();
             fis.close();
             out("fatList carregado");
         }
         catch(Exception e){
         	e.printStackTrace();
         }
    }
    
    /**
     * Apagar dados das Empresas
     */
    
    public void resetEmp(){
        File empList = new File("empList");
        empList.delete();
    }
    
    public void testPrint(HashMap<Integer,String> map){
        for(Map.Entry<Integer,String> u : map.entrySet()){
                out("Username: {"+u.getKey()+"} Password: {"+u.getValue()+"}\n");
            }
    }
	
    public void totalFaturado(int x, ArrayList<Fatura> z) {
    	DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	out("\nIntroduzir data inicial (dd/MM/yyyy):");
        String inicio = in.nextLine();
        inicio = in.nextLine();
        LocalDate date1 = null;
    	date1 = LocalDate.parse(inicio, sdf);
    	out("\nIntroduzir data final (dd/MM/yyyy):");
        String fim= in.nextLine();
    	LocalDate date2 = null;
    	date2 = LocalDate.parse(fim, sdf);
    	double total = 0;	
        	for(int i=0;i<z.size();i++) {
        		fat = z.get(i);
        		if(fat.getNIFEmitente()==x && fat.getData().isBefore(date2) && fat.getData().isAfter(date1)) {
        			total += fat.getValor();
        		}
        	}
    	System.out.println("Total faturado pela empresa no intervalo: "+ total + "€");
    }
    
    
    public static void main(String[] args){        
        new Gestao();
    }
}
