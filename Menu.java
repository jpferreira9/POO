import java.util.Scanner;

public class Menu{
    public static void clear() {  
        System.out.print("\u000C");  
        System.out.flush();  
    }
    public void out(Object o){
        System.out.println(o.toString());
    }
    public void menu_inicial(){
        out("\n\t\tBem vindo ao JavaFactura\n\n\n\nEscolha a sua opção:");
        out("\n\t1)Fazer login");
        out("\n\t2)Registar um novo utilizador");
    }
    public Menu(){
        menu_inicial();
        Scanner in = new Scanner(System.in);
        
        switch(in.nextInt()){
            case 1:
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