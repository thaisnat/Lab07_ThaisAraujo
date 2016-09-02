package loja;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.TipoDeJogoInvalidoException;
import jogo.Jogabilidade;
import usuario.Noob;
import usuario.Usuario;

public class LojaFacade {
	
	private LojaController myController;
	
	public LojaFacade(){
		this.myController = new LojaController();
	}
	
	public void adicionaUsuario(String nome, String login) {
		myController.adicionaUsuario(nome, login);
	}
}
