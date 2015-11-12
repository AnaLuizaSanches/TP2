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
    
}
