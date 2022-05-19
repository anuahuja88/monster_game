package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewTeamScreen {

	private JFrame window;
	private GameEnvironment manager;
	private Item jamJar;
	private Item strengthPotion;
	private Item healthPotion;
	private int amountHealth = 0;  // amount of health potions in inventory initialized to 0
	private int amountStrength = 0;  // amount of Strength potions in inventory initialized to 0
	private int amountJam = 0;  // amount of jam jars in inventory initialized to 0

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTeamScreen window = new ViewTeamScreen();
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
	public ViewTeamScreen() {
		initialize();
	}
	public ViewTeamScreen(GameEnvironment incoming) {
		manager = incoming;
		jamJar = manager.getStore().getItemList().get(0);
		strengthPotion =  manager.getStore().getItemList().get(1);
		healthPotion = manager.getStore().getItemList().get(2);
		initialize();
		window.setVisible(true);
	}

	public void closeWindow() {
		window.dispose();
	}
	public void finshedWindow() {
		manager.closeViewTeamScreen(this);
	}

	/**
	 * Initialize the contents of the window.
	 */
	private void initialize() {
		window = new JFrame();
		window.getContentPane().setFont(new Font("Osaka", Font.PLAIN, 16));
		window.setBounds(100, 100, 578, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel messageLbl = new JLabel("");
		messageLbl.setBounds(221, 6, 325, 34);
		messageLbl.setForeground(Color.RED);
		messageLbl.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(messageLbl);
		
		JLabel lblNewLabel = new JLabel("Your Team");
		lblNewLabel.setBounds(26, 6, 118, 34);
		lblNewLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(lblNewLabel);
		
		JButton mainMenuButton = new JButton("Main Menu");
		mainMenuButton.setBounds(411, 317, 144, 44);
		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finshedWindow();
			}
		});
		mainMenuButton.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(mainMenuButton);
		
		JLabel inventoryLbl = new JLabel("Inventory");
		inventoryLbl.setBounds(26, 296, 169, 21);
		inventoryLbl.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(inventoryLbl);
		
		JLabel hlthPotionInvent = new JLabel("Health Potions: 0");

		for (Item i : manager.getPlayer().GetItems()) {
			if (i == healthPotion) {
				amountHealth ++;
			}
		}
		hlthPotionInvent.setText("Health Potions: " + amountHealth);
		hlthPotionInvent.setFont(new Font("Osaka", Font.PLAIN, 14));
		hlthPotionInvent.setBounds(6, 329, 128, 21);
		window.getContentPane().add(hlthPotionInvent);
		
		JLabel lblStrengthPotions = new JLabel("Strength Potions: 0");

		for (Item i : manager.getPlayer().GetItems()) {
			if (i == strengthPotion) {
				amountStrength ++;
			}
		}
		lblStrengthPotions.setText("Strength Potions: " + amountStrength);
		lblStrengthPotions.setFont(new Font("Osaka", Font.PLAIN, 14));
		lblStrengthPotions.setBounds(146, 329, 128, 21);
		window.getContentPane().add(lblStrengthPotions);
		
		JLabel lblJamJars = new JLabel("Jam Jars: 0");
		for (Item i : manager.getPlayer().GetItems()) {
			if (i == jamJar) {
				amountJam ++;
			}
		}
		lblJamJars.setText("Jam Jars: " + amountJam);
		lblJamJars.setFont(new Font("Osaka", Font.PLAIN, 14));
		lblJamJars.setBounds(293, 329, 118, 21);
		window.getContentPane().add(lblJamJars);
		
		JButton monst1 = new JButton(manager.getPlayer().GetMonsters().get(0).GetMonsterName());
		monst1.setBounds(26, 52, 169, 55);
		window.getContentPane().add(monst1);
		
		JButton monst2 = new JButton("");
		monst2.setBounds(207, 52, 169, 55);
		if (manager.getPlayer().GetMonsters().size() == 2) {
			monst2.setText(manager.getPlayer().GetMonsters().get(1).GetMonsterName());
		}
		window.getContentPane().add(monst2);
		
		
		JButton monst3 = new JButton("");
		monst3.setBounds(386, 52, 169, 55);
		window.getContentPane().add(monst3);
		if (manager.getPlayer().GetMonsters().size() == 3) {
			monst2.setText(manager.getPlayer().GetMonsters().get(1).GetMonsterName());
			monst3.setText(manager.getPlayer().GetMonsters().get(2).GetMonsterName());
		}
		
		JLabel healthLbl1 = new JLabel("Health: " + manager.getPlayer().GetMonsters().get(0).GetHealth());
		healthLbl1.setBounds(26, 119, 169, 21);
		healthLbl1.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(healthLbl1);
		
		JLabel healthLbl2 = new JLabel("Health:");
		healthLbl2.setBounds(207, 119, 169, 21);
		healthLbl2.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(healthLbl2);
		if (manager.getPlayer().GetMonsters().size() == 2) {
			healthLbl2.setText("Health: " + manager.getPlayer().GetMonsters().get(1).GetHealth());
		}
		
		JLabel healthLbl3 = new JLabel("Health:");
		healthLbl3.setBounds(386, 119, 169, 21);
		healthLbl3.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(healthLbl3);
		if (manager.getPlayer().GetMonsters().size() == 3) {
			healthLbl2.setText("Health: " + manager.getPlayer().GetMonsters().get(1).GetHealth());
			healthLbl3.setText("Health: " + manager.getPlayer().GetMonsters().get(2).GetHealth());
		}
		
		JLabel damageLbl1 = new JLabel("Damage: " + manager.getPlayer().GetMonsters().get(0).GetDamage());
		damageLbl1.setBounds(26, 152, 169, 21);
		damageLbl1.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(damageLbl1);
		
		JLabel damageLbl2 = new JLabel("Damage:");
		damageLbl2.setBounds(207, 152, 169, 21);
		damageLbl2.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(damageLbl2);
		if (manager.getPlayer().GetMonsters().size() == 2) {
			damageLbl2.setText("Damage: " + manager.getPlayer().GetMonsters().get(1).GetDamage());
		}
		
		JLabel damageLbl3 = new JLabel("Damage:");
		damageLbl3.setBounds(386, 152, 169, 21);
		damageLbl3.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(damageLbl3);
		if (manager.getPlayer().GetMonsters().size() == 3) {
			damageLbl2.setText("Damage: " + manager.getPlayer().GetMonsters().get(1).GetDamage());
			damageLbl3.setText("Damage: " + manager.getPlayer().GetMonsters().get(2).GetDamage());
		}
		
		JButton applyHP_1 = new JButton("Apply Health potion");
		applyHP_1.setBounds(26, 185, 169, 34);
		applyHP_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().GetItems().contains(healthPotion) == true){
					manager.getPlayer().GetMonsters().get(0).ChangeHealth(5);
					healthLbl1.setText("Health: " + manager.getPlayer().GetMonsters().get(0).GetHealth());
					hlthPotionInvent.setText("Health Potions: " + (amountHealth -1));
					messageLbl.setText("Health Potion Applied to monster");
					window.repaint();
					manager.getPlayer().GetItems().remove(healthPotion);
				}else {
					messageLbl.setText("Item does not exist in your inventory");
				}
			}
		});
		window.getContentPane().add(applyHP_1);
		
		JButton applySP_1 = new JButton("Apply Strength  potion");
		applySP_1.setBounds(26, 219, 169, 34);
		applySP_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().GetItems().contains(strengthPotion) == true){
					manager.getPlayer().GetMonsters().get(0).ChangeDamage(5);
					damageLbl1.setText("Damage: " + manager.getPlayer().GetMonsters().get(0).GetDamage());
					messageLbl.setText("Strength Potion Applied to monster");
					lblStrengthPotions.setText("Strength Potions: " + (amountStrength-1));
					window.repaint();
					manager.getPlayer().GetItems().remove(strengthPotion);
				}else {
					messageLbl.setText("Item does not exist in your inventory");
				}
			}
		});
		window.getContentPane().add(applySP_1);
		
		JButton applyJJ_1 = new JButton("Apply JamJar");
		applyJJ_1.setBounds(26, 252, 169, 34);
		applyJJ_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().GetItems().contains(jamJar) == true){
					manager.getPlayer().GetMonsters().get(0).ChangeHealth(5);
					manager.getPlayer().GetMonsters().get(0).ChangeDamage(5);
					healthLbl1.setText("Health: " + manager.getPlayer().GetMonsters().get(0).GetHealth());
					damageLbl1.setText("Damage: " + manager.getPlayer().GetMonsters().get(0).GetDamage());
					messageLbl.setText("Jam Jar Applied to monster");
					lblJamJars.setText("Jam Jars: " + (amountJam-1));
					window.repaint();
					manager.getPlayer().GetItems().remove(jamJar);
				}else {
					messageLbl.setText("Item does not exist in your inventory");
				}
			}
		});
		window.getContentPane().add(applyJJ_1);
		
		JButton applyHP_2 = new JButton("Apply Health potion");
		applyHP_2.setBounds(196, 185, 169, 34);
		applyHP_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().GetMonsters().size() == 2) {
					if (manager.getPlayer().GetItems().contains(healthPotion) == true){
						manager.getPlayer().GetMonsters().get(1).ChangeHealth(5);
						healthLbl2.setText("Health: " + manager.getPlayer().GetMonsters().get(1).GetHealth());
						messageLbl.setText("Health Potion Applied to monster");
						hlthPotionInvent.setText("Health Potions: " + (amountHealth -1));
						window.repaint();
						manager.getPlayer().GetItems().remove(healthPotion);
					}else {
						messageLbl.setText("Item does not exist in your inventory");
					}
				}else {
					messageLbl.setText("No monster");

				}
				}
		});
		window.getContentPane().add(applyHP_2);
		
		JButton applyHP_3 = new JButton("Apply Health potion");
		applyHP_3.setBounds(377, 185, 169, 34);
		applyHP_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().GetMonsters().size() == 3) {
					if (manager.getPlayer().GetItems().contains(healthPotion) == true){
						manager.getPlayer().GetMonsters().get(2).ChangeHealth(5);
						healthLbl3.setText("Health: " + manager.getPlayer().GetMonsters().get(2).GetHealth());
						messageLbl.setText("Health Potion Applied to monster");
						hlthPotionInvent.setText("Health Potions: " + (amountHealth -1));
						window.repaint();
						manager.getPlayer().GetItems().remove(healthPotion);
					}else {
						messageLbl.setText("Item does not exist in your inventory");
					}
				}else {
					messageLbl.setText("No monster");

				}
				}
		});
		window.getContentPane().add(applyHP_3);
		
		JButton applySP_2 = 
				
				
				new JButton("Apply Strength  potion");
		applySP_2.setBounds(196, 219, 169, 34);
		applySP_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().GetMonsters().size() == 2) {
					if (manager.getPlayer().GetItems().contains(strengthPotion) == true){
						manager.getPlayer().GetMonsters().get(1).ChangeDamage(5);
						damageLbl2.setText("Damage: " + manager.getPlayer().GetMonsters().get(1).GetDamage());
						messageLbl.setText("Strength Potion Applied to monster");
						lblStrengthPotions.setText("Strength Potions: " + (amountStrength-1));
						window.repaint();
						manager.getPlayer().GetItems().remove(strengthPotion);
					}else {
						messageLbl.setText("Item does not exist in your inventory");
					}
				}else {
					messageLbl.setText("No monster");

			}}
		});
		window.getContentPane().add(applySP_2);
		
		JButton applySP_3 = new JButton("Apply Strength  potion");
		applySP_3.setBounds(377, 219, 169, 34);
		applySP_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().GetMonsters().size() == 3) {
					if (manager.getPlayer().GetItems().contains(strengthPotion) == true){
						manager.getPlayer().GetMonsters().get(2).ChangeDamage(5);
						damageLbl2.setText("Damage: " + manager.getPlayer().GetMonsters().get(2).GetDamage());
						messageLbl.setText("Strength Potion Applied to monster");
						lblStrengthPotions.setText("Strength Potions: " + (amountStrength-1));
						window.repaint();
						manager.getPlayer().GetItems().remove(strengthPotion);
					}else {
						messageLbl.setText("Item does not exist in your inventory");
					}
				}else {
					messageLbl.setText("No monster");

			}}
		});
		window.getContentPane().add(applySP_3);
		
		JButton applyJJ_2 = new JButton("Apply JamJar");
		applyJJ_2.setBounds(196, 252, 169, 34);
		applyJJ_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().GetMonsters().size() == 2) {
					if (manager.getPlayer().GetItems().contains(jamJar) == true){
						manager.getPlayer().GetMonsters().get(1).ChangeHealth(5);
						manager.getPlayer().GetMonsters().get(1).ChangeDamage(5);
						healthLbl2.setText("Health: " + manager.getPlayer().GetMonsters().get(1).GetHealth());
						damageLbl2.setText("Damage: " + manager.getPlayer().GetMonsters().get(1).GetDamage());
						messageLbl.setText("Strength Potion Applied to monster");
						lblJamJars.setText("Jam Jars: " + (amountJam-1));
						window.repaint();
						manager.getPlayer().GetItems().remove(jamJar);
					}else {
						messageLbl.setText("Item does not exist in your inventory");
					}
				}else {
					messageLbl.setText("No monster");

				}
			}
		});
		window.getContentPane().add(applyJJ_2);
		
		JButton applyJJ_3 = new JButton("Apply JamJar");
		applyJJ_3.setBounds(377, 252, 169, 34);
		applyJJ_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().GetMonsters().size() == 3) {
					if (manager.getPlayer().GetItems().contains(jamJar) == true){
						manager.getPlayer().GetMonsters().get(2).ChangeHealth(5);
						manager.getPlayer().GetMonsters().get(2).ChangeDamage(5);
						healthLbl2.setText("Health: " + manager.getPlayer().GetMonsters().get(2).GetHealth());
						damageLbl2.setText("Damage: " + manager.getPlayer().GetMonsters().get(2).GetDamage());
						messageLbl.setText("Jam Jar Applied to monster");
						lblJamJars.setText("Jam Jars: " + (amountJam-1));
						window.repaint();
						manager.getPlayer().GetItems().remove(jamJar);
					}else {
						messageLbl.setText("Item does not exist in your inventory");
					}
				}else {
					messageLbl.setText("No monster");
				}
			}
		});
		window.getContentPane().add(applyJJ_3);
		
		
		
		
	}
}