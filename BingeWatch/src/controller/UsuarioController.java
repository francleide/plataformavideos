/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Francleide
 */

public class UsuarioController {
    private Usuario usuario;
    
    private UsuarioDAO usuarioDAO;
    private List<Usuario> listaUsuarios;
    
    public UsuarioController(){
        usuario = new Usuario();
        listaUsuarios = new ArrayList<Usuario>();
    }
}
