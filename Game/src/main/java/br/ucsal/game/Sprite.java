package br.ucsal.game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Sprite {

	protected int x;
	protected int y;
	protected int height;
	protected int width;
	protected boolean visibility;
	
	protected Image image;
	
	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
		visibility = true;
	}
	
	protected void carregarImagem(String imageName) {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(imageName)); 
		image = ii.getImage();
	}
	
	protected void dimensionarImagem() {
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	
	public Image obterImagem() {
		return image;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public boolean isVisibile() {
		return visibility;
	}

	public void setVisible(Boolean visible) {
		this.visibility = visible;
	}
}
