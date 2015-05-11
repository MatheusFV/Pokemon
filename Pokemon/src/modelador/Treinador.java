package modelador;

import java.util.Scanner;

public class Treinador {
	public String nome;
	public int vez;
	public int nPokemons = 0;
	public Pokemon[] listaPokemon = new Pokemon[6];
	public Pokemon atual;
	public Item[] itens = new Item[5];
	public int nItens = 5;
	public int nPokebolas = 5;

	public Treinador(String nome) {
		this.nome = nome;
		this.itens[0] = new Item("super", 90);
		this.itens[1] = new Item("super", 90);
		this.itens[2] = new Item("super", 90);
		this.itens[3] = new Item("hyper", 180);
		this.itens[4] = new Item("hyper", 180);
	}

	public void addLista(Pokemon novo) {
		this.listaPokemon[this.nPokemons] = novo;
		this.nPokemons++;
	}

	public void modificaAtual(Scanner scan) {
		boolean vivo = false;
		int n = 0;
		System.out.println("\n" + this.nome + ", seus pokemons são: ");
		int i;
		for (i = 0; i < 6; i++) {
			if (i < this.nPokemons) {
				System.out.println(i + ". " + this.listaPokemon[i].Nome);
			}
		}
		while (vivo == false) {
			System.out
					.println("Digite o numero do pokemon que deseja escolher:");
			n = scan.nextInt();
			if (listaPokemon[n].hp > 0) {
				vivo = true;
			} else {
				System.out.println("Este pokemon está morto, escolha outro!");
			}
		}
		this.atual = this.listaPokemon[n];
	}

	public void utilizaItem(Scanner scan) {
		System.out.println("\n" + this.nome + ", seus itens são as pocoes: ");
		int i;
		int n = 0, x = 0;
		boolean curou = false;
		boolean disponivel = false;
		for (i = 0; i <= 4; i++) {
			if (this.itens[i].status == "Disponível") {
				System.out.println(i + ". " + this.itens[i].tipo + ", "
						+ this.itens[i].status);
			}
		}
		while (disponivel == false) {
			System.out.println("Digite o numero do item que deseja usar:");
			x = scan.nextInt();
			if (this.itens[x].status == "Disponível") {
				disponivel = true;
			} else {
				System.out
						.println("Este não é um item disponível, escolha outro.");
			}
		}
		System.out.println("\n" + this.nome + ", seus pokemons são: ");
		for (i = 0; i < 6; i++) {
			if (i < this.nPokemons) {
				System.out.println(i + ". " + this.listaPokemon[i].Nome);
			}
		}
		while (curou == false) {
			System.out
					.println("Digite o numero do pokemon em que deseja usar o item:");
			n = scan.nextInt();
			if (this.itens[x].status == "Disponível"
					&& this.listaPokemon[n].hp > 0) {
				this.itens[x].Curar(this.listaPokemon[n]);
				curou = true;
				this.nItens--;
			}
		}
		System.out.println("Hp do " + this.listaPokemon[n].Nome
				+ " restaurada para " + this.listaPokemon[n].hp);
	}

	public void escolhePokemon(Scanner scan) {
		Lista a = new Lista();

		System.out
				.println("\n" + this.nome + ", escolha seu primeiro Pokemon:");
		System.out.println("(1)Charmander");
		System.out.println("(2)Squirtle");
		System.out.println("(3)Bulbasaur");
		System.out.println("Digite o numero do Pokemon:");
		int p1 = scan.nextInt();

		if (p1 == 1)
			this.addLista(a.Charmander);
		else if (p1 == 2)
			this.addLista(a.Squirtle);
		else if (p1 == 3)
			this.addLista(a.Bulbasaur);

		System.out.println("\n" + this.nome + ", voce escolheu: "
				+ this.listaPokemon[0] + "!");
		this.atual = this.listaPokemon[0];

	}

	public void escolhePokemons(Scanner scan) {
		Lista a = new Lista();

		System.out.println("\n" + this.nome + ", escolha 1 Pokemon Forte:");
		System.out.println("(1)Charizard (5)Gyarados  (9)Zapdos");
		System.out.println("(2)Venusaur  (6)Lapras    (10)Machamp");
		System.out.println("(3)Muk       (7)Rhydon    (11)Dodrio");
		System.out.println("(4)Alakazam  (8)Dragonite");
		System.out.println("Digite o numero do Pokemon escolhido:");
		int p11 = scan.nextInt();
		if (p11 == 1)
			this.addLista(a.Charizard);
		else if (p11 == 2)
			this.addLista(a.Venusaur);
		else if (p11 == 3)
			this.addLista(a.Muk);
		else if (p11 == 4)
			this.addLista(a.Alakazam);
		else if (p11 == 5)
			this.addLista(a.Gyarados);
		else if (p11 == 6)
			this.addLista(a.Lapras);
		else if (p11 == 7)
			this.addLista(a.Rhydon);
		else if (p11 == 8)
			this.addLista(a.Dragonite);
		else if (p11 == 9)
			this.addLista(a.Zapdos);
		else if (p11 == 10)
			this.addLista(a.Machamp);
		else if (p11 == 11)
			this.addLista(a.Dodrio);

		System.out.println("\n" + this.nome + ", escolha 3 Pokemons Médios:");
		System.out.println("(1)Ponyta     (8)Exeggutor   (15)Rhyhorn");
		System.out.println("(2)Growlithe  (9)Dewgong     (16)Pidgeot");
		System.out.println("(3)Vaporeon   (10)Hitmonlee  (17)Golbat");
		System.out.println("(4)Golduck    (11)Hitmonchan (18)Kadabra");
		System.out.println("(5)Electrode  (12)Gloom      (19)MrMime");
		System.out.println("(6)Electabuzz (13)Arbok      (20)Dragonair");
		System.out.println("(7)Weepinbell (14)Dugtrio");
		System.out
				.println("Digite os 3 numeros dos Pokemons separados por espacos:");
		int p12 = scan.nextInt();
		int p13 = scan.nextInt();
		int p14 = scan.nextInt();

		if (p12 == 1)
			this.addLista(a.Ponyta);
		else if (p12 == 2)
			this.addLista(a.Growlithe);
		else if (p12 == 3)
			this.addLista(a.Vaporeon);
		else if (p12 == 4)
			this.addLista(a.Golduck);
		else if (p12 == 5)
			this.addLista(a.Electrode);
		else if (p12 == 6)
			this.addLista(a.Electabuzz);
		else if (p12 == 7)
			this.addLista(a.Weepinbell);
		else if (p12 == 8)
			this.addLista(a.Exeggutor);
		else if (p12 == 9)
			this.addLista(a.Dewgong);
		else if (p12 == 10)
			this.addLista(a.Hitmonlee);
		else if (p12 == 11)
			this.addLista(a.Hitmonchan);
		else if (p12 == 12)
			this.addLista(a.Gloom);
		else if (p12 == 13)
			this.addLista(a.Arbok);
		else if (p12 == 14)
			this.addLista(a.Dugtrio);
		else if (p12 == 15)
			this.addLista(a.Rhyhorn);
		else if (p12 == 16)
			this.addLista(a.Pidgeot);
		else if (p12 == 17)
			this.addLista(a.Golbat);
		else if (p12 == 18)
			this.addLista(a.Kadabra);
		else if (p12 == 19)
			this.addLista(a.MrMime);
		else if (p12 == 20)
			this.addLista(a.Dragonair);

		if (p13 == 1)
			this.addLista(a.Ponyta);
		else if (p13 == 2)
			this.addLista(a.Growlithe);
		else if (p13 == 3)
			this.addLista(a.Vaporeon);
		else if (p13 == 4)
			this.addLista(a.Golduck);
		else if (p13 == 5)
			this.addLista(a.Electrode);
		else if (p13 == 6)
			this.addLista(a.Electabuzz);
		else if (p13 == 7)
			this.addLista(a.Weepinbell);
		else if (p13 == 8)
			this.addLista(a.Exeggutor);
		else if (p13 == 9)
			this.addLista(a.Dewgong);
		else if (p13 == 10)
			this.addLista(a.Hitmonlee);
		else if (p13 == 11)
			this.addLista(a.Hitmonchan);
		else if (p13 == 12)
			this.addLista(a.Gloom);
		else if (p13 == 13)
			this.addLista(a.Arbok);
		else if (p13 == 14)
			this.addLista(a.Dugtrio);
		else if (p13 == 15)
			this.addLista(a.Rhyhorn);
		else if (p13 == 16)
			this.addLista(a.Pidgeot);
		else if (p13 == 17)
			this.addLista(a.Golbat);
		else if (p13 == 18)
			this.addLista(a.Kadabra);
		else if (p13 == 19)
			this.addLista(a.MrMime);
		else if (p13 == 20)
			this.addLista(a.Dragonair);

		if (p14 == 1)
			this.addLista(a.Ponyta);
		else if (p14 == 2)
			this.addLista(a.Growlithe);
		else if (p14 == 3)
			this.addLista(a.Vaporeon);
		else if (p14 == 4)
			this.addLista(a.Golduck);
		else if (p14 == 5)
			this.addLista(a.Electrode);
		else if (p14 == 6)
			this.addLista(a.Electabuzz);
		else if (p14 == 7)
			this.addLista(a.Weepinbell);
		else if (p14 == 8)
			this.addLista(a.Exeggutor);
		else if (p14 == 9)
			this.addLista(a.Dewgong);
		else if (p14 == 10)
			this.addLista(a.Hitmonlee);
		else if (p14 == 11)
			this.addLista(a.Hitmonchan);
		else if (p14 == 12)
			this.addLista(a.Gloom);
		else if (p14 == 13)
			this.addLista(a.Arbok);
		else if (p14 == 14)
			this.addLista(a.Dugtrio);
		else if (p14 == 15)
			this.addLista(a.Rhyhorn);
		else if (p14 == 16)
			this.addLista(a.Pidgeot);
		else if (p14 == 17)
			this.addLista(a.Golbat);
		else if (p14 == 18)
			this.addLista(a.Kadabra);
		else if (p14 == 19)
			this.addLista(a.MrMime);
		else if (p14 == 20)
			this.addLista(a.Dragonair);

		System.out.println("\n" + this.nome + ", escolha 2 Pokemons Fracos:");
		System.out.println("(1)Charmander (5)Jynx    (9)Butterfree");
		System.out.println("(2)Squirtle   (6)Machop  (10)Abra");
		System.out.println("(3)Pikachu    (7)Ekans   (11)Dratini");
		System.out.println("(4)Bulbasaur  (8)Diglett");
		System.out
				.println("Digite os numeros dos Pokemons separados por espaco:");
		int p15 = scan.nextInt();
		int p16 = scan.nextInt();

		if (p15 == 1)
			this.addLista(a.Charmander);
		else if (p15 == 2)
			this.addLista(a.Squirtle);
		else if (p15 == 3)
			this.addLista(a.Pikachu);
		else if (p15 == 4)
			this.addLista(a.Bulbasaur);
		else if (p15 == 5)
			this.addLista(a.Jynx);
		else if (p15 == 6)
			this.addLista(a.Machop);
		else if (p15 == 7)
			this.addLista(a.Ekans);
		else if (p15 == 8)
			this.addLista(a.Diglett);
		else if (p15 == 9)
			this.addLista(a.Butterfree);
		else if (p15 == 10)
			this.addLista(a.Abra);
		else if (p15 == 11)
			this.addLista(a.Dratini);

		if (p16 == 1)
			this.addLista(a.Charmander);
		else if (p16 == 2)
			this.addLista(a.Squirtle);
		else if (p16 == 3)
			this.addLista(a.Pikachu);
		else if (p16 == 4)
			this.addLista(a.Bulbasaur);
		else if (p16 == 5)
			this.addLista(a.Jynx);
		else if (p16 == 6)
			this.addLista(a.Machop);
		else if (p16 == 7)
			this.addLista(a.Ekans);
		else if (p16 == 8)
			this.addLista(a.Diglett);
		else if (p16 == 9)
			this.addLista(a.Butterfree);
		else if (p16 == 10)
			this.addLista(a.Abra);
		else if (p16 == 11)
			this.addLista(a.Dratini);

		System.out.println("\n" + this.nome + ", seus pokemons são: ");
		int i;
		for (i = 0; i < 6; i++) {
			System.out.println(i + ". " + this.listaPokemon[i].Nome);
		}
		this.atual = this.listaPokemon[5];
		System.out.println("Seu pokemon atual é: " + this.atual.Nome);
	}
}
