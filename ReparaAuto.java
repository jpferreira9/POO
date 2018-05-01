import java.time.LocalDate;
import java.util.ArrayList;

public class ReparaAuto extends Fatura{
    
    public ReparaAuto(){
        super();
    }
    
    public ReparaAuto(int nif,String email,String nome,String morada,String password,ArrayList<String> actividade,int ffiscalorFiscal,LocalDate data,int nifCliente,String descriçao,double valor){
        super(nif,email, nome, morada, password,actividade,ffiscalorFiscal,data,nifCliente,descriçao,valor);
    }
    
    public ReparaAuto(ReparaAuto ra){
        super
    }
}
