package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//After each battle the player will come here to see if they won or lost, and how many coins they won
public class PostBattleScreen {

	private JFrame window;
	private GameEnvironment manager;
	private PostBattleScreen screen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostBattleScreen window = new PostBattleScreen();
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
	public PostBattleScreen() {
		initialize();
	}
	public  PostBattleScreen(GameEnvironment incoming) {
		manager = incoming;
		screen = this;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closePostBattleScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 578, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel messageLabel = new JLabel("");
		messageLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		messageLabel.setBounds(108, 22, 456, 51);
		window.getContentPane().add(messageLabel);
		if (manager.getPlayer().getWonLastGame() == true) {
			messageLabel.setText("Congratulations, you won the battle!");
			messageLabel.setForeground(Color.GREEN);
		}else {
			messageLabel.setText("Unfortunately.... you lost the battle :((");
			messageLabel.setForeground(Color.RED);
		}
		
		JButton btnNewButton = new JButton("Sleep");
		btnNewButton.setBounds(179, 274, 223, 70);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.getPlayer().getCurrentDay() < manager.getPlayer().getDays() -1) {
					finishedWindow();
				}else {
					window.dispose();
					manager.launchGameOverScreen();
				}
			}
		});
		btnNewButton.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(btnNewButton);
		
		JLabel coinsGained = new JLabel();
		coinsGained.setForeground(Color.BLACK);
		coinsGained.setBounds(34, 96, 516, 33);
		window.getContentPane().add(coinsGained);
		if (manager.getPlayer().getWonLastGame() == true) {
			coinsGained.setText("You gained " + manager.getBattle().getAddedCoins() + " coins");
		}else {
			coinsGained.setText("Your whole team is dead! Purchase another monster before battling again.");
		}
	}
}
