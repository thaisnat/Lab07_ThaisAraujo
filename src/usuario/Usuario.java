package usuario;

import java.util.ArrayList;
import excecoes.StringInvalidaException;
import excecoes.TipoDeJogoInvalidoException;
import excecoes.ValorInvalidoException;
import jogo.Jogo;

public class Usuario {

	public static final String FIM_DE_LINHA = System.lineSeparator();

	private String name;
	private String login;
	private ArrayList<Jogo> myGames;
	private double credits;
	private int x2p;
	private TipoDeUsuario userType;
	private Jogo jogo;

	public Usuario(String name, String login) throws StringInvalidaException {

		if (name == null || name.trim().isEmpty()) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio.");
		}
		if (login == null || login.trim().isEmpty()) {
			throw new StringInvalidaException("Login nao pode ser nulo ou vazio.");
		}

		this.name = name;
		this.login = login;
		this.myGames = new ArrayList<>();
		this.credits = 0;
		this.userType = new Noob();
		this.jogo = new Jogo();
	}
	
	/**
	public boolean compraJogo(Jogo gameReceived){
		int preco = (int)gameReceived.getPreco();
		
		if(credits >= userType.calculaDesconto(gameReceived.getPreco())){
			if (verificaJogo(gameReceived)) {
				return false;
			} else {
				this.setCredits(this.getCredits() - userType.calculaDesconto(gameReceived.getPreco()));
				this.setX2p(this.getX2p() + preco * userType.bonificacaoJogo());
				return myGames.add(gameReceived);
			}
		}
		return false;
	}
	*/
	
	/**
	 * metodo que verifica se o jogo existe
	 * @param gameReceived
	 * @return
	 */
	private boolean verificaJogo(String gameReceived) {
		for (Jogo jogo : myGames) {
			if (myGames.contains(gameReceived)) {
				return true;
			}
		}
		return false;
	}
	
	
	public int recompensar(String nomeJogo, int scoreObtido, boolean zerou) throws TipoDeJogoInvalidoException{
		if(verificaJogo(nomeJogo)){
			int pontosDaJogada = Jogo.registraJogada(scoreObtido, zerou) + userType.valorRecompensar();
			this.setX2p(this.getX2p() + pontosDaJogada);
			return this.getX2p();			
		}else{
			throw new TipoDeJogoInvalidoException("Jogo nao esta na lista do usuario");
		}	
	}
	
	public int punir(String nomeJogo, int scoreObtido, boolean zerou) throws TipoDeJogoInvalidoException{
		if(verificaJogo(nomeJogo)){
			int pontosDaJogada = Jogo.registraJogada(scoreObtido, zerou) + userType.valorPunir();
			this.setX2p(this.getX2p() - pontosDaJogada);
			return this.getX2p();			
		}else{
			throw new TipoDeJogoInvalidoException("Jogo nao esta na lista do usuario");
		}	
	}
	
	/**
	public double calculaPrecoTotal() {
		double total = 0;
		Iterator itr = myGames.iterator();
		while (itr.hasNext()) {
			Jogo achado = (Jogo) itr.next();
			total += achado.getPreco();
		}
		return total;
	}
	 */
	
	/**
	 * Metodos Get e Set
	 * HashCode
	 * Equals
	 * toString 
	 */
	
	/**
	 * Getters
	 * @return
	 */
	public String getName() {
		return name;
	}
	public String getLogin() {
		return login;
	}
	public ArrayList<Jogo> getMyGames() {
		return myGames;
	}
	public double getCredits() {
		return credits;
	}
	public int getX2p() {
		return x2p;
	}
	public TipoDeUsuario getUserType() {
		return userType;
	}
	/**
	 * Setters
	 * @param name
	 * @param login
	 * @param myGames
	 * @param credits
	 * @param x2p
	 * @param userType
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setMyGames(ArrayList<Jogo> myGames) {
		this.myGames = myGames;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
	public void setX2p(int x2p) {
		this.x2p = x2p;
	}
	public void setUserType(TipoDeUsuario userType) {
		this.userType = userType;
	}
	/**
	 * HashCode igual ao Equals 
	 * @return
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}
	/**
	 * Equals pelo Login
	 * @param obj
	 * @return
	 */
	public boolean equals(Object obj){
		if(!(obj instanceof Usuario)){
			return false;
		}
		Usuario outro = (Usuario) obj;
		if(getLogin() == outro.getLogin()){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return this.login + "/n" + name + "- Jogador" + this.getClass().getSimpleName() + "\n";

	}
}
