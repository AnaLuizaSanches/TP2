package Administrador;

import Exceptions.InvalidNumberException;
import java.util.ArrayList;

public interface Cadastro {

    public abstract void Cadastrar() throws InvalidNumberException;
    
    public abstract void excluir();
    
    public abstract void listar();
    
    public abstract void pesquisar();
    
    public abstract void alterar();
}
