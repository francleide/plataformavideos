/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Usuario;

/**
 *
 * @author Francleide
 */
public class UsuarioDAO {
    private EntityManager em;
    
    public void salvar(Usuario c) { 
        
        em.persist(c); 
    }
    public void atualizar(Usuario c) { em.merge(c); }
    public void remover(Usuario c) { c = em.find(Usuario.class, c.getLogin()); em.remove(c); }
    
    public Usuario buscarLogin(String login) {
		return (Usuario) em.find(Usuario.class, login);
	}
    public List<Usuario> getUsuarios(){
        Query query = em.createQuery("Select o From Usuario o");
        return (List<Usuario>) query.getResultList();
    }
    

    
}
