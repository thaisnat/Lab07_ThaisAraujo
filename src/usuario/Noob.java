package usuario;

import java.util.Set;
import excecoes.TipoDeJogabilidadeInvalidoException;
import jogo.Jogabilidade;
import jogo.Jogo;

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
	
	public int valorRecompensar() throws TipoDeJogabilidadeInvalidoException {
		
		Set<Jogabilidade> listaJ = Jogo.getJogabilidades();
		
		for (Jogabilidade jogabilidade : listaJ) {
			if(jogabilidade == Jogabilidade.OFFLINE){
				return 30;
			} else if(jogabilidade == Jogabilidade.MULTIPLAYER){
				return 10;
			} 
		}
		throw new TipoDeJogabilidadeInvalidoException("Tipo de jogabilidade invalido");
	}
	
	public int valorPunir() throws TipoDeJogabilidadeInvalidoException {
		
		Set<Jogabilidade> listaJ = Jogo.getJogabilidades();
		
		for (Jogabilidade jogabilidade : listaJ) {
			if(jogabilidade == Jogabilidade.ONLINE){
				return 10;
			} else if(jogabilidade == Jogabilidade.COMPETITIVO){
				return 20;
			} else if(jogabilidade == Jogabilidade.COOPERATIVO){
				return 50;
			}
		}
		throw new TipoDeJogabilidadeInvalidoException("Tipo de jogabilidade invalido");
	}

}
