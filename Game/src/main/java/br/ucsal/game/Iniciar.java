package br.ucsal.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class Iniciar extends JFrame {

	private static final long serialVersionUID = 1L;

	private final int B_HEIGHT = 950;
	private final int B_WIDTH = 600;
	
	public Iniciar() {
		construirMenuBar();
		construirFase();
		configurarTela();
	}

	public static void main(String[] args) {
		new Iniciar();
	}

	private JMenuBar construirMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBorder(new LineBorder(Color.red));
		JMenu menu = new JMenu("Options");
		
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		menu.add(new JSeparator());
		menu.add(sair);
		menuBar.add(menu);
		setJMenuBar(menuBar);

		return menuBar;
	}

	private JPanel construirFase() {
		PrimeiraFase fase = new PrimeiraFase();
		add(fase);
		return fase;
	}

	private void configurarTela() {
		setSize(B_HEIGHT, B_WIDTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Space Nave");
	}
}
