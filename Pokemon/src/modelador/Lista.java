package modelador;

public class Lista {
	//Cria ataques
	
	//Tipo: Normal
	Ataque bodyslam   = new Ataque("Body Slam", "Normal", 3, 85);
	Ataque dizzypunch = new Ataque("Dizzy Punch", "Normal", 5, 70);
	Ataque doubleedge = new Ataque("Double Edge", "Normal", 1, 120);
	//Tipo: Fogo
	Ataque blastburn  = new Ataque("Blast Burn","Fogo", 1, 150);
	Ataque flamethower= new Ataque("Flamethower", "Fogo", 2, 95);
	//Tipo: Agua
	Ataque bubblebeam = new Ataque("Bubblebeam", "Agua", 4, 80);
	Ataque surf       = new Ataque("Surf", "Agua", 3, 95);
	//Tipo: Eletrico
	Ataque thunderbolt= new Ataque("Thunderbolt", "Eletrico", 3, 95);
	Ataque thunder    = new Ataque("Thunder", "Eletrico", 2, 120);
	//Tipo: Planta
	Ataque razorleaf  = new Ataque("Razor Leaf", "Planta", 4, 90);
	Ataque solarbeam  = new Ataque("Solarbeam", "Planta", 2, 120);
	//Tipo: Gelo
	Ataque icebeam    = new Ataque("Ice Beam", "Gelo", 3, 95);
	Ataque blizzard   = new Ataque("Blizzard", "Gelo", 2, 120);
	//Tipo: Lutador
	Ataque superpower = new Ataque("Superpower", "Lutador", 2, 120);
	Ataque machpunch  = new Ataque("Mach Punch", "Lutador", 5, 80);
	//Tipo: Venenoso
	Ataque sludgebomb = new Ataque("Sludge Bomb", "Venenoso", 4, 90);
	Ataque acid       = new Ataque("Acid", "Venenoso", 5, 70);
	//Tipo: Terrestre
	Ataque earthquake = new Ataque("Earthquake", "Terrestre", 3, 100);
	Ataque dig        = new Ataque ("Dig", "Terrestre", 5, 70);
	//Tipo: Voador
	Ataque fly        = new Ataque("Fly", "Voador", 3, 90);
	Ataque skyattack  = new Ataque("Sky Attack", "Voador", 1, 140);
	//Tipo: Psiquico
	Ataque psychic    = new Ataque("Psychic", "Psiquico", 5, 90);
	Ataque psychoboost= new Ataque("Psycho Boost", "Psiquico", 2, 140);
	//Tipo: Dragao
	Ataque outrage    = new Ataque("Outrage", "Dragao", 4, 90);
	Ataque dragonclaw = new Ataque("Dragon Claw", "Dragao", 2, 80);
	
	//Cria Pokemons
	
	//Fortes
	Pokemon Charizard = new Pokemon("Charizard", "Fogo", "Agua", 534, 84, 
								blastburn, flamethower, bodyslam, fly);
	Pokemon Gyarados  = new Pokemon("Gyarados", "Agua", "Eletrico", 540, 95,
								bubblebeam, surf, dizzypunch, fly);
	Pokemon Zapdos    = new Pokemon("Zapdos", "Eletrico", "Gelo", 580, 90, 
								thunderbolt, thunder, skyattack, dizzypunch);
	Pokemon Venusaur  = new Pokemon("Venusaur", "Planta", "Voador", 525, 85,
								razorleaf, solarbeam, acid, sludgebomb);
	Pokemon Lapras    = new Pokemon("Lapras", "Gelo", "Lutador", 535, 85,
								bubblebeam, icebeam, blizzard, surf);
	Pokemon Machamp   = new Pokemon("Machamp", "Lutador", "Psiquico", 520, 90,
								superpower, machpunch, bodyslam, dizzypunch);
	Pokemon Muk       = new Pokemon("Muk", "Venenoso", "Terrestre", 520, 100, 
								sludgebomb, acid, bodyslam, dizzypunch);
	Pokemon Rhydon    = new Pokemon("Rhydon", "Terrestre", "Lutador", 510, 90,
								earthquake, dig, doubleedge, bodyslam);
	Pokemon Dodrio    = new Pokemon("Dodrio", "Voador", "Eletrico", 510, 90,
								fly, skyattack, bodyslam, dizzypunch);
	Pokemon Alakazam  = new Pokemon("Alakazam", "Psiquico", "Psiquico", 520, 80,
								psychic, psychoboost, dizzypunch, doubleedge);
	Pokemon Dragonite = new Pokemon("Dragonite", "Dragao", "Gelo", 600, 70,
								fly, skyattack, outrage, dragonclaw);
	//Medios
	
	Pokemon Ponyta    = new Pokemon("Ponyta", "Fogo", "Terrestre", 400, 70,
								flamethower, doubleedge, bodyslam, dizzypunch);
	Pokemon Growlithe = new Pokemon("Growlithe", "Fogo", "Agua", 400, 70,
								blastburn, flamethower, bodyslam, dizzypunch);
	Pokemon Vaporeon  = new Pokemon("Vaporeon", "Agua", "Planta", 400, 70,
								bubblebeam, surf, icebeam, blizzard);
	Pokemon Golduck   = new Pokemon("Golduck", "Agua", "Planta", 400, 70,
								bubblebeam, surf, bodyslam, doubleedge);
	Pokemon Electrode = new Pokemon("Electrode", "Eletrico", "Terrestre", 400, 70,
								thunderbolt, thunder, bodyslam, dizzypunch);
	Pokemon Electabuzz= new Pokemon("Electabuzz", "Eletrico", "Terrestre", 400, 70,
								thunderbolt, thunder, bodyslam, dizzypunch);
	Pokemon Weepinbell= new Pokemon("Weepinbell", "Planta", "Voador", 400, 70,
								razorleaf, solarbeam, sludgebomb, acid);
	Pokemon Exeggutor = new Pokemon("Exeggutor", "Planta", "Voador", 400, 70,
								razorleaf, solarbeam, sludgebomb, acid);
	Pokemon Dewgong   = new Pokemon("Dewgong", "Gelo", "Lutador", 400, 70,
								icebeam, blizzard, bubblebeam, bodyslam);
	Pokemon Hitmonlee = new Pokemon("Hitmonlee", "Lutador", "Voador", 400, 70,
								superpower, machpunch, bodyslam, doubleedge);
	Pokemon Hitmonchan= new Pokemon("Hitmonchan", "Lutador", "Voador", 400, 70,
								superpower, machpunch, bodyslam, doubleedge);
	Pokemon Gloom     = new Pokemon("Gloom", "Venenoso", "Voador", 400, 70,
								sludgebomb, acid, razorleaf, bodyslam);
	Pokemon Arbok     = new Pokemon("Arbok", "Venenoso", "Voador", 400, 70,
								sludgebomb, acid, dizzypunch, bodyslam);
	Pokemon Dugtrio   = new Pokemon("Dugtrio", "Terrestre", "Lutador", 400, 70,
								earthquake, dig, doubleedge, bodyslam);
	Pokemon Rhyhorn   = new Pokemon("Rhyhorn", "Terrestre", "Lutador", 400, 70,
								earthquake, dig, doubleedge, bodyslam);
	Pokemon Pidgeot   = new Pokemon("Pidgeot", "Voador", "Eletrico", 400, 70,
								fly, skyattack, bodyslam, dizzypunch);
	Pokemon Golbat    = new Pokemon("Golbat", "Voador", "Eletrico", 400, 70,
								fly, skyattack, sludgebomb, acid);
	Pokemon Kadabra   = new Pokemon("Kadabra", "Psiquico", "Psiquico", 400, 70,
								psychic, psychoboost, dizzypunch, doubleedge);
	Pokemon MrMime    = new Pokemon("Mr. Mime", "Psiquico", "Psiquico", 400, 70,
								psychic, psychoboost, dizzypunch, doubleedge);
	Pokemon Dragonair = new Pokemon("Dragonair", "Dragao", "Gelo", 400, 70,
								outrage, dragonclaw, bodyslam, doubleedge);
	
	//Fracos
	
	Pokemon Charmander= new Pokemon("Charmander", "Fogo", "Agua", 300, 60,
								blastburn, flamethower, bodyslam, dizzypunch);
	Pokemon Squirtle  = new Pokemon("Squirtle", "Agua", "Planta", 300, 60,
								bubblebeam, surf, bodyslam, doubleedge);
	Pokemon Pikachu   = new Pokemon("Pikachu", "Eletrico", "Terrestre", 300, 60,
								thunderbolt, thunder, bodyslam, dizzypunch);
	Pokemon Bulbasaur = new Pokemon("Bulbasaur", "Planta", "Voador", 300, 60,
								razorleaf, solarbeam, sludgebomb, acid);
	Pokemon Jynx      = new Pokemon("Jynxs", "Gelo", "Lutador", 300, 60,
								icebeam, blizzard, psychic, psychoboost);
	Pokemon Machop    = new Pokemon("Machop", "Lutador", "Voador", 300, 60,
								superpower, machpunch, bodyslam, doubleedge);
	Pokemon Ekans     = new Pokemon("Ekans", "Venenoso", "Terrestre", 300, 60,
								sludgebomb, acid, razorleaf, bodyslam);
	Pokemon Diglett   = new Pokemon("Diglett", "Terrestre", "Lutador", 300, 60,
								earthquake, dig, doubleedge, bodyslam);
	Pokemon Butterfree= new Pokemon("Butterfree", "Voador", "Eletrico", 300, 60,
								fly, skyattack, bodyslam, dizzypunch);
	Pokemon Abra      = new Pokemon("Abra", "Psiquico", "Psiquico", 300, 60,
								psychic, psychoboost, dizzypunch, doubleedge);
	Pokemon Dratini   = new Pokemon("Dratini", "Dragao", "Gelo", 300, 60,
								outrage, dragonclaw, bodyslam, doubleedge);
	
}
