package usuario;

import java.util.Iterator;
import java.util.Set;

import excecoes.StringInvalidaException;
import excecoes.TipoDeJogabilidadeInvalidoException;
import excecoes.ValorInvalidoException;
import jogo.Jogabilidade;
import jogo.Jogo;

public class Veterano implements TipoDeUsuario  {
	public static final double DESCONTO_VETERANO = 0.8;

	public Veterano() {
		
	}

	/**
	 * calcula e retorna o valor do desconto atribuido a classe
	 * @return
	 */
	public double calculaDesconto(double preco) {
		double valor = preco - (preco * 0.20);
		return valor;
	}
	
	/**
	 * retorna o valor do bonus informado da classe
	 * @return
	 */
	public int bonificacaoJogo(){
		return 15;
	}
	
	private String verificaJogabilidade(Set<Jogabilidade> jogabilidades) throws TipoDeJogabilidadeInvalidoException{
		for (Jogabilidade jogabilidade : jogabilidades) {
			if(jogabilidades.equals("Online")){
				return "Online";
			} else if(jogabilidades.equals("Competitivo")){
				return "Competitivo";
			} else if(jogabilidades.equals("Cooperativo")){
				return "Cooperativo";
			} else if(jogabilidades.equals("Offline")){
				return "Offline";
			}else if(jogabilidades.equals("Multiplayer")){
				return "Multiplayer";
			}
		}
		throw new TipoDeJogabilidadeInvalidoException("Tipo de jogabilidade invalido");
	}
	
	public int valorPunir() throws TipoDeJogabilidadeInvalidoException {
		Object jogabilidades = null;
		if(verificaJogabilidade((Set<Jogabilidade>) jogabilidades).equals("Competitivo")){
			return 20;
		} else if(verificaJogabilidade((Set<Jogabilidade>) jogabilidades).equals("Offline")){
			return 20;
		} 
		throw new TipoDeJogabilidadeInvalidoException("Tipo de jogabilidade invalido");
	}
	
	public int valorRecompensar() throws TipoDeJogabilidadeInvalidoException {
		Object jogabilidades = null;
		if(verificaJogabilidade((Set<Jogabilidade>) jogabilidades).equals("Online")){
			return 10;
		} else if(verificaJogabilidade((Set<Jogabilidade>) jogabilidades).equals("Cooperativo")){
			return 20;
		} 		
		throw new TipoDeJogabilidadeInvalidoException("Tipo de jogabilidade invalido");
	}
	

}
