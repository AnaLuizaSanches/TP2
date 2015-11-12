package Administrador;

public class Partido {
    String nome;
    String sigla;
    String numero;

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
    
    public static void Cadastrar(){}
    
    public static void excluir(){}
    
    public static void alterar(){}
    
    public static void listar(){}
    
    public static void pesquisar(){}
    
}
