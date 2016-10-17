package bw.view;

import java.util.ArrayList;

import bw.MainApp;
import bw.model.Usuario;
import javafx.fxml.FXML;

public class UsuarioController {
	private MainApp mainApp;
	
	private ArrayList<Usuario> usuarios;
	
	//remove usuario
	@FXML
	private void deletarUsuario(){
		int indexusuario= buscarUsuario();
		usuarios.remove(indexusuario);
	}
	//adiciona usuario 
	@FXML
	private void novoUsuarioCliente(Usuario usuario){
		usuarios.add(usuario);
	}
	
	//edita usuario 
	@FXML
	private void editarUsuario(Usuario usuario){
		int indexusuario= buscarUsuario();
		usuarios.set(indexusuario, usuario);
		
	}
	
	private int buscarUsuario(){
		
		return 0;
	}
}
