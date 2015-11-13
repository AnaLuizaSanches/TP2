package Administrador;

import java.util.ArrayList;
import java.util.Scanner;

public class Partido {
    static Scanner in = new Scanner(System.in);
    static ArrayList<Partido> lista = new ArrayList();
    private String nome;
    private String sigla;
    private String numero;

    public Partido() {      //para o cadastrador
    }

    public Partido(String nome, String sigla, String numero) {
        this.nome = nome;
        this.sigla = sigla;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return " numero: " + numero + " sigla: " + sigla + "nome: " + nome;
    }
    
    public static void Cadastrar(){
        System.out.println("Digite o nome do partido: ");
        String nome = in.next();
        
        System.out.println("Digite a sigla do partido: ");
        String sigla = in.next();
        
        System.out.println("Digite o numero do partido: ");
        String numero = in.next();
        
        Partido aux = new Partido(nome, sigla, numero);
        lista.add(aux);
    }
    
    public static void excluir(){}
    
    public static void alterar(){}
    
    public static void listar(){}
    
    public static void pesquisar(){}
    
}
