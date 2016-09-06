package jogo;

import java.util.HashSet;
import java.util.Set;
import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.ValorScoreInvalidoException;

public abstract class Jogo {
	public static final String FIM_DE_LINHA = System.lineSeparator();

	// atributos
	private String nome;
	private double preco;
	private int maiorScore, quantidadeJogadas, jogadorZerou;
	private boolean zerou;
	static Set<Jogabilidade> jogabilidades;

	public Jogo(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio.");
		}
		if (preco < 0) {
			throw new PrecoInvalidoException("Preco nao pode ser negativo");
		}

		this.nome = nome;
		this.preco = preco;
		this.jogadorZerou = 0;
		this.quantidadeJogadas = 0;
		this.maiorScore = 0;
		jogabilidades = new HashSet<Jogabilidade>();
	}

	public Jogo(String nome, double preco, Set<Jogabilidade> jogabilidades)
			throws StringInvalidaException, PrecoInvalidoException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio.");
		}
		if (preco < 0) {
			throw new PrecoInvalidoException("Preco nao pode ser negativo");
		}

		this.nome = nome;
		this.preco = preco;
		this.jogadorZerou = 0;
		this.quantidadeJogadas = 0;
		this.maiorScore = 0;
		Jogo.jogabilidades = jogabilidades;
	}

	/**
	 * Metodo que recebe um inteiro que indica a pontuacao atual do jogador
	 * verifica se o jogador zerou o jogo
	 * @param score
	 * @param zerou
	 * @throws Exception 
	 */
	public int registraJogada(int score, boolean zerou) throws ValorScoreInvalidoException{
		if(score > 0){
			if (maiorScore < score) {
				maiorScore = score;	
			}
		}else{
			throw new ValorScoreInvalidoException("Score nao pode ser menor ou igual a zero.");
		}
		
		if (zerou == true){
			zerou = true;
			jogadorZerou = jogadorZerou + 1;
		}
		
		this.quantidadeJogadas += 1;

		int x2pAtual = pontosExtra();
		return x2pAtual;
	}
	
	abstract int pontosExtra();


	/**
	 * Metodos Get e Set
	 * HashCode
	 * Equals
	 * toString 
	 */
	
	/**
	 * Getters
	 * @return
	 * @param nome
	 * @param preco
	 * @param jogadorZerou
	 * @param maiorScore
	 * @param quantidadeJogadas
	 * @param Jogabilidades
	 * @param zerou
	 */
	public String getNome() {
		return nome;
	}
	public double getPreco() {
		return preco;
	}
	public int getJogadorZerou() {
		return jogadorZerou;
	}
	public int getMaiorScore() {
		return maiorScore;
	}
	public int getQuantidadeJogadas() {
		return quantidadeJogadas;
	}
	public static Set<Jogabilidade> getJogabilidades() {
		return jogabilidades;
	}
	public boolean getZerou() {
		return zerou;
	}
	
	/**
	 * Setters
	 * @param nome
	 * @param preco
	 * @param jogadorZerou
	 * @param maiorScore
	 * @param quantidadeJogadas
	 * @param Jogabilidades
	 * @param zerou
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public void setJogadorZerou(int jogadorZerou) {
		this.jogadorZerou = jogadorZerou;
	}
	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}
	public void setQuantidadeJogadas(int quantidadeJogadas) {
		this.quantidadeJogadas = quantidadeJogadas;
	}
	public void setZerou(boolean zerou) {
		this.zerou = zerou;
	}
	public void setJogabilidades(Set<Jogabilidade> jogabilidades) {
		Jogo.jogabilidades = jogabilidades;
	}

	/**
	 * HashCode igual ao Equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Equals pelo Preco
	 */
	public boolean equals(Object obj){
		if(!(obj instanceof Jogo)){
			return false;
		}
		Jogo outro = (Jogo) obj;
		if(getPreco() == outro.getPreco()){
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
		StringBuilder essaString = new StringBuilder();
		essaString.append("+" + this.nome + "-" + this.getClass().getSimpleName() + ":\n");
		essaString.append("==> Jogou " + this.getQuantidadeJogadas() + " vez(es)\n");
		essaString.append("==> Zerou " + this.getJogadorZerou() + " vez(es)\n");
		essaString.append("==> Maior score " + this.getMaiorScore() + ":\n");
		return essaString.toString();
	}
}
