package loja;

import excecoes.StringInvalidaException;
import usuario.Usuario;

public class FactoryDeUsuario {
	
	public Usuario criaUsuario(String nome, String login) throws StringInvalidaException{
		return new Usuario(nome,login);
	}
}
