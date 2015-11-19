package UrnaEletronica;

import Administrador.Eleitor;
import java.util.Date;
import java.util.Scanner;

public class PresidendeEleicao extends Eleitor{
    static Scanner in = new Scanner(System.in);
    static String zonaUrna;
    static String secaoUrna;
    
    public PresidendeEleicao(String nome, Date nascimento, String titulo, String zona, String secao) {
        super(nome, nascimento, titulo, zona, secao);
    }
    
    
    public void iniciaEleição(){        //função inutil que esta pedindo no trabalho
        System.out.println("Iniciando processo de eleição...");
        System.out.println("Digite sua zona: ");
        zonaUrna = in.next();
        System.out.println("Digite sua seção: ");
        secaoUrna = in.next();
        System.out.println("Digite o seu titulo: ");
        String titulo = in.next();
        System.out.println("Digite o seu nome: ");
        String name = in.next();
        System.out.println("Digite a hora de abertura (hh:mm) : ");
        String abertura = in.next();
        System.out.println("Digite o numero de eleitores por seção: ");
        int eleitoresPorSecao = in.nextInt();
        Principal.menuEleicoes();
    }
}
