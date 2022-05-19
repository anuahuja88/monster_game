package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MonsterScreen {

	private JFrame window;
	private GameEnvironment manager;
	

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
		
		JLabel slctMonstLabel = new JLabel("Select your first monster!");
		slctMonstLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		slctMonstLabel.setBounds(179, 41, 200, 23);
		window.getContentPane().add(slctMonstLabel);
		
		JButton monst1Label = new JButton(manager.getStore().getMonsterList().get(0).GetMonsterName());
		monst1Label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().GetMonsters().add(manager.getStore().getMonsterList().get(0));
				manager.getPlayer().ChangeCoins(-3);
				finshedWindow();
			}
		});
		monst1Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		monst1Label.setBounds(19, 103, 173, 95);
		window.getContentPane().add(monst1Label);
		
		JButton monst2Label = new JButton(manager.getStore().getMonsterList().get(1).GetMonsterName());
		monst2Label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getPlayer().GetMonsters().add(manager.getStore().getMonsterList().get(1));
				manager.getPlayer().ChangeCoins(-3);
				finshedWindow();
			}
		});
		monst2Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		monst2Label.setBounds(204, 103, 173, 95);
		window.getContentPane().add(monst2Label);
		
		JButton monst3Label = new JButton(manager.getStore().getMonsterList().get(2).GetMonsterName());
		monst3Label.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getStore().CreateMonsterList(manager.getPlayer().GetMonsters().size());
				manager.getPlayer().GetMonsters().add(manager.getStore().getMonsterList().get(2));
				manager.getPlayer().ChangeCoins(-3);
				finshedWindow();
			}
		});
		monst3Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		monst3Label.setBounds(389, 103, 173, 95);
		window.getContentPane().add(monst3Label);
		
		JLabel health1Label = new JLabel("Health: " + manager.getStore().getMonsterList().get(0).GetHealth());
		health1Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		health1Label.setBounds(29, 209, 173, 31);
		window.getContentPane().add(health1Label);
		
		JLabel health2Label = new JLabel("Health: " + manager.getStore().getMonsterList().get(1).GetHealth());
		health2Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		health2Label.setBounds(214, 209, 173, 31);
		window.getContentPane().add(health2Label);
		
		JLabel health3Label = new JLabel("Health: " + manager.getStore().getMonsterList().get(2).GetHealth());
		health3Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		health3Label.setBounds(399, 209, 173, 31);
		window.getContentPane().add(health3Label);
		
		JLabel damage1Label = new JLabel("Damage: " + manager.getStore().getMonsterList().get(0).GetDamage());
		damage1Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		damage1Label.setBounds(29, 250, 173, 31);
		window.getContentPane().add(damage1Label);
		
		JLabel damage2Label = new JLabel("Damage: " + manager.getStore().getMonsterList().get(1).GetDamage());
		damage2Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		damage2Label.setBounds(214, 250, 173, 31);
		window.getContentPane().add(damage2Label);
		
		JLabel damage3Label = new JLabel("Damage: " + manager.getStore().getMonsterList().get(2).GetDamage());
		damage3Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		damage3Label.setBounds(399, 250, 173, 31);
		window.getContentPane().add(damage3Label);
		
		JLabel price1Label = new JLabel("Price: $" + manager.getStore().getMonsterList().get(0).GetPrice());
		price1Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		price1Label.setBounds(29, 293, 173, 31);
		window.getContentPane().add(price1Label);
		
		JLabel price2Label = new JLabel("Price: $" + manager.getStore().getMonsterList().get(1).GetPrice());
		price2Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		price2Label.setBounds(214, 293, 173, 31);
		window.getContentPane().add(price2Label);
		
		JLabel price3Label = new JLabel("Price: $" + manager.getStore().getMonsterList().get(2).GetPrice());
		price3Label.setFont(new Font("Osaka", Font.PLAIN, 16));
		price3Label.setBounds(399, 293, 173, 31);
		window.getContentPane().add(price3Label);
		
		JLabel lblNewLabel = new JLabel("Available coins = $" + manager.getPlayer().GetCoins());
		lblNewLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		lblNewLabel.setBounds(19, 75, 183, 16);
		window.getContentPane().add(lblNewLabel);
		
		JLabel slctMonstLabel_1 = new JLabel("Welcome " + manager.getPlayer().GetName());
		slctMonstLabel_1.setFont(new Font("Osaka", Font.PLAIN, 16));
		slctMonstLabel_1.setBounds(6, 6, 200, 23);
		window.getContentPane().add(slctMonstLabel_1);
	}
}
