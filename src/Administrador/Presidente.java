package Administrador;

import java.util.Date;

public class Presidente extends Eleitor{

    public Presidente(String nome, Date nascimento, String titulo, String zona, String secao) {
        super(nome, nascimento, titulo, zona, secao);
    }
    
    public void iniciaEleição(){}

}
