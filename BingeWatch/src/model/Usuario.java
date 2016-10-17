package bw.model;
import java.util.ArrayList;

import java.util.Date;
import java.time.LocalDate;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Usuario {
	private StringProperty login;
	private StringProperty senha;
	private ObjectProperty<LocalDate> idade;
	private boolean permissao;
	private ObservableList<Favorito> favoritos;
	private ObservableList<Assistido> assistidos;

	public ObservableList<Favorito> getFavoritos() {
		return favoritos;
	}


	public ObservableList<Assistido> getAssistidos() {
		return assistidos;
	}


	public void setAssistidos(Assistido assistido,boolean play ) {
		if(play == true)
		this.assistidos.add(assistido);
	}

	public void setFavoritos(Favorito favorito, boolean favoritado) {
		if(favoritado==true){
			this.favoritos.add(favorito);
		}
	
	}

	public StringProperty getLogin() {
		return login;
	}


	public void setLogin(StringProperty login) {
		this.login = login;
	}


	public StringProperty getSenha() {
		return senha;
	}


	public void setSenha(StringProperty senha) {
		this.senha = senha;
	}


	public ObjectProperty<LocalDate> getIdade() {
		return idade;
	}


	public void setIdade(ObjectProperty<LocalDate> idade) {
		this.idade = idade;
	}


	public boolean isPermissao() {
		return permissao;
	}


	public void setPermissao(boolean permissao) {
		this.permissao = permissao;
	}
	

	public Usuario (String login, String senha){
		this.login = new SimpleStringProperty(login);
		this.senha = new SimpleStringProperty(senha);
		this.idade = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
		this.permissao = false;
	}
	public Usuario (){
		this(null, null);
	}

}
