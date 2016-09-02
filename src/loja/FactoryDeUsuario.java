package loja;

import usuario.Noob;
import usuario.Usuario;
import excecoes.StringInvalidaException;

public class FactoryDeUsuario {
	
	public Usuario criaUsuario(String nome, String login) throws StringInvalidaException{
		return new Noob(nome,login);
	}
}
