package br.com.jogo.excecoes;

public class JogadorNaoSelecionadoException extends Exception {
	private String erro;

	// Construtor padrao - inicializa variavel de instancia para o desconhecido
	/**
	 * Construtor padrão da Exceção que altera a mensagem de erro para "unknown"
	 */
	public JogadorNaoSelecionadoException() {
		super(); // chamar o construtor da superclasse
		erro = "unknown";
	}

	// Construtor recebe algum tipo de mensagem que e salvo em uma Variavel de
	// instancia
	/**
	 * Construtor da Exceção que recebe uma mensagem de erro
	 * 
	 * @param err
	 *            Mensagem de erro
	 */
	public JogadorNaoSelecionadoException(String err) {
		super(err); // chamar o construtor da superclasse
		erro = err; // salva messagem
	}

	/*
	 * metodo publico, pode ser chamado pelo coletor de excecao. Ele retorna a
	 * mensagem de erro
	 */
	/**
	 * Descrição do método
	 * 
	 * @return Retorna a mensagem de erro passada no construtor da Exceção
	 */
	public String getError() {
		return erro;
	}
}