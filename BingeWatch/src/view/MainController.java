package view;

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
import javafx.util.Duration;

public class MainController implements Initializable{
	
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String path = new File("D:/Vídeos/RuPauls.Drag.Race.All.Stars.S02E02.1080p.WEBRip-AKU.mp4").getAbsolutePath();
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setRate(1);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		volumeSlider.setValue(mediaPlayer.getVolume() * 100);
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
		
		//timeLine.setMax(mediaPlayer.getTotalDuration().toSeconds());
		timeLine.setValue(mediaPlayer.getStartTime().toSeconds());
		timeLine.valueProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable arg0) {
				if (timeLine.isValueChanging()) {
		            	mediaPlayer.seek(duration.multiply(timeLine.getValue() / 100.0));
		            updateValues();
		       }
				
			}
		});
		setLayout();
		
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
		      int durationHours = intDuration / (60 * 60);
		      if (durationHours > 0) {
		         intDuration -= durationHours * 60 * 60;
		      }
		      int durationMinutes = intDuration / 60;
		      int durationSeconds = intDuration - durationHours * 60 * 60 - 
		          durationMinutes * 60;
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
}
