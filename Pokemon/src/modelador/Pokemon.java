package modelador;

import java.util.Scanner;

public class Pokemon {
	public String Nome;
	public String Tipo;
	public String Fraqueza;
	public Ataque[] ataques = new Ataque[4];
	public int hp;
	public int maxHp;
	public int attack;
	
	Scanner scan = new Scanner(System.in);

	public Pokemon(String Nome, String Tipo, String Fraqueza, int hp,
			int attack, Ataque at0, Ataque at1, Ataque at2, Ataque at3) {
		this.Nome = Nome;
		this.Tipo = Tipo;
		this.Fraqueza = Fraqueza;
		this.hp = hp;
		this.maxHp = hp;
		this.attack = attack;
		this.ataques[0] = at0;
		this.ataques[1] = at1;
		this.ataques[2] = at2;
		this.ataques[3] = at3;
	}

	public Ataque escolheAtaque() {
		for (int a = 0; a < 100; a++) {
			System.out.println(this.ataques[0].Nome + " = 0");
			System.out.println(this.ataques[1].Nome + " = 1");
			System.out.println(this.ataques[2].Nome + " = 2");
			System.out.println(this.ataques[3].Nome + " = 3");
			int atk = scan.nextInt();
			if (atk == 0) {
				return this.ataques[0];
			} else if (atk == 1) {
				return this.ataques[1];
			} else if (atk == 2) {
				return this.ataques[2];
			} else if (atk == 3) {
				return this.ataques[3];
			}
			System.out.println(atk + " este não é um numero válido, tente novamente!");
		}
		System.out.println("Caraca, voce conseguiu errar 100 vezes! Perdeu o jogo!");
		return null;
	}

	public void Atacar(Pokemon adversario, Ataque ataque) {

		adversario.hp -= this.attack + ataque.dano;
		if (adversario.hp < 0){
			adversario.hp = 0;
		}
		if (adversario.Fraqueza == ataque.tipo){
			adversario.hp -= ataque.dano;
		}
	}
}
