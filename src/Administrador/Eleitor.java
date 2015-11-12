package Administrador;

import java.util.Date;

public class Eleitor {
    String nome;
    Date nascimento;
    String titulo;
    String zona;
    String secao;

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
    
    public static void Cadastrar(){}
    
    public static void excluir(){}
    
    public static void alterar(){}
    
    public static void listar(){}
    
    public static void pesquisar(){}
    
}
