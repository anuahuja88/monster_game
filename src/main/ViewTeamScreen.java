package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


//Where player can view his entire team and inventory of items and can apply those items to their team
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
		window.setBounds(100, 100, 650, 450);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel messageLbl = new JLabel("");
		messageLbl.setBounds(230, 6, 325, 34);
		messageLbl.setForeground(Color.RED);
		messageLbl.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(messageLbl);
		
		JLabel lblNewLabel = new JLabel("Your Team");
		lblNewLabel.setBounds(26, 6, 118, 34);
		lblNewLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(lblNewLabel);
		
		JButton mainMenuButton = new JButton("Main Menu");
		mainMenuButton.setBounds(500, 384, 144, 44);
		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finshedWindow();
			}
		});
		mainMenuButton.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(mainMenuButton);
		
		JLabel inventoryLbl = new JLabel("Inventory");
		inventoryLbl.setBounds(16, 298, 169, 21);
		inventoryLbl.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(inventoryLbl);
		
		JLabel hlthPotionInvent = new JLabel("Health Potions: 0");

		for (Item i : manager.getPlayer().getItems()) {
			if (i == healthPotion) {
				amountHealth ++;
			}
		}
		hlthPotionInvent.setText("Health Potions: " + amountHealth);
		hlthPotionInvent.setFont(new Font("Osaka", Font.PLAIN, 14));
		hlthPotionInvent.setBounds(16, 396, 128, 21);
		window.getContentPane().add(hlthPotionInvent);
		
		JLabel lblStrengthPotions = new JLabel("Strength Potions: 0");

		for (Item i : manager.getPlayer().getItems()) {
			if (i == strengthPotion) {
				amountStrength ++;
			}
		}
		lblStrengthPotions.setText("Strength Potions: " + amountStrength);
		lblStrengthPotions.setFont(new Font("Osaka", Font.PLAIN, 14));
		lblStrengthPotions.setBounds(207, 396, 150, 21);
		window.getContentPane().add(lblStrengthPotions);
		
		JLabel lblJamJars = new JLabel("Jam Jars: 0");
		for (Item i : manager.getPlayer().getItems()) {
			if (i == jamJar) {
				amountJam ++;
			}
		}
		lblJamJars.setText("Jam Jars: " + amountJam);
		lblJamJars.setFont(new Font("Osaka", Font.PLAIN, 14));
		lblJamJars.setBounds(415, 396, 118, 21);
		window.getContentPane().add(lblJamJars);
		
		JLabel healthLbl1 = new JLabel("Health: ");
		healthLbl1.setBounds(26, 119, 169, 21);
		healthLbl1.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(healthLbl1);
		
		JLabel damageLbl1 = new JLabel("Damage: ");
		damageLbl1.setBounds(26, 152, 169, 21);
		damageLbl1.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(damageLbl1);
		
		JButton monst1 = new JButton();
		monst1.setBounds(26, 52, 169, 55);
		window.getContentPane().add(monst1);
		if (manager.getPlayer().getMonsters().size() != 0) {
			monst1.setText(manager.getPlayer().getMonsters().get(0).getMonsterName());
			healthLbl1.setText("Health: " + manager.getPlayer().getMonsters().get(0).getHealth());
			damageLbl1.setText("Damage: " + manager.getPlayer().getMonsters().get(0).getDamage());
		}
		
		JButton monst2 = new JButton("");
		monst2.setBounds(207, 52, 169, 55);
		if (manager.getPlayer().getMonsters().size() == 2) {
			monst2.setText(manager.getPlayer().getMonsters().get(1).getMonsterName());
		}
		window.getContentPane().add(monst2);
		
		
		JButton monst3 = new JButton("");
		monst3.setBounds(386, 52, 169, 55);
		window.getContentPane().add(monst3);
		if (manager.getPlayer().getMonsters().size() == 3) {
			monst2.setText(manager.getPlayer().getMonsters().get(1).getMonsterName());
			monst3.setText(manager.getPlayer().getMonsters().get(2).getMonsterName());
		}
		
		
		
		JLabel healthLbl2 = new JLabel("Health:");
		healthLbl2.setBounds(207, 119, 169, 21);
		healthLbl2.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(healthLbl2);
		if (manager.getPlayer().getMonsters().size() == 2) {
			healthLbl2.setText("Health: " + manager.getPlayer().getMonsters().get(1).getHealth());
		}
		
		JLabel healthLbl3 = new JLabel("Health:");
		healthLbl3.setBounds(386, 119, 169, 21);
		healthLbl3.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(healthLbl3);
		if (manager.getPlayer().getMonsters().size() == 3) {
			healthLbl2.setText("Health: " + manager.getPlayer().getMonsters().get(1).getHealth());
			healthLbl3.setText("Health: " + manager.getPlayer().getMonsters().get(2).getHealth());
		}
		
		
		
		JLabel damageLbl2 = new JLabel("Damage:");
		damageLbl2.setBounds(207, 152, 169, 21);
		damageLbl2.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(damageLbl2);
		if (manager.getPlayer().getMonsters().size() == 2) {
			damageLbl2.setText("Damage: " + manager.getPlayer().getMonsters().get(1).getDamage());
		}
		
		JLabel damageLbl3 = new JLabel("Damage:");
		damageLbl3.setBounds(386, 152, 169, 21);
		damageLbl3.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(damageLbl3);
		if (manager.getPlayer().getMonsters().size() == 3) {
			damageLbl2.setText("Damage: " + manager.getPlayer().getMonsters().get(1).getDamage());
			damageLbl3.setText("Damage: " + manager.getPlayer().getMonsters().get(2).getDamage());
		}
		
		JButton applyHP_1 = new JButton("Apply Health potion");
		applyHP_1.setBounds(6, 185, 206, 34);
		applyHP_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().getItems().contains(healthPotion) == true){
					manager.getPlayer().getMonsters().get(0).changeHealth(5);
					healthLbl1.setText("Health: " + manager.getPlayer().getMonsters().get(0).getHealth());
					hlthPotionInvent.setText("Health Potions: " + (amountHealth -1));
					messageLbl.setText("Health Potion Applied to monster");
					manager.getPlayer().getItems().remove(healthPotion);
					window.repaint();
				}else {
					messageLbl.setText("Item does not exist in your inventory");
				}
			}
		});
		window.getContentPane().add(applyHP_1);
		
		JButton applySP_1 = new JButton("Apply Strength potion");
		applySP_1.setBounds(6, 219, 206, 34);
		applySP_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().getItems().contains(strengthPotion) == true){
					manager.getPlayer().getMonsters().get(0).changeDamage(5);
					damageLbl1.setText("Damage: " + manager.getPlayer().getMonsters().get(0).getDamage());
					messageLbl.setText("Strength Potion Applied to monster");
					lblStrengthPotions.setText("Strength Potions: " + (amountStrength-1));
					manager.getPlayer().getItems().remove(strengthPotion);
					window.repaint();
				}else {
					messageLbl.setText("Item does not exist in your inventory");
				}
			}
		});
		window.getContentPane().add(applySP_1);
		
		JButton applyJJ_1 = new JButton("Apply JamJar");
		applyJJ_1.setBounds(6, 252, 206, 34);
		applyJJ_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().getItems().contains(jamJar) == true){
					manager.getPlayer().getMonsters().get(0).changeHealth(5);
					manager.getPlayer().getMonsters().get(0).changeDamage(5);
					healthLbl1.setText("Health: " + manager.getPlayer().getMonsters().get(0).getHealth());
					damageLbl1.setText("Damage: " + manager.getPlayer().getMonsters().get(0).getDamage());
					messageLbl.setText("Jam Jar Applied to monster");
					lblJamJars.setText("Jam Jars: " + (amountJam-1));
					manager.getPlayer().getItems().remove(jamJar);
					window.repaint();
				}else {
					messageLbl.setText("Item does not exist in your inventory");
				}
			}
		});
		window.getContentPane().add(applyJJ_1);
		
		JButton applyHP_2 = new JButton("Apply Health potion");
		applyHP_2.setBounds(207, 185, 206, 34);
		applyHP_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().getMonsters().size() >= 2) {
					if (manager.getPlayer().getItems().contains(healthPotion) == true){
						manager.getPlayer().getMonsters().get(1).changeHealth(5);
						healthLbl2.setText("Health: " + manager.getPlayer().getMonsters().get(1).getHealth());
						messageLbl.setText("Health Potion Applied to monster");
						hlthPotionInvent.setText("Health Potions: " + (amountHealth -1));
						manager.getPlayer().getItems().remove(healthPotion);
						window.repaint();
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
		applyHP_3.setBounds(405, 185, 203, 34);
		applyHP_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().getMonsters().size() == 3) {
					if (manager.getPlayer().getItems().contains(healthPotion) == true){
						manager.getPlayer().getMonsters().get(2).changeHealth(5);
						healthLbl3.setText("Health: " + manager.getPlayer().getMonsters().get(2).getHealth());
						messageLbl.setText("Health Potion Applied to monster");
						hlthPotionInvent.setText("Health Potions: " + (amountHealth -1));
						
						manager.getPlayer().getItems().remove(healthPotion);
						window.repaint();
					}else {
						messageLbl.setText("Item does not exist in your inventory");
					}
				}else {
					messageLbl.setText("No monster");

				}
				}
		});
		window.getContentPane().add(applyHP_3);
		
		JButton applySP_2 = new JButton("Apply Strength potion");
		applySP_2.setBounds(207, 219, 206, 34);
		applySP_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().getMonsters().size() >= 2) {
					if (manager.getPlayer().getItems().contains(strengthPotion) == true){
						manager.getPlayer().getMonsters().get(1).changeDamage(5);
						damageLbl2.setText("Damage: " + manager.getPlayer().getMonsters().get(1).getDamage());
						messageLbl.setText("Strength Potion Applied to monster");
						lblStrengthPotions.setText("Strength Potions: " + (amountStrength-1));
						
						manager.getPlayer().getItems().remove(strengthPotion);
						window.repaint();
					}else {
						messageLbl.setText("Item does not exist in your inventory");
					}
				}else {
					messageLbl.setText("No monster");

			}}
		});
		window.getContentPane().add(applySP_2);
		
		JButton applySP_3 = new JButton("Apply Strength potion");
		applySP_3.setBounds(405, 219, 203, 34);
		applySP_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().getMonsters().size() == 3) {
					if (manager.getPlayer().getItems().contains(strengthPotion) == true){
						manager.getPlayer().getMonsters().get(2).changeDamage(5);
						damageLbl3.setText("Damage: " + manager.getPlayer().getMonsters().get(2).getDamage());
						messageLbl.setText("Strength Potion Applied to monster");
						lblStrengthPotions.setText("Strength Potions: " + (amountStrength-1));
						manager.getPlayer().getItems().remove(strengthPotion);
						window.repaint();
					}else {
						messageLbl.setText("Item does not exist in your inventory");
					}
				}else {
					messageLbl.setText("No monster");

			}}
		});
		window.getContentPane().add(applySP_3);
		
		JButton applyJJ_2 = new JButton("Apply JamJar");
		applyJJ_2.setBounds(207, 252, 206, 34);
		applyJJ_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().getMonsters().size() >= 2) {
					if (manager.getPlayer().getItems().contains(jamJar) == true){
						manager.getPlayer().getMonsters().get(1).changeHealth(5);
						manager.getPlayer().getMonsters().get(1).changeDamage(5);
						healthLbl2.setText("Health: " + manager.getPlayer().getMonsters().get(1).getHealth());
						damageLbl2.setText("Damage: " + manager.getPlayer().getMonsters().get(1).getDamage());
						messageLbl.setText("Jam Jar Applied to monster");
						lblJamJars.setText("Jam Jars: " + (amountJam-1));
						manager.getPlayer().getItems().remove(jamJar);
						window.repaint();
						
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
		applyJJ_3.setBounds(405, 252, 203, 34);
		applyJJ_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().getMonsters().size() == 3) {
					if (manager.getPlayer().getItems().contains(jamJar) == true){
						manager.getPlayer().getMonsters().get(2).changeHealth(5);
						manager.getPlayer().getMonsters().get(2).changeDamage(5);
						healthLbl3.setText("Health: " + manager.getPlayer().getMonsters().get(2).getHealth());
						damageLbl3.setText("Damage: " + manager.getPlayer().getMonsters().get(2).getDamage());
						messageLbl.setText("Jam Jar Applied to monster");
						lblJamJars.setText("Jam Jars: " + (amountJam-1));
						manager.getPlayer().getItems().remove(jamJar);
						window.repaint();
					}else {
						messageLbl.setText("Item does not exist in your inventory");
					}
				}else {
					messageLbl.setText("No monster");
				}
			}
		});
		window.getContentPane().add(applyJJ_3);
		
		JButton sellHealthPotion = new JButton("Sell Health Potion");
		sellHealthPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().getItems().contains(healthPotion) == true){
					messageLbl.setText("Health Potion Sold");
					hlthPotionInvent.setText("Health Potion " + (amountHealth-1));
					manager.getPlayer().getItems().remove(healthPotion);
					manager.getPlayer().changeCoins(3);
					window.repaint();
				}else {
					messageLbl.setText("Item does not exist in your inventory");
				}
			}
		});
		sellHealthPotion.setBounds(6, 331, 206, 34);
		window.getContentPane().add(sellHealthPotion);
		
		JButton sellStrengthPotion = new JButton("Sell Strength Potion");
		sellStrengthPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().getItems().contains(strengthPotion) == true){
					messageLbl.setText("Strength Potion Sold");
					lblStrengthPotions.setText("Strength Potion: " + (amountStrength-1));
					manager.getPlayer().getItems().remove(strengthPotion);
					manager.getPlayer().changeCoins(3);
					window.repaint();
				}else {
					messageLbl.setText("Item does not exist in your inventory");
				}
			}
		});
		sellStrengthPotion.setBounds(207, 331, 206, 34);
		window.getContentPane().add(sellStrengthPotion);
		
		JButton btnSellJamJar = new JButton("Sell JamJar");
		btnSellJamJar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().getItems().contains(jamJar) == true){
					messageLbl.setText("Jam Jar Sold");
					lblJamJars.setText("Jam Jar: " + (amountJam-1));
					manager.getPlayer().getItems().remove(jamJar);
					manager.getPlayer().changeCoins(5);
					window.repaint();
				}else {
					messageLbl.setText("Item does not exist in your inventory");
				}
			}
		});
		btnSellJamJar.setBounds(405, 331, 206, 34);
		window.getContentPane().add(btnSellJamJar);
		
		
		
		
	}
}
