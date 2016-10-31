/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import application.Main;
import dao.UsuarioDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author Francleide
 */
public class LoginLayoutController implements Initializable {
    @FXML
    private Hyperlink url;
    @FXML
    private Button btn;
    @FXML
    private TextField login;
    @FXML
    private PasswordField senha;
 
    private Main main;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    
    private Stage stage;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Hyperlink getUrl() {
        return url;
    }

    public void setUrl(Hyperlink url) {
        this.url = url;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public TextField getLogin() {
        return login;
    }

    public void setLogin(TextField login) {
        this.login = login;
    }

    public PasswordField getSenha() {
        return senha;
    }

    public void setSenha(PasswordField senha) {
        this.senha = senha;
    }
    @FXML
    public void Openview(){
       //Usuario temp = new Usuario();
         main.adminOverview();
//        if(login.getText().equals(usuarioDAO.buscarLogin(login.getText()))){
//            Usuario u =usuarioDAO.buscarLogin(login.getText());
//            if(u.getSenha().equals(senha.getText())){
//                if(u.getPermissao().equals("admin")){
//                    main.adminOverview();
//                }else{
//                    main.userOverview();
//                }
//            }else{
//                 System.out.print("senha incorreta!/n");
//            }
//               
//                
//            
//        }else {
//             System.out.print("login nao existe");
//        }    
        
    }
    @FXML
    public void OpenCadastroCliente(){
        
    }
    @FXML
    public void init(){
        login.setText("Login");
        senha.setText("Senha");
    }
    public void setStage(Stage dialogStage) {
        this.stage = dialogStage;
    }
    
}
