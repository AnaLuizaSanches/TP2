package Administrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Vereador extends Candidato{
    public static ArrayList<Vereador> lista = new ArrayList();
    static Vereador cadastrador = new Vereador();

    public Vereador() {
    }
    
    public Vereador(String codigo, String nome, String email, Date nascimento, Partido partido) {
        super(codigo, nome, email, nascimento, partido);
    }

    @Override
    public void Cadastrar() {
        System.out.println("Digite o nome do candidato: ");
        String nome = in.nextLine();
        
        String codigo = null;
        boolean loop = true;
        do{
            try{
                System.out.println("Digite o codigo do candidato: ");
                codigo = in.next();
                if(codigo.length() != 4)
                    throw new Exception();
                else
                    loop = false;
            } catch(Exception e){
                System.out.println("O codigo do vereador deve possuir 4 digitos.");
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
                
        Vereador aux = new Vereador(codigo, nome, email, nascimento, partido);
        this.lista.add(aux);
    }

    @Override
    public void excluir() {
        try {
            System.out.println("Digite a posicao do Vereador que deseja excluir: ");
            int posicao = in.nextInt();
            this.lista.remove(posicao);
        } catch (NumberFormatException e){
            System.out.println("Erro na formatação.");
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
        System.out.println("Digite o nome do vereador que deseja pesquisar: ");
        String nome = in.next();
        int quantidade = 0;
        
        Iterator i = this.lista.iterator();
        
        while(i.hasNext()){
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

            //Olhar isso aqui
            System.out.println("Novo partido: ");
            Partido partido = lookForPartido();
            this.lista.get(posicao).setPartido(partido);
        } catch (NumberFormatException e){
            System.out.println("Erro na formatação.");
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
}
