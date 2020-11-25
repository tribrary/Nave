package br.ucsal.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import java.io.IOException;
import java.util.ArrayList;

//import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;

public class Jogo extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private final int B_WIDTH = 1000;
	private final int B_HEIGHT = 680;
	private final int DELAY = 1;
	//private Image imagemFundo;
	private Timer timer;
	
	private Nave nave;
	
	
	public Jogo()  {
		initJogo();
	}
	
	private void initJogo() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);
		setBackground(Color.BLACK);
		nave = new Nave(40, 60, B_WIDTH);
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		desenharImagem(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void desenharImagem(Graphics g) {
//		g.drawImage(imagemFundo, 0, 0, null);
		g.drawImage(nave.getImage(), nave.getX(), nave.getY(), this);
		ArrayList<?> tiros = nave.getTiros();
		for (Object t1 : tiros) {
			Tiro tiro = (Tiro) t1;
			g.drawImage(tiro.obterImagem(), tiro.getX(), tiro.getY(), this);
		}
	}
	
	private void updateTiro() {
		ArrayList<?> tiros = nave.getTiros();
		for (int i = 0; i < tiros.size(); i++) {
			Tiro tiro = (Tiro) tiros.get(i);
			if(tiro.isVisibile()) {
				tiro.mover();
			}else {
				tiros.remove(i);
			}
		}
	}
	
	private class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			nave.keyReleased(e);
		}
		@Override
		public void keyPressed(KeyEvent e) {
			nave.keyPressed(e);
		}
	}

	public void actionPerformed(ActionEvent e) {
		updateTiro();
		nave.move();
		repaint();
	}
	
}
