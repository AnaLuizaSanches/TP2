package UrnaEletronica;

import Administrador.Eleitor;
import Administrador.Prefeito;
import Administrador.Vereador;
import java.util.ArrayList;
import java.util.Scanner;

public class Eleicoes {
    static Scanner in = new Scanner(System.in);
    static String zonaUrna;
    static String secaoUrna;
    static String abertura;
    static String fechamento;
    static int numEleitores;
    static int maxEleitores;
    static int nulosPref = 0;
    static int nulosVer = 0;
    static int brancosPref = 0;
    static int brancosVer = 0;
    
    
    public static void iniciaEleicao(){   
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
        abertura = in.next();
        System.out.println("Digite o numero de eleitores por seção: ");
        maxEleitores = in.nextInt();
        numEleitores = 0;
        
        menuEleicoes();
    }
    public static void menuEleicoes(){
        boolean loop = true;
        int op = 0;
        do{
            System.out.println("1- Novo voto");
            System.out.println("2- Fechar Eleicões");
            op = in.nextInt();
            switch(op){
                case 1:
                    try{
                        votacao();
                    }catch(Exception e){
                        System.out.println("Erro: "+e.getMessage());
                    }
                    break;
                case 2:
                    finalizaEleicoes();
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(loop);
    
    }
    public static void votacao() throws Exception{
        if(numEleitores<maxEleitores){
            System.out.println("Digite o titulo de eleitor");
            String titulo = in.next();
            if(!Eleitor.existe(titulo))
                throw new Exception("Erro: Titulo não existe");
            if(Eleitor.jaVotou(titulo))
                throw new Exception("Erro: Eleitor já votou");
            if(!Eleitor.existe(titulo,zonaUrna,secaoUrna))
                throw new Exception("Erro: eleitor em zona/secao errada");
            String voto = null;
            String conf = null;
            boolean loop = true;
            //votação do prefeito
            do{
                try{
                System.out.println("Digite o codigo do prefeito(NN ou 99 para branco)");
                voto = in.next();
                if(voto.length() != 2)
                    throw new Exception("O código do prefeito deve ter 2 digitos");
                if(voto.equals("99")){
                    System.out.println("Voto branco. confirmar ? (s para confirmar)");
                    conf = in.next();
                    if(conf == "s"){
                        brancosPref++;
                        loop = false;
                    } 
                    
                }else if(!Prefeito.existe(voto)){
                    System.out.println("Voto nulo. confirmar ? (s para confirmar)");
                    conf = in.next();
                    if(conf == "s"){
                        nulosPref++;
                        loop = false;
                    } 
                }else{
                    Prefeito.exibir(voto);
                    System.out.println("confirmar ? (s para confirmar)");
                    conf = in.next();
                    if(conf == "s"){
                        Prefeito.atribuirVoto(voto);
                        loop = false;
                    } 
                }
                }catch(Exception e){
                    System.out.println("Erro: "+ e.getMessage());
                }
            }while(loop);
            //votação do vereador
            
            loop = true;
            do{
                try{
                System.out.println("Digite o codigo do vereador(NNNN ou 9999 para branco)");
                voto = in.next();
                if(voto.length() != 4)
                    throw new Exception("O código do vereador deve ter 4 digitos");
                if(!Vereador.existe(voto)){
                    System.out.println("Voto nulo. confirmar ? (s para confirmar)");
                    conf = in.next();
                    if(conf == "s"){
                        nulosVer++;
                        loop = false;
                    } 
                }else if(voto.equals("9999")){
                    System.out.println("Voto branco. confirmar ? (s para confirmar)");
                    conf = in.next();
                    if(conf == "s"){
                        brancosVer++;
                        loop = false;
                    } 
                }else{
                    Vereador.exibir(voto);
                    System.out.println("confirmar ? (s para confirmar)");
                    conf = in.next();
                    if(conf == "s"){
                        Vereador.atribuirVoto(voto);
                        loop = false;
                    } 
                }
                }catch(Exception e){
                    System.out.println("Erro: "+ e.getMessage());
                }
            }while(loop);    
            
            numEleitores++;//incrementa o numero de eleitores
        }else{
            System.out.println("Não há mais eleitores para votar, favor finalizar eleição");      
        }
    }
    public static void finalizaEleicoes(){
        System.out.println("Digite o horario de finalização");
        fechamento = in.next();
        relatorio();

    }
    
    public static void relatorio(){
        if(numEleitores != 0){
            System.out.println("Hora inicial : " + abertura + " Hora Final : "+fechamento);
            System.out.println("Prefeito");
            Prefeito.relatorio(numEleitores);
            System.out.println("Votos Brancos"+(brancosPref*100)/numEleitores+"% ("+ brancosPref+")");
            System.out.println("Votos Nulos"+(nulosPref*100)/numEleitores+"% ("+ nulosPref+")");
            System.out.println("Vereador");
            Vereador.relatorio(numEleitores);
            System.out.println("Votos Brancos"+(brancosVer*100)/numEleitores+"% ("+ brancosVer+")");
            System.out.println("Votos Nulos"+(nulosVer*100)/numEleitores+"% ("+ nulosVer+")");
            System.out.println("Total de votos: " +(numEleitores*100)/maxEleitores+"% ("+numEleitores+")");
        }
    }
}
