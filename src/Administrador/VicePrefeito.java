/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Administrador;

import java.util.Date;

/**
 *
 * @author aluno
 */
public class VicePrefeito extends Candidato{

    public VicePrefeito(String codigo, String nome, String email, Date nascimento, Partido partido) {
        super(codigo, nome, email, nascimento, partido);
    }
    
}
