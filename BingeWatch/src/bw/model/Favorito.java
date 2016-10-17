package bw.model;

public class Favorito {
	
private int id;
private Item item;

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
	
}
