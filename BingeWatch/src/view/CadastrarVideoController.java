package view;

import java.io.File;
import java.io.FileInputStream;

import controller.VideoPlayerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
	
	@FXML private Button btnEscolherImagem;
	
	@FXML private ImageView imgPreview;
	
	@FXML private TextField videoPath;
	@FXML private TextField txtTitulo;
	@FXML private TextField txtAno;
	@FXML private TextField txtCategoria;
	@FXML private TextField txtFaixaEtaria;
	
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
				videoPath.setText(file.getName());
				video = new Video(filePath);
				video.setDuracaoSegundos(video.getMedia().getDuration().toSeconds());
				video.setPath(file.getAbsolutePath().toString());
				video.setImagem(imgPreview);
				labelDuration.setText(video.getDuracaoFormatada());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void selectImage(){
		if(video != null){
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Selecionar img");
			fileChooser.getExtensionFilters().addAll(
	                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg" ));
			File file = fileChooser.showOpenDialog(new Stage());
			if (file != null){
				try {
					imgPreview.setImage(new Image(new FileInputStream(file), 250, 0, true,
		                    true));
					imgPreview.setFitHeight(200);
					imgPreview.setFitWidth(250);
					video.setImagem(imgPreview);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			Alert alert = new Alert(AlertType.ERROR, "Selecione um v�deo primeiro!", ButtonType.CLOSE);
			alert.show();
		}
	}
	
	public void cancelar(){
		filePath = new String();
		videoPath.clear();
		Stage stage = (Stage) btnCancelar.getScene().getWindow();
	    stage.close();
		
	}
	
	public void confirmar(){
		boolean temErro = hasInvalidFields();
		if(!temErro){
			video.setTitulo(txtTitulo.getText());
			try{
				video.setAno(Integer.parseInt(txtAno.getText()));
				video.setFaixaEtaria(Integer.parseInt(txtFaixaEtaria.getText()));
				video.setCategoria(txtCategoria.getText());
				
				video.getImagem().setOnMouseClicked(e->VideoCatalogoController.setSelectedVideo(video));
				VideoCatalogoController.getHashVideos().put(video.getImagem(), video);
		        VideoCatalogoController.updateCatalogo();
		        Stage stage = (Stage) btnCadastrar.getScene().getWindow();
			    stage.close();
			}catch (NumberFormatException e){
				Alert alert = new Alert(AlertType.ERROR, "Os campos 'Ano' e 'Faixa et�ria' devem ser n�meros inteiros");
				alert.show();
			}
		}
	}
	
	public boolean hasInvalidFields(){
		boolean error = false;
		Alert alert = new Alert(AlertType.ERROR);
		alert.getButtonTypes().setAll(ButtonType.OK);
		
		if (txtTitulo.getText().isEmpty() || txtTitulo.getText().trim().equals("")){
			alert.setContentText("Preencha o campo de t�tulo!");
			error = true;
		}
			
		else if (txtAno.getText().isEmpty() || txtTitulo.getText().trim().equals("")){
			alert.setContentText("Preencha o ano!");
			error = true;
		}
		else if (txtCategoria.getText().isEmpty() || txtTitulo.getText().trim().equals("")){
			alert.setContentText("Preencha a categoria!");
			error = true;
		}
		else if (txtFaixaEtaria.getText().isEmpty() || txtTitulo.getText().trim().equals("")){
			alert.setContentText("Preencha a faixa et�ria!");
			error = true;
		}
		else if(video.getImagem() == null){
			alert.setContentText("Selecione uma imagem!");
			error = true;
		}
		
		if (error)
			alert.show();
		
		return error;
		
	}
		
	public void getMediaInfo(){
		video = new Video(filePath);
		//labelDuration.setText(video.getMedia().getDuration().toString());
	}
}