package Modeladores;

public class Pokemons extends Ataques {
	/*Pokemons a serem utilizados no jogo*/
	
	
	//Fortes
	public Pokemon charizard = new Pokemon ("Charizard","fogo","agua",634,90,flamethrower, dragonclaw, outrage,punch);
	public Pokemon zapdos = new Pokemon ("Zapdos","eletrico","psiquico",580,90,thunder,fly,aeroblast,headbutt);
	//Medios
	public Pokemon ninetales = new Pokemon ("Ninetales","fogo","agua",400,70,blastburn,flamethrower,fakeout,headbutt);
	public Pokemon alakazam = new Pokemon ("Alakazam","psiquico","eletrico",490,60,psychic,psychoboost,punch,fakeout);
	public Pokemon raichu = new Pokemon ("Raichu","eletrico","psiquico",380,75,thunder,thunderbolt,headbutt,punch);
	public Pokemon machamp = new Pokemon ("Machamp","lutador","voador",400,70,superpower,crosschop,punch,fakeout);
	public Pokemon vaporeon = new Pokemon ("Vaporeon","agua","eletrico",430,65,hydropump,surf,peck,doubleedge);
	public Pokemon dragonair = new Pokemon ("Dragonair","dragao","dragao",420,70,dragonclaw,outrage,peck,doubleedge);
	public Pokemon pidgeot = new Pokemon ("Pidgeot","voador","eletrico",370,80,fly,aeroblast,headbutt,peck);
	//Fracos
	public Pokemon magikarp = new Pokemon ("Magikarp","agua","eletrico",100,40,headbutt,fakeout,peck,surf);
	public Pokemon pikachu = new Pokemon ("Pikachu","eletrico","psiquico",180,45,peck,thunderbolt,headbutt,punch);
	public Pokemon eevee = new Pokemon ("Eevee","normal","lutador",200,40,punch,headbutt,doubleedge,fakeout);
	public Pokemon charmander = new Pokemon ("Charmander","fogo","agua",190,45,flamethrower,punch,peck,headbutt);
}
