package view;

import java.util.ArrayList;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Usuario;

public class AllAdminController {
	private Main main;
	
	private ArrayList<Usuario> usuarios;
	@FXML
	private TableView<Usuario> tabelaUsuario;
        @FXML
	private TableColumn<Usuario, String> loginColumn;
        @FXML
	private TableColumn<Usuario, String> tipoColumn;
        @FXML
        private Label nomeUsuario;
	@FXML
        private Label loginUsuario;
        @FXML
        private Label senhaUsuario;
        @FXML
        private Label tipoUsuario;
        @FXML
        private Label dataUsuario;
	@FXML
        private TextField nomeField;
        @FXML
        private TextField loginField;
        @FXML
        private TextField senhaField;
        @FXML
        private ComboBox permissao;
        @FXML
        private DatePicker nascimento;
        
	//remove usuario
	@FXML
	private void deletarUsuario(Usuario usuario){
		int indexusuario= buscarUsuario(usuario);
		
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
		int indexusuario= buscarUsuario(usuario);
		usuarios.set(indexusuario, usuario);
		
	}
	
	private int buscarUsuario(Usuario usuario){
		int i;
		for(i=0;i<usuarios.size();i++){
			if(usuarios.get(i)==usuario){
				return i;
			}
		}
		return -1;
	}
	private void showDetalheUsuario(Usuario usuario){
            if(usuario!=null){
                nomeUsuario.setText(usuario.getNome());
                loginUsuario.setText(usuario.getLogin());
                senhaUsuario.setText(usuario.getSenha());
                tipoUsuario.setText(usuario.getPermissao());
                dataUsuario.setText(usuario.getIdade().toString());
            }else{
                nomeUsuario.setText("");
                loginUsuario.setText("");
                senhaUsuario.setText("");
                tipoUsuario.setText("");
                dataUsuario.setText("");
            }
	}
        public AllAdminController(){
        
        }
        @FXML
        private void initUser(){
            loginColumn.setCellValueFactory(cellData -> cellData.getValue().getLoginProperty());
            tipoColumn.setCellValueFactory(cellData -> cellData.getValue().getPermissaoProperty());
            
            showDetalheUsuario(null);
            
            tabelaUsuario.getSelectionModel().selectedItemProperty().addListener( (observable, oldValue, newValue) -> showDetalheUsuario(newValue));
            
        }
        public void setMain(Main main) {
        this.main = main;

        // Adiciona os dados da observable list na tabela
        tabelaUsuario.setItems(main.getUsuarioData());
    }
    @FXML
    private void handleDeleteUsuario() {
        int selectedIndex = tabelaUsuario.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tabelaUsuario.getItems().remove(selectedIndex);
        }else {
            // Nada selecionado.

        Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Nenhuma seleção");
                alert.setHeaderText("Nenhuma Pessoa Selecionada");
                alert.setContentText("Por favor, selecione uma pessoa na tabela.");

                alert.showAndWait();
        }
    }   
	
}
