package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DateUtil;
import model.Usuario;

public class EditUsuarioController {
	private Usuario usuario;
	
	public TextField login;
	public TextField senha;
	public TextField dtAniversario;
	
	private Stage dialogStage;
	
	private boolean okClicked =false;
	
	private void initialize() {
    }
	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	public void setUsuario(Usuario usuario) {
        this.usuario = usuario;

//        login.setText(usuario.getLogin());
//        senha.setText(usuario.getSenha());
//        dtAniversario.setText(DateUtil.format(usuario.getIdade()));
//        dtAniversario.setPromptText("dd.mm.yyyy");
    }
	
	public boolean isOkClicked() {
        return okClicked;
    }
	
	@FXML
    private void handleCancel() {
        dialogStage.close();
    }
	@FXML
    private void handleOk() {
       
//            usuario.setLogin(login.getText());
//            usuario.setSenha(senha.getText());
//            
//            usuario.setIdade(DateUtil.parse(dtAniversario.getText()));
//
//            okClicked = true;
            dialogStage.close();
        
    }

	

}
