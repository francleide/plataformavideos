package model;

import java.io.File;

import javafx.scene.media.Media;

public class Video {
	private Media media;
	private String titulo;
	private String descricao;
	private String path;
	private int duracaoSegundos;
	private int ano;
	private String categoria;
	private String faixaEtaria;
	private String diretor;
	
	public Video(String filePath, String titulo){
		String path = new File(filePath).getAbsolutePath();
		media = new Media(new File(path).toURI().toString());
		this.titulo = titulo;
	}
	
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
}
