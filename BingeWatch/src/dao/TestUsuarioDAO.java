/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.time.LocalDate;
import java.util.Calendar;
import model.Usuario;

/**
 *
 * @author Francleide
 */
public class TestUsuarioDAO {
    public static void main(String[] args) throws Exception {
    Usuario usuario = new Usuario();
    
    usuario.setNome("Rafael Filho");
    usuario.setLogin("rafa");
    usuario.setSenha("1234");
    usuario.setIdade(LocalDate.of(1994, 1,15));
    usuario.setPermissao("admin");
    
    UsuarioDAO dao = new UsuarioDAO();
    System.out.println("Salvando a pessoa: " + usuario.getNome());
    dao.salvar(usuario);
    
  }
}
