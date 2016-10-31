package model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
    @Id
    private String login;
    @Column
    private String nome;
    
    @Column(nullable=false)
    private String senha;
    @Column(nullable=false)
    private LocalDate idade;
    @Column(nullable=false)
    private String permissao;
    @OneToMany(mappedBy="usuario")
    private List<Favorito> favoritos;
    @OneToMany(mappedBy="usuario")
    private List<Assistido> assistidos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getIdade() {
        return idade;
    }

    public void setIdade(LocalDate idade) {
        this.idade = idade;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public List<Favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<Favorito> favoritos) {
        this.favoritos = favoritos;
    }

    public List<Assistido> getAssistidos() {
        return assistidos;
    }

    public void setAssistidos(List<Assistido> assistidos) {
        this.assistidos = assistidos;
    }
    public StringProperty getNomeProperty() {
        return new SimpleStringProperty(this.getNome());
    }
    public StringProperty getLoginProperty() {
        return new SimpleStringProperty(this.getLogin());
    }
    public StringProperty getPermissaoProperty() {
        return new SimpleStringProperty(this.getPermissao());
    }
    public ObjectProperty<LocalDate> getLocalDate() {
        return new SimpleObjectProperty<>(this.getIdade());
    }
    public Usuario (String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;    
        this.idade = LocalDate.now();
        this.permissao = "user";
    }
    
    public Usuario (){
            this(null, null, null);
    }

}
