package br.ucsal.game;


public class Tiro extends Sprite{
	
	private final int VELOCIDADE_TIRO = 15;
	private int alcance;
	
	
	public Tiro(int x, int y, int alcance) {
		super(x, y);
		this.alcance = alcance;
		iniTiro();
	}
	
	private void iniTiro() {
		carregarImagem("/tiro.png");
		dimensionarImagem();
	}
	
	public void mover() {
		x += VELOCIDADE_TIRO;
		if(x > this.alcance) {
			visibility = false;
		}
	}
}
