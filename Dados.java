import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.Month;

/** JavaFatura
 * @author Francisco Correia
 * @author João Ferreira
 * @author Luís Félix
 *
 */

public class Dados{
    
	/**
	 * Povoa o mapa distritos com nome de distritos e respetiva taxa de deducao
	 * @return mapa distritos povoado
	 */
    public HashMap<String, Double> povDistritos(){
        HashMap<String,Double> distritos = new HashMap<String,Double>();
        distritos.put("Viana do Castelo", 0.17);
        distritos.put("Braga", 0.17);
        distritos.put("Vila Real",0.125);
        distritos.put("Bragança",0.125);
        distritos.put("Porto", 0.17);
        distritos.put("Aveiro", 0.17);
        distritos.put("Viseu", 0.125);
        distritos.put("Guarda", 0.125);
        distritos.put("Coimbra", 0.17);
        distritos.put("Castelo Branco", 0.125);
        distritos.put("Leiria", 0.17);
        distritos.put("Santarem", 0.125);
        distritos.put("Portalegre", 0.125);
        distritos.put("Lisboa", 0.17);
        distritos.put("Evora", 0.125);
        distritos.put("Setubal", 0.17);
        distritos.put("Beja", 0.17);
        distritos.put("Faro", 0.17);
        distritos.put("Madeira", 0.16);
        distritos.put("Açores", 0.136);
        return distritos;
    }
    
    /**
     * Povoa o mapa atividades com nome de atividades e respetiva taxa de deducao
     * @return mapa atividades povoado
     */
    public HashMap<String, Double> povAtividades(){
        HashMap<String,Double> atividades = new HashMap<String,Double>();
        atividades.put("Cabeleireiros", 0.25);
        atividades.put("Despesas Familiares", 0.1);
        atividades.put("Educação", 0.13);
        atividades.put("Habitação", 0.25);
        atividades.put("Lares", 0.2);
        atividades.put("Passes Mensais", 0.16);
        atividades.put("Reparações Automóvel", 0.2);
        atividades.put("Reparações Motorizadas", 0.2);
        atividades.put("Restauração e Alojamento", 0.25);
        atividades.put("Saúde", 0.1);
        atividades.put("Veterinários", 0.15);
        atividades.put("Outros", 0.18);
        
        return atividades;
    }
    
    /**
     * Povoa o mapa empresas com alguns exemplos de empresas
     * @param empP mapa de empresas a povoar
     */
    public void povEmpresa(HashMap<Integer,Empresa> empP){
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("Saúde");
        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("Cabeleireiros");
        ArrayList<String> a3 = new ArrayList<String>();
        a3.add("Despesas Familiares");
        a3.add("Outros");
        ArrayList<String> a4 = new ArrayList<String>();
        a4.add("Despesas Familiares");
        a4.add("Restauração e Alojamento");
        a4.add("Saúde");   
        ArrayList<String> a5 = new ArrayList<String>();
        a5.add("Passes Mensais");
        ArrayList<String> a6 = new ArrayList<String>();
        a6.add("Restauração e Alojamento");
        ArrayList<String> a7 = new ArrayList<String>();
        a7.add("Educação");
        a7.add("Saúde");
        ArrayList<String> a8 = new ArrayList<String>();
        a8.add("Reparações Automóvel");
        a8.add("Reparações Motorizadas");
        ArrayList<String> a9 = new ArrayList<String>();
        a9.add("Outros");
        ArrayList<String> a10 = new ArrayList<String>();
        a10.add("Habitação");
        ArrayList<String> a11 = new ArrayList<String>();
        a11.add("Veterinários");
        
        Empresa e1 = new Empresa (510685390,"prelada","Farmacia da Prelada, Lda","prelada@javafatura.pt", "Porto", a1, 0.27);
        Empresa e2 = new Empresa (555555552, "lucia", "Cabeleiros Lucia", "lucia@javafatura.pt", "Aveiro", a2, 0.42);
        Empresa e3 = new Empresa (555555553, "amazon", "Amazon", "amazon@javafatura.pt", "Lisboa", a3, 0.17);
        Empresa e4 = new Empresa (555555554, "pingodoce", "Pingo Doce", "pingodoce@javafatura.pt", "Guarda", a4, 0.125);
        Empresa e5 = new Empresa (555555555, "cp", "Comboios de Portugal", "cp@javafatura.pt", "Porto", a5, 0.35);
        Empresa e6 = new Empresa (555555556, "gale", "Vila Gale", "gale@javafatura.pt", "Faro", a6, 0.42);
        Empresa e7 = new Empresa (555555557, "uminho", "Universidade do Minho", "uminho@javafatura.pt", "Braga", a7, 0.17); 
        Empresa e8 = new Empresa (555555558, "auto", "AutoRepair", "auto@javafatura.pt", "Beja", a8, 0.17);
        Empresa e9 = new Empresa (555555559, "media","Media Markt", "media@javafatura.pt", "Açores", a9, 0.136);
        Empresa e10 = new Empresa (555555550,"remax", "Remax", "remax@javafatura.pt", "Madeira", a10, 0.41);
        Empresa e11 = new Empresa (555555551, "care", "Animal Care", "care@javafatura.pt", "Evora", a11, 0.275);
        
        empP.put(510685390, e1);
        empP.put(555555552, e2);
        empP.put(555555553, e3);
        empP.put(555555554, e4);
        empP.put(555555555, e5);
        empP.put(555555556, e6);
        empP.put(555555557, e7);
        empP.put(555555558, e8);
        empP.put(555555559, e9);
        empP.put(555555550, e10);
        empP.put(555555551, e11);
    }
    
    /**
     * Povoa o mapa individuais com alguns exemplos de individuais
     * @param indP mapa de individuais a povoar
     */
    public void povIndividuais(HashMap<Integer,Individual> indP){

        ArrayList<Integer> na1 = new ArrayList<Integer>();
        ArrayList<Integer> na2 = new ArrayList<Integer>();
        na2.add(222222224);
        na2.add(222222225);
        na2.add(222222226);
        ArrayList<Integer> na3 = new ArrayList<Integer>();
        na3.add(222222227);
        na3.add(222222228);
        ArrayList<Integer> na4 = new ArrayList<Integer>();
        na4.add(222222229);
        na4.add(100000000);
        ArrayList<Integer> na5 = new ArrayList<Integer>();
        na5.add(100000001);
        na5.add(100000002);
        na5.add(100000003);
        ArrayList<Integer> na6 = new ArrayList<Integer>();
        na6.add(100000004);
        ArrayList<Integer> na7 = new ArrayList<Integer>();
        na7.add(100000005);
        na7.add(100000006);
        ArrayList<Integer> na8 = new ArrayList<Integer>();
        na8.add(100000007);
        ArrayList<Integer> na9 = new ArrayList<Integer>();
        ArrayList<Integer> na10 = new ArrayList<Integer>();
        na10.add(100000008);
        na10.add(100000009);
        na10.add(100000010);
        ArrayList<Integer> na11 = new ArrayList<Integer>();
        na11.add(100000011);
        na11.add(100000012);
        na11.add(100000013);
        ArrayList<Integer> na12 = new ArrayList<Integer>();
        na12.add(100000014);
        ArrayList<Integer> na13 = new ArrayList<Integer>();
        ArrayList<Integer> na14 = new ArrayList<Integer>();
        ArrayList<Integer> na15 = new ArrayList<Integer>();
        na15.add(111111111);
        na2.add(222222225);
        na2.add(222222226);
        
        Individual i1 = new Individual(111111110,"luispass","luis","luis@javafatura.pt","Morada do Luis",0,na1,1);
        Individual i2 = new Individual(111111111,"joaopass","joao","joao@javafatura.pt","Morada do Joao",3,na2,2.6);
        Individual i3 = new Individual(111111112,"franciscopass","francisco","francisco@javafatura.pt","Morada do Francisco",2,na3,1.3);
        Individual i4 = new Individual(111111113,"tierripass","Tierri","tierri@javafatura.pt","Morada do Tierri",2,na4,1.3);
        Individual i5 = new Individual(111111114,"joanapass","joana","joana@javafatura.pt","Morada da Joana",3,na5,1.6);
        Individual i6 = new Individual(111111115,"josepass","jose","jose@javafatura.pt","Morada do Jose",1,na6,1.3);
        Individual i7 = new Individual(111111116,"claudiapass","claudia","claudia@javafatura.pt","Morada da Claudia",2,na7,1.6);
        Individual i8 = new Individual(111111117,"brunopass","bruno","bruno@javafatura.pt","Morada do Bruno",1,na8,1.3);
        Individual i9 = new Individual(111111118,"pedropass","pedro","pedro@javafatura.pt","Morada do Pedro",0,na9,1);
        Individual i10 = new Individual(111111119,"ritapass","rita","rita@javafatura.pt","Morada da Rita",3,na10,1.9);
        Individual i11 = new Individual(222222220,"antoniopass","antonio","antonio@javafatura.pt","Morada do Antonio",2,na11,1.6);
        Individual i12 = new Individual(222222221,"anapass","ana","ana@javafatura.pt","Morada da Ana",1,na12,1.3);
        Individual i13 = new Individual(222222222,"andrepass","andre","andre@javafatura.pt","Morada do Andre",0,na13,1);
        Individual i14 = new Individual(222222223,"nunopass","nuno","nuno@javafatura.pt","Morada do Nuno",0,na14,1);
        Individual i15 = new Individual(222222224,"zepass","ze","ze@javafatura.pt","Morada do Ze",3,na15,2.6);
        
        indP.put(111111110,i1);
        indP.put(111111111,i2);
        indP.put(111111112,i3);
        indP.put(111111113,i4);
        indP.put(111111114,i5);
        indP.put(111111115,i6);
        indP.put(111111116,i7);
        indP.put(111111117,i8);
        indP.put(111111118,i9);
        indP.put(111111119,i10);
        indP.put(222222220,i11);
        indP.put(222222221,i12);
        indP.put(222222222,i13);
        indP.put(222222223,i14);
        indP.put(222222224,i15);
    }
    
    /**
     * Povoa o mapa users com alguns exemplos de utilizadores
     * @param indP mapa de users a povoar
     */
    public void povUsers(HashMap<Integer,String> usersP){
        usersP.put(1234,"admin");
        usersP.put(510685390, "prelada");
        usersP.put(555555552, "lucia");
        usersP.put(555555553, "amazon");
        usersP.put(555555554, "pingodoce");
        usersP.put(555555555, "cp");
        usersP.put(555555556, "gale");
        usersP.put(555555557, "uminho");
        usersP.put(555555558, "auto");
        usersP.put(555555559, "media");
        usersP.put(555555550, "remax");
        usersP.put(555555551, "care");
        usersP.put(111111110,"luispass");
        usersP.put(111111111,"joaopass");
        usersP.put(111111112,"franciscopass");
        usersP.put(111111113,"tierripass");
        usersP.put(111111114,"joanapass");
        usersP.put(111111115,"josepass");
        usersP.put(111111116,"claudiapass");
        usersP.put(111111117,"brunopass");
        usersP.put(111111118,"pedropass");
        usersP.put(111111119,"ritapass");
        usersP.put(222222220,"antoniopass");
        usersP.put(222222221,"anapass");
        usersP.put(222222222,"andrepass");
        usersP.put(222222223,"nunopass");
    }
    
    /**
     * Povoa o mapa faturas com alguns exemplos de faturas
     * @param fat mapa de faturas a povoar
     */
    public void povFat(HashMap<Integer,ArrayList<Fatura>> fat) {
    	Fatura f1 = new Fatura(510685390,"Farmácia da Prelada, Lda",LocalDate.of(2018,Month.JANUARY,10),111111119,"Floxapen 15mg","Saúde",12.37,0.27);
    	Fatura f2 = new Fatura(555555552,"Cabeleireiros Lucia",LocalDate.of(2018,Month.JANUARY,11),111111113,"Pacote 23","Cabeleireiros",15.50,0.42);
    	Fatura f3 = new Fatura(555555551,"Animal Care",LocalDate.of(2018,Month.FEBRUARY, 15),111111114,"Vacina Raiva","Veterinários",45.0,0.27);
    	Fatura f4 = new Fatura(555555554,"Pingo Doce",LocalDate.of(2018,Month.FEBRUARY, 23),111111114,"Papel Higiénico","Pendente",3.99,0.125);
    	Fatura f5 = new Fatura(555555550,"Remax",LocalDate.of(2018, Month.MARCH, 15),111111119,"Casa Rio Tinto","Habitação",20000.0,0.41);
    	Fatura f6 = new Fatura(555555555,"Comboios de Portugal",LocalDate.of(2018, Month.MARCH, 23),222222220,"Passe Mensal A2","Passes Mensais",25.0,0.33);
    	Fatura f7 = new Fatura(555555556,"Vila Gale",LocalDate.of(2018, Month.APRIL, 16),111111116,"Estadia 2 Noites","Restauração e Alojamento",100.0,0.42);
    	Fatura f8 = new Fatura(555555557,"Universidade do Minho",LocalDate.of(2018, Month.MAY, 5),111111117,"Propinas Abril 2018","Validada",0.0,0.17);
    	Fatura f9 = new Fatura(555555557,"Universidade do Minho",LocalDate.of(2018, Month.MAY, 5),111111117,"Propinas Abril 2018","Educação",171.30,0.30);
    	        
    	ArrayList<Fatura> arr1 = new ArrayList<>();
    	arr1.add(f1);
    	ArrayList<Fatura> arr2 = new ArrayList<>();
    	arr2.add(f2);
    	ArrayList<Fatura> arr3 = new ArrayList<>();
    	arr3.add(f3);
    	ArrayList<Fatura> arr4 = new ArrayList<>();
    	arr4.add(f4);
    	ArrayList<Fatura> arr5 = new ArrayList<>();
    	arr5.add(f5);
    	ArrayList<Fatura> arr6 = new ArrayList<>();
    	arr6.add(f6);
    	ArrayList<Fatura> arr7 = new ArrayList<>();
    	arr7.add(f7);
    	ArrayList<Fatura> arr8 = new ArrayList<>();
    	arr8.add(f8);
    	arr8.add(f9);
    	
    	
    	fat.put(510685390, arr1);
    	fat.put(555555552, arr2);
    	fat.put(555555551, arr3);
    	fat.put(555555554, arr4);
    	fat.put(555555550, arr5);
    	fat.put(555555555, arr6);
    	fat.put(555555556, arr7);
    	fat.put(555555557, arr8);
    }
    
}
