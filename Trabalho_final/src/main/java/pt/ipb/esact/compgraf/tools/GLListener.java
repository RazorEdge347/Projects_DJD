package pt.ipb.esact.compgraf.tools;

public interface GLListener {

	/**
	 * Invocado para inicializar a cena (alocar recursos)
	 */
	void init();

	/**
	 * Invocado para redimensionar a janela
	 * @param width Largura
	 * @param height Altura
	 */
	void resize(int width, int height);

	/**
	 * Invocado para fazer render dos objetos no cenario
	 * @param width Largura
	 * @param height Altura
	 */
	void render(int width, int height);

	/**
	 * Invocado no final da execucao (libertar recursos)
	 */
	void release();

}
