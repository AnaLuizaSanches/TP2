
package Administrador;

import Ferramentas.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public abstract class Candidato implements Cadastro{
    static Scanner in = new Scanner(System.in);
    private String codigo;
    private String nome;
    private String email;
    private Date nascimento;
    private Partido partido;
    private int Votos;
    
    public Candidato() {            //para o cadastrador
    }

    public Candidato(String codigo, String nome, String email, Date nascimento, Partido partido) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.partido = partido;
        this.Votos = 0;
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

    public int getVotos() {
        return Votos;
    }

    public void setVotos(int Votos) {
        this.Votos = Votos;
    }
    
    @Override
    public String toString() {
        return "codigo: " + codigo + " nome: " + nome + " email: " + email + " nascimento: "
                + Data.getString(nascimento) + " partido: " + partido.toString();
    }
    public void votar(){
        Votos++;
    }

    @Override
    public abstract void Cadastrar();

    @Override
    public abstract void excluir();

    @Override
    public abstract void listar();

    @Override
    public abstract void pesquisar();

    @Override
    public abstract void alterar();
    
}
