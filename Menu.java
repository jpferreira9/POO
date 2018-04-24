/* (Individuais - IRS)Coeficiente Fiscal: deducao em valor$
 * 4000 + bonus
 * (Individuais)Codigo atividades: Atividades definidas pelo governo - ver net
 * 
 * Escritex:
 * (Empresa - IRC)Fator deducao fiscal: em %, varia com ? 
 * Areas que nao permitem deduzir: ?
 * ver portal ds financas
 */

import java.util.*;

public class Menu{
    Empresa emp = new Empresa();
    Individual ind = new Individual();
    Entidade ent = new Entidade();
    Fatura fact = new Fatura();
    
    HashMap<Integer, String> users = new HashMap<>();
    
    
    public static void clear() {  
        System.out.print("\u000C");  
        System.out.flush();  
    }
    public void out(Object o){
        System.out.println(o.toString());
    }
    public void login_menu(){
        clear();
        out("\n\t\tBem vindo ao JavaFactura\n\n\n\nEscolha a sua opção:");
        out("\n\t1)Fazer login"); 
        //validar o acesso à aplicação utilizando as credenciais (nif e password)
        out("\n\t2)Registar um novo utilizador"); 
        //registar um contribuinte, quer seja individual ou empresa
    }
    public void menu_individual(int nif){
        clear();
        out("\n\t Bem vindo, escolha a sua opção: \n\n\n\n\n");
        out("\n\t1)Verificar despesas"); 
        //verificar, por parte do contribuinte individual, as despesas que foram emitidas em seu nome 
        out("\n\t2)Verificar dedução fiscal acumulada");
        // verificar o montante de dedução fiscal acumulado, por si e pelo agregado familiar;
    }
    public void menu_empresa(int nif){
        clear();
        out("\n\t Bem vindo, escolha a sua opção: \n\n\n\n\n");
        out("\n\t1)Criar fatura"); 
        //criar facturas associadas a despesas feitas por um contribuinte individual
        out("\n\t2)Editar fatura"); 
        /* associar/editar classificação de actividade económica a um documento de despesa
        deve deixar registo para ser depois rastreada */
        out("\n\t3)Verificar faturas emitidas"); 
        //obter a listagem das facturas todas de uma determinada empresa, ordenada por data de emissão ou por valor
        out("\n\t4)Verificar faturas de contribuinte"); 
        /* obter por parte das empresas, as listagens das facturas por contribuinte num determinado intervalo de datas
         obter por parte das empresas, as listagens das facturas por contribuinte ordenadas por valor decrescente de despesa */
        out("\n\t5)Verificar total faturado"); 
        // indicar o total facturado por uma empresa num determinado período
    }
    public void menu_admin(){
        clear();
        out("\n\t Bem vindo, escolha a sua opção: \n\n\n\n\n");
        out("\n\t1)Verificar 10 contribuintes que mais gastam");
        // determinar a relação dos 10 contribuintes que mais gastam em todo o sistema
        out("\n\t2)Verificar as X empresas com maior nº de faturas e as suas deduções fiscais");
        /* determinar a relação das X empresas que mais facturas em todo o sistema e o montante de deduções 
         fiscais que as despesas registadas (dessas empresas) representam*/
        
    }
    public void save(){
        //gravar o estado da aplicação em cheiro, para que seja possível retomar mais tarde a execução    
    }
    public Menu(){ 
        users.put(1234, "bolas");
        while(1==1){    
            login_menu();
            Scanner in = new Scanner(System.in);
            
            switch(in.nextInt()){
                case 1: // Login de utilizador 
                    out("\nIntroduza NIF: ");
                    int a = in.nextInt();
                    if(a == 1234 || (a > 99999999 && a < 1000000000 && (a < 300000000 || a >= 500000000 || a < 700000000 || a >= 800000000))){
                        boolean check = users.containsKey(a);
                        if(check == true){
                           out("\nIntroduza password: ");
                           String pw = in.next();
                           if(pw.equals(users.get(a))){
                               if(a == 1234) menu_admin();
                               else if(a < 300000000) menu_individual(a);
                               else if(a> 3000000) menu_empresa(a);
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
                    int b = in.nextInt();
                    if(b > 99999999 && b < 1000000000 && (b < 300000000 || b >= 500000000 || b < 700000000 || b >= 800000000)){
                        boolean check = users.containsKey(b);
                        if(check == false) {
                            out("\nIntroduza password:");
                            String pw = in.next();
                            users.put(b, pw);
                            out("\nRegisto efetuado");
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
            out("\nPrima qualquer nº>0 para continuar, 0 para sair:");
            if(in.nextInt() == 0) return;
        }
    }
    public static void main(String[] args){
        new Menu();
    }
    
}