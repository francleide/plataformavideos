package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Favorito {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Column
private Item item;
@ManyToOne
private Usuario usuario;

    public Favorito(int id,Item item){
            this.id=id;
            this.item=item;
    }
    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }
    public Object getItem() {
            return item;
    }
    public void setItem(Item item) {
            this.item = item;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
	
}
