package jogo;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;

public class Rpg extends Jogo{
	public final static int TAXA_XP2 = 10;
	
	public Rpg(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco);
	}
	
	public Rpg (String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco, jogabilidades);
	}

	@Override
	public int pontosExtra(){
		int valor;
		valor = (super.getJogadorZerou() * 10);
		return valor;
	}

}
