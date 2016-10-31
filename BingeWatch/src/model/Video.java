package model;

import java.io.File;

import javafx.scene.image.ImageView;
import javafx.scene.media.Media;

public class Video {
	private Media media;
	private String titulo;
	private String descricao;
	private String path;
	private double duracaoSegundos;
	private Integer ano;
	private String categoria;
	private Integer faixaEtaria;
	private String diretor;
	private ImageView imagem;
	private String duracaoFormatada;
	
	public Video(String filePath){
		String path = new File(filePath).getAbsolutePath();
		media = new Media(new File(path).toURI().toString());
		imagem = new ImageView();
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
	public double getDuracaoSegundos() {
		return duracaoSegundos;
	}
	public void setDuracaoSegundos(double duracaoSegundos) {
		this.duracaoSegundos = duracaoSegundos;
		setDuracaoFormatada(duracaoSegundos);
	}
	public Integer getAno() {
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
	public Integer getFaixaEtaria() {
		return faixaEtaria;
	}
	public void setFaixaEtaria(int faixaEtaria) {
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

	public String getDuracaoFormatada() {
		return duracaoFormatada;
	}

	public void setDuracaoFormatada(double duracao) {
		Double horas ;
		Double minutos;
		Double segundos;
		
		horas = duracao / 60*60;
		duracao -= (horas*60*60);
		
		minutos = duracao/60;
		duracao -= minutos*60;
		
		segundos = duracao;
		
		duracaoFormatada = (horas.toString() + ":" + minutos.toString() + ":" + segundos.toString());
		
	}
}
