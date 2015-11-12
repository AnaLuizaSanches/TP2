package Administrador;

import java.util.ArrayList;

public class Main {                //Para testes

    public static void main(String[] args) {
        Candidato cadastrador = new Candidato();
        cadastrador.Cadastrar();
        System.out.println(Candidato.lista.get(0).getNome());
    }
    
}
