package UrnaEletronica;

import Administrador.Eleitor;
import Administrador.Prefeito;
import Administrador.Vereador;
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
            int conf = 0;
            boolean loop = true;
            //votação do prefeito
            do{
                try{
                System.out.println("Digite o codigo do prefeito(NN ou 99 para branco)");
                voto = in.next();
                if(voto.length() != 2)
                    throw new Exception("O código do prefeito deve ter 2 digitos");
                if(voto.equals("99")){
                    System.out.println("Voto branco. confirmar ? (0/1)");
                    conf = in.nextInt();
                    if(conf == 1){
                        brancosPref++;
                        loop = false;
                    }  
                }else if(!Prefeito.existe(voto)){
                    System.out.println("Voto nulo. confirmar ? (0/1)");
                    conf = in.nextInt();
                    if(conf == 1){
                        nulosPref++;
                        loop = false;
                    } 
                }else{
                    Prefeito.exibir(voto);
                    System.out.println("confirmar ? (0/1)");
                    conf = in.nextInt();
                    if(conf == 1){
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
                if(voto.equals("9999")){
                    System.out.println("Voto branco. confirmar ? (0/1)");
                    conf = in.nextInt();
                    if(conf == 1){
                        brancosVer++;
                        loop = false;
                    } 
                }else if(!Vereador.existe(voto)){
                    System.out.println("Voto nulo. confirmar ? (0/1)");
                    conf = in.nextInt();
                    if(conf == 1){
                        nulosVer++;
                        loop = false;
                    } 
                }else{
                    Vereador.exibir(voto);
                    System.out.println("confirmar ? (0/1)");
                    conf = in.nextInt();
                    if(conf == 1){
                        Vereador.atribuirVoto(voto);
                        loop = false;
                    } 
                }
                }catch(Exception e){
                    System.out.println("Erro: "+ e.getMessage());
                }
            }while(loop);    
            
            numEleitores++;//incrementa o numero de eleitores
            Eleitor.votou(titulo);// informa que o eleitor acaba de votar, e nao podera votar novamente
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
        int num = numEleitores,max = maxEleitores;
        //variaveis usadas nos denominadores, caso seja 0 sao alteradas para 1.
        if(numEleitores == 0)
            num = 1;
        if(maxEleitores == 0)
            max = 1;
        System.out.println("\n\n\tHora inicial : " + abertura + " Hora Final : "+fechamento);
        System.out.println("\n\tPrefeito\n");
        Prefeito.relatorio(num);
        System.out.println("Votos Brancos : "+(brancosPref*100)/num+" % ("+ brancosPref+")");
        System.out.println("Votos Nulos : "+(nulosPref*100)/num+" % ("+ nulosPref+")");
        System.out.println("\n\tVereador\n");
        Vereador.relatorio(num);
        System.out.println("Votos Brancos : "+(brancosVer*100)/num+"% ("+ brancosVer+")");
        System.out.println("Votos Nulos : "+(nulosVer*100)/num+" % ("+ nulosVer+")");
        System.out.println("Total de votos : " +(numEleitores*100)/max+" % ("+numEleitores+")");
        System.out.println("\n\tResultado Final\n");
        Prefeito.resultado(numEleitores);
        Vereador.resultado(numEleitores);
        System.out.println("\n\n");
    }
}
