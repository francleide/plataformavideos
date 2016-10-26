package view;

import java.io.File;

import controller.VideoPlayerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Video;

public class CadastrarVideoController {

	@FXML
	private Button btnCadastrar;
	
	@FXML
	private Button btnCancelar;
	
	@FXML
	private Button btnSelectFile;
	
	@FXML
	private Button btnView;
	
	@FXML
	private TextField videoPath;
	
	@FXML
	private Label labelDuration; 
	
	private String filePath;
	
	private Video video;
	
	
	
	public void selectFile(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Selecionar video");
		fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*.avi", "*.mp4"));
		File file = fileChooser.showOpenDialog(new Stage());
		if (file != null){
			try {
				filePath = file.getAbsolutePath().toString();
				videoPath.setText(filePath);
				getMediaInfo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void exibirVideo(){
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VideoPlayer.fxml"));
			VideoPlayerController.setPath(filePath);
			Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Reproduzir Vídeo");
            stage.setScene(new Scene(root1));  
            Stage oldStage = (Stage) btnCancelar.getScene().getWindow();
    	    oldStage.close();
            
            stage.show();
            
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void cancelar(){
		filePath = new String();
		videoPath.clear();
		Stage stage = (Stage) btnCancelar.getScene().getWindow();
	    stage.close();
		
	}
	
	public void confirmar(){
		VideoCatalogoController.getVideosCadastrados().add(video);
		VideoCatalogoController.getObservableListVideos().add(video);
		Stage stage = (Stage) btnCancelar.getScene().getWindow();
	    stage.close();
	}
	
	public void getMediaInfo(){
		video = new Video(filePath, "Teste");
		video.setImagem(new ImageView("images/logoBW.png"));
		//labelDuration.setText(video.getMedia().getDuration().toString());
	}
}
