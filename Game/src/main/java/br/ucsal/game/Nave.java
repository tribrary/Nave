package br.ucsal.game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Nave extends Sprite {

	private int dx, dy;

	private List<Disparo> disparos;

	public Nave() {
		carregarImagem("/images/nave.png");
		dimensionarImagem();

		disparos = new ArrayList<Disparo>();

		this.x = 100;
		this.y = 220;
	}

	public void move() {
		x += dx;
		y += dy;

		if (this.x < 1) {
			this.x = 1;
		}
		
		if (this.x > 830) {
			this.x = 830;
		}

		if (this.y < 1) {
			this.y = 1;
		}

		if (this.y > 460) {
			this.y = 460;
		}
	}

	public void atira() {
		this.disparos.add(new Disparo(this.x + this.width, this.y + this.height
				/ 2));
	}

	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_SPACE) {
			atira();
		}

		if (codigo == KeyEvent.VK_UP) {
			dy = -3;

		}
		
		if (codigo == KeyEvent.VK_DOWN) {
			dy = 3;
		}

		if (codigo == KeyEvent.VK_LEFT) {
			dx = -2;

		}
		
		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 2;
		}
	}

	public void keyReleased(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_UP) {
			dy = 0;

		}
		
		if (codigo == KeyEvent.VK_DOWN) {
			dy = 0;

		}
		
		if (codigo == KeyEvent.VK_LEFT) {
			dx = 0;

		}
		
		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 0;

		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	public boolean isVisivel() {
		return visible;
	}

	public void setVisivel(boolean visible) {
		this.visible = visible;
	}

	public List<Disparo> getDisparos() {
		return disparos;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public int getAltura() {
		return height;
	}

	@Override
	public int getLargura() {
		return width;
	}
}
