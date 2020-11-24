package br.ucsal.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;

public class Jogo extends JPanel implements ActionListener{
	
	private final int B_WIDTH = 854;
	private final int B_HEIGHT = 480;
	private final int INITIAL_X = 0;
	private final int INITIAL_Y = 0;
	private final int DELAY = 10;
	private Image imagemFundo;
	private Timer timer;
	private int x, y;
	
	private static final long serialVersionUID = 1L;
	private Nave nave = new Nave();
	
	
	public Jogo() throws IOException {
		imagemFundo = ImageIO.read(new File("src/main/resources/fundo.jpg"));
		initJogo();
	}
	
	private void initJogo() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLUE);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);
		x = INITIAL_X;
		y = INITIAL_Y;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		desenharImagem(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void desenharImagem(Graphics g) {
		g.drawImage(imagemFundo, 0, 0, null);
		g.drawImage(nave.getImage(), nave.getX(), nave.getY(), this);
	}
	

	public void actionPerformed(ActionEvent e) {
		nave.move();
		repaint();
	}
	
	private class TAdapter extends KeyAdapter{
		
		@Override
		public void keyReleased(KeyEvent e) {
			nave.keyReleased(e);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			nave.keyPressed(e);
		}
	}
}
