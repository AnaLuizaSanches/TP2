package Administrador;

import Ferramentas.Data;
import Exceptions.InvalidNumberException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

public class Prefeito extends Candidato{

    private VicePrefeito vice;
    public static ArrayList<Prefeito> lista = new ArrayList();
    static Prefeito cadastrador = new Prefeito();

    public Prefeito() {
    }

    public Prefeito(VicePrefeito vice, String codigo, String nome, String email, Date nascimento, Partido partido) {
        super(codigo, nome, email, nascimento, partido);
        this.vice = vice;
    }

    public VicePrefeito getVice() {
        return vice;
    }

    public void setVice(VicePrefeito vice) {
        this.vice = vice;
    }
    
    @Override
    public String toString() {
        return super.toString()+" vice: " + vice;
    }
    /* 
    metodo que verifica se existe um prefeito com determinado codigo 
    retornando true se exite e false se não existe    
    */
    public static boolean existe(String codigo){
        for(Prefeito p : lista){
            if(p.getCodigo().equals(codigo))
                return true;
        }
        return false;
    }
    /*
    metodo que exibe os atributos de um prefeito dado o seu codigo
    */
    public static void exibir(String codigo){
        for(Prefeito p : lista){
            if(p.getCodigo().equals(codigo))
                System.out.println(p.toString());
        }
    }
    /*
    metodo que atribui voto ao vereador de determinado codigo
    */
    public static void atribuirVoto(String codigo){
        for(Prefeito p : lista){
            if(p.getCodigo().equals(codigo))
                p.votar();
        }
    }
    /*
    metodo que gera o relatorio dos candidatos a prefeito
    */
    public static void relatorio(int totalVotos){
        for(Prefeito p : lista){
            System.out.println(p.getNome() +"("+p.getCodigo()+") : "
           + (p.getVotos()*100)/totalVotos +" % (" + p.getVotos() + ")");
        }
        ordenar();
    }
    /*
    metodo que ordena decrescente
    */
    public static void ordenar(){
        Collections.sort(lista, new Comparator<Prefeito>() {
        @Override public int compare(Prefeito p1, Prefeito p2) {
            return p2.getVotos() - p1.getVotos();
        }
    });
    }
    /*
    metodo que verifica e imprime se há um ganhador das eleiçoes ou se tera segundo turno.
    */
    public static void resultado(int totalVotos){
        ordenar();
        if(lista.get(0).getVotos() >= (1 + (totalVotos/2))){
            System.out.println("O candidato a Prefeito "+lista.get(0).getNome()
                    +" ganhou as eleições");
        }else{
            System.out.println("Segundo turno entre "+lista.get(0).getNome() 
                    +" e "+ lista.get(1).getNome()+" para Prefeito");
        }    
    }
    
    @Override
    public void Cadastrar() {
        System.out.println("Digite o nome do candidato: ");
        String nome = in.nextLine();
        
        boolean loop = true;
        String codigo = null;
        do{
            try{
                System.out.println("Digite o codigo do candidato: ");
                codigo = in.next();

                if(codigo.length() != 2)
                    throw new InvalidNumberException("O código do prefeito deve ter 2 digitos");
                else if(existe(codigo))
                    System.out.println("Erro: codigo já existente");
                else
                    loop = false;
            } catch(Exception e){
                System.out.println("Erro :"+e.getMessage());
           }
        } while(loop);

        System.out.println("Digite o email do candidato: ");
        String email = in.next();
        
        //Data de nascimento    
        System.out.println("digite a data de nascimento (dd/mm/yyyy): ");
        String dataStr = in.next();
        Date nascimento = Data.getDate(dataStr);
       
        //Partido
        
        Partido partido = lookForPartido();
        
        //Vice Prefeito
        
        VicePrefeito vice = lookForVice();
        
        //so de teste isso
        Prefeito aux = new Prefeito( vice, codigo, nome, email, nascimento, partido);
        this.lista.add(aux);
    }

    @Override
    public void excluir() {
        try {
            System.out.println("Digite a posição do prefeito que deseja excluir: ");
            int posicao = in.nextInt();
            this.lista.remove(posicao);
        } catch (NumberFormatException e){
            System.out.println("Erro :"+e.getMessage());
        } catch (Exception e){
            System.out.println("Erro :"+e.getMessage());
        }
    }

    @Override
    public void listar() {
        Iterator i = this.lista.iterator();
        int quantidade = 0;
        
        while(i.hasNext()){     //pega quantos prefeitos existem na lista
            i.next();
            quantidade++;
        }
        
        for(int j=0; j <quantidade; j++){      //mostra somente o nome e o codigo dos caras
            System.out.println(this.lista.get(j).getNome());
            System.out.println(this.lista.get(j).getCodigo());
            System.out.println("\n");
        }
    }

    @Override
    public void pesquisar() {
        System.out.println("Digite o nome do prefeito que deseja pesquisar: ");
        String nome = in.next();
        int quantidade = 0;
        
        Iterator i = this.lista.iterator();
        
        while(i.hasNext()){     //pega quantos prefeitos existem na lista
            i.next();
            quantidade++;
        }
        
        for(int j=0; j <quantidade; j++){
            if(this.lista.get(j).getNome().equals(nome)){
                System.out.println(this.lista.get(j).getNome());
                System.out.println(this.lista.get(j).getNascimento());
                System.out.println(this.lista.get(j).getCodigo());
            }
        }
    }

    @Override
    public void alterar() {
        try{
            System.out.println("Digite a posição do candidato que deseja alterar: ");
            int posicao = in.nextInt();

            System.out.println("Novo nome: ");
            String novon = in.next();
            this.lista.get(posicao).setNome(novon);

            System.out.println("Novo email: ");
            String novoem = in.next();
            this.lista.get(posicao).setEmail(novoem);

            System.out.println("Nova data de nascimento (dd/mm/yyyy): ");
            String dataStr = in.next();
            this.lista.get(posicao).setNascimento(Data.getDate(dataStr));

            //Partido
            System.out.println("Novo partido: ");
            this.lista.get(posicao).setPartido(lookForPartido());

            System.out.println("Novo vice: ");
            this.lista.get(posicao).setVice(lookForVice());
        } catch (NumberFormatException e){
            System.out.println("Erro :"+e.getMessage());
        }
    }
    
    
    public Partido lookForPartido(){       //Procura por um partido
        Iterator p = Partido.lista.iterator();
        int quantPart = 0;
        Partido partido = null;
        boolean loop = true;
        
        while(p.hasNext()){     //para pegar a quantidade de partidos
            p.next();
            quantPart++;
        }
        
        do{
            System.out.println("Digite o numero do partido: ");
            String num = in.next();
            
            for(int k=0; k< quantPart; k++){
                if(Partido.lista.get(k).getNumero().equals(num)){       //se encontrar o partido na lista de partidos
                    partido = Partido.lista.get(k);
                }
            }
            if(partido != null)
                loop = false;
            else
                System.out.println("Partido não encontrado, digite novamente.");
        }while(loop);
        
        return partido;
    }
    
    public VicePrefeito lookForVice(){
        Iterator v = VicePrefeito.lista.iterator();
        int quantVice = 0;
        VicePrefeito vice = null;
        boolean loop = true;
        while(v.hasNext()){     //pega o numero de vices
            v.next();
            quantVice++;
        }
        
        do{
            System.out.println("Digite o codigo do vice-prefeitna formatação.o: ");
            String num2 = in.next();
            for(int k=0; k<quantVice; k++){
                if(VicePrefeito.lista.get(k).getCodigo().equals(num2)){
                    vice = VicePrefeito.lista.get(k);
                }
            }
            if(vice != null)
                loop = false;
            else
                System.out.println("Vice não encontrado, digite novamente.");
        }while(loop);
        
        return vice;
    }
}
