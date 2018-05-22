import java.util.*;
import java.time.LocalDate;

public class Menu implements java.io.Serializable{
    public static void clear() {  
        System.out.print("\u000C");  
        System.out.flush();  
    }
    
    public void out(Object o){
        System.out.println(o.toString());
    }
    
    public void login(){
        clear();
        out("\n\t ####### Bem vindo #######\n\n\n\nEscolha a sua opção: ");
        out("\n\t1) Fazer login"); 
        //FEITO validar o acesso à aplicação utilizando as credenciais (nif e password)
        out("\n\t2) Registar um novo utilizador"); 
        //FEITO registar um contribuinte, quer seja individual ou empresa
        out("\n\t3) Sair");
    }
    
    public void individual(int nif){
        clear();
        out("\n\t ####### Bem vindo\n\n\n\nEscolha a sua opção: #######");
        out("\n\t1) Verificar despesas"); 
        //verificar, por parte do contribuinte individual, as despesas que foram emitidas em seu nome 
        out("\n\t2) Verificar dedução fiscal acumulada");
        // verificar o montante de dedução fiscal acumulado, por si e pelo agregado familiar;
        out("\n\n\t0) Sair");
    }
    
    public void atividadesP1(){
        clear();
        out("####### Selecione a(s) atividade(s): #######");
        out("\n\t1) Cabeleireiros");
        out("\n\t2) Despesas Familiares");
        out("\n\t3) Educação");
        out("\n\t4) Habitação");
        out("\n\t5) Lares");
        out("\n\t6) Passes Mensais");
        out("\n\t9) Página Seguinte ----->");
        out("\n\t0) Sair");
    }
    
    public void atividadesP2(){
        clear();
        out("Selecione a(s) atividade(s):");
        out("\n\t1) Reparação Automóvel");
        out("\n\t2) Reparação Motorizadas");
        out("\n\t3) Restauração & Alojamento");
        out("\n\t4) Saúde");
        out("\n\t5) Veterinários");
        out("\n\t6) Outros");
        out("\n\t9) <----- Página Anterior");
        out("\n\t0) Sair");
    }
    
    public void empresa(int nif){
        clear();
        out("\n\t Bem vindo\n\n\n\nEscolha a sua opção:");
        out("\n\t1) Criar fatura"); 
        //criar facturas associadas a despesas feitas por um contribuinte individual
        out("\n\t2) Editar fatura"); 
        /* associar/editar classificação de actividade económica a um documento de despesa
        deve deixar registo para ser depois rastreada */
        out("\n\t3) Verificar faturas emitidas"); 
        //obter a listagem das facturas todas de uma determinada empresa, ordenada por data de emissão ou por valor
        out("\n\t4) Verificar faturas de contribuinte"); 
        /* obter por parte das empresas, as listagens das facturas por contribuinte num determinado intervalo de datas
         obter por parte das empresas, as listagens das facturas por contribuinte ordenadas por valor decrescente de despesa */
        out("\n\t5) Verificar total faturado"); 
        // indicar o total facturado por uma empresa num determinado período
        out("\n\t6) Ver lista das atividades da empresa");
        out("\n\n\t0) Sair");
    }
    
    public void admin(){
        clear();
        out("\n\t Bem vindo ADMIN\n\n\n\nEscolha a sua opção:");
        out("\n\t1) Verificar 10 contribuintes que mais gastam");
        // determinar a relação dos 10 contribuintes que mais gastam em todo o sistema
        out("\n\t2) Verificar as X empresas com maior nº de faturas e as suas deduções fiscais");
        /* determinar a relação das X empresas que mais facturas em todo o sistema e o montante de deduções 
         fiscais que as despesas registadas (dessas empresas) representam*/
        out("\n\t3) Ver NIF's registados");
        out("\n\t4) Ver empresas registadas");
        out("\n\t5) Ver individuais registados");
        out("\n\t7) Limpar dados");
        out("\n\n\t0) Sair");
    }
    
    public void limpaDados(){
        clear();
        out("\n\t\t\t####### LIMPAR DADOS #######\n\n");
        out("\t1) Eliminar todos os dados");
        out("\t2) Eliminar dados das Empresas");
        out("\t3) Eliminar dados Individuais");
        out("\n\t0) Voltar atras");
    }
    
    public void pausar(){
        try {Thread.sleep(2000);} catch (Exception e){}
    }
    
    public void fatHeader() {
        out("--------------------------------------------------------------------------------------------------------");
        out("      |            |           |             |             |            |            |");
        out("  Nº  |  Vendedor  |    NIF    |    Data     | NIF Cliente | Descrição  | Actividade |    Valor  ");
        out("      |            |           |             |             |            |            |");
        out("--------------------------------------------------------------------------------------------------------");
    }
    
    public void impFat(int numFat, int nifE, String nome, LocalDate dataF, int nifC, String desc, double v, String activ) {
        String numFatF = String.format("%04d", numFat);
        String nomeF = nome.substring(0, Math.min(nome.length(), 10));
        String descF = desc.substring(0, Math.min(desc.length(), 10));
        String activF = activ.substring(0, Math.min(activ.length(), 10));
        while(nomeF.length()<10) {
            nomeF += " ";
        }
        while(descF.length()<10) {
            descF += " ";
        }
        while(activF.length()<10) {
            activF += " ";
        }
        out(numFatF + "  | " +nomeF+ " | " +nifE+ " |  " +dataF+" | " +nifC+ "   | " +descF+ " | " +activF+ " | " +v+"€ ");
        out("--------------------------------------------------------------------------------------------------------");
    }
    
    
    public void sair(){
        clear();
        out("\n\n\tObrigado pela oferta ao estado.");
    }
    
}