package view;

import java.io.IOException;
import java.util.HashMap;

import controller.VideoPlayerController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Video;

public class VideoCatalogoController extends Application{

	
	private Stage stage;
	
	private SplitPane splitMain;
	private SplitPane splitCatalogo;
	private AnchorPane leftPane, rightPane, upperPane, lowerPane;
	private VBox detalhesBox;
	
	private ImageView logoBW;
	
	private Button btnCadastrar;
	private Button btnReproduzir;
	
	private static Label titulo, ano, faixaEtaria;
	
	private ScrollPane scrollFilmes;
	private static TilePane tileFilmes;
	
	private static Video selectedVideo;
	
	private static HashMap<ImageView, Video> hashVideos = new HashMap<ImageView, Video>();
	
	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		
		splitMain = new SplitPane();
		splitCatalogo = new SplitPane();
		scrollFilmes = new ScrollPane();
		tileFilmes = new TilePane();
		
		btnCadastrar = new Button("Cadastrar Conteúdo");
		btnReproduzir = new Button("Reproduzir");
		logoBW = new ImageView("images/logoBW.png");
		
		titulo = new Label("");
		ano = new Label("");
		faixaEtaria = new Label("");
		
		detalhesBox = new VBox();
		initListeners();
		initLayout();
		
		scrollFilmes.setContent(tileFilmes);
		
		leftPane = new AnchorPane();
		rightPane = new AnchorPane();
		
		leftPane.getChildren().addAll(scrollFilmes);
		leftPane.setPrefWidth(600);
		scrollFilmes.prefWidthProperty().bind(leftPane.widthProperty());
		
		detalhesBox.getChildren().addAll(titulo, ano, faixaEtaria, btnReproduzir);
		rightPane.getChildren().addAll(detalhesBox);
		rightPane.setPrefWidth(200);
		rightPane.setMinWidth(200);
		splitCatalogo.getItems().addAll(leftPane, rightPane);
		 upperPane = new AnchorPane();
		 lowerPane = new AnchorPane();
		
		upperPane.setMinHeight(100);
		upperPane.setMaxHeight(100);
		upperPane.getChildren().addAll(logoBW, btnCadastrar);
		
		upperPane.setMinWidth(800);
		upperPane.setPrefWidth(800);
		lowerPane.getChildren().addAll(splitCatalogo);
		lowerPane.setPrefWidth(800);
		lowerPane.setMinWidth(800);
		lowerPane.setPrefHeight(600);
		splitMain.getItems().addAll(upperPane, lowerPane);
		
        stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        stage.setHeight(Screen.getPrimary().getVisualBounds()
                .getHeight());
        Scene scene = new Scene(splitMain);
        stage.setScene(scene);
        stage.show();
	}
	
	public void initListeners(){
		btnCadastrar.setOnAction(new EventHandler<ActionEvent>(){
	        
				@Override
				public void handle(ActionEvent arg0) {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadastrarVideo.fxml"));
		            Parent root1;
					try {
						root1 = (Parent) fxmlLoader.load();
						Stage stage = new Stage();
			            stage.initModality(Modality.APPLICATION_MODAL);
			            stage.initStyle(StageStyle.UNDECORATED);
			            stage.setTitle("Cadastrar Vídeo");
			            stage.setScene(new Scene(root1));  
			            stage.show();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
				}
		});
		
		btnReproduzir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				reproduzirVideo(selectedVideo.getPath());
				
			}
			
		});
	}
	
	public void reproduzirVideo(String filePath){
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VideoPlayer.fxml"));
			VideoPlayerController.setPath(filePath);
			Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.initModality(Modality.APPLICATION_MODAL);
	        stage.initStyle(StageStyle.UNDECORATED);
	        stage.setTitle("Reproduzir Vídeo");
	        stage.setScene(new Scene(root1));  
	        
	        stage.show();
	        
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public void initLayout(){
		//SPLIT CABEÇALHO X CONTEÚDO
		splitMain.setOrientation(Orientation.VERTICAL);
		splitMain.setDividerPositions(0.1725);
		splitMain.setPrefHeight(600);
		splitMain.setMinHeight(600);
		splitMain.setPrefWidth(800);
		splitMain.setMinWidth(800);
		
		//SPLIT CATALGO X DETALHES
		splitCatalogo.setOrientation(Orientation.HORIZONTAL);
		splitCatalogo.setDividerPositions(0.759);
		splitCatalogo.prefWidthProperty().bind(splitMain.widthProperty());
		splitCatalogo.setPrefHeight(500);
		//LOGO
		logoBW.setFitHeight(89);
		logoBW.setFitWidth(134);
		logoBW.setLayoutX(10);
		logoBW.setLayoutY(10);
		
		//Botão Cadastrar
		btnCadastrar.setLayoutY(10);
		btnReproduzir.setLayoutY(10);
		btnReproduzir.setLayoutX(200);
		
		//SCROLL FILMES
		scrollFilmes.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		scrollFilmes.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Vertical scroll bar
		scrollFilmes.setFitToWidth(true);
		scrollFilmes.prefHeightProperty().bind(splitCatalogo.heightProperty());
		
		//TILE FILMES
		tileFilmes.setPadding(new Insets(15, 15, 15, 15));
		tileFilmes.setHgap(15);
		tileFilmes.setVgap(15);
	}
	
	public static void updateCatalogo(){
		tileFilmes.getChildren().clear();
        tileFilmes.getChildren().addAll(hashVideos.keySet());
	}
	public static void main(String[] args) {
		launch(args);
	}

	public static HashMap<ImageView, Video> getHashVideos() {
		return hashVideos;
	}

	public static void setHashVideos(HashMap<ImageView, Video> hashVideos) {
		VideoCatalogoController.hashVideos = hashVideos;
	}

	public static TilePane getTileFilmes() {
		return tileFilmes;
	}

	public static void setTileFilmes(TilePane tileFilmes) {
		VideoCatalogoController.tileFilmes = tileFilmes;
	}

	public static Video getSelectedVideo() {
		return selectedVideo;
	}

	public static void setSelectedVideo(Video selectedVideo) {
		VideoCatalogoController.selectedVideo = selectedVideo;
		titulo.setText(VideoCatalogoController.selectedVideo.getTitulo());
		ano.setText(VideoCatalogoController.selectedVideo.getAno().toString());
		faixaEtaria.setText(VideoCatalogoController.selectedVideo.getFaixaEtaria().toString());
	}

	public static Label getTitulo() {
		return titulo;
	}

	public static void setTitulo(Label titulo) {
		VideoCatalogoController.titulo = titulo;
	}

	public static Label getAno() {
		return ano;
	}

	public static void setAno(Label ano) {
		VideoCatalogoController.ano = ano;
	}

	public static Label getFaixaEtaria() {
		return faixaEtaria;
	}

	public static void setFaixaEtaria(Label faixaEtaria) {
		VideoCatalogoController.faixaEtaria = faixaEtaria;
	}
}