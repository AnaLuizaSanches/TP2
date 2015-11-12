
package Administrador;

import java.util.Date;

public class Candidato {
    private String codigo;
    private String nome;
    private String email;
    private Date nascimento;
    private Partido partido;    

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
    
    public static void Cadastrar(){}
    
    public static void excluir(){}
    
    public static void alterar(){}
    
    public static void listar(){}
    
    public static void pesquisar(){}
}
