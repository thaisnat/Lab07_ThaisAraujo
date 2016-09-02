package loja;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.Rpg;

public class FactoryDeJogo {
	
	public void criaJogo(String nome, double preco, String tipo, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException{
		if (tipo.equalsIgnoreCase("Rpg")){
			criaJogoRPG(nome,preco,jogabilidades);	
		} else if (tipo.equalsIgnoreCase("Luta")){
			criaJogoLuta(nome,preco,jogabilidades);
		} else if (tipo.equalsIgnoreCase("Plataforma")){
			criaJogoPlataforma(nome,preco,jogabilidades);
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
