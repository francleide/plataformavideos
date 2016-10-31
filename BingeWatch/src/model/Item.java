package model;

public enum Item {
	Serie(0),
	Filme(1),
	Epsodio(2),
	Video(3);
	
	private final int valor;
	Item(int valorOpcao){
		valor = valorOpcao;
	}
	public int getValor(){
		return valor;
	}
}
