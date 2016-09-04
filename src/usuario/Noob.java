package usuario;

import java.util.Set;
import excecoes.TipoDeJogabilidadeInvalidoException;
import jogo.Jogabilidade;


public class Noob implements TipoDeUsuario {
	public static final double DESCONTO_NOOB = 0.9;

	public Noob() {
		
	}
	
	/**
	 * calcula e retorna o valor do desconto atribuido a classe
	 * @return
	 */
	public double calculaDesconto(double preco) {
		double valor = preco - (preco * 0.10);
		return valor;
	}

	/**
	 * retorna o valor do bonus informado da classe
	 * @return
	 */
	public int bonificacaoJogo(){
		return 10;
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
		if(verificaJogabilidade((Set<Jogabilidade>) jogabilidades).equals("Online")){
			return 10;
		} else if(verificaJogabilidade((Set<Jogabilidade>) jogabilidades).equals("Competitivo")){
			return 20;
		} else if(verificaJogabilidade((Set<Jogabilidade>) jogabilidades).equals("Cooperativo")){
			return 50;
			}
		throw new TipoDeJogabilidadeInvalidoException("Tipo de jogabilidade invalido");
	}
	
	public int valorRecompensar() throws TipoDeJogabilidadeInvalidoException {
		Object jogabilidades = null;
		if(verificaJogabilidade((Set<Jogabilidade>) jogabilidades).equals("Offline")){
			return 30;
		} else if(verificaJogabilidade((Set<Jogabilidade>) jogabilidades).equals("CMultiplayer")){
			return 10;
		} 		
		throw new TipoDeJogabilidadeInvalidoException("Tipo de jogabilidade invalido");
	}
			
	
}
