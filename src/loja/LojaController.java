package loja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jogo.Jogabilidade;
import jogo.Jogo;
import usuario.Usuario;
import easyaccept.EasyAccept;
import excecoes.PrecoInvalidoException;
import excecoes.RegistroDeJogadaInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.TipoDeJogoInvalidoException;
import excecoes.TipoDeUsuarioInvalidoException;
import excecoes.ValorInvalidoException;

public class LojaController {
	public static final String FIM_DE_LINHA = System.lineSeparator();
	private List<Usuario> meusUsuarios;
	private HashMap<String, Jogabilidade> mapJogabildades;
	private FactoryDeUsuario factoryUsuario;
	private FactoryDeJogo factoryJogo;
	
	public LojaController() {
		this.meusUsuarios = new ArrayList<Usuario>();
		this.initializeMap();
		this.factoryUsuario = new FactoryDeUsuario();
		this.factoryJogo = new FactoryDeJogo();
	}
	
	private Usuario criaUsuario(String nome, String login) throws StringInvalidaException{
		return factoryUsuario.criaUsuario(nome, login);
	}
	
	private Jogo criaJogo(String nome, double preco, String tipo, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException, TipoDeJogoInvalidoException{
		return factoryJogo.criaJogo(nome, preco, tipo, jogabilidades);
	}
	
	public void adicionaUsuario(String nome, String login) throws StringInvalidaException, TipoDeUsuarioInvalidoException {
		try {
			if(buscaUsuario(login) != null){
				Usuario novoUser;
				novoUser = this.criaUsuario(nome, login);
				meusUsuarios.add(novoUser);
			}else{
				throw new TipoDeUsuarioInvalidoException("Usuario nao encontrado");
			}	
		} catch (Exception e) {
			throw new TipoDeUsuarioInvalidoException("Usuario invalido");
		}

	}

	public void vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser) {

		try {
			Usuario buscado = this.buscaUsuario(loginUser);
			Set<Jogabilidade> tiposJogabilidades = this.createJogabilidades(jogabilidades);
			Jogo jogoVendido = this.criaJogo(jogoNome, preco, estiloJogo,tiposJogabilidades);
			buscado.compraJogo(jogoVendido);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void registraJogada(String login, String nomeJogo, int score, boolean venceu) throws RegistroDeJogadaInvalidoException {
		try {
			Usuario user = this.buscaUsuario(login);
			user.registradaJogada(nomeJogo, score, venceu);
		} catch (Exception e) {
			throw new RegistroDeJogadaInvalidoException("Jogada nao registrada");
		}

	}

	public void adicionaCredito(String login, double credito) throws ValorInvalidoException {
		try {
			if (credito < 0) {
				throw new ValorInvalidoException("Credito nao pode ser negativo");
			}
			Usuario user = this.buscaUsuario(login);
			user.setCredits(user.getCredits() + credito);
		} catch (Exception e) {
			throw new ValorInvalidoException("Credito nao adicionado");
		}
	}

	private Usuario buscaUsuario(String login) throws TipoDeUsuarioInvalidoException {
		Usuario buscado = null;

		try {
			for (int i = 0; i < meusUsuarios.size(); i++) {
				if (meusUsuarios.get(i).getLogin().equals(login)) {
					buscado = meusUsuarios.get(i);
				}
			}
		} catch (Exception e) {
			throw new TipoDeUsuarioInvalidoException("Usuario nao encontrado");
		}
		return buscado;
	}
	
	
	/**
	 * Verifica se o usuario Noob tem x2p suficiente para se tornar um Veterano
	 * @param login
	 * @return
	 * @throws Exception
	 */
	/**
	public boolean upgradeUsuario(String login) throws Exception{
		TipoDeUsuario esseUsuario = null;
		for (Usuario usuario : meusUsuarios) {
			if(usuario.getLogin().equalsIgnoreCase(login)){
				esseUsuario = usuario;
			} 
		}
		if(esseUsuario != null){
			if(esseUsuario.getClass() == Noob.class);
				if (esseUsuario.getX2p() >= 1000){
					
					String atribuindoNome = esseUsuario.getName();
					String atribuindoLogin = esseUsuario.getLogin();
					double atribuindoDinheiro = esseUsuario.getCredits();
					
					esseUsuario = new Veterano();
					int x2p = esseUsuario.getX2p();
					esseUsuario.setX2p(x2p);
					return true;
				}
		} else{
			throw new Exception("Usuario ja eh Veterano");
		}
		return false;
	}
	*/
	private double confereCredito(String login) {
		try {
			Usuario procurado = this.buscaUsuario(login);
			return procurado.getCredits();
		} catch (Exception e) {
			e.getMessage();
		}
		return 0;
	}

	public String informacaoUsuarios() {
		String myString = "=== Central P2-CG ===" + FIM_DE_LINHA + FIM_DE_LINHA;
		for (int i = 0; i < meusUsuarios.size(); i++) {
			myString += meusUsuarios.get(i).toString() + FIM_DE_LINHA;
		}
		return myString;
	}

	public int getX2p(String login) throws TipoDeUsuarioInvalidoException {
		Usuario buscado = this.buscaUsuario(login);
		return buscado.getX2p();
	}

	private Set<Jogabilidade> createJogabilidades(String names1) {
		Set<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();

		String[] listofNames = names1.split(",");

		for (int i = 0; i < listofNames.length; i++) {
			String element = listofNames[i].toUpperCase();
			if (element != null) {
				Jogabilidade tipojogabilidade = mapJogabildades.get(element);
				jogabilidades.add(tipojogabilidade);
			}
		}

		return jogabilidades;

	}

	private void initializeMap() {
		this.mapJogabildades = new HashMap<String, Jogabilidade>();
		mapJogabildades.put("ONLINE", Jogabilidade.ONLINE);
		mapJogabildades.put("OFFLINE", Jogabilidade.OFFLINE);
		mapJogabildades.put("COMPETITIVO", Jogabilidade.COMPETITIVO);
		mapJogabildades.put("COOPERATIVO", Jogabilidade.COOPERATIVO);
		mapJogabildades.put("MULTIPLAYER", Jogabilidade.MULTIPLAYER);

	}

	public static void main(String[] args) {
		args = new String[] { "loja.LojaController", "acceptance_test/us1.txt", "acceptance_test/us2.txt",  "acceptance_test/us3.txt" };
		EasyAccept.main(args);

	}

}
