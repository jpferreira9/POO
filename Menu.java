import java.util.*;

public class Menu{
    public static void clear() {  
        System.out.print("\u000C");  
        System.out.flush();  
    }
    public void out(Object o){
        System.out.println(o.toString());
    }
    public void login(){
        clear();
        out("\n\t\tBem vindo ao JavaFactura\n\n\n\nEscolha a sua opção:");
        out("\n\t1)Fazer login"); 
        //FEITO validar o acesso à aplicação utilizando as credenciais (nif e password)
        out("\n\t2)Registar um novo utilizador"); 
        //FEITO registar um contribuinte, quer seja individual ou empresa
    }
    public void individual(int nif){
        clear();
        out("\n\t Bem vindo\n\n\n\nEscolha a sua opção:");
        out("\n\t1)Verificar despesas"); 
        //verificar, por parte do contribuinte individual, as despesas que foram emitidas em seu nome 
        out("\n\t2)Verificar dedução fiscal acumulada");
        // verificar o montante de dedução fiscal acumulado, por si e pelo agregado familiar;
    }
    public void empresa(int nif){
        clear();
        out("\n\t Bem vindo\n\n\n\nEscolha a sua opção:");
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
    public void admin(){
        clear();
        out("\n\t Bem vindo ADMIN\n\n\n\nEscolha a sua opção:");
        out("\n\t1)Verificar 10 contribuintes que mais gastam");
        // determinar a relação dos 10 contribuintes que mais gastam em todo o sistema
        out("\n\t2)Verificar as X empresas com maior nº de faturas e as suas deduções fiscais");
        /* determinar a relação das X empresas que mais facturas em todo o sistema e o montante de deduções 
         fiscais que as despesas registadas (dessas empresas) representam*/
        out("\n\t3)RESET");
        
    }
}