package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;


//Main menu is the hub of the game, the player can go to the store, view his team and battle from here
public class MainMenu {

	private JFrame window;
	private GameEnvironment manager;
	private MainMenu screen;
	private RandomEvent random;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu(GameEnvironment incoming) {
		manager = incoming;
		screen = this;
		initialize();
		window.setVisible(true);
	}
	public MainMenu(GameEnvironment incoming, RandomEvent newRandom) {
		manager = incoming;
		screen = this;
		random = newRandom;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closeMainMenu(this);
	}
	public MainMenu() {
		initialize();
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Main Menu");
		window.setBounds(100, 100, 622, 427);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(23, 58, 229, 97);
		window.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel coinLabel = new JLabel("Coins: " + manager.getPlayer().getCoins());
		coinLabel.setBounds(10, 6, 267, 23);
		panel.add(coinLabel);
		coinLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		
		JLabel lblCurrentDau = new JLabel("Current day: " + manager.getPlayer().getCurrentDay());
		lblCurrentDau.setBounds(10, 38, 267, 23);
		panel.add(lblCurrentDau);
		lblCurrentDau.setFont(new Font("Osaka", Font.PLAIN, 16));
		
		JLabel lblDaysRemaining = new JLabel("Days remaining: " + (manager.getPlayer().getDays()- manager.getPlayer().getCurrentDay() ));
		lblDaysRemaining.setBounds(10, 68, 267, 23);
		panel.add(lblDaysRemaining);
		lblDaysRemaining.setFont(new Font("Osaka", Font.PLAIN, 16));
		
		JLabel progressLabel = new JLabel("Game Progress");
		progressLabel.setBounds(23, 21, 130, 27);
		progressLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(progressLabel);
		
		JButton VisitStoreButton = new JButton("Visit Store");
		VisitStoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				manager.launchStoreScreen();
			}
		});
		VisitStoreButton.setFont(new Font("Osaka", Font.PLAIN, 16));
		VisitStoreButton.setBounds(478, 346, 130, 38);
		window.getContentPane().add(VisitStoreButton);
		
		JLabel lblNewLabel = new JLabel("Choose a team to battle");
		lblNewLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 161, 253, 38);
		window.getContentPane().add(lblNewLabel);
		
	
		
		JButton battle_1_Button = new JButton();
		battle_1_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.getBattles().getPossibleBattles().get(0).setPlayerSelected(true);
				finishedWindow();
				manager.launchBattleScreen();
			}
		});
		battle_1_Button.setText(manager.getBattles().getPossibleBattles().get(0).getName());
		battle_1_Button.setFont(new Font("Osaka", Font.PLAIN, 16));
		battle_1_Button.setBounds(6, 211, 147, 82);
		window.getContentPane().add(battle_1_Button);
		
		JButton btnBattle = new JButton(manager.getBattles().getPossibleBattles().get(1).getName());
		btnBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.getBattles().getPossibleBattles().get(1).setPlayerSelected(true);
				finishedWindow();
				manager.launchBattleScreen();
			}
		});
		btnBattle.setFont(new Font("Osaka", Font.PLAIN, 16));
		btnBattle.setBounds(165, 211, 147, 82);
		window.getContentPane().add(btnBattle);
		
		JButton btnBattle_1 = new JButton(manager.getBattles().getPossibleBattles().get(2).getName());
		btnBattle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.getBattles().getPossibleBattles().get(2).setPlayerSelected(true);
				finishedWindow();
				manager.launchBattleScreen();
			}
		});
		btnBattle_1.setFont(new Font("Osaka", Font.PLAIN, 16));
		btnBattle_1.setBounds(324, 211, 150, 82);
		window.getContentPane().add(btnBattle_1);
		
		JLabel health1Label = new JLabel("Total Health: " +  Integer.toString(manager.getBattles().getPossibleBattles().get(0).getTotalHealth()));
		health1Label.setFont(new Font("Osaka", Font.PLAIN, 14));
		health1Label.setBounds(10, 293, 117, 31);
		window.getContentPane().add(health1Label);
		
		JLabel lblDamage = new JLabel("Total Damage: " + Integer.toString(manager.getBattles().getPossibleBattles().get(0).getTotalDamage()));
		lblDamage.setFont(new Font("Osaka", Font.PLAIN, 14));
		lblDamage.setBounds(10, 321, 123, 31);
		window.getContentPane().add(lblDamage);
		
		JButton viewTeamButton = new JButton("View Team/Item");
		viewTeamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				manager.launchViewTeamScreen();
			}
		});
		viewTeamButton.setFont(new Font("Osaka", Font.PLAIN, 16));
		viewTeamButton.setBounds(264, 58, 308, 97);
		window.getContentPane().add(viewTeamButton);
		
		JLabel health1Label_1 = new JLabel("Total Health: " + Integer.toString(manager.getBattles().getPossibleBattles().get(1).getTotalHealth()));
		health1Label_1.setFont(new Font("Osaka", Font.PLAIN, 14));
		health1Label_1.setBounds(165, 293, 117, 31);
		window.getContentPane().add(health1Label_1);
		
		JLabel health1Label_2 = new JLabel("Total Health: "  + Integer.toString(manager.getBattles().getPossibleBattles().get(2).getTotalHealth()));
		health1Label_2.setFont(new Font("Osaka", Font.PLAIN, 14));
		health1Label_2.setBounds(324, 293, 117, 31);
		window.getContentPane().add(health1Label_2);
		
		JLabel lblDamage_1 = new JLabel("Total Damage: " + Integer.toString(manager.getBattles().getPossibleBattles().get(1).getTotalDamage()));
		lblDamage_1.setFont(new Font("Osaka", Font.PLAIN, 14));
		lblDamage_1.setBounds(166, 321, 123, 31);
		window.getContentPane().add(lblDamage_1);
		
		JLabel lblDamage_2 = new JLabel("Total Damage: " + Integer.toString(manager.getBattles().getPossibleBattles().get(2).getTotalDamage()));
		lblDamage_2.setFont(new Font("Osaka", Font.PLAIN, 14));
		lblDamage_2.setBounds(324, 321, 123, 31);
		window.getContentPane().add(lblDamage_2);
		
		JLabel randomEventLbl = new JLabel("");
		randomEventLbl.setForeground(Color.RED);
		randomEventLbl.setFont(new Font("Dialog", Font.BOLD, 16));
		randomEventLbl.setBounds(165, 21, 407, 22);
		window.getContentPane().add(randomEventLbl);
		try {
		if (random.monsterLeave == true) {
			System.out.println("asdf");
			randomEventLbl.setText("Monster randomly left overnight");
			manager.getRandomEvent().monsterLeave = false;
		}
		if (random.newMonster == true) {
			randomEventLbl.setText("New Monster randomly joined overnight");
			manager.getRandomEvent().newMonster = false;
		}
		if (random.levelUp == true) {
			randomEventLbl.setText("Monster randomly levelled up overnight");
			manager.getRandomEvent().levelUp = false;
		}
		}catch (Exception e) {
			randomEventLbl.setText("");
		}
		
	}
}
