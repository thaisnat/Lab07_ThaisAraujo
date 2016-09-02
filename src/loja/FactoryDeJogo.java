package loja;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.TipoDeJogoInvalidoException;
import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.Rpg;

public class FactoryDeJogo {
	
	public Jogo criaJogo(String nome, double preco, String tipo, Set<Jogabilidade> jogabilidades) throws TipoDeJogoInvalidoException, StringInvalidaException, PrecoInvalidoException{
		switch (tipo.toUpperCase()) {
		case "RPG":
			return criaJogoRPG(nome,preco,jogabilidades);
		case "LUTA":
			return criaJogoLuta(nome,preco,jogabilidades);
		case "PLATAFORMA":
			return criaJogoPlataforma(nome,preco,jogabilidades);
		default:
			throw new TipoDeJogoInvalidoException("Tipo de jogo invalido");
		}
	}
	
	private Jogo criaJogoRPG(String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException{
		return new Rpg(nome,preco,jogabilidades);
	}
	
	private Jogo criaJogoLuta(String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException{
		return new Luta(nome,preco,jogabilidades);
	}
	
	private Jogo criaJogoPlataforma(String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException{
		return new Plataforma(nome,preco,jogabilidades);
	}
}
