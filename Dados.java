import java.util.*;
import java.util.HashMap;

public class Dados{
    
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
        distritos.put("Evora", 0.12);
        distritos.put("Setubal", 0.17);
        distritos.put("Beja", 0.17);
        distritos.put("Faro", 0.17);
        distritos.put("Madeira", 0.16);
        distritos.put("Açores", 0.136);
        return distritos;
    }
       
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
 
}
