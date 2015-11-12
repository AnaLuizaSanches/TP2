
package Administrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Candidato implements Cadastro{
    static Scanner in = new Scanner(System.in);
    static ArrayList<Candidato> lista = new ArrayList();
    private String codigo;
    private String nome;
    private String email;
    private Date nascimento;
    private Partido partido;    

    public Candidato() {            //para o cadastrador
    }

    public Candidato(String codigo, String nome, String email, Date nascimento, Partido partido) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.partido = partido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public void Cadastrar() {
        System.out.println("Digite o nome do candidato: ");
        String nome = in.nextLine();
        
        System.out.println("Digite o codigo do candidato: ");
        String codigo = in.next();
        
        System.out.println("Digite o email do candidato: ");
        String email = in.next();
        
        //colocar date aqui 
        Date test = new Date();
        
        //depois de criar o arraylist estatico de partidos criar um iterator para procurar um partido digitado pelo usuario
        Partido teste = new Partido();
        
        //so de teste isso
        Candidato c = new Candidato(codigo, nome, email, test, teste);
        this.lista.add(c);
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
