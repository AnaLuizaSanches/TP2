package UrnaEletronica;

public class Relatorio {
    public static int totalDeVotos= 1;      //1 para testar a funcao 
    public static int votosBrancos = 0;     //contagem de votos brancos
    public static int votosNulos = 0;       //contagem de votos nulos
    
    public static void showRelatorio(){     //relatorio em si

        float porcBrancos = (votosBrancos/totalDeVotos) * 100;
        float porcNulos = (votosNulos/totalDeVotos) * 100;
        System.out.println("Votos brancos: " + porcBrancos + "%(" + votosBrancos + ")");
        System.out.println("Votos nulos: " + porcNulos + "%(" + votosNulos + ")");
        System.out.println("Total de votos: " + totalDeVotos);
    }
}
