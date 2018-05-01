import java.util.*;
import java.io.*;
import java.time.*;

public class Gestao implements java.io.Serializable{
    Empresa emp = new Empresa();
    Individual ind = new Individual();
    Fatura fat = new Fatura();
    Menu menu = new Menu();
       
    Scanner in = new Scanner(System.in);
    
    HashMap<Integer,String> ativs = new HashMap<Integer,String>();
    HashMap<Integer,String> users =  new HashMap<Integer,String>();
    ArrayList<Integer> nifAgregado = new ArrayList<Integer>();
    
    public void out(Object o){
        System.out.println(o.toString());
    }
    public boolean nifValido(int x){
        int z = x/100000000;
        if(x == 1234 || (z > 0.9 && z < 10 && (z < 3|| z >= 5 || z < 7 || z >= 8))) return true;
        else return false;
    }
    public void admin(){
       while(true){ 
            menu.admin();
            switch(in.nextInt()){
               case 1:
                    out("\nOS 10 CONTRIBUINTES COM MAIS DESPESAS:");
                    break;
               
               case 2:
                    out("\nQUANTAS EMPRESAS?");
                    int num = in.nextInt();
                    break;
                    
               case 3:
                    out("\nLIMPAR DADOS?");
                    if(in.nextInt()==1)reset();
                    break;
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
                    break;
                    
                default:
                    out("\nOPCAO INVALIDA!");
                    break;
            }
        }
    }
    
    public void empresa(int x){
        while(true){         
            menu.empresa(x);
            switch(in.nextInt()){
                case 1:
                    out("CRIAR FATURA DE VENDA");
                    fat.imprime();
                    break;
                
                case 2:
                    out("\nASSOCIAR/EDITAR ATIVIDADE NA FATURA");
                    fat.editar();
                    break;
                    
                case 3:
                    out("\nLISTA DE FATURAS:");
                    fat.lista();
                    break;
                    
                case 4:
                    out("\nINTRODUZIR NUMERO CONTRIBUINTE");
                    
                    out("\nINTRODUZIR DATA:");
                    fat.cliente();
                    break;
                    
                case 5:
                    out("\nINTRODUZIR DATA:");
                    
                    out("\nTOTAL FATURADO:");
                    fat.total();
                    break;
                    
                default:
                    out("\nOPCAO INVALIDA");
                    break;
            }
        }
    }
    
    public void ativP1(){
        menu.atividadesP1();
        while(true){
            switch(in.nextInt()){
                case 1:
                    ativs.put(1,"Cabeleireiros");                
                    break;
                case 2:
                    ativs.put(2,"Despesas Familiares");
                    break;
                case 3:
                    ativs.put(3,"Educação");
                    break;
                case 4:
                    ativs.put(4,"Habitação");
                    break;
                case 5:
                    ativs.put(5,"Lares");
                    break;
                case 6:
                    ativs.put(6,"Passes Mensais");
                    break;
                case 9:
                    ativP2();
                    break;
                case 0:
                    return;
                default:
                    out("Opção inválida");
                    break;
            }
        }
    }
    public void ativP2(){
        menu.atividadesP2();
        while(true){
            switch(in.nextInt()){
                case 1:
                    ativs.put(7,"Reparações Automóvel");
                    break;
                case 2:
                    ativs.put(8,"Reparações Motorizadas");
                    break;
                case 3:
                    ativs.put(9,"Restauração e Alojamento");
                    break;
                case 4:
                    ativs.put(10,"Saúde");
                    break;
                case 5:
                    ativs.put(11,"Veterinários");
                    break;
                case 6:
                    ativs.put(12,"Outros");
                    break;
                case 9:
                    ativP1();
                    break;
                case 0:
                    return;
                default:
                    out("Opção inválida");
                    break;
            }
        }
    }
    
    public Gestao(){
            users.put(1234,"bolas");
            load();
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
                                   if(a == 1234) admin();
                                   else if(a < 300000000) individual(a);
                                   else if(a > 300000000) empresa(a);
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
                                    String nome = in.nextLine();
                                    out("\nIntroduza o seu e-mail");
                                    String mail = in.nextLine();
                                    out("\nIntroduza a sua morada");
                                    String morada = in.nextLine();
                                    out("\nIntroduza o numero de dependentes do agregado familiar");
                                    int depAgreg = in.nextInt();
                                    out("Introduza os NIFs do agregado familiar");
                                    while(depAgreg > 0){
                                        int y = in.nextInt();
                                        if(nifValido(y)==true){
                                            nifAgregado.add(y);
                                            depAgreg--;
                                        }
                                        else out("NIF inválido");
                                    }
                                }
                                else { // DEFINIDO COMO EMPRESA
                                    out("\nIntroduza o nome da empresa");
                                    String nome = in.nextLine();
                                    out("\nIntroduza o seu e-mail");
                                    String mail = in.nextLine();
                                    out("\nIntroduza a sua morada");
                                    String morada = in.nextLine();
                                    ativP1();
                                    
                                }
                                out("\nRegisto efetuado");
                                save(users);
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
    
    public void save(HashMap<Integer,String> users){ //gravar o estado da aplicação em ficheiro, para que seja possível retomar mais tarde a execução   
        try{
            File userList = new File("userList");
            FileOutputStream fos = new FileOutputStream(userList);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(users);
            oos.flush();
            oos.close();
            fos.close();
            out("Ficheiro guardado");
        }
        catch(Exception e){}
    }
    public void load(){//ler o estado da aplicacao em ficheiro        
        try{
            File toRead = new File("userList");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            users = (HashMap<Integer,String>)ois.readObject();
            
            ois.close();
            fis.close();
        }
        catch(Exception e){}
    }
    public void testPrint(HashMap<Integer,String> users){
        for(Map.Entry<Integer,String> u : users.entrySet()){
                out("Username: {"+u.getKey()+"} Password: {"+u.getValue()+"}\n");
            }
    }
    public void reset(){//limpar o ficheiro
        File userList = new File("userList");
        userList.delete();
    }
    
    public static void main(String[] args){        
        new Gestao();
    }
}
