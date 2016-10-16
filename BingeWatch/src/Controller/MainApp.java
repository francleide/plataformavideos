package Controller;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		this.primaryStage = stage;
		this.primaryStage.setTitle("BingeWatch");
		initRootLayout();
		showLoginOverview();
	}

    private void showLoginOverview() {
		// TODO Auto-generated method stub
		//Carrega LoginLayout
    	try{
    		FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/view/LoginLayout.fxml"));
			AnchorPane loginLayout =(AnchorPane) loader.load();
			
			//Define o layout dentro do root layout.
			rootLayout.setCenter(loginLayout);
    	}catch (IOException e){
    		e.printStackTrace();
    	}
	}

	private void initRootLayout() {
		// TODO Auto-generated method stub
		try{
			//Carrega o root layout do arquivo fxml.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			//Mostra a scebe contendo o root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public MainApp(){
    	
    }
 
}
