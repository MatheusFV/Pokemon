package Modeladores;

import java.util.Random;

public class Pokemon {
	String nome;
	String tipo;
	String fraqueza;
	int hp;
	int power;
	Ataque [] ataques = new Ataque[4];
	int nataques = 0;

	public Pokemon(String nome,String tipo,String fraqueza,int hp,int power,
			Ataque ataque1,Ataque ataque2,Ataque ataque3,Ataque ataque4){
		this.nome = nome;
		this.tipo = tipo;
		this.hp = hp;
		this.power = power;
		this.fraqueza = fraqueza;
		this.ataques[0] = ataque1;
		this.ataques[1] = ataque2;
		this.ataques[2] = ataque3;
		this.ataques[3] = ataque4;
	}
	
	void levaDano(int dano){
		this.hp -= dano;
	}
	
	void atacar(Pokemon pokemon,Ataque ataque){
		Random rn = new Random();
		pokemon.levaDano((int)((ataque.dano + this.power)*((rn.nextDouble()/0.5) + 0.8)));
		if (pokemon.fraqueza == this.tipo){
			pokemon.levaDano(ataque.dano);
		}
	}

}
