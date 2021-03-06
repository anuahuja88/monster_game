package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Where the player chooses his first monster to join his team
public class MonsterScreen {

	private JFrame window;
	private GameEnvironment manager;
	private Store store;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonsterScreen window = new MonsterScreen();
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
	public MonsterScreen() {
		initialize();
	}
	public MonsterScreen(GameEnvironment incoming) {
		manager = incoming;
		store = new Store();
		initialize();
		window.setVisible(true);
	}

	public void closeWindow() {
		window.dispose();
	}
	public void finshedWindow() {
		manager.closeMonsterScreen(this);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Choose Monster");
		window.setBounds(100, 100, 578, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		//Label for selecting players first monster
		JLabel slctMonstLabel = new JLabel("Select your first monster!");
		slctMonstLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		slctMonstLabel.setBounds(179, 41, 200, 23);
		window.getContentPane().add(slctMonstLabel);
		
		//Button to choose the first monster to be in players team
		JButton monst1Label = new JButton(store.getMonsterList().get(0).getMonsterName());
		monst1Label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().getMonsters().add(manager.getStore().getMonsterList().get(0));
				manager.getPlayer().changeCoins(-3);
				finshedWindow();
			}
		});
		monst1Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		monst1Label.setBounds(19, 103, 173, 95);
		window.getContentPane().add(monst1Label);
		
		//Button to choose the second monster to be in players team
		JButton monst2Label = new JButton(store.getMonsterList().get(1).getMonsterName());
		monst2Label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().getMonsters().add(store.getMonsterList().get(1));
				manager.getPlayer().changeCoins(-3);
				finshedWindow();
			}
		});
		monst2Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		monst2Label.setBounds(204, 103, 173, 95);
		window.getContentPane().add(monst2Label);
		
		//Button to choose the third monster to be in players team
		JButton monst3Label = new JButton(manager.getStore().getMonsterList().get(2).getMonsterName());
		monst3Label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getStore().createMonsterList(manager.getPlayer().getMonsters().size());
				manager.getPlayer().getMonsters().add(store.getMonsterList().get(2));
				manager.getPlayer().changeCoins(-3);
				finshedWindow();
			}
		});
		monst3Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		monst3Label.setBounds(389, 103, 173, 95);
		window.getContentPane().add(monst3Label);
		
		// Health of first monster Label
		JLabel health1Label = new JLabel("Health: " + store.getMonsterList().get(0).getHealth());
		health1Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		health1Label.setBounds(29, 209, 173, 31);
		window.getContentPane().add(health1Label);
		
		// Health of second monster Label
		JLabel health2Label = new JLabel("Health: " + store.getMonsterList().get(1).getHealth());
		health2Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		health2Label.setBounds(214, 209, 173, 31);
		window.getContentPane().add(health2Label);
		
		// Health of third monster Label
		JLabel health3Label = new JLabel("Health: " + store.getMonsterList().get(2).getHealth());
		health3Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		health3Label.setBounds(399, 209, 173, 31);
		window.getContentPane().add(health3Label);
		
		// Damage of first monster Label
		JLabel damage1Label = new JLabel("Damage: " + store.getMonsterList().get(0).getDamage());
		damage1Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		damage1Label.setBounds(29, 250, 173, 31);
		window.getContentPane().add(damage1Label);
		
		// Damage of second monster Label
		JLabel damage2Label = new JLabel("Damage: " + store.getMonsterList().get(1).getDamage());
		damage2Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		damage2Label.setBounds(214, 250, 173, 31);
		window.getContentPane().add(damage2Label);
		
		// Damage of third monster Label
		JLabel damage3Label = new JLabel("Damage: " + store.getMonsterList().get(2).getDamage());
		damage3Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		damage3Label.setBounds(399, 250, 173, 31);
		window.getContentPane().add(damage3Label);
		
		//Price of first monster
		JLabel price1Label = new JLabel("Price: $" + store.getMonsterList().get(0).getPrice());
		price1Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		price1Label.setBounds(29, 293, 173, 31);
		window.getContentPane().add(price1Label);
		
		//Price of second Monster
		JLabel price2Label = new JLabel("Price: $" + store.getMonsterList().get(1).getPrice());
		price2Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		price2Label.setBounds(214, 293, 173, 31);
		window.getContentPane().add(price2Label);
		
		//Price of third Monster
		JLabel price3Label = new JLabel("Price: $" + store.getMonsterList().get(2).getPrice());
		price3Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		price3Label.setBounds(399, 293, 173, 31);
		window.getContentPane().add(price3Label);
		
		//Displays available coins to the player
		JLabel lblNewLabel = new JLabel("Available coins = $" + manager.getPlayer().getCoins());
		lblNewLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		lblNewLabel.setBounds(19, 75, 183, 16);
		window.getContentPane().add(lblNewLabel);
		
		// welcomes player
		JLabel slctMonstLabel_1 = new JLabel("Welcome " + manager.getPlayer().getName());
		slctMonstLabel_1.setFont(new Font("Osaka", Font.PLAIN, 16));
		slctMonstLabel_1.setBounds(6, 6, 200, 23);
		window.getContentPane().add(slctMonstLabel_1);
	}
}
