package br.com.jogo.excecoes;

public class JogadorNaoSelecionadoException extends Exception {
	private String erro;

	// Construtor padrao - inicializa a variável de instância para o desconhecido.
	
	/**
	 * Construtor padrão da Exceção que altera a mensagem de erro para "unknown"
	 */
	public JogadorNaoSelecionadoException() {
		super(); 			// chamar o construtor da superclasse
		erro = "unknown";
	}

	/*
	 * Construtor recebe algum tipo de mensagem que é salvo em uma variável de
	 * instância.
	 */

	/**
	 * Construtor da Exceção que recebe uma mensagem de erro
	 * 
	 * @param err
	 *            Mensagem de erro
	 */
	public JogadorNaoSelecionadoException(String err) {
		super(err); // chamar o construtor da superclasse
		erro = err; // salva menssagem
	}

	/*
	 * Método público, pode ser chamado pelo coletor de excecão. Ele retorna a
	 * mensagem de erro.
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