package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Video;

public class VideoCatalogoController implements Initializable{

	@FXML
	private Button btnCadastrar;
	
	private static ArrayList<Video> videosCadastrados;
	
	@FXML
	private TableView<Video> tbVideos;
	
	@FXML
	private TableColumn<Video, String> columnVideo;
	private static ObservableList<Video> observableListVideos = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		videosCadastrados = new ArrayList<Video>();
		
		this.columnVideo = new TableColumn<>("Video");
		this.columnVideo.setCellValueFactory(cellData->cellData.getValue().tituloProperty());
		tbVideos.setItems(observableListVideos);
	}
	
	public void cadastrarVideoDialog(ActionEvent event) throws Exception{
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadastrarVideo.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Cadastrar Vídeo");
            stage.setScene(new Scene(root1));  
            stage.show();
            
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void setImages(){
		for (Video v: videosCadastrados){

		}
	}

	public static ArrayList<Video> getVideosCadastrados() {
		return videosCadastrados;
	}

	public static void setVideosCadastrados(ArrayList<Video> videosCadastrados) {
		VideoCatalogoController.videosCadastrados = videosCadastrados;
	}

	public static ObservableList<Video> getObservableListVideos() {
		return observableListVideos;
	}

	public static void setObservableListVideos(ObservableList<Video> observableListVideos) {
		VideoCatalogoController.observableListVideos = observableListVideos;
	}

}
