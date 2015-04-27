package Modeladores;

public class Treinador {
	String nome;
	Pokemon [] pokemons= new Pokemon[6];	
	Itens itens = new Itens();
	int nvivos = 6;
	public Treinador (String nome,Pokemon um,Pokemon dois,Pokemon tres,Pokemon d, Pokemon e, Pokemon f){
		this.nome = nome;
		this.pokemons[0] = um;
		this.pokemons[1] = dois;
		this.pokemons[2] = tres;
		this.pokemons[3] = d;
		this.pokemons[4] = e;
		this.pokemons[5] = f;
	}
}
