/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Francleide
 */
@Entity
public class Episodio extends Video{
    @Column
    private int numero;
    @Column
    private List<String> atoresConvidados;
    
    public Episodio(){
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<String> getAtoresConvidados() {
        return atoresConvidados;
    }

    public void setAtoresConvidados(List<String> atoresConvidados) {
        this.atoresConvidados = atoresConvidados;
    }
        
}
