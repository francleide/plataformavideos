package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VideoPlayerController implements Initializable{
	
	@FXML
	private MediaView mediaView;
	private MediaPlayer mediaPlayer;
	private Media media;
	private Duration duration;
	
	@FXML
	private Slider volumeSlider;
	@FXML
	private Slider timeLine;
	@FXML
	private Label playTime;
	
	private static String path;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setRate(1);
		mediaView.setMediaPlayer(mediaPlayer);
		
		volumeSlider.setValue(mediaPlayer.getVolume() * 100);
		timeLine.setValue(mediaPlayer.getStartTime().toSeconds());
		
		initListeners();
		setLayout();
		
		mediaPlayer.play();
	}
	
	private void initListeners(){
		volumeSlider.valueProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable arg0) {
				mediaPlayer.setVolume(volumeSlider.getValue()/100);
				
			}
		});
		
		
		mediaPlayer.currentTimeProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                updateValues();
            }
        });
		
		mediaPlayer.setOnReady(new Runnable() {
            public void run() {
                duration = mediaPlayer.getMedia().getDuration();
                updateValues();
            }
        });
		
		timeLine.valueProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable arg0) {
				if (timeLine.isValueChanging()) {
		            	mediaPlayer.seek(duration.multiply(timeLine.getValue() / 100.0));
		            updateValues();
		       }
				
			}
		});
	}
	
	private String selectMedia(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Selecionar video");
		fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*.avi", "*.mp4"));
		File file = fileChooser.showOpenDialog(new Stage());
		if (file != null){
			try {
				return file.getAbsolutePath().toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	protected void updateValues() {
	    if (playTime != null && timeLine != null && volumeSlider != null && duration != null) {
	        Platform.runLater(new Runnable() {
	            public void run() {
	                Duration currentTime = mediaPlayer.getCurrentTime();
	                playTime.setText(formatTime(currentTime, duration));
	                timeLine.setDisable(duration.isUnknown());
	                if (!timeLine.isDisabled() && duration.greaterThan(Duration.ZERO) && !timeLine.isValueChanging()) {
	                	timeLine.setValue(currentTime.toMillis()/duration.toMillis() * 100.0);
	                }
	                if (!volumeSlider.isValueChanging()) {
	                    volumeSlider.setValue((int) Math.round(mediaPlayer.getVolume() * 100));
	                }
	            }
	        });
	    }
	}
	
	private static String formatTime(Duration elapsed, Duration duration) {
		   int intElapsed = (int)Math.floor(elapsed.toSeconds());
		   int elapsedHours = intElapsed / (60 * 60);
		   if (elapsedHours > 0) {
		       intElapsed -= elapsedHours * 60 * 60;
		   }
		   int elapsedMinutes = intElapsed / 60;
		   int elapsedSeconds = intElapsed - elapsedHours * 60 * 60 
		                           - elapsedMinutes * 60;
		 
		   if (duration.greaterThan(Duration.ZERO)) {
		      int intDuration = (int)Math.floor(duration.toSeconds());
		      int durationHours;
		      int durationMinutes;
		      int durationSeconds;
		      
		      durationHours = intDuration / (60 * 60);
		      intDuration -= durationHours * 60 * 60;
		      
		      durationMinutes = intDuration / 60;
		      intDuration -= durationMinutes * 60;
		      
		      durationSeconds = intDuration;
		      
		      if (durationHours > 0) {
		         return String.format("%d:%02d:%02d/%d:%02d:%02d", 
		            elapsedHours, elapsedMinutes, elapsedSeconds,
		            durationHours, durationMinutes, durationSeconds);
		      } else {
		          return String.format("%02d:%02d/%02d:%02d",
		            elapsedMinutes, elapsedSeconds,durationMinutes, 
		                durationSeconds);
		      }
		      } else {
		          if (elapsedHours > 0) {
		             return String.format("%d:%02d:%02d", elapsedHours, 
		                    elapsedMinutes, elapsedSeconds);
		            } else {
		                return String.format("%02d:%02d",elapsedMinutes, 
		                    elapsedSeconds);
		            }
		        }
		    }
	
	public void fechar(ActionEvent event){
		mediaPlayer.stop();
		Stage stage = (Stage) volumeSlider.getScene().getWindow();
	    stage.close();
	}
	
	public void setLayout()
	{
		DoubleProperty width = mediaView.fitWidthProperty();
		DoubleProperty height = mediaView.fitHeightProperty();
		
		width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
	}
	
	public void play(ActionEvent event){
		mediaPlayer.play();
	}
	public void pause(ActionEvent event){
		mediaPlayer.pause();
		
	}
	public void stop(ActionEvent event){
		mediaPlayer.stop();
	}
	public void reload(ActionEvent event){
		mediaPlayer.seek(mediaPlayer.getStartTime());
		mediaPlayer.play();
	}

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		VideoPlayerController.path = path;
	}
}
