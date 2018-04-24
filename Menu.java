    
    /* (Individuais - IRS)Coeficiente Fiscal: deducao em valor$
     * 4000 + bonus
     * (Individuais)Codigo atividades: Atividades definidas pelo governo - ver net
     * 
     * Escritex:
     * (Empresa - IRC)Fator deducao fiscal: em %, varia com ? 
     * Areas que nao permitem deduzir: ?
     * ver portal ds financas
     * 
     */

import java.util.Scanner;

public class Menu{
    Empresa emp = new Empresa();
    Individual ind = new Individual();
    Entidade ent = new Entidade();
    Factura fact = new Factura();
    
    public static void clear() {  
        System.out.print("\u000C");  
        System.out.flush();  
    }
    public void out(Object o){
        System.out.println(o.toString());
    }
    public void login_menu(){
        out("\n\t\tBem vindo ao JavaFactura\n\n\n\nEscolha a sua opção:");
        out("\n\t1)Fazer login");
        out("\n\t2)Registar um novo utilizador");
    }
    public Menu(){
        login_menu();
        Scanner in = new Scanner(System.in);
        
        switch(in.nextInt()){
            case 1:
                out("Introduza NIF: ");
                
                out("Introduza Password: ");
                break;
                
            case 2:
                break;
                
            default:
                out("Opção inválida");
                break;
        }
    }
    public static void main(String[] args){
        new Menu();
    }
    
}
