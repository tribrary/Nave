package br.ucsal.game;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;

public class Principal extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public Principal() throws IOException {
		initUI();
	}
	
	private void initUI() throws IOException {
		add(new Jogo());
		setTitle("Jogo");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				Principal ex = null;
				try {
					ex = new Principal();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ex.setVisible(true);	
			}
		});
	}
}
