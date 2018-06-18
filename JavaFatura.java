import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map.Entry;

/** JavaFatura
 * @author Francisco Correia
 * @author João Ferreira
 * @author Luís Félix
 *
 */

public class JavaFatura implements java.io.Serializable{
    Empresa emp = new Empresa();
    Individual ind = new Individual();
    Fatura fat = new Fatura();
    Menu menu = new Menu();
    Dados dados = new Dados();   
    Scanner in = new Scanner(System.in);
    
    /**
     * Lista de faturas de uma dada empresa
     */
    ArrayList<Fatura> listaFaturas = new ArrayList<Fatura>();
    
    /**
     * Mapa que contem users do programa para fins de login (guarda NIF e Password)
     */
    HashMap<Integer,String> users =  new HashMap<Integer,String>();
    
    /**
     * Mapa que contem NIF e dados da empresa (guarda o NIF como key para acesso mais facil)
     */
    HashMap<Integer,Empresa> dadosEmp = new HashMap<Integer,Empresa>();
    
    /**
     * Mapa que contem NIF e dados de um individuo (guarda o NIF como key para acesso mais facil)
     */
    HashMap<Integer,Individual> dadosInd = new HashMap<Integer, Individual>();
    
    /**
     * Mapa que contem NIF de uma empresa e um arrayList de faturas emitidas pela mesma
     */
    HashMap<Integer,ArrayList<Fatura>> dadosFat = new HashMap<Integer,ArrayList<Fatura>>();
    
    /**
     * Mapa que contem distrito e taxa de deduçao para o mesmo
     */
    final HashMap<String,Double> dadosDistr = dados.povDistritos();
    
    /**
     * Mapa que contem atividade e taxa de deduçao para a mesma
     */
    final HashMap<String,Double> dadosActiv = dados.povAtividades();
    
    /**
     * "Substitui" o System.out.println()
     * @param o objecto dado para imprimir
     */
    public void out(Object o){
        System.out.println(o.toString());
    }
    
    /**
     * Verifica se um NIF é considerado válido segundo os critérios do Portal das Finanças
     * @param x NIF dado
     * @return true se o NIF é válido e false caso contrário
     */
    public boolean nifValido(int x){
        int z = x/100000000;
        if(x == 1234 || (z > 0.9 && z < 10 && (z < 3|| z >= 5 || z < 7 || z >= 8))) return true;
        else return false;
    }
    
    /**
     * Aguarda input do utilizador
     */
    public void inputWait() {
        out("\n\n\t\tPrima 'Enter' para continuar");
        try{
            System.in.read();
        }
        catch(Exception e){
        }
    }
    
    /**
     * Elimina os dados guardados
     */
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
                    out("\nDe certeza que pretende eliminar os Individuais registados(s/n)");
                    if(in.next().equals("s")){
                        resetIndiv();
                        menu.clear();
                        out("\n\n\n\t\t\t********** Dados eliminados! **********");
                        menu.pausar();
                    }
                    return;
                    
                case 3:
                    out("\nDe certeza que pretende eliminar as Empresas egistadas (s/n)");
                    if(in.next().equals("s")){
                        resetEmp();
                        menu.clear();
                        out("\n\n\n\t\t\t********** Dados eliminados! **********");
                        menu.pausar();
                    }
                    return;
                    
                case 4:
                    out("\nDe certeza que pretende eliminar as faturas registadas (s/n)");
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
    
    public void inicio(){
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
                                    return;
                                }
                                else if(a < 300000000){
                                    individual(a);
                                    return;
                                }
                                else if(a > 300000000){
                                    empresa(a);
                                    return;
                                }
                            }
                            else {
                                out("\nPassword incorrecta!");
                                break;
                            }
                        }
                        else {
                            out("\nNIF não registado!");
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
                                nome = in.nextLine();
                                out("\nIntroduza o seu e-mail");
                                String mail = in.nextLine();
                                out("\nIntroduza a sua morada");
                                String morada = in.nextLine();
                                out("\nIntroduza o numero de dependentes do agregado familiar");
                                int depAgreg = in.nextInt();
                                out("Introduza os NIFs do agregado familiar");

                                ArrayList<Integer> nifAgregado = new ArrayList<Integer>();
                                double coef = 1;
                                int nrAgreg = depAgreg;
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

                                Individual indiv = new Individual(a,pw,nome,mail,morada,nrAgreg,nifAgregado,coef);

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
                                
                                if(ativs.size()==1){
                                    deducao = dadosActiv.get(ativs.get(0));
                                }
                                
                                fator += deducao;   
                                emp = new Empresa(a,pw, nome, mail, distrito, ativs ,fator);

                                dadosEmp.put(a,emp);
                                saveEmpresa(dadosEmp);
                            }
                            menu.clear();
                            out("\n\n\t\t***Registo efetuado***\n\n");
                            saveUsers(users);
                            break;
                        }
                        else{
                            out("\n\tNIF já registado!");    
                            break;
                        }
                    }
                    else {
                        out("\nNIF inválido!");
                        break;
                    }
                case 3:
                    menu.sair();
                    return;
                    
                default:
                    out("\nOpção inválida!");
                    break;
                }
            out("\nPrima qualquer nº para continuar, 0 para sair:");
            if(in.nextInt() == 0) return;
        }
    }
    
    
    /**
     * Interpreta o menu do administrador
     */
    public void admin(){
       while(true){ 
            menu.admin();
            switch(in.nextInt()){
               case 1:
                    menu.clear();
                    out("\n\tOs 10 Contribuintes com mais despesas:");
                    maisDespesas();
                    inputWait();
                    break;
               
               case 2:
                    menu.clear();
                    if(dadosFat.size() > 0){
                        out("\n\tQuantas empresas deseja verificar?");
                        int num = in.nextInt();
                    
                        HashMap<Integer,ArrayList<Fatura>> clonefats = new HashMap<Integer,ArrayList<Fatura>>();
                        clonefats = (HashMap)dadosFat.clone();
                        ArrayList<Integer> nifMaisFats = new ArrayList<Integer>();
                        int c = 0;
                        while(c < num && clonefats!=null){
                            int maior = maior(clonefats);
                            nifMaisFats.add(maior);
                            clonefats.remove(maior);
                            c++;
                        }
                        ArrayList<Fatura> receipt = new ArrayList<Fatura>();
                        int i=1;
                        double total = 0;
                        double deduzivel = 0;
                        menu.clear();
                        menu.fatHeader3();
                        for(Integer n: nifMaisFats){
                            if(dadosFat.containsKey(n)){
                                receipt = dadosFat.get(n);
                                total = valorTotalNif(receipt);
                                deduzivel = valorTotalDed(receipt);
                                dadosEmp.get(n).imprimeTotal(i,total, deduzivel);
                                i++;
                            }
                            else break;
                        }
                    }
                    else{
                        out("\n\n\t\t Nao existem faturas registadas");
                    }
                    inputWait();
                    break;
                    
               case 3:
                    menu.clear();
                    out("\n\tUtilizadores registados:\n");
                    mapPrint(users);
                    inputWait();
                    break;
                    
               case 4:
                    menu.clear();
                    out("\n\tEmpresas Registadas:\n");
                    out(dadosEmp.toString());
                    inputWait();
                    break;
                    
               case 5:
                    menu.clear();
                    out("\n\tIndividuais Registados:\n");
                    out(dadosInd.toString());
                    inputWait();
                    break;
               
               case 6:
                    menu.clear();
                    out("\n\tFaturas Registadas:\n");
                    out(dadosFat.toString());
                    inputWait();
                    break;
               
               case 7:
                    limparDados();
                    break;
               
               case 8:
                    menu.clear();
                    dados.povUsers(users);
                    dados.povEmpresa(dadosEmp);
                    dados.povIndividuais(dadosInd);
                    dados.povFat(dadosFat);
                    saveUsers(users);
                    saveIndividual(dadosInd);
                    saveEmpresa(dadosEmp);
                    saveFaturas(dadosFat);
                    out("\n\n\n\t\t\t********** Dados carregados! **********");
                    menu.pausar();
                    break;
               
               case 0:
                    inicio();
                    return;
                    
               default:
                    out("\nOPCAO INVALIDA!");
                    break;
            }
        }
    }
    
    /**
     * Interpreta o menu de um utilizador individual
     * @param x NIF dado
     */
    public void individual(int x){
        while(true){
            menu.individual(x);
            switch(in.nextInt()){
                case 1:
                    menu.clear();
                    out("\n\t" +dadosInd.get(x).toString());
                    inputWait();
                    break;
                
                case 2:
                    menu.clear();
                    out("\nLista de despesas:");
                    ArrayList<Fatura> fatCliente = new ArrayList<Fatura>();
                    fatCliente = listagemDespesas(x);
                    menu.fatHeader2();
                    for(Fatura f : fatCliente)
                        menu.impFat2(f.getDEmitente(),f.getNIFEmitente(),f.getData(), f.getDescricao(), f.getValor(), f.getAtividade());    
                    
                    inputWait();
                    break;
                
                case 3:
                    menu.clear();
                    out("\n\t\tDeducao fiscal acumulada:");
                    
                    fatCliente = listagemDespesas(x);
                    double total = 0;
                    double deduzivel = 0;
                    for(Fatura f: fatCliente){
                        total += f.getValor();
                        deduzivel += f.getValor()*f.getDeducao();
                    }
                    
                    double coeficiente = dadosInd.get(x).getCoef();
                    double deduzivelMax = 500*coeficiente;
                    
                    if(deduzivel>deduzivelMax){
                        deduzivel = deduzivelMax;
                    }
                    
                    out("\n\t O seu coeficiente fiscal: "+coeficiente);
                    out("\n\t Valor maximo deduzivel para o individual: " +deduzivelMax+"€");
                    out("\n\t Valor total faturado: " +total+ "€");
                    out("\n\t Valor total deduzivel: " +deduzivel+ "€");
                    inputWait();
                    break;
                
                case 4:
                    ArrayList<Fatura> novasFats = new ArrayList<Fatura>();
                    boolean existe = false;
                    for(Map.Entry<Integer,ArrayList<Fatura>> entry : dadosFat.entrySet()){
                        if(temPendente(x,entry.getValue())){
                            novasFats = editar2(x,dadosEmp.get(entry.getKey()), entry.getValue());
                            existe = true;
                            dadosFat.put(entry.getKey(),novasFats);
                        }
                    }
                    
                    if(!existe){
                        menu.clear();
                        out("\n\n\t Nao tem faturas que precisem de validacao");
                    }
                    
                    inputWait();
                    saveFaturas(dadosFat);
                    break;
                    
                case 0:
                    inicio();
                    return;
                    
                default:
                    out("\nOPCAO INVALIDA!");
                    break;
            }
        }
    }
    
    /**
     * Interpreta o menu de um utilizador Empresa
     * @param x NIF dado
     */
    public void empresa(int x) {
        while(true){         
            menu.empresa(x);
            //System.out.println(x);
            //System.out.println(dadosEmp.get(x).toString());
            switch(in.nextInt()){
                case 1:
                    menu.clear();
                    out("\n" +dadosEmp.get(x).toString());
                    inputWait();
                    break;
                    
                case 2:
                    menu.clear();
                    out("\n\t\tCriar fatura de venda");
                    fat = dadosEmp.get(x).criarFatura();
  
                    if(dadosFat.containsKey(x))
                        listaFaturas = dadosFat.get(x);
                    listaFaturas.add(fat);
                    dadosFat.put(x,listaFaturas);
                    saveFaturas(dadosFat);
                    inputWait();
                    break;
    
                case 3:
                    menu.clear();
                    out("\n\tLista de faturas:");
                    if(dadosFat.get(x) == null)
                        out("\n\t ***** Nao existem faturas registadas nesta Empresa *****");
                    else{
                        dadosEmp.get(x).imprimeFaturas(x,dadosFat.get(x));
                    }
                    inputWait();
                    break;
                    
                case 4:
                    menu.clear();
                    
                    if(listaFaturas == null || dadosFat.get(x) == null){
                        out("\n\t ***** Nao existem faturas registadas nesta Empresa *****");
                        inputWait();
                    }
                    else{
                    out("\nIntroduzir número de contribuinte:");
                    int y = in.nextInt();
                    while(nifValido(y)==false) {
                        out("NIF inválido, tente novamente");
                        y = in.nextInt();
                    }
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
                    double tot = 0;
                    for(int i=0;i<listaFaturas.size();i++) {
                        fat = listaFaturas.get(i);
                        if(fat.getNIFEmitente()==x && fat.getNIFCliente()==y && fat.getData().isBefore(date2) && fat.getData().isAfter(date1)) {
                            tot += fat.getValor();
                        }
                    }
                    out("O NIF "+y+ " gastou "+tot+"€ entre "+inicio+ " e " + fim);
                    inputWait();
                    }
                    
                    break;
                    
                case 5:
                    menu.clear();
                    listaFaturas = dadosFat.get(x);
                    if(listaFaturas != null)
                    totalFaturado(x,listaFaturas);
                    else{
                        out("\n\t ***** Nao existem faturas registadas nesta Empresa *****");
                        inputWait();
                    }
                    break;
                
                case 6:
                    menu.clear();
                    out("\n\t\tLista das atividades da empresa:\n");
                    dadosEmp.get(x).imprimeActivs();
                    inputWait();
                    break;
                /*
                case 3:
                    menu.clear();
                    out("\n\t\tEditar atividade na fatura");
                    listaFaturas = dadosFat.get(x);
                    if(listaFaturas == null){
                        out("\n\t ***** Nao existem faturas registadas nesta Empresa *****");
                        inputWait();
                    }
                    else{
                    ArrayList<Fatura> novaListaFats = new ArrayList<Fatura>();
                    novaListaFats = editar(listaFaturas);
                    dadosFat.replace(x,novaListaFats);
                    saveFaturas(dadosFat);
                    }
                    break;
                */
                    
                case 0:
                    inicio();
                    return;
                    
                default:
                    out("\nOPCAO INVALIDA");
                    break;
            }
        }
    }
    
    /**
     * Imprime ate 10 individuais de acordo com o valor gasto na totalidade
     */
    public void maisDespesas() {
        out("\n10 contribuintes com mais despesas:");
        ArrayList<Fatura> allR = new ArrayList<Fatura>();
        ArrayList<Integer> listaNIFS = new ArrayList<Integer>();
        ArrayList<Double> listaGASTO = new ArrayList<Double>();
        HashMap<Integer,Double> userGasto = new HashMap<Integer,Double>();
        // pega no mapa das faturas todas e adiciona no arraylist
        for(Entry<Integer, ArrayList<Fatura>> u : dadosFat.entrySet()){
            allR.addAll(u.getValue());
        }
        // percorre o arraylist das faturas e cria um array com nifs e um com gastos, na mesma ordem
        for(int i=0;i<allR.size();i++) {
            listaNIFS.add(allR.get(i).getNIFCliente());
            listaGASTO.add(allR.get(i).getValor());
            
        }
        // povoamento do mapa com nifs e valores a 0
        for(int i=0;i<listaNIFS.size();i++) {
            int nif = listaNIFS.get(i);
            userGasto.put(nif,0.0);
        }
        // povoamento do mapa com nifs e respetivo total gasto
        for(int i=0;i<listaNIFS.size();i++) {
            int nif = listaNIFS.get(i);
            double tempVal = listaGASTO.get(i);
            double valFinal = tempVal + userGasto.get(nif);
            userGasto.put(nif,valFinal);
        }
        // percorre o mapa userGasto e imprime consecutivamente users com maior despesa total 
        int count = 0;
        while(!userGasto.isEmpty() && count<= 9 && userGasto.size()>0) {
            Map.Entry<Integer, Double> maxEntry = null;
            int index = 0;
            for(Map.Entry<Integer,Double> entry : userGasto.entrySet()) {
                if(maxEntry==null || entry.getValue().compareTo(maxEntry.getValue())>0) {
                    maxEntry = entry;
                    index = entry.getKey();
                }
            }
            out("NIF: " + index + " gastou "+maxEntry.getValue()+"€");
            count++;
            userGasto.remove(index);
        }
        out("\n\n");
    }
    
    
    /**
     * Edita a atividade de uma fatura, guardando o registo anterior 
     * (poe valor a 0 por motivos de calculo) e acrescenta a fatura editada
     * @param fats array das faturas
     * @return array das faturas com a nova fatura acrescentada
     */
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
            f.setDeducao(dadosActiv.get(novaActiv));
            fats.add(f);
            menu.clear();
            out("***** Atividade modificada com sucesso *****");
            menu.pausar();
        
            return fats;
        
        }
    }
    
    public boolean temPendente(int x, ArrayList<Fatura> fats){
        for(Fatura f: fats)
            if(f.getAtividade().equals("Pendente") && f.getNIFCliente()==x)
                return true;
        return false;
    }
    
    public ArrayList<Fatura> editar2(int x, Empresa e, ArrayList<Fatura> fats){
        
        Fatura f = new Fatura();
        ArrayList<Fatura> novasFats = new ArrayList<Fatura>(fats.size());
        for(Fatura fat: fats){
            novasFats.add(fat);
        }
        
        for(Fatura fat: fats){
            if(fat.getAtividade().equals("Pendente") && fat.getNIFCliente()==x){
                f = fat.clone();
                editActiv(e.getActiv(), f);
                novasFats.add(f);
            }
        }
        
        for(Fatura fat: fats){
            if(fat.getAtividade().equals("Pendente") && fat.getNIFCliente()==x){
                fat.setValor(0.0);
                fat.setAtividade("Validada");
            }
        }
        
        
        out("***** Atividade modificada com sucesso *****");
        menu.pausar();
        
        return novasFats;
    }
    
    public void editActiv(ArrayList<String> ativs, Fatura f){
        menu.clear();
        out("\tNIF Empresa: " +f.getNIFEmitente());
        out("\tDesignacao Empresa: " +f.getDEmitente());
        out("\tData: " +f.getData());
        out("\tNIF Cliente: " +f.getNIFCliente());
        out("\tDescricao: " +f.getDescricao());
        out("\n\tQue atividade pretende atribuir?");
        int i=1;
        for(String s: ativs){
            out("\t"+i+": " +s);
            i++;
        }
        int index = in.nextInt();
        String novAtividade = ativs.get(index-1);
        double ffiscal = f.getDeducao() + dadosActiv.get(novAtividade);
        f.setAtividade(novAtividade);
        f.setDeducao(ffiscal);
    }
    
    
    /**
     * Indica qual o NIF da Empresa com mais faturas
     * @param cloneFats clone do map de todas as faturas registadas
     * @return nif com mais faturas
     */
    public int maior(HashMap<Integer,ArrayList<Fatura>> cloneFats){
        int max = 0;
        for(Map.Entry<Integer,ArrayList<Fatura>> u : cloneFats.entrySet())
            if(u.getValue().size() > max)
                max = u.getKey();
        
        return max;
    }
    
    /**
     * Calcula o valor total de todas as faturas
     * @param arrayFat array de faturas
     * @return soma do valor de todas as faturas
     */
    public double valorTotalNif(ArrayList<Fatura> arrayFat){
        double valor = 0;
        for(Fatura f: arrayFat){
            valor += f.getValor();
        }
        return valor;
    }
    
    public double valorTotalDed(ArrayList<Fatura> arrayFat){
        double ded = 0;
        for(Fatura f: arrayFat)
            ded += f.getValor()*f.getDeducao();
        return ded;
    }
    
    /**
     * Verifica o total faturado por uma empresa x dentro de um intervalo de tempo definido manualmente pelo utilizador
     * @param x NIF da empresa
     * @param z Lista das faturas da empresa
     */
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
        inputWait();
    }
    
    /**
     * Verifica, por parte do contribuinte individual, as despesas que foram emitidas em seu nome 
     * @param x NIF de um Individual
     * @return Lista de faturas em que o NIF do Individual foi definido como cliente
     */
    public ArrayList<Fatura> listagemDespesas(int x) {
        ArrayList<Fatura> fatCliente = new ArrayList<Fatura>();
        for(Map.Entry<Integer,ArrayList<Fatura>> u : dadosFat.entrySet()){
            listaFaturas = u.getValue();
            for(int i=0; i<listaFaturas.size();i++) {
                if(listaFaturas.get(i).getNIFCliente()==x) {
                    fatCliente.add(listaFaturas.get(i));
                }
            }
        }
        return fatCliente;
    }
    
    /**
     * Interpreta o menu das atividades e adiciona a um ArrayList as atividades o utilizador considera relevantes a empresa
     * @param ativs ArrayList que contem Strings de atividades
     */
    public void atividades(ArrayList<String> ativs){
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
    public JavaFatura(){
        loadUsers();
        loadIndividual();
        loadEmpresa();
        loadFaturas();
        users.put(1234,"admin");
        
        if(users.size()>1 && dadosEmp.isEmpty() && dadosInd.isEmpty() && dadosFat.isEmpty()){
            dados.povUsers(users);
            dados.povEmpresa(dadosEmp);
            dados.povIndividuais(dadosInd);
            dados.povFat(dadosFat);
            saveUsers(users);
            saveIndividual(dadosInd);
            saveEmpresa(dadosEmp);
            saveFaturas(dadosFat);
           
        }
        inicio();
    }
    
    /**
     * Gravar os utilizadores criados em ficheiro binario,
     * para que seja possível retomar mais tarde a execução
     * @param utilizadores - map onde estao registados todos os utilizadores
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
            //out("Ficheiro Users guardado com sucesso");
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
     * Apagar dados para utilizadores
     */
    public void resetUsers(){
        File userList = new File("userList");
        userList.delete();
    }
    
     /**
     * Gravar os dados dos NIF's Individuais criados em ficheiro,
     * para que seja possível retomar mais tarde a execução
     * @param indiv - map onde estao registados todos os individuais
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
            //out("Ficheiro Individual guardado com sucesso");
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
        catch(Exception e){out("Erro ao abrir ficheiro Individual");
        }
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
            //out("Empresa guardada com sucesso");
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
            //out("Ficheiro Faturas guardado com sucesso");
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
    
    
    /**
     * Imprime dados de login de todos os utilizadores registados (NIF e Password) 
     * @param map mapa de utilizadores
     */
    public void mapPrint(HashMap<Integer,String> map){
        for(Map.Entry<Integer,String> u : map.entrySet()){
            out(" Username: {"+u.getKey()+"} Password: {"+u.getValue()+"}\n");
        }
    }

    
    public static void main(String[] args) throws IOException{
        new JavaFatura();
    }
}
