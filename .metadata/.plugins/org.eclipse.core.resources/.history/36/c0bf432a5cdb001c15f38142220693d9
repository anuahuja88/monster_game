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
	public GameOverScreen() {
		initialize();
	}
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
		
		JLabel gameOverLbl = new JLabel("");
		gameOverLbl.setFont(new Font("Osaka", Font.PLAIN, 28));
		gameOverLbl.setBounds(173, 61, 205, 66);
		window.getContentPane().add(gameOverLbl);
		if (manager.getPlayer().getWonLastGame() == true) {
			gameOverLbl.setText("Game Over :)");
			gameOverLbl.setForeground(Color.GREEN);
		}else {
			gameOverLbl.setText("Game Over :(");
			gameOverLbl.setForeground(Color.RED);
		}
		
		JLabel messageLbl = new JLabel(manager.getPlayer().getName() + " lasted " + manager.getPlayer().getCurrentDay() + " days.");
		messageLbl.setFont(new Font("Osaka", Font.PLAIN, 16));
		messageLbl.setBounds(66, 158, 466, 28);
		window.getContentPane().add(messageLbl);
		
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		quitButton.setFont(new Font("Osaka", Font.PLAIN, 16));
		quitButton.setBounds(173, 256, 205, 66);
		window.getContentPane().add(quitButton);
		
		JLabel scoreLabel = new JLabel("Your final score is " + manager.getPlayer().getScore());
		scoreLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		scoreLabel.setBounds(66, 190, 466, 28);
		window.getContentPane().add(scoreLabel);
	}
}
