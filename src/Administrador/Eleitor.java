package Administrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Eleitor implements Cadastro{
    static Scanner in = new Scanner(System.in);
    static ArrayList<Eleitor> lista = new ArrayList();
    private String nome;
    private Date nascimento;
    private String titulo;
    private String zona;
    private String secao;

    public Eleitor() {              //para o cadastrador
    }

    public Eleitor(String nome, Date nascimento, String titulo, String zona, String secao) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.titulo = titulo;
        this.zona = zona;
        this.secao = secao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    @Override
    public void Cadastrar() {
        System.out.println("Digite o nome do eleitor: ");
        String nome = in.nextLine();
        
        //Fazer a data de nascimento
        Date nasc = new Date();
        
        System.out.println("Digite o titulo do eleitor: ");
        String titulo = in.next();
        
        System.out.println("A zona eleitoral do eleitor: ");
        String zona = in.next();
        
        System.out.println("Digite a seção eleitoral do eleitor: ");
        String secao = in.next();
        
        Eleitor aux = new Eleitor(nome, nasc, titulo, zona, secao);
        this.lista.add(aux);
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pesquisar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
