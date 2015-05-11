package modelador;

public class Item {
	public String tipo;
	public int cura;
	public String status = "Disponível";
	
	public Item(String tipo, int cura){
		this.tipo = tipo;
		this.cura = cura;
	}
	
	public int Curar(Pokemon p){
		int hpAtual;
		
		this.status = "Indisponível";
		hpAtual = p.hp + this.cura;
		if(hpAtual >= p.maxHp){
			p.hp = p.maxHp;
			return p.maxHp;
		}
		p.hp = hpAtual;
		return hpAtual;
	}
}
