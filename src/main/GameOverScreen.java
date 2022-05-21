package main;
import java.awt.EventQueue;

import javax.swing.JFrame;

import main.GameEnvironment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameOverScreen {

	private JFrame window;
	private GameEnvironment manager;
	private GameOverScreen screen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOverScreen window = new GameOverScreen();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameOverScreen(GameEnvironment incoming) {
		manager = incoming;
		screen = this;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closeGameOverScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 578, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel gameOverLbl = new JLabel("Game Over :(");
		gameOverLbl.setForeground(Color.RED);
		gameOverLbl.setFont(new Font("Osaka", Font.PLAIN, 28));
		gameOverLbl.setBounds(173, 61, 205, 66);
		window.getContentPane().add(gameOverLbl);
		
		JLabel messageLbl = new JLabel(manager.getPlayer().getName() + " lasted " + manager.getPlayer().getCurrentDay() + " days.");
		messageLbl.setFont(new Font("Osaka", Font.PLAIN, 16));
		messageLbl.setBounds(66, 158, 466, 28);
		window.getContentPane().add(messageLbl);
		
		JButton restartButton = new JButton("Play Again");
		restartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		restartButton.setFont(new Font("Osaka", Font.PLAIN, 16));
		restartButton.setBounds(173, 256, 205, 66);
		window.getContentPane().add(restartButton);
	}
}
