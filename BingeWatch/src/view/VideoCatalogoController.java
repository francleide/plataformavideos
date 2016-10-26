package view;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Video;

public class VideoCatalogoController implements Initializable{

	@FXML
	private GridPane catalogoGrid;
	
	private HashMap<String, Video> catalogoImages;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
