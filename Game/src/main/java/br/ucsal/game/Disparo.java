package br.ucsal.game;

import java.awt.Image;
import java.awt.Rectangle;

public class Disparo extends Sprite {

	private static final int LARGURA_TELA = 950;
	private static final int VELOCIDADE = 8;

	public Disparo(int x, int y) {
		this.x = x;
		this.y = y;

		carregarImagem("/images/tiro.png");

		dimensionarImagem();

		visible = true;
	}

	public void mover() {
		this.x += VELOCIDADE;
		if (this.x > LARGURA_TELA) {
			visible = false;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);

	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int getAltura() {
		return width;
	}

	@Override
	public int getLargura() {
		return height;
	}

	@Override
	public boolean isVisivel() {
		return visible;
	}

	@Override
	public void setVisivel(boolean visivel) {
		visible = visivel;
	}
}
