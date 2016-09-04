package usuario;

import excecoes.TipoDeJogabilidadeInvalidoException;


public interface TipoDeUsuario {
	
	public abstract double calculaDesconto(double preco);
	
	public abstract int bonificacaoJogo();
	
	public abstract int valorPunir() throws TipoDeJogabilidadeInvalidoException;
	
	public int valorRecompensar() throws TipoDeJogabilidadeInvalidoException;
}
