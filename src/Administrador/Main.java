package Administrador;

import java.util.Scanner;

public class Main {                

    public static void main(String[] args) {
        preCadastros();
        menuCadastros();        //inicia partes de cadastros
        
    }
    
    public static void menuCadastros(){
        boolean loop = true;
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("Qual cadastro deseja configurar?");
            System.out.println("1- Prefeito");
            System.out.println("2- Vereador");
            System.out.println("3- Vice-Prefeito");
            System.out.println("4- Eleitor");
            System.out.println("5- Partido");
            System.out.println("6- Inicar eleição");
            int option = in.nextInt();
            switch(option){
                case 1:
                    menu2(1);
                    break;
                case 2:
                    menu2(2);
                    break;
                case 3:
                    menu2(3);
                    break;
                case 4:
                    menu2(4);
                    break;
                case 5:
                    menu2(5);
                    break;
                case 6:
                    loop = false;
                default:
                    System.out.println("Opção irregular.");
                    break;
            }
        }while(loop);
    }
    
    public static void menu2(int index){
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("Qual opção deseja?");
            System.out.println("1- Cadastrar");
            System.out.println("2- Excluir");
            System.out.println("3- Alterar");
            System.out.println("4- Listar");
            System.out.println("5- Pesquisar");
            System.out.println("6- Sair");
            int option = in.nextInt();
            switch(option){
                case 1:
                    if(index == 1)
                        Prefeito.cadastrador.Cadastrar();
                    else
                        if(index == 2)
                            Vereador.cadastrador.Cadastrar();
                    else
                            if(index == 3)
                                VicePrefeito.cadastrador.Cadastrar();
                    else
                                if(index == 4)
                                    Eleitor.cadastrador.Cadastrar();
                    else
                                    if(index == 5)
                                        Partido.Cadastrar();
                    break;
                case 2:
                    if(index == 1)
                        Prefeito.cadastrador.excluir();
                    else
                        if(index == 2)
                            Vereador.cadastrador.excluir();
                    else
                            if(index == 3)
                                VicePrefeito.cadastrador.excluir();
                    else
                                if(index == 4)
                                    Eleitor.cadastrador.excluir();
                    else
                                    if(index == 5)
                                        Partido.excluir();
                    break;
                case 3:
                    if(index == 1)
                        Prefeito.cadastrador.alterar();
                    else
                        if(index == 2)
                            Vereador.cadastrador.alterar();
                    else
                            if(index == 3)
                                VicePrefeito.cadastrador.alterar();
                    else
                                if(index == 4)
                                    Eleitor.cadastrador.alterar();
                    else
                                    if(index == 5)
                                        Partido.alterar();
                    break;
                case 4:
                    if(index == 1)
                        Prefeito.cadastrador.listar();
                    else
                        if(index == 2)
                            Vereador.cadastrador.listar();
                    else
                            if(index == 3)
                                VicePrefeito.cadastrador.listar();
                    else
                                if(index == 4)
                                    Eleitor.cadastrador.listar();
                    else
                                    if(index == 5)
                                        Partido.listar();
                    break;
                case 5:
                    if(index == 1)
                        Prefeito.cadastrador.pesquisar();
                    else
                        if(index == 2)
                            Vereador.cadastrador.pesquisar();
                    else
                            if(index == 3)
                                VicePrefeito.cadastrador.pesquisar();
                    else
                                if(index == 4)
                                    Eleitor.cadastrador.pesquisar();
                    else
                                    if(index == 5)
                                        Partido.pesquisar();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção irregular");
            }
        }while(true);
    }
    
    public static void preCadastros(){
        //Partidos 
        Partido pt1 = new Partido("partidoBom", "PB", "01");
        Partido.lista.add(pt1);
        Partido pt2 = new Partido("partidoVerde", "PV", "02");
        Partido.lista.add(pt2);
        Partido pt3 = new Partido("partidoJuventude", "PJ", "03");
        Partido.lista.add(pt3);
        
        //VicePrefeitos
        VicePrefeito vp1 = new VicePrefeito("0001", "JoseAlves", "JA@gmail.com", Data.getDate("01/02/1980"), pt2);
        VicePrefeito.lista.add(vp1);
        VicePrefeito vp2 = new VicePrefeito("0002", "LuisaBorges", "LB@live.com", Data.getDate("13/09/1970"), pt2);
        VicePrefeito.lista.add(vp2);
        VicePrefeito vp3 = new VicePrefeito("0003", "ClaudioManoel", "CM@hotmail.com", Data.getDate("11/12/1990"), pt3);
        VicePrefeito.lista.add(vp3);
        
        //Prefeitos
        Prefeito p1 = new Prefeito(vp1, "0001", "AndreLegal", "AL@hotmail.com", Data.getDate("07/06/1997"), pt1);
        Prefeito.lista.add(p1);
        Prefeito p2 = new Prefeito(vp2, "0002", "AnaJoia", "AJ@gmail.com", Data.getDate("14/08/1995"), pt1);
        Prefeito.lista.add(p2);
        Prefeito p3 = new Prefeito(vp3, "0003", "PrMconnagit", "PM@hotmail.com", Data.getDate("12/11/1950"), pt1);
        Prefeito.lista.add(p3);
        
        //Vereadores
        Vereador v1 = new Vereador("0001", "Dumbledore", "DM@gmail.com", Data.getDate("02/08/1820"), pt1);
        Vereador.lista.add(v1);
        Vereador v2 = new Vereador("0002", "HermioneGranger", "HG@gmail.com", Data.getDate("05/12/1990"), pt1);
        Vereador.lista.add(v2);
        Vereador v3 = new Vereador("0003", "NataliaSales", "NS@gmail.com", Data.getDate("01/05/1990"), pt3);
        Vereador.lista.add(v3);
        
        //Eleitores
        Eleitor e1 = new Eleitor();
        Eleitor.lista.add(e1);
        Eleitor e2 = new Eleitor();
        Eleitor.lista.add(e2);
        Eleitor e3  =new Eleitor();
        Eleitor.lista.add(e3);
    }
    
}
