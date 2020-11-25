package br.ucsal.game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Sprite {

	protected int x, y;
	
	protected int height, width;
	
	protected boolean visible;
	
	protected Image image;
	
	protected void carregarImagem(String imageName) {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(imageName)); 
		image = ii.getImage();
	}
	
	protected void dimensionarImagem() {
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	
	public abstract Rectangle getBounds();
	
	public abstract int getX();
	
	public abstract int getY();
	
	public abstract int getAltura();
	
	public abstract int getLargura();
	
	public abstract boolean isVisivel();
	
	public abstract void setVisivel(boolean visivel);
	
	public abstract Image getImage();
}
