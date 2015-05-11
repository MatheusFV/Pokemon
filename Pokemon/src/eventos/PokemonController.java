package eventos;

import java.util.Random;
import java.util.Scanner;

import modelador.Ataque;
import modelador.Cenario;
import modelador.Pokemon;
import modelador.Treinador;

public class PokemonController extends Controller {
	Treinador player1 = new Treinador("Player1");
	Treinador player2 = new Treinador("Player2");
	Cenario cen = new Cenario();
	int lin = 8, col = 5;

	void ataque(Pokemon atacante, Pokemon atacado, Ataque atk) {
		atacante.Atacar(atacado, atk);
		if (atk.tipo == atacado.Fraqueza) {
			System.out.println("\nO ataque do " + atacante.Nome
					+ " teve um super efeito!");
		}
	}

	void criaPlayer() {
		System.out.println("Seja bem vindo ao Mundo Pokemon!");
		player1.escolhePokemon(scan);
	}

	void criaPlayers() {
		System.out.println("Sejam bem vindos a Batalha Pokemon multiplayer!");
		player1.escolhePokemons(scan);
		player2.escolhePokemons(scan);
	}

	private class Caminhando extends Event {

		public void action() {
			boolean encontrou;
			int movimento;
			encontrou = cen.printaCenario(lin, col);
			encontrou = false;
			while (encontrou == false) {
				System.out.println("Digite (8) para se mover para o norte!");
				System.out.println("Digite (2) para se mover para o sul!");
				System.out.println("Digite (6) para se mover para o leste!");
				System.out.println("Digite (4) para se mover para o oeste!");
				movimento = scan.nextInt();
				if (movimento == 8) {
					lin--;
					if (lin < 0) {
						lin = 15;
					}
					encontrou = cen.printaCenario(lin, col);
				} else if (movimento == 2) {
					lin++;
					if (lin > 15) {
						lin = 0;
					}
					encontrou = cen.printaCenario(lin, col);
				} else if (movimento == 6) {
					col++;
					if (col > 15) {
						col = 0;
					}
					encontrou = cen.printaCenario(lin, col);
				} else if (movimento == 4) {
					col--;
					if (col < 0) {
						col = 15;
					}
					encontrou = cen.printaCenario(lin, col);
				} else {
					System.out.println("Digitou errado, tente novamente!");
				}
			}
			cen.pokemon = cen.encontraPokemon();
			System.out.println("\n\nVoce encontrou um " + cen.pokemon.Nome
					+ ", o que deseja fazer?\n");
			addEvent(new Comandos3());
		}

		public String description() {
			return "";
		}

	}

	private class Comandos3 extends Event {

		public void action() {
			boolean um = false;
			int p1 = 0;
			Random rand = new Random();

			System.out.println("\n");
			System.out
					.println("----------------------------------------------------");
			System.out
					.println("|               Status dos Pokemons                |");
			System.out
					.println("----------------------------------------------------");
			System.out.println("Player1: " + player1.listaPokemon[0].Nome
					+ " hp = " + player1.listaPokemon[0].hp + ".");
			if (player1.nPokemons > 1) {
				System.out.println("         " + player1.listaPokemon[1].Nome
						+ " hp = " + player1.listaPokemon[1].hp + ".");
				if (player1.nPokemons > 2) {
					System.out.println("         "
							+ player1.listaPokemon[2].Nome + " hp = "
							+ player1.listaPokemon[2].hp + ".");
					if (player1.nPokemons > 3) {
						System.out.println("         "
								+ player1.listaPokemon[3].Nome + " hp = "
								+ player1.listaPokemon[3].hp + ".");
						if (player1.nPokemons > 4) {
							System.out.println("         "
									+ player1.listaPokemon[4].Nome + " hp = "
									+ player1.listaPokemon[4].hp + ".");
							if (player1.nPokemons > 5) {
								System.out.println("         "
										+ player1.listaPokemon[5].Nome
										+ " hp = " + player1.listaPokemon[5].hp
										+ ".\n");
							}
						}
					}
				}
			}
			System.out.println("");
			if (player1.nPokemons > 0) {
				while (um == false) {
					System.out.println("Player 1:");
					System.out.println("Digite 1 para atacar.");
					System.out.println("Digite 2 para trocar de pokemon.");
					System.out.println("Digite 3 para utilizar um item.");
					System.out.println("Digite 4 para fugir da batalha.");
					System.out.println("Digite 5 para jogar uma pokebola.");
					p1 = scan.nextInt();
					if (p1 != 3) {
						um = true;
					} else if (player1.nItens == 0) {
						System.out
								.println("Você não tem mais itens, escolha outra opção.");
					} else {
						um = true;
					}
				}
				if (p1 == 1) {
					addEvent(new AtacarSelvagem());
				} else if (p1 == 2) {
					addEvent(new trocarPokemon3());
				} else if (p1 == 3) {
					addEvent(new utilizaItem3());
				} else if (p1 == 4) {
					int num = rand.nextInt(100);
					if (num < 70) {
						System.out.println("Conseguiu fugir com segurança!");
						addEvent(new Caminhando());
					} else {
						System.out.println("Não conseguiu escapar!");
						ataque(cen.pokemon, player1.atual,
								cen.ataquePokemon(cen.pokemon));
						if (player1.atual.hp <= 0 && player1.nPokemons > 1) {
							System.out.println(player1.atual.Nome
									+ " morreu, troque de pokemon!");
							player1.modificaAtual(scan);
							addEvent(new Comandos3());
						} else if (player1.atual.hp <= 0
								&& player1.nPokemons <= 1) {
							System.out
									.println("Voce perdeu a batalha, seu pokemon terá a vida recuperada e voce poderá tentar novamente!");
							player1.atual.hp = player1.atual.maxHp;
							addEvent(new Caminhando());
						} else {
							addEvent(new Comandos3());
						}
					}
				} else if (p1 == 5) {
					addEvent(new jogarPokebola());
				}else{
					System.out.println("Digitou errado, tente novamente!");
					addEvent(new Comandos3());
				}
			}
		}

		public String description() {
			return "";
		}
	}

	private class AtacarSelvagem extends Event {

		public void action() {
			Pokemon um = player1.atual;
			Pokemon dois = cen.pokemon;
			System.out.println("Player1, escolha o ataque que o  "
					+ player1.atual.Nome + " utilizará:");
			Ataque atk = um.escolheAtaque();
			Ataque atksel = cen.ataquePokemon(cen.pokemon);
			if (atk.prioridade >= atksel.prioridade) {
				ataque(um, dois, atk);
				if (cen.pokemon.hp > 0) {
					ataque(dois, um, atksel);
				}
			} else {
				ataque(dois, um, atksel);
				if (um.hp > 0) {
					ataque(um, dois, atk);
				}
			}
			if (dois.hp <= 0) {
				System.out.println("Parabéns, voce derrotou o " + dois.Nome
						+ "!");
				addEvent(new Caminhando());
			}
			if (um.hp <= 0 && player1.nPokemons > 1) {
				System.out.println("O " + um.Nome
						+ " foi derrotado, escolha outro pokemon!");
				player1.modificaAtual(scan);
				addEvent(new Comandos3());
			} else if (um.hp <= 0 && player1.nPokemons <= 1) {
				System.out
						.println("Voce perdeu a batalha, seu pokemon terá a vida recuperada e voce poderá tentar novamente!");
				um.hp = um.maxHp;
				addEvent(new Caminhando());
			} else if (dois.hp > 0) {
				System.out.println("\n" + player1.atual.Nome + " tem "
						+ player1.atual.hp + "hp sobrando!\n");
				System.out.println(cen.pokemon.Nome + " tem " + cen.pokemon.hp
						+ "hp sobrando!");
				addEvent(new Comandos3());
			}

		}

		public String description() {
			return "\n";
		}

	}

	private class jogarPokebola extends Event {

		public void action() {
			Random rand = new Random();
			int hp = cen.pokemon.hp;
			int maxhp = cen.pokemon.maxHp;
			int pokebola = (maxhp) * rand.nextInt(maxhp * 2);
			if (player1.nPokebolas > 0) {
				if ((maxhp * hp) > pokebola) {
					System.out.println("Voce falhou em capturar o "
							+ cen.pokemon.Nome + "!");
					ataque(cen.pokemon, player1.atual,
							cen.ataquePokemon(cen.pokemon));
					if (player1.atual.hp > 0) {
						addEvent(new Comandos3());
					}
				} else {
					System.out.println("Voce conseguiu capturar o pokemon!");
					player1.addLista(cen.pokemon);
					addEvent(new Caminhando());
				}
				player1.nPokebolas--;
				if (player1.atual.hp <= 0 && player1.nPokemons > 1) {
					System.out.println("O " + player1.atual.Nome
							+ " foi derrotado, escolha outro pokemon!");
					player1.modificaAtual(scan);
				} else if (player1.atual.hp <= 0 && player1.nPokemons <= 1) {
					System.out
							.println("Voce perdeu a batalha, seu pokemon terá a vida recuperada e voce poderá tentar novamente!");
					player1.atual.hp = player1.atual.maxHp;
					addEvent(new Caminhando());
				} else {
				}
			} else {
				System.out.println("Voce nao tem mais pokebolas");
				addEvent(new Comandos3());
			}
		}

		public String description() {

			return "";
		}

	}

	private class Comandos extends Event {

		public void action() {
			boolean um = false;
			boolean dois = false;
			int p1 = 0, p2 = 0;

			System.out
					.println("----------------------------------------------------");
			System.out
					.println("|               Status dos Pokemons                |");
			System.out
					.println("----------------------------------------------------");
			System.out.println("Player1: " + player1.listaPokemon[0].Nome
					+ " hp = " + player1.listaPokemon[0].hp + ".");
			System.out.println("         " + player1.listaPokemon[1].Nome
					+ " hp = " + player1.listaPokemon[1].hp + ".");
			System.out.println("         " + player1.listaPokemon[2].Nome
					+ " hp = " + player1.listaPokemon[2].hp + ".");
			System.out.println("         " + player1.listaPokemon[3].Nome
					+ " hp = " + player1.listaPokemon[3].hp + ".");
			System.out.println("         " + player1.listaPokemon[4].Nome
					+ " hp = " + player1.listaPokemon[4].hp + ".");
			System.out.println("         " + player1.listaPokemon[5].Nome
					+ " hp = " + player1.listaPokemon[5].hp + ".");
			System.out
					.println("----------------------------------------------------");
			System.out.println("Player2: " + player2.listaPokemon[0].Nome
					+ " hp = " + player2.listaPokemon[0].hp + ".");
			System.out.println("         " + player2.listaPokemon[1].Nome
					+ " hp = " + player2.listaPokemon[1].hp + ".");
			System.out.println("         " + player2.listaPokemon[2].Nome
					+ " hp = " + player2.listaPokemon[2].hp + ".");
			System.out.println("         " + player2.listaPokemon[3].Nome
					+ " hp = " + player2.listaPokemon[3].hp + ".");
			System.out.println("         " + player2.listaPokemon[4].Nome
					+ " hp = " + player2.listaPokemon[4].hp + ".");
			System.out.println("         " + player2.listaPokemon[5].Nome
					+ " hp = " + player2.listaPokemon[5].hp + ".");
			System.out
					.println("----------------------------------------------------");
			System.out.println("\n");
			if (player1.nPokemons > 0 && player2.nPokemons > 0) {
				while (um == false) {
					System.out.println("Player 1:");
					System.out.println("Digite 1 para atacar.");
					System.out.println("Digite 2 para trocar de pokemon.");
					System.out.println("Digite 3 para utilizar um item.");
					System.out.println("Digite 4 para fugir da batalha.");
					p1 = scan.nextInt();
					if (p1 != 3) {
						um = true;
					} else if (player1.nItens == 0) {
						System.out
								.println("Você não tem mais itens, escolha outra opção.");
					} else {
						um = true;
					}
				}
				while (dois == false) {
					System.out.println("Player 2:");
					System.out.println("Digite 1 para atacar.");
					System.out.println("Digite 2 para trocar de pokemon.");
					System.out.println("Digite 3 para utilizar um item.");
					System.out.println("Digite 4 para fugir da batalha.");
					p2 = scan.nextInt();
					if (!(p2 == 3)) {
						dois = true;
					} else if (player2.nItens == 0) {
						System.out
								.println("Você não tem mais itens, escolha outra opção.");
					} else {
						dois = true;
					}
				}
				if (p2 > p1 && p2 != 4) {
					if (p2 == 2) {
						addEvent(new trocarPokemon2());
					} else if (p2 == 3) {
						addEvent(new utilizaItem2());
					}
					if (p1 == 1) {
						addEvent(new Atacar1());
					} else if (p1 == 2) {
						addEvent(new trocarPokemon1());
					} else if (p1 == 3) {
						addEvent(new utilizaItem1());
					}
					addEvent(new Comandos());
				} else if (p1 > p2 && p1 != 4) {
					if (p1 == 2) {
						addEvent(new trocarPokemon1());
					} else if (p1 == 3) {
						addEvent(new utilizaItem1());
					} else if (p1 == 4) {
						addEvent(null);
						System.out.println("Player 1 noob fugiu!");
					}
					if (p2 == 1) {
						addEvent(new Atacar2());
					} else if (p2 == 2) {
						addEvent(new trocarPokemon2());
					} else if (p2 == 3) {
						addEvent(new utilizaItem2());
					}
					addEvent(new Comandos());
				} else if (p2 == 4 && p1 == 4) {
					addEvent(null);
					System.out.println("Ambos os noobs fugiram!");
				} else if (p2 == 4) {
					addEvent(null);
					System.out.println("Player 2 noob fugiu!");
				} else if (p1 == 4) {
					addEvent(null);
					System.out.println("Player 1 noob fugiu!");

				}

				else {
					if (p1 == 1) {
						addEvent(new Atacar());
					} else if (p1 == 2) {
						addEvent(new trocarPokemon1());
						addEvent(new trocarPokemon2());
					} else if (p1 == 3) {
						addEvent(new utilizaItem1());
						addEvent(new utilizaItem2());
					}
					addEvent(new Comandos());
				}
			} else {
				addEvent(null);
			}

		}

		public String description() {
			return "";
		}

	}

	private class Atacar extends Event {

		public void action() {
			System.out.println("Player1, escolha o ataque que o  "
					+ player1.atual.Nome + " utilizará:");
			Ataque ataque1 = player1.atual.escolheAtaque();
			System.out.println("Player2, escolha o ataque que o  "
					+ player2.atual.Nome + " utilizará:");
			Ataque ataque2 = player2.atual.escolheAtaque();
			if (ataque1.prioridade > ataque2.prioridade) {
				ataque(player1.atual, player2.atual, ataque1);
				if (player2.atual.hp <= 0 && player2.nPokemons > 0) {
					player2.atual.hp = 0;
					player2.nPokemons--;
					System.out.println("O pokemon " + player2.atual.Nome
							+ " morreu, escolha outro pokemon.");
					player2.modificaAtual(scan);
				} else if (player2.atual.hp <= 0 && player2.nPokemons == 0) {
					System.out.println("Player2 perdeu a batalha!");
					System.out
							.println("Parabéns Player1, você é quase um mestre pokemon!");
				} else {
					ataque(player2.atual, player1.atual, ataque2);
					if (player1.atual.hp <= 0 && player1.nPokemons > 0) {
						player1.atual.hp = 0;
						player1.nPokemons--;
						System.out.println("O pokemon " + player1.atual.Nome
								+ " morreu, escolha outro pokemon.");
						player1.modificaAtual(scan);
					} else if (player1.atual.hp <= 0 && player1.nPokemons == 0) {
						System.out.println("Player1 perdeu a batalha!");
						System.out
								.println("Parabéns Player2, você é quase um mestre pokemon!");
					}
				}
			} else if (ataque1.prioridade < ataque2.prioridade) {
				ataque(player2.atual, player1.atual, ataque2);
				if (player1.atual.hp <= 0 && player1.nPokemons > 0) {
					player1.atual.hp = 0;
					player1.nPokemons--;
					System.out.println("O pokemon " + player1.atual.Nome
							+ " morreu, escolha outro pokemon.");
					player1.modificaAtual(scan);
				} else if (player1.atual.hp <= 0 && player1.nPokemons == 0) {
					System.out.println("Player1 perdeu a batalha!");
					System.out
							.println("Parabéns Player2, você é quase um mestre pokemon!");
				} else {
					ataque(player1.atual, player2.atual, ataque1);
					if (player2.atual.hp <= 0 && player2.nPokemons > 0) {
						player2.atual.hp = 0;
						player2.nPokemons--;
						System.out.println("O pokemon " + player2.atual.Nome
								+ " morreu, escolha outro pokemon.");
						player2.modificaAtual(scan);
					} else if (player2.atual.hp <= 0 && player2.nPokemons == 0) {
						System.out.println("Player2 perdeu a batalha!");
						System.out
								.println("Parabéns Player1, você é quase um mestre pokemon!");
					}
				}
			} else {
				if (player1.vez > player2.vez) {
					ataque(player1.atual, player2.atual, ataque1);
					if (player2.atual.hp <= 0 && player2.nPokemons > 0) {
						player2.atual.hp = 0;
						player2.nPokemons--;
						System.out.println("O pokemon " + player2.atual.Nome
								+ " morreu, escolha outro pokemon.");
						player2.modificaAtual(scan);
					} else if (player2.atual.hp <= 0 && player2.nPokemons == 0) {
						System.out.println("Player2 perdeu a batalha!");
						System.out
								.println("Parabéns Player1, você é quase um mestre pokemon!");
					} else {
						ataque(player2.atual, player1.atual, ataque2);
						if (player1.atual.hp <= 0 && player1.nPokemons > 0) {
							player1.atual.hp = 0;
							player1.nPokemons--;
							System.out.println("O pokemon "
									+ player1.atual.Nome
									+ " morreu, escolha outro pokemon.");
							player1.modificaAtual(scan);
						} else if (player1.atual.hp <= 0
								&& player1.nPokemons == 0) {
							System.out.println("Player1 perdeu a batalha!");
							System.out
									.println("Parabéns Player2, você é quase um mestre pokemon!");
						}
					}
					player1.vez = 0;
					player2.vez = 1;
				} else {
					ataque(player2.atual, player1.atual, ataque2);
					if (player1.atual.hp <= 0 && player1.nPokemons > 0) {
						player1.atual.hp = 0;
						player1.nPokemons--;
						System.out.println("O pokemon " + player1.atual.Nome
								+ " morreu, escolha outro pokemon.");
						player1.modificaAtual(scan);
					} else if (player1.atual.hp <= 0 && player1.nPokemons == 0) {
						System.out.println("Player1 perdeu a batalha!");
						System.out
								.println("Parabéns Player2, você é quase um mestre pokemon!");
					} else {
						ataque(player1.atual, player2.atual, ataque1);
						if (player2.atual.hp <= 0 && player2.nPokemons > 0) {
							player2.atual.hp = 0;
							player2.nPokemons--;
							System.out.println("O pokemon "
									+ player2.atual.Nome
									+ " morreu, escolha outro pokemon.");
							player2.modificaAtual(scan);
						} else if (player2.atual.hp <= 0
								&& player2.nPokemons == 0) {
							System.out.println("Player2 perdeu a batalha!");
							System.out
									.println("Parabéns Player1, você é quase um mestre pokemon!");
						}
					}
					player2.vez = 0;
					player1.vez = 1;
				}
			}
			System.out.println("\n" + player1.atual.Nome + " tem "
					+ player1.atual.hp + "hp sobrando!\n");
			System.out.println(player2.atual.Nome + " tem " + player2.atual.hp
					+ "hp sobrando!");
		}

		public String description() {
			return "";
		}

	}

	private class Atacar1 extends Event {

		public void action() {
			Pokemon um = player1.atual;
			Pokemon dois = player2.atual;
			System.out.println("Player1, escolha o ataque que o  "
					+ player1.atual.Nome + " utilizará:");
			Ataque atk = um.escolheAtaque();
			ataque(um, dois, atk);
			if (dois.hp <= 0 && player2.nPokemons > 0) {
				dois.hp = 0;
				player2.nPokemons--;
				System.out.println("O pokemon " + dois.Nome
						+ " morreu, escolha outro pokemon.");
				player2.modificaAtual(scan);
			} else if (dois.hp <= 0 && player2.nPokemons == 0) {
				System.out.println("Player2 perdeu a batalha!");
				System.out
						.println("Parabéns Player1, você é quase um mestre pokemon!");
			}
		}

		public String description() {
			return "\n" + player2.atual.Nome + " tem " + player2.atual.hp
					+ "hp sobrando!";
		}
	}

	private class Atacar2 extends Event {

		public void action() {
			Pokemon um = player1.atual;
			Pokemon dois = player2.atual;
			System.out.println("Player2, escolha o ataque que o  "
					+ player2.atual.Nome + " utilizará:");
			Ataque atk = dois.escolheAtaque();
			ataque(dois, um, atk);
			if (um.hp <= 0 && player1.nPokemons > 0) {
				um.hp = 0;
				player1.nPokemons--;
				System.out.println("O pokemon " + um.Nome
						+ " morreu, escolha outro pokemon.");
				player1.modificaAtual(scan);
			} else if (um.hp <= 0 && player1.nPokemons == 0) {
				System.out.println("Player1 perdeu a batalha!");
				System.out
						.println("Parabéns Player2, você é quase um mestre pokemon!");
			}
		}

		public String description() {

			return "\n" + player1.atual.Nome + " tem " + player1.atual.hp
					+ "hp sobrando!";
		}

	}

	private class trocarPokemon1 extends Event {
		public void action() {
			player1.modificaAtual(scan);
		}

		public String description() {
			return player1.atual.Nome + " vai!";
		}

	}

	private class trocarPokemon2 extends Event {
		public void action() {
			player2.modificaAtual(scan);
		}

		public String description() {
			return player2.atual.Nome + " vai!";
		}

	}

	private class trocarPokemon3 extends Event {
		public void action() {
			player1.modificaAtual(scan);
			ataque(cen.pokemon, player1.atual, cen.ataquePokemon(cen.pokemon));
			if (player1.atual.hp <= 0 && player1.nPokemons > 1) {
				System.out.println("O " + player1.atual.Nome
						+ " foi derrotado, escolha outro pokemon!");
				player1.modificaAtual(scan);
			}
			if (player1.atual.hp <= 0 && player1.nPokemons <= 1) {
				System.out
						.println("Voce perdeu a batalha, seu pokemon terá a vida recuperada e voce poderá tentar novamente!");
				player1.atual.hp = player1.atual.maxHp;
				addEvent(new Caminhando());
			} else {
				addEvent(new Comandos3());
			}
		}

		public String description() {
			return player1.atual.Nome + " vai!";
		}

	}

	private class utilizaItem1 extends Event {
		public void action() {
			player1.utilizaItem(scan);
		}

		public String description() {
			return "";
		}

	}

	private class utilizaItem2 extends Event {
		public void action() {
			player2.utilizaItem(scan);
		}

		public String description() {
			return "";
		}

	}

	private class utilizaItem3 extends Event {
		public void action() {
			player1.utilizaItem(scan);
			ataque(cen.pokemon, player1.atual, cen.ataquePokemon(cen.pokemon));
			if (player1.atual.hp <= 0 && player1.nPokemons > 1) {
				System.out.println("O " + player1.atual.Nome
						+ " foi derrotado, escolha outro pokemon!");
				player1.modificaAtual(scan);
			}
			if (player1.atual.hp <= 0 && player1.nPokemons <= 1) {
				System.out
						.println("Voce perdeu a batalha, seu pokemon terá a vida recuperada e voce poderá tentar novamente!");
				player1.atual.hp = player1.atual.maxHp;
				addEvent(new Caminhando());
			} else {
				addEvent(new Comandos3());
			}
		}

		public String description() {
			return "";
		}

	}

	public static void main(String[] args) {
		PokemonController pc = new PokemonController();
		Scanner scan = new Scanner(System.in);
		boolean end = false;
		while (end == false) {

			System.out
					.println("Voce quer jogar multiplayer(1) ou single player(2) ?");
			int resp = scan.nextInt();
			if (resp == 1) {
				pc.criaPlayers();
				pc.addEvent(pc.new Comandos());
				pc.run();
				end = true;
			} else if (resp == 2) {
				pc.criaPlayer();
				pc.addEvent(pc.new Caminhando());
				pc.run();
				end = true;
			} else {
				System.out.println("Digitou errado, tente novamente");
			}
		}
		scan.close();
	}

}
