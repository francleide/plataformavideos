/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Usuario;
import view.AllAdminController;

/**
 *
 * @author Francleide
 */
public class Main extends Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    BorderPane rootLayout;
    AnchorPane loginLayout;
    AnchorPane admin;
    AnchorPane user;
    private Stage primaryStage;
    private ObservableList<Usuario> usuarioData = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Binge Watch");
        initRootLayout();
        showOverview();        
    }
    private void showOverview() {
        try {
            // Carrega o person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/LoginLayout.fxml"));
            loginLayout = (AnchorPane) loader.load();
            
            // Define o person overview dentro do root layout.
            rootLayout.setCenter(loginLayout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initRootLayout() {
         try{
        // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Mostra a scene (cena) contendo o root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public Main(){
        usuarioData.add(new Usuario("Maria","Mari","1234"));
        usuarioData.add(new Usuario("Lauana","lu","1234"));
        usuarioData.add(new Usuario("Pedro","pedrinho","1234"));
    }

    public ObservableList<Usuario> getUsuarioData() {
        return usuarioData;
    }
    
    
    public void adminOverview(){
       try {
        // Carrega a person overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/view/PrincipalAdminOverview.fxml"));
        admin = (AnchorPane) loader.load();
        // Define a person overview no centro do root layout.
        rootLayout.setCenter(admin);

//        // Dá ao controlador acesso à the main.
//        AllAdminController controller = loader.getController();
//        controller.setMain(this);

    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void userOverview() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
