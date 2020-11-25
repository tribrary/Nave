package br.ucsal.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PrimeiraFase extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	
	private final int DELAY = 12;
	private Image fundo;

	private Nave nave;

	private Timer timer;

	private List<Alien> inimigos;

	private boolean emJogo;
	
	private int[][] coordenadas = { {760, 20}, {700, 100}, {640, 180}, {580, 260}, {640, 320}, {700, 400}, {760, 480},
			{1060, 20}, {1000, 100}, {940, 180}, {880, 260}, {940, 320}, {1000, 400}, {1060, 480},
			{1360, 20}, {1360, 100}, {1360, 180}, {1360, 260}, {1360, 320}, {1360, 400}, {1360, 480},
			{1420, 20}, {1420, 100}, {1420, 180}, {1420, 260}, {1420, 320}, {1420, 400}, {1420, 480},
			{1760, 20}, {1700, 100}, {1640, 180}, {1580, 260}, {1640, 320}, {1700, 400}, {1760, 480},
			{580, 20}, {700, 100}, {640, 180}, {760, 260}, {640, 320}, {700, 400}, {580, 480},
			{2000, 20}, {2160, 100}, {2220, 180}, {2280, 260}, {2220, 320}, {2160, 400}, {2000, 480},
			{1569, 20}, {7450, 100}, {650, 180}, {5250, 260}, {2360, 320}, {1600, 400}, {950, 480},
			{2400, 20}, {2460, 100}, {2520, 180}, {2600, 260}, {2660, 320}, {2720, 400}, {2800, 480},
			{3280, 20}, {3200, 100}, {3120, 180}, {3060, 260}, {3000, 320}, {2920, 400}, {2860, 480},};

	public PrimeiraFase() {
		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());

		ImageIcon image = new ImageIcon(Iniciar.class.getResource("/images/fundo.png"));
		fundo = image.getImage();
		nave = new Nave();

		emJogo = true;

		inicializarAliens();

		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void inicializarAliens() {
		inimigos = new ArrayList<Alien>();

		for (int i = 0; i < coordenadas.length; i++) {
			inimigos.add(new Alien(coordenadas[i][0], coordenadas[i][1]));
		}
	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		
		
		graficos.drawImage(fundo, 0, 0, null);


		if (emJogo) {
			graficos.drawImage(nave.getImage(), nave.getX(), nave.getY(), this);

			List<Disparo> disparos = nave.getDisparos();

			for (int i = 0; i < disparos.size(); i++) {
				Disparo m = (Disparo) disparos.get(i);
				graficos.drawImage(m.getImage(), m.getX(), m.getY(), this);
			}

			for (int i = 0; i < inimigos.size(); i++) {
				Alien in = inimigos.get(i);
				graficos.drawImage(in.getImage(), in.getX(), in.getY(), this);
			}

			graficos.setColor(Color.white);
			graficos.drawString("Ameaças: " + inimigos.size(), 5, 15);

		} else {
			Thread.currentThread();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			ImageIcon fimJogo = new ImageIcon(Iniciar.class.getResource("/images/game-over.png"));

			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
		}
		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if (inimigos.size() == 0) {
			emJogo = false;
		}

		List<Disparo> disparos = nave.getDisparos();

		for (int i = 0; i < disparos.size(); i++) {
			Disparo disparo = (Disparo) disparos.get(i);

			if (disparo.isVisible()) {
				disparo.mover();
			} else {
				disparos.remove(i);
			}
		}

		for (int i = 0; i < inimigos.size(); i++) {
			Alien alien = inimigos.get(i);

			if (alien.isVisible()) {
				alien.mover();
			} else {
				inimigos.remove(i);
			}
		}

		nave.move();
		checarColisoes();
		repaint();
	}

	public void checarColisoes() {
		Rectangle formaNave = nave.getBounds();
		Rectangle formaAlien;
		Rectangle formaDisparo;

		for (int i = 0; i < inimigos.size(); i++) {

			Alien tempoAlien = inimigos.get(i);
			formaAlien = tempoAlien.getBounds();

			if (formaNave.intersects(formaAlien)) {
				nave.setVisivel(false);
				tempoAlien.setVisible(false);
				emJogo = false;
			}
		}

		List<Disparo> disparos = nave.getDisparos();

		for (int i = 0; i < disparos.size(); i++) {
			Disparo tempoDisparo = disparos.get(i);
			formaDisparo = tempoDisparo.getBounds();

			for (int j = 0; j < inimigos.size(); j++) {
				Alien tempoAlien = inimigos.get(j);
				formaAlien = tempoAlien.getBounds();

				if (formaDisparo.intersects(formaAlien)) {
					tempoAlien.setVisible(false);
					tempoDisparo.setVisible(false);
				}
			}
		}
	}

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				emJogo = true;
				nave = new Nave();
				inicializarAliens();
			}

			nave.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			nave.keyReleased(e);
		}
	}
}
