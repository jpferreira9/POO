import java.util.*;
import java.io.*;
import java.time.*;

public class Gestao implements java.io.Serializable{
    Empresa emp = new Empresa();
    Individual ind = new Individual();
    Fatura fat = new Fatura();
    Menu menu = new Menu();
    Dados dados = new Dados();   
    Scanner in = new Scanner(System.in);

    HashMap<Integer,String> users =  new HashMap<Integer,String>();
    HashMap<Integer,Empresa> dadosEmp = new HashMap<Integer,Empresa>();
    HashMap<Integer,Individual> dadosInd = new HashMap<Integer, Individual>();
    HashMap<Integer,ArrayList<Fatura>> dadosFat = new HashMap<Integer,ArrayList<Fatura>>();
    ArrayList<Fatura> listaFaturas = new ArrayList<Fatura>();
    
    final HashMap<String,Double> dadosDistr = dados.povDistritos();
    final HashMap<String,Double> dadosActiv = dados.povAtividades();
    

    
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
                    out("\n\tOs 10 Contribuintes com mais despesas:");
                    break;
               
               case 2:
                    out("\n\tQUANTAS EMPRESAS?");
                    int num = in.nextInt();
                    break;
                    
               case 3:
                    menu.clear();
                    out("\n\tUtilizadores registados:\n");
                    mapPrint(users);
                    in.nextInt();
                    break;
                    
               case 4:
                    menu.clear();
                    out("\n\tEmpresas Registadas:\n");
                    System.out.println(dadosEmp.toString());
                    in.nextInt();
                    break;
                    
               case 5:
                    menu.clear();
                    out("\n\tIndividuais Registados:\n");
                    System.out.println(dadosInd.toString());
                    in.nextInt();
                    break;
                    
               case 7:
                    limparDados();
                    break;
                    
               case 0:
                    return;
                    
               default:
                    out("\nOPCAO INVALIDA!");
                    break;
            }
        }
    }
    
    public void individual(int x){
        while(true){
            menu.individual(x);
            switch(in.nextInt()){
                case 1:
                    out("\nLISTA DE DESPESAS:");
                    break;
                
                case 2:
                    out("\nDEDUCAO FISCAL ACUMULADA:");
                    //ver se realmente e isto
                    out("\n\t"+dadosInd.get(x).getCoef());
                    in.nextInt();
                    break;
                
                case 0:
                    return;
                    
                default:
                    out("\nOPCAO INVALIDA!");
                    break;
            }
        }
    }
    
    public void empresa(int x){
        while(true){         
            menu.empresa(x);
                //System.out.println(x);
                System.out.println(dadosEmp.get(x).toString());
            switch(in.nextInt()){

                case 1:
                    out("Fatura de venda");
                    fat = dadosEmp.get(x).criarFatura();
  
                    if(dadosFat.containsKey(x))
                        listaFaturas = dadosFat.get(x);
                    listaFaturas.add(fat);
                    dadosFat.put(x,listaFaturas);
                    saveFaturas(dadosFat);
                    in.nextInt();
                    break;
                
                case 2:
                    out("\nEditar atividade na fatura");
                    listaFaturas = dadosFat.get(x);
                    ArrayList<Fatura> novaListaFats = new ArrayList<Fatura>();
                    novaListaFats = editar(listaFaturas);
                    dadosFat.replace(x,novaListaFats);
                    saveFaturas(dadosFat);
                    break;
                    
                case 3:
                    menu.clear();
                    out("\nLista de faturas:");
                    if(dadosFat.get(x) == null)
                        out("Nao existem faturas registadas nesta Empresa");
                    else{
                        dadosEmp.get(x).imprimeFaturas(x,dadosFat.get(x));
                    }
                    in.nextInt();
                    break;
                    
                case 4:
                    out("\nINTRODUZIR NUMERO CONTRIBUINTE");
                    
                    out("\nIntroduzir data:");
                    
                    break;
                    
                case 5:
                    out("\nINTRODUZIR DATA:");
                    
                    out("\nTotal faturado:");
                    
                    break;
                
                case 6:
                    menu.clear();
                    out("\n\tLista das atividades da empresa:\n");
                    dadosEmp.get(x).imprimeActivs();

                        
                    out("\n\n\n\n\n\t\tPRIMA QUALQUER NUMERO PARA VOLTAR ATRAS");
                    in.nextInt();
                    break;
                    
                case 0:
                    return;
                    
                default:
                    out("\nOPCAO INVALIDA");
                    break;
            }
        }
    }
    
    public ArrayList<Fatura> editar(ArrayList<Fatura> fats){
        menu.clear();
        out("\n\tIntroduza o numero da fatura que pretende mudar a atividade");
        int nr = in.nextInt();
        if(nr>fats.size()){
            out("\n***** Nao existe fatura com esse numero *****");
            menu.pausar();
            return fats;
        }
        else{
            int i = 1;
            Fatura f = new Fatura();
            for(Fatura fat: fats){
                if(i==nr){
                    f = fat.clone();
                    fat.setValor(0.0);
    
                    break;
                }
                i++;
            }
            
            menu.menu_ativs();
            String novaActiv = "";
            novaActiv = emp.select_activ(novaActiv);
            f.setAtividade(novaActiv);
            fats.add(f);
            menu.clear();
            out("Atividade modificada com sucesso");
            menu.pausar();
        
            return fats;
        }
    }
    
    
    public void atividades(ArrayList ativs){
        out("####### Selecione a(s) atividade(s): #######");
        menu.menu_ativs();
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
                case 7:
                    ativs.add("Reparações Automóvel");
                    break;
                case 8:
                    ativs.add("Reparações Motorizadas");
                    break;
                case 9:
                    ativs.add("Restauração e Alojamento");
                    break;
                case 10:
                    ativs.add("Saúde");
                    break;
                case 11:
                    ativs.add("Veterinários");
                    break;
                case 12:
                    ativs.add("Outros");
                    break;
                case 0:
                    return;
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
        loadFaturas();
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
                                nom = in.nextLine();
                                out("\nIntroduza o seu e-mail");
                                String mail = in.nextLine();
                                out("\nIntroduza a sua morada");
                                String morada = in.nextLine();
                                out("\nIntroduza o numero de dependentes do agregado familiar");
                                int depAgreg = in.nextInt();
                                out("Introduza os NIFs do agregado familiar");

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
                                out("\nIntroduza o seu-mail");
                                String mail = in.nextLine();
                                out("\nIntroduza o seu distrito");
                                String distrito = in.nextLine();
                                while(!dadosDistr.containsKey(distrito)){
                                    out("Introduza um distrito valido, atencao as maiusculas");
                                    distrito = in.nextLine();
                                }
                                
                                double fator = dadosDistr.get(distrito);
                                
                                ArrayList<String> ativs = new ArrayList<String>();
                                atividades(ativs);
                                double deducao = 0.0;
                                for(String s: ativs){
                                    if(dadosActiv.get(s)>deducao)
                                        deducao = dadosActiv.get(s);
                                }
                                
                                fator += deducao;
                                out(fator);   
                                emp = new Empresa(a,pw, nome, mail, distrito, ativs ,fator);

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
            out("Ficheiro Users guardado com sucesso");
        }
        catch(Exception e){out("Erro ao guardar ficheiro Users");}
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
        catch(Exception e){out("Erro ao abrir ficheiro Users");}
    }
    
    /**
     * Apagar dados para login de utilizadores
     */
    
    public void resetUsers(){
        File userList = new File("userList");
        userList.delete();
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
            out("Ficheiro Individual guardado com sucesso");
        }
        catch(Exception e){out("Erro ao guardar ficheiro Individual");}
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
        catch(Exception e){out("Erro ao abrir ficheiro Individual");}
    }
    
    /**
     * Apagar dados do ficheiro dos Individuais
     */
    
    public void resetIndiv(){
        File indivList = new File("indivList");
        indivList.delete();
    }
    
     /**
      * Gravar em ficheiro binario os dados dos NIF's de Empresas criadas em ficheiro,
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
            out("Empresa guardada com sucesso");
        }
        catch(Exception e){
            //out("Erro ao guardar Empresa");
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
        }
        catch(Exception e){out("Erro ao abrir ficheiro Empresa");}
    }
    
    /**
     * Apagar dados do ficheiro das Empresas
     */
    
    public void resetEmp(){
        File empList = new File("empList");
        empList.delete();
    }
    
     /**
     * Grava ficheiro binario com todas as faturas criadas
     * A cada NIF da empresa grava uma lista com as faturas criadas pela empresa
     */
        
    public void saveFaturas(HashMap<Integer,ArrayList<Fatura>> faturas){   
        try{
            File fatsList = new File("fatsList");
            FileOutputStream fos = new FileOutputStream(fatsList);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(faturas);
            oos.flush();
            oos.close();
            fos.close();
            out("Ficheiro Faturas guardado com sucesso");
        }
        catch(Exception e){out("Erro ao guardar ficheiro Faturas");}
    }
    
    /**
     * Ler os dados do ficheiro das Fatura
     */
    
    public void loadFaturas(){        
        try{
            File toRead = new File("fatsList");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            dadosFat = (HashMap<Integer,ArrayList<Fatura>>)ois.readObject();
            
            ois.close();
            fis.close();
        }
        catch(Exception e){out("Erro ao abrir ficheiro Faturas");}
    }
    
    /**
     * Apagar dados do ficheiro das Faturas
     */
    
    public void resetFaturas(){
        File fatsList = new File("fatsList");
        fatsList.delete();
    }
    
    
    
    public void mapPrint(HashMap<Integer,String> map){
        for(Map.Entry<Integer,String> u : map.entrySet()){
                out(" Username: {"+u.getKey()+"} Password: {"+u.getValue()+"}\n");
            }
    }

    
    public static void main(String[] args) throws IOException, Exception{
        new Gestao();
    }
}
