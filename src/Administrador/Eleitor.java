package Administrador;

import Ferramentas.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Eleitor implements Cadastro{
    static Scanner in = new Scanner(System.in);
    public static ArrayList<Eleitor> lista = new ArrayList();
    public static Eleitor cadastrador = new Eleitor();
    private String nome;
    private Date nascimento;
    private String titulo;
    private String zona;
    private String secao;
    private boolean votou;

    public Eleitor() {              //para o cadastrador
    }

    public Eleitor(String nome, Date nascimento, String titulo, String zona, String secao) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.titulo = titulo;
        this.zona = zona;
        this.secao = secao;
        votou = false;
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
    public String toString() {
        return "nome: " + nome + " nascimento: " + nascimento + " titulo: " + 
                titulo + " zona: " + zona + " secao: " + secao;
    }
    public static boolean existe(String titulo){
        for(Eleitor e : lista){
            if(e.getTitulo().equals(titulo))
                return true;
        }
        return false;
    }
    public static boolean existe(String titulo, String zona, String secao){
        for(Eleitor e : lista){
            if(e.getTitulo().equals(titulo) && e.getSecao().equals(secao) && e.getZona().equals(zona))
                return true;
        }
        return false;
    }
    public static boolean jaVotou(String titulo){
        for(Eleitor e : lista){
            if(e.getTitulo().equals(titulo))
                if(e.votou)
                    return true;
        }
        return false;
    }
    public static void votou(String titulo){
        for(Eleitor e : lista){
            if(e.getTitulo().equals(titulo))
                    e.votou = true;
        }
    }
    public static Eleitor getEleitor(String titulo){
        for(Eleitor e : lista){
            if(e.getTitulo().equals(titulo))
                return e;
        }
        return null;
    }
    
    @Override
    public void Cadastrar() {
        System.out.println("Digite o nome do eleitor: ");
        String nome = in.nextLine();
        Date nascimento = null;
        //Data de nascimento    
        try {
            System.out.println("digite a data de nascimento (dd/mm/yyyy): ");
            String dataStr = in.next();
            nascimento = Data.getDate(dataStr);
        } catch(NumberFormatException e){
            System.out.println("Erro :"+e.getMessage());
        }
        boolean loop = true;
        String titulo;
        do{
            System.out.println("Digite o titulo do eleitor: ");
            titulo = in.next();
            if(!existe(titulo))
                loop = false;
            else
                System.out.println("Erro: Titulo de eleitor já existente");
        }while(loop);
        
        System.out.println("Digite a zona eleitoral do eleitor (1-2-3): ");
        String zona = in.next();
        
        System.out.println("Digite a seção eleitoral do eleitor: ");
        String secao = in.next();
        
        Eleitor aux = new Eleitor(nome, nascimento, titulo, zona, secao);
        this.lista.add(aux);
    }

    @Override
    public void excluir() {
        try {
            System.out.println("Digite a posição que deseja excluir: ");
            int posicao = in.nextInt();
            this.lista.remove(posicao);
            System.out.println("Eleitor removido.");
        } catch(NumberFormatException e){
            System.out.println("Erro :"+e.getMessage());
        }
    }

    @Override
    public void listar() {
        Iterator i = this.lista.iterator();
        int quantidade = 0;
        
        while(i.hasNext()){ 
            i.next();
            quantidade++;
        }
        
        for(int j=0; j <quantidade; j++){
            System.out.println(this.lista.get(j).getNome());
            System.out.println(this.lista.get(j).getTitulo());
            System.out.println("\n");
        }
    }

    @Override
    public void pesquisar() {
        System.out.println("Digite o nome do eleitor que deseja pesquisar: ");
        String nome = in.next();
        Iterator i = this.lista.iterator();
        int quantidade = 0;
        
        while(i.hasNext()){     
            i.next();
            quantidade++;
        }
        
        for(int j=0; j <quantidade; j++){   
            if(this.lista.get(j).getNome().equals(nome)){
                System.out.println(this.lista.get(j).getNome());
                System.out.println(this.lista.get(j).getNascimento());
                System.out.println(this.lista.get(j).getTitulo());
                System.out.println("\n");
            }
        }
    }

    @Override
    public void alterar() {
        try {
            System.out.println("Digite a posicao do eleitor que deseja alterar: ");
            int posicao = in.nextInt();

            System.out.println("Novo nome: ");
            String novon = in.next();
            this.lista.get(posicao).setNome(novon);

            System.out.println("Nova zona: ");
            String novaz = in.next();
            this.lista.get(posicao).setZona(novaz);

            System.out.println("Nova secao: ");
            String novas = in.next();
            this.lista.get(posicao).setSecao(novas);

            System.out.println("Nova data de nascimento (dd/mm/yyyy): ");
            String novad = in.next();
            this.lista.get(posicao).setNascimento(Data.getDate(novad));
        } catch (NumberFormatException e){
            System.out.println("Erro :"+e.getMessage());
        }
    }
}
