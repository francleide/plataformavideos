package model;

public class Assistido {
	private int id;
	private Item item;
	public Assistido(int id,Item item){
		this.id=id;
		this.item=item;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
}
