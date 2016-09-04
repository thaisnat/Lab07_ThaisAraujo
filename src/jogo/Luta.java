package jogo;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;

public class Luta extends Jogo{

	public Luta(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco);
	}
	
	public Luta (String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco, jogabilidades);
	}
	
	@Override
	public int pontosExtra() {
		int valor = 0;
		valor = valor + (super.getMaiorScore()/1000);
		return valor;
	}
}
