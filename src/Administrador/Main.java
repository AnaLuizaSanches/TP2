package Administrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Main {                //Para testes

    public static void main(String[] args) {
        
    }
    
    public void preCadastros(){
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
    }
    
}
