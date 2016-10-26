package model;

import java.io.File;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;

public class Video {
	private Media media;
	private StringProperty titulo;
	private String descricao;
	private String path;
	private int duracaoSegundos;
	private int ano;
	private String categoria;
	private String faixaEtaria;
	private String diretor;
	private ImageView imagem;
	
	public Video(String filePath, String titulo){
		String path = new File(filePath).getAbsolutePath();
		media = new Media(new File(path).toURI().toString());
		this.titulo = new SimpleStringProperty(titulo);
		imagem = new ImageView();
	}
	
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	public String getTitulo() {
		return titulo.get();
	}
	public StringProperty tituloProperty() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo.set(titulo);
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getDuracaoSegundos() {
		return duracaoSegundos;
	}
	public void setDuracaoSegundos(int duracaoSegundos) {
		this.duracaoSegundos = duracaoSegundos;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getFaixaEtaria() {
		return faixaEtaria;
	}
	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ImageView getImagem() {
		return imagem;
	}

	public void setImagem(ImageView imagem) {
		this.imagem = imagem;
	}
}
