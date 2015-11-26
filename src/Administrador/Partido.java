package Administrador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Partido {
    static Scanner in = new Scanner(System.in);
    public static ArrayList<Partido> lista = new ArrayList();
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
    /* 
    metodo que verifica se existe um partido com determinada sigla 
    retornando true se exite e false se não existe    
    */
    public static boolean existe(String sigla){
        for(Partido p : lista){
            if(p.getSigla().equals(sigla))
                return true;
        }
        return false;
    }
    
    public static void Cadastrar(){
        System.out.println("Digite o nome do partido: ");
        String nome = in.next();
        boolean loop = true;
        String sigla;
        do{
            System.out.println("Digite a sigla do partido: ");
            sigla = in.next();
            
            if(!existe(sigla))
                loop = false;
            else
                System.out.println("Erro: Sigla de Partido já existente");
        }while(loop);
        
        System.out.println("Digite o numero do partido: ");
        String numero = in.next();
        
        Partido aux = new Partido(nome, sigla, numero);
        lista.add(aux);
    }
    
    public static void excluir(){
        try {
            System.out.println("Digite a posicao do partido que deseja excluir: ");
            int posicao = in.nextInt();
            lista.remove(posicao);
        } catch (NumberFormatException e){
            System.out.println("Erro :"+e.getMessage());
        }
    }
    
    public static void alterar(){
        try {
            System.out.println("Digite a posicao do partido que deseja alterar: ");
            int posicao = in.nextInt();

            System.out.println("Novo nome: ");
            String nome = in.next();
            lista.get(posicao).setNome(nome);

            System.out.println("Nova sigla: ");
            String sigla = in.next();
            lista.get(posicao).setSigla(sigla);
        } catch (NumberFormatException e){
            System.out.println("Erro :"+e.getMessage());
        }
    }
    
    public static void listar(){
        Iterator i = lista.iterator();
        int quantidade = 0;
        
        while(i.hasNext()){ 
            i.next();
            quantidade++;
        }
        
        for(int j=0; j <quantidade; j++){      
            System.out.println(lista.get(j).getNome());
            System.out.println(lista.get(j).getSigla());
            System.out.println(lista.get(j).getNumero());
            System.out.println("\n");
        }
    }
    
    public static void pesquisar(){
        Iterator i = lista.iterator();
        int quantidade = 0;
        System.out.println("Digite o numero do partido que deseja pesquisar: ");
        String num = in.next();
        
        while(i.hasNext()){     //pega quantos prefeitos existem na lista
            i.next();
            quantidade++;
        }
        
        for(int j=0; j <quantidade; j++){ 
            if(lista.get(j).getNumero().equals(num)){
                System.out.println(lista.get(j).getNome());
                System.out.println(lista.get(j).getSigla());
                System.out.println(lista.get(j).getNumero());
                System.out.println("\n");
            }
        }
    }
}
