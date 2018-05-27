import java.time.LocalDate;

/** JavaFatura
 * @author Francisco Correia
 * @author João Ferreira
 * @author Luís Félix
 *
 */

public class Menu implements java.io.Serializable{
   
	/**
	 * Limpa o texto do ecrã
	 */
	public void clear() {  
        System.out.print("\u000C");  
        System.out.flush();  
    }
    
    /**
     * "Substitui" o System.out.println()
     * @param o objecto dado para imprimir
     */
    public void out(Object o){
        System.out.println(o.toString());
    }
    
    /**
     * Imprime as opções do menu principal
     */
    public void login(){
        clear();
        out("\n\t ####### Bem vindo #######\n\n\n\nEscolha a sua opção: ");
        out("\n\t1) Fazer login"); 
        out("\n\t2) Registar um novo utilizador"); 
        out("\n\t3) Sair");
    }
    
    /**
     * Imprime as opções do menu user individual
     */
    public void individual(int nif){
        clear();
        out("\n\t ####### Bem vindo #######\n\n\n\n\tEscolha a sua opção:");
        out("\n\t1) Ver os seus dados");
        out("\n\t2) Verificar despesas"); 
        out("\n\t3) Verificar dedução fiscal acumulada");
        out("\n\t4) Validar fatura(s)"); 
        out("\n\n\t0) LogOut");
    }
    
    /**
     * Imprime as oções possíveis ao registar uma atividade
     */
    public void menu_ativs(){
        clear();
        out("####### Selecione a atividade: #######");
        out("\n\t1) Cabeleireiros");
        out("\t2) Despesas Familiares");
        out("\t3) Educação");
        out("\t4) Habitação");
        out("\t5) Lares");
        out("\t6) Passes Mensais");
        out("\t7) Reparação Automóvel");
        out("\t8) Reparação Motorizadas");
        out("\t9) Restauração & Alojamento");
        out("\t10) Saúde");
        out("\t11) Veterinários");
        out("\t12) Outros");
        out("\n\t0) Sair");
    }
    
    /**
     * Imprime as opções do menu user empresa
     */
    public void empresa(int nif){
        clear();
        out("\n\t Bem vindo\n\n\n\nEscolha a sua opção:");
        out("\n\t1) Ver os seus dados");
        out("\n\t2) Criar fatura"); 
        out("\n\t3) Verificar faturas emitidas"); 
        out("\n\t4) Verificar faturas de contribuinte num determinado periodo"); 
        out("\n\t5) Verificar total faturado num determinado periodo"); 
        out("\n\t6) Ver lista das atividades da empresa");
        out("\n\n\t0) LogOut");
    }
    
    /**
     * Imprime as opções do menu user administrador
     */
    public void admin(){
        clear();
        out("\n\t Bem vindo ADMIN\n\n\n\nEscolha a sua opção:");
        out("\n\t1) Verificar 10 contribuintes que mais gastam");
        out("\n\t2) Verificar as X empresas com maior nº de faturas e as suas deduções fiscais");
        out("\n\t3) Ver NIF's registados");
        out("\n\t4) Ver empresas registadas");
        out("\n\t5) Ver individuais registados");
        out("\n\t6) Ver faturas registados");
        out("\n\t7) Limpar dados");
        out("\n\n\t0) LogOut");
    }
    
    /**
     * Imprime as opções do menu user limpa dados
     */
    public void limpaDados(){
        clear();
        out("\n\t\t\t####### LIMPAR DADOS #######\n\n");
        out("\t1) Eliminar todos os dados");
        out("\t2) Eliminar dados das Individuais");
        out("\t3) Eliminar dados Empresas");
        out("\t4) Eliminar dados Faturas");
        out("\n\t0) Voltar atras");
    }
    
    /**
     * Pausa a execuçao do código no tempo dado
     */
    public void pausar(){
        try {Thread.sleep(2000);} catch (Exception e){}
    }
    
    /**
     * Imprime o cabeçalho de uma fatura
     */
    public void fatHeader() {
        out("-----------------------------------------------------------------------------------------------------------------------------");
        out("      |            |           |             |             |            |            |                |");
        out("  Nº  |  Vendedor  |    NIF    |    Data     | NIF Cliente | Descrição  | Actividade |  Taxa deducao  |  Valor  ");
        out("      |            |           |             |             |            |            |                |");
        out("-----------------------------------------------------------------------------------------------------------------------------");
    }
    
    /**
     * Imprime os dados de uma fatura
     */    
    public void impFat(int numFat, int nifE, String nome, LocalDate dataF, int nifC, String desc, double v, String activ, double deducao) {
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
        out(numFatF + "  | " +nomeF+ " | " +nifE+ " |  " +dataF+" | " +nifC+ "   | " +descF+ " | " +activF+ " |     "+(deducao*100)+"%      |   "  +v+"€ ");
        out("-----------------------------------------------------------------------------------------------------------------------------");
    }
    
    /**
     * Imprime o cabeçalho da lista de despesas de um user individual
     */
    public void fatHeader2() {
        out("-------------------------------------------------------------------------------------");
        out("            |           |             |            |            |               ");
        out("  Vendedor  |    NIF    |    Data     | Descrição  | Actividade |   Valor  ");
        out("            |           |             |            |            |               ");
        out("-------------------------------------------------------------------------------------");
    }
    
    /**
     * Imprime os dados da lista de despesas de um user individual
     */
    public void impFat2(String nomeVendedor, int nifVendedor, LocalDate dataF, String desc, double v, String activ) {
        String nomeF = nomeVendedor.substring(0, Math.min(nomeVendedor.length(), 10));
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
        out(nomeF+ "  | " +nifVendedor+ " |  " +dataF+" | " +descF+ " | " +activF+ " |  " +v+"€ ");
        out("-------------------------------------------------------------------------------------");
    }
    
    /**
     * Imprime o cabeçalho da lista de despesas e respetiva dedução
     */
    public void fatHeader3() {
        out("------------------------------------------------------------------------------");
        out("      |            |           |");
        out("  Nº  |  Vendedor  |    NIF    |  Valor deduzivel / Valor Total  ");
        out("      |            |           |");
        out("-------------------------------------------------------------------------------");
    }
    
    /**
     * Imprime mensagem de despedida da aplicação
     */
    public void sair(){
        clear();
        out("\n\n\tObrigado pela sua preferencia.");
    }
    
}
