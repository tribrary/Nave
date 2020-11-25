package br.ucsal.game;

import java.awt.Image;
import java.awt.Rectangle;

public class Alien extends Sprite {

	private static final int LARGURA_TELA = 950;
	private static final int VELOCIDADE = 3;

	private static int contador = 0;

	public Alien(int x, int y) {
		this.x = x;
		this.y = y;

		contador ++;
		if (contador % 2 == 0) {
			carregarImagem("/images/alien1.png");
		}else {
			carregarImagem("/images/alien2.png");
		}

		dimensionarImagem();

		visible = true;
	}

	public void mover() {
		if (this.x < 0) {
			this.x = LARGURA_TELA;
		} else {
			this.x -= VELOCIDADE;
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
	@Override
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
		return height;
	}

	@Override
	public int getLargura() {
		return width;
	}

	@Override
	public boolean isVisivel() {
		return visible;
	}

	@Override
	public void setVisivel(boolean visivel) {
		this.visible = visivel;
	}
}
