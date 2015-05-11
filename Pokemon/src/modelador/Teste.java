package modelador;

import static org.junit.Assert.*;

import org.junit.Test;

public class Teste {
	Lista lista = new Lista();
	Treinador thiago = new Treinador("Thiago");
	
	@Test
	public void testaNomes(){
		assertEquals("Thiago", thiago.nome);
		assertEquals("Charmander", lista.Charmander.Nome);
		assertEquals("Machop", lista.Machop.Nome);
		assertEquals("Surf", lista.surf.Nome);
	}
	
	@Test
	public void testaListaAtaques(){
		assertEquals("Dig", lista.Diglett.ataques[1].Nome);
		assertEquals("Sludge Bomb", lista.Ekans.ataques[0].Nome);
	}
	
	@Test
	public void testaAtaque(){
		lista.Squirtle.Atacar(lista.Pikachu, lista.Squirtle.ataques[0]);
		assertEquals(160, lista.Pikachu.hp);
	}
	
	@Test
	public void testaCura(){
		lista.Squirtle.Atacar(lista.Pikachu, lista.Squirtle.ataques[0]);
		thiago.itens[0].Curar(lista.Pikachu);
		assertEquals(250, lista.Pikachu.hp);
		thiago.itens[3].Curar(lista.Bulbasaur);
		assertEquals(300, lista.Bulbasaur.hp);
	}
	
	@Test
	public void testaAddLista(){
		thiago.addLista(lista.Abra);
		assertEquals("Abra", thiago.listaPokemon[0].Nome);
		
	}
	
	
}
