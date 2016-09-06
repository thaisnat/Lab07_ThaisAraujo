package loja;

import excecoes.RegistroDeJogadaInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.TipoDeUsuarioInvalidoException;
import excecoes.ValorInvalidoException;

public class LojaFacade {
	
	private LojaController myController;
	
	public LojaFacade(){
		this.myController = new LojaController();
	}
	
	public void adicionaUsuario(String nome, String login) throws StringInvalidaException, TipoDeUsuarioInvalidoException {
		myController.adicionaUsuario(nome, login);
	}
	
	public void vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser){
		myController.vendeJogo(jogoNome, preco, jogabilidades, estiloJogo, loginUser);
	}
	
	public void adicionaCredito(String login, double credito) throws ValorInvalidoException{
		myController.adicionaCredito(login, credito);
	}
	
	public void registraJogada(String login, String nomeJogo, int score, boolean venceu) throws RegistroDeJogadaInvalidoException{
		myController.registraJogada(login, nomeJogo, score, venceu);
	}
}
