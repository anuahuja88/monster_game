package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

// BattleScreen displays the line up of monsters battling from the chosen teams
//This is where the battle occurs and the outcome is then displayed to the user 
public class BattleScreen {

	private JFrame window;
	private GameEnvironment manager;
	private BattleScreen screen;
	private Player enemyPlayer;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public BattleScreen(GameEnvironment incoming) {
		manager = incoming;
		screen = this;
		chooseEnemyPlayer();
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closeBattleScreen(this);
	}
	public void  chooseEnemyPlayer() {
		for (Player battle : manager.getBattles().getPossibleBattles()) {
	
			if(battle.getPlayerSelected() == true) {

				enemyPlayer = battle;
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Battle Screen");
		window.setBounds(100, 100, 650, 450);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		//sets up message label
		JLabel messageLabel = new JLabel("");
		messageLabel.setForeground(Color.RED);
		messageLabel.setBounds(39, 26, 471, 27);
		window.getContentPane().add(messageLabel);
		
		JLabel welcomeLabel = new JLabel("Battle Zone!");
		welcomeLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		welcomeLabel.setBounds(224, 12, 154, 15);
		window.getContentPane().add(welcomeLabel);
		
		JLabel vsLabel = new JLabel("VS");
		vsLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		vsLabel.setBounds(257, 143, 67, 59);
		window.getContentPane().add(vsLabel);
		
		//button that runs the battle functions and shows the player the outcome of the battle
		JButton batlleButton = new JButton("Battle!");
		batlleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.battle(manager.getPlayer(), enemyPlayer);			
				if (manager.getPlayer().getCoins() < 3 && manager.getPlayer().getWonLastGame()==false) {
					finishedWindow();
					manager.endGame(true);
					manager.launchGameOverScreen();
				}else {
					finishedWindow();
					manager.launchPostBattleScreen();	
						

				}
			}
		});
		batlleButton.setBounds(199, 255, 154, 75);
		window.getContentPane().add(batlleButton);
		
		//takes player back to main menu
		JButton mainMenuButton = new JButton("Main Menu");
		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enemyPlayer.setPlayerSelected(false);
				finishedWindow();
				manager.launchMainMenu();
			}
		});
		mainMenuButton.setBounds(472, 372, 145, 35);
		window.getContentPane().add(mainMenuButton);
		
		//displays home players name 
		JLabel homePlayer = new JLabel(manager.getPlayer().getName());
		homePlayer.setFont(new Font("Dialog", Font.BOLD, 16));
		homePlayer.setBounds(55, 51, 154, 15);
		window.getContentPane().add(homePlayer);
		
		//displays enemy players name 
		JLabel enemyPlayerLbl = new JLabel(enemyPlayer.getName());
		enemyPlayerLbl.setFont(new Font("Dialog", Font.BOLD, 16));
		enemyPlayerLbl.setBounds(383, 52, 154, 15);
		window.getContentPane().add(enemyPlayerLbl);
		
		//displays players team
		JButton myMonst1 = new JButton("");
		myMonst1.setBounds(42, 78, 145, 59);
		window.getContentPane().add(myMonst1);
		if (manager.getPlayer().getMonsters().size() == 0) {
			messageLabel.setText("No monsters in team, purchase monster from store before continuing");
		}else {
			myMonst1.setText(manager.getPlayer().getMonsters().get(0).getMonsterName());
		}
		
		//displays players team
		JButton myMonst2 = new JButton("");
		myMonst2.setBounds(42, 149, 145, 59);
		window.getContentPane().add(myMonst2);
		if (manager.getPlayer().getMonsters().size() == 2) {
			myMonst1.setText(manager.getPlayer().getMonsters().get(0).getMonsterName());
			myMonst2.setText(manager.getPlayer().getMonsters().get(1).getMonsterName());
			
		}
		
		//displays players team
		JButton myMonst3 = new JButton("");
		myMonst3.setBounds(42, 220, 145, 59);
		window.getContentPane().add(myMonst3);
		if (manager.getPlayer().getMonsters().size() == 3) {
			myMonst1.setText(manager.getPlayer().getMonsters().get(0).getMonsterName());
			myMonst2.setText(manager.getPlayer().getMonsters().get(1).getMonsterName());
			myMonst3.setText(manager.getPlayer().getMonsters().get(2).getMonsterName());
			
		}
		//displays enemys team
		JButton enemyMonst1 = new JButton("");
		enemyMonst1.setBounds(365, 78, 145, 59);
		window.getContentPane().add(enemyMonst1);
		if (enemyPlayer.getMonsters().size() == 1) {
			enemyMonst1.setText(enemyPlayer.getMonsters().get(0).getMonsterName());
			
		}
		//displays enemys team
		JButton enemyMonst2 = new JButton("");
		enemyMonst2.setBounds(365, 149, 145, 59);
		window.getContentPane().add(enemyMonst2);
		if (enemyPlayer.getMonsters().size() == 2) {
			enemyMonst1.setText(enemyPlayer.getMonsters().get(0).getMonsterName());
			enemyMonst2.setText(enemyPlayer.getMonsters().get(1).getMonsterName());
			
		}
		//displays enemys team
		JButton enemyMonst3 = new JButton("");
		enemyMonst3.setBounds(365, 220, 145, 59);
		window.getContentPane().add(enemyMonst3);
		if (enemyPlayer.getMonsters().size() == 3) {
			enemyMonst1.setText(enemyPlayer.getMonsters().get(0).getMonsterName());
			enemyMonst2.setText(enemyPlayer.getMonsters().get(1).getMonsterName());
			enemyMonst3.setText(enemyPlayer.getMonsters().get(2).getMonsterName());
			
		}
		
		
	
	}
}
