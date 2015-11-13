package Administrador;

import java.util.Date;

public class Prefeito extends Candidato{

    private VicePrefeito vice;

    public Prefeito(VicePrefeito vice, String codigo, String nome, String email, Date nascimento, Partido partido) {
        super(codigo, nome, email, nascimento, partido);
        this.vice = vice;
    }

    public VicePrefeito getVice() {
        return vice;
    }

    public void setVice(VicePrefeito vice) {
        this.vice = vice;
    }

    @Override
    public String toString() {
        return super.toString()+" vice: " + vice;
    }
    
    @Override
    public void Cadastrar() {
        System.out.println("Digite o nome do candidato: ");
        String nome = in.nextLine();
        
        System.out.println("Digite o codigo do candidato: ");
        String codigo = in.next();
        
        System.out.println("Digite o email do candidato: ");
        String email = in.next();
        
        //Data de nascimento    
        System.out.println("digite a data de nascimento (dd/mm/yyyy): ");
        String dataStr = in.next();
        Date nascimento = Data.getDate(dataStr);
       
        
        //depois de criar o arraylist estatico de partidos criar um iterator para procurar um partido digitado pelo usuario
        System.out.println("Digite o código do partido: ");
       
        Partido teste = new Partido();
        
        System.out.println("Digite o numero do vice-prefeito: ");
        
        
        //so de teste isso
        Prefeito aux = new Prefeito((VicePrefeito) new Candidato(), codigo, nome, email, nascimento, teste);
        super.lista.add(aux);
    }
    
    
    
    
}
