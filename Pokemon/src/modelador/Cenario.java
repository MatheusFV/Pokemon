package modelador;

import java.util.Random;

public class Cenario {

	public Pokemon pokemon;
	Random rand = new Random();
	int matriz[][] = new int[16][16];
	
	public Cenario(){
		this.criaMatriz();
	}

	void criaMatriz() {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (i < 8 && j < 8)
					this.matriz[i][j] = 1;
				else if (i < 8 && j > 7)
					this.matriz[i][j] = 0;
				else if (i > 7 && j < 8)
					this.matriz[i][j] = 0;
				else if (i > 7 && j > 7)
					this.matriz[i][j] = 1;
			}
		}
	}

	public boolean printaCenario(int nLin, int nCol) {

		System.out
				.println("  -----------------------------------------------------------------");
		for (int i = 0; i < 16; i++) {
			System.out.printf("  |");
			for (int j = 0; j < 16; j++) {
				if (this.matriz[i][j] == 1){
					if (i == nLin && j == nCol) {
						System.out.printf(" * |");
					}else {
						System.out.printf(" ^ |");
					}
				}
				else if (this.matriz[i][j] == 0){
					if (i == nLin && j == nCol) {
						System.out.printf(" * |");
					} else {
						System.out.printf("   |");
					}
				}
			}
			System.out.print("\n");
		}
		System.out
				.println("  -----------------------------------------------------------------");
		if (this.matriz[nLin][nCol] == 1) {
			int a = rand.nextInt(100);
			if (a < 30) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public Pokemon encontraPokemon() {
		int num = rand.nextInt(10);
		Lista lista = new Lista();

		if (num == 0) {
			return lista.Abra;
		} else if (num == 1) {
			return lista.Bulbasaur;
		} else if (num == 2) {
			return lista.Butterfree;
		} else if (num == 3) {
			return lista.Charmander;
		} else if (num == 4) {
			return lista.Diglett;
		} else if (num == 5) {
			return lista.Dratini;
		} else if (num == 6) {
			return lista.Ekans;
		} else if (num == 7) {
			return lista.Jynx;
		} else if (num == 8) {
			return lista.Machop;
		} else if (num == 9) {
			return lista.Pikachu;
		} else {
			return lista.Squirtle;
		}
	}

	public Ataque ataquePokemon(Pokemon pokemon) {
		int num = rand.nextInt(3);
		return pokemon.ataques[num];
	}
}
