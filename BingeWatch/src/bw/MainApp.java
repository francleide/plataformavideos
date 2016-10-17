package bw;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private TextField txLogin;
	private PasswordField txSenha;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showUsuarioLogin();
        
        showPrincipal();

	}

	private void initRootLayout() {
		// TODO Auto-generated method stub
		try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostra a scene contendo o root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	private void showUsuarioLogin() {
		// TODO Auto-generated method stub
		try {
            // Carrega o person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LoginLayout.fxml"));
            AnchorPane loginUsuario = (AnchorPane) loader.load();

            // Define o login dentro do root layout.
            rootLayout.setCenter(loginUsuario);
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

	 public Stage getPrimaryStage() {
	        return primaryStage;
	    }
	 
	public static void main(String[] args) {
		launch(args);
	}
	
	private void login(){
		
	}
	
	private void showPrincipal(){
		if(txLogin.getText()=="Admin" && txSenha.getText()=="123"){
			try {
	            // Carrega o person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/PrincipalAdminOverview.fxml"));
	            AnchorPane usuarioAdmin = (AnchorPane) loader.load();

	            // Define o login dentro do root layout.
	            rootLayout.setCenter(usuarioAdmin );
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		if(txLogin.getText()=="user" && txSenha.getText()=="123"){
			try {
	            // Carrega o person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/PrincipalClienteOverview.fxml"));
	            AnchorPane usuarioCliente = (AnchorPane) loader.load();

	            // Define o login dentro do root layout.
	            rootLayout.setCenter(usuarioCliente);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
	}

	
	
}
