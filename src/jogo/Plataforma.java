package jogo;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;

public class Plataforma extends Jogo {
	public final static int MAXIMUM_SCORE = 100000;
	public final static int TAXA_XP2 = 20;
	public Plataforma(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco);
	}

	public Plataforma(String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco, jogabilidades);
	}

	@Override
	public int pontosExtra() {
		int valor = 0;
		valor = valor + (int)(super.getJogadorZerou()*20);
		return valor;
	}

}
