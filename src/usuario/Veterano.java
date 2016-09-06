package usuario;

import java.util.Set;

import jogo.Jogabilidade;
import jogo.Jogo;
import excecoes.TipoDeJogabilidadeInvalidoException;
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
	
	public int valorRecompensar() throws TipoDeJogabilidadeInvalidoException {
		
		Set<Jogabilidade> listaJ = Jogo.getJogabilidades();
		
		for (Jogabilidade jogabilidade : listaJ) {
			if(jogabilidade == Jogabilidade.ONLINE){
				return 10;
			} else if(jogabilidade == Jogabilidade.COOPERATIVO){
				return 20;
			} 
		}
		throw new TipoDeJogabilidadeInvalidoException("Tipo de jogabilidade invalido");
	}
	
	public int valorPunir() throws TipoDeJogabilidadeInvalidoException {
		
		Set<Jogabilidade> listaJ = Jogo.getJogabilidades();
		
		for (Jogabilidade jogabilidade : listaJ) {
			if(jogabilidade == Jogabilidade.COMPETITIVO){
				return 20;
			} else if(jogabilidade == Jogabilidade.OFFLINE){
				return 20;
			}
		}
		throw new TipoDeJogabilidadeInvalidoException("Tipo de jogabilidade invalido");
	}

}
