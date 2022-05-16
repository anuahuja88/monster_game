
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreScreen {

	private JFrame window;
	private GameEnvironment manager;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreScreen window = new StoreScreen();
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
	public StoreScreen() {
		initialize();
	}
	StoreScreen(GameEnvironment incoming) {
		manager = incoming;
		initialize();
		window.setVisible(true);
	}

	public void closeWindow() {
		window.dispose();
	}
	public void finshedWindow() {
		manager.closeStoreScreen(this);
	}

	/**
	 * Initialize the contents of the window.
	 */
	private void initialize() {
		
		window = new JFrame();
		window.setTitle("Store");
		window.setBounds(100, 100, 578, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome to the Store");
		welcomeLabel.setBounds(6, 6, 173, 40);
		welcomeLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(welcomeLabel);
		
		JLabel lblMonstersOnSale = new JLabel("Monsters on sale");
		lblMonstersOnSale.setBounds(6, 45, 133, 40);
		lblMonstersOnSale.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(lblMonstersOnSale);
		
		JLabel lblItemsOnSale = new JLabel("Items on sale");
		lblItemsOnSale.setBounds(6, 207, 107, 40);
		lblItemsOnSale.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(lblItemsOnSale);
		
		JButton mainMenuButton = new JButton("Main Menu");
		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finshedWindow();
			}
		});
		mainMenuButton.setBounds(465, 332, 107, 40);
		mainMenuButton.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(mainMenuButton);
		
		JLabel monster_1 = new JLabel(manager.getStore().getMonsterList().get(0).GetMonsterName());
		monster_1.setBounds(16, 82, 124, 26);
		monster_1.setForeground(Color.BLUE);
		monster_1.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(monster_1);
		
		JLabel monster_2 = new JLabel(manager.getStore().getMonsterList().get(1).GetMonsterName());
		monster_2.setBounds(185, 82, 124, 26);
		monster_2.setForeground(Color.RED);
		monster_2.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(monster_2);
		
		JLabel monster_3 = new JLabel(manager.getStore().getMonsterList().get(0).GetMonsterName());
		monster_3.setBounds(356, 82, 124, 26);
		monster_3.setForeground(Color.GREEN);
		monster_3.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(monster_3);
		
		JLabel monst1Health = new JLabel("Health: " + manager.getStore().getMonsterList().get(0).GetHealth());
		monst1Health.setBounds(15, 109, 124, 26);
		monst1Health.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(monst1Health);
		
		JLabel monst2Health = new JLabel("Health: " +  manager.getStore().getMonsterList().get(1).GetHealth());
		monst2Health.setBounds(184, 113, 124, 26);
		monst2Health.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(monst2Health);
		
		JLabel monst3Health = new JLabel("Health: " +  manager.getStore().getMonsterList().get(2).GetHealth());
		monst3Health.setBounds(356, 113, 124, 26);
		monst3Health.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(monst3Health);
		
		JLabel monst1Damage = new JLabel("Damage: " + manager.getStore().getMonsterList().get(0).GetDamage());
		monst1Damage.setBounds(15, 136, 124, 26);
		monst1Damage.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(monst1Damage);
		
		JLabel monst2Damage = new JLabel("Damage: " +  manager.getStore().getMonsterList().get(1).GetDamage());
		monst2Damage.setBounds(184, 140, 124, 26);
		monst2Damage.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(monst2Damage);
		
		JLabel monst3Damage = new JLabel("Damage: " + manager.getStore().getMonsterList().get(2).GetDamage());
		monst3Damage.setBounds(356, 140, 124, 26);
		monst3Damage.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(monst3Damage);
		
		JLabel monst1Price = new JLabel("Price: " + manager.getStore().getMonsterList().get(0).GetPrice());
		monst1Price.setBounds(15, 161, 124, 26);
		monst1Price.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(monst1Price);
		
		JLabel monst2Price = new JLabel("Price: " + manager.getStore().getMonsterList().get(1).GetPrice());
		monst2Price.setBounds(185, 165, 124, 26);
		monst2Price.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(monst2Price);
		
		JLabel monst3Price = new JLabel("Price: " + manager.getStore().getMonsterList().get(2).GetPrice());
		monst3Price.setBounds(356, 165, 124, 26);
		monst3Price.setFont(new Font("Osaka", Font.PLAIN, 14));
		window.getContentPane().add(monst3Price);
		
		JLabel coinError = new JLabel("");
		coinError.setForeground(Color.RED);
		coinError.setFont(new Font("Osaka", Font.PLAIN, 10));
		coinError.setBounds(201, 44, 261, 26);
		window.getContentPane().add(coinError);
		
		JButton purchaseMonst1 = new JButton("Purchase");
		purchaseMonst1.addActionListener(new ActionListener() {
			int price = manager.getStore().getMonsterList().get(0).GetPrice();
			public void actionPerformed(ActionEvent e) {
				if (manager.getPlayer().GetCoins() > price) {
					manager.getPlayer().BuyMonster(manager.getStore().getMonsterList().get(0));
					manager.getPlayer().ChangeCoins(-(price));
					finshedWindow();
					manager.launchStoreScreen();
				}else {
					coinError.setText("Not enough coins to purchase monster");
		
				}
					
				
			}
		});
		purchaseMonst1.setBounds(6, 185, 117, 29);
		window.getContentPane().add(purchaseMonst1);
		
		JButton purchaseMonst2 = new JButton("Purchase");
		purchaseMonst2.setBounds(177, 185, 117, 29);
		window.getContentPane().add(purchaseMonst2);
		
		JButton purchaseMonst3 = new JButton("Purchase");
		purchaseMonst3.setBounds(345, 185, 117, 29);
		window.getContentPane().add(purchaseMonst3);
		
		JLabel lblAvailableCoins = new JLabel("Available coins: " + manager.getPlayer().GetCoins());
		lblAvailableCoins.setFont(new Font("Osaka", Font.PLAIN, 16));
		lblAvailableCoins.setBounds(293, 6, 173, 40);
		window.getContentPane().add(lblAvailableCoins);
		
		JLabel healthPotion = new JLabel("Health Potion");
		healthPotion.setForeground(Color.BLACK);
		healthPotion.setFont(new Font("Osaka", Font.PLAIN, 14));
		healthPotion.setBounds(16, 250, 124, 26);
		window.getContentPane().add(healthPotion);
		
		JLabel healthPotionAttribute = new JLabel("(Increases health by 5)");
		healthPotionAttribute.setForeground(Color.RED);
		healthPotionAttribute.setFont(new Font("Osaka", Font.PLAIN, 10));
		healthPotionAttribute.setBounds(16, 270, 123, 26);
		window.getContentPane().add(healthPotionAttribute);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 82, 456, 132);
		window.getContentPane().add(panel);
		
		JLabel helathPotionPrice = new JLabel("Price: 3");
		helathPotionPrice.setFont(new Font("Osaka", Font.PLAIN, 14));
		helathPotionPrice.setBounds(15, 303, 124, 26);
		window.getContentPane().add(helathPotionPrice);
		
		JLabel JamJar = new JLabel("JamJar");
		JamJar.setForeground(Color.BLACK);
		JamJar.setFont(new Font("Osaka", Font.PLAIN, 14));
		JamJar.setBounds(338, 250, 124, 26);
		window.getContentPane().add(JamJar);
		
		JLabel StrengthPotion = new JLabel("Strength Potion");
		StrengthPotion.setForeground(Color.BLACK);
		StrengthPotion.setFont(new Font("Osaka", Font.PLAIN, 14));
		StrengthPotion.setBounds(177, 250, 124, 26);
		window.getContentPane().add(StrengthPotion);
		
		JLabel strengthPotionPrice = new JLabel("Price: 3");
		strengthPotionPrice.setFont(new Font("Osaka", Font.PLAIN, 14));
		strengthPotionPrice.setBounds(177, 303, 124, 26);
		window.getContentPane().add(strengthPotionPrice);
		
		JLabel jamJarPotion = new JLabel("Price: 5");
		jamJarPotion.setFont(new Font("Osaka", Font.PLAIN, 14));
		jamJarPotion.setBounds(338, 303, 124, 26);
		window.getContentPane().add(jamJarPotion);
		
		JButton purchaseHealthPotion = new JButton("Purchase");
		purchaseHealthPotion.setBounds(6, 338, 117, 29);
		window.getContentPane().add(purchaseHealthPotion);
		
		JButton purchaseStrengthPotion = new JButton("Purchase");
		purchaseStrengthPotion.setBounds(165, 338, 117, 29);
		window.getContentPane().add(purchaseStrengthPotion);
		
		JButton purchaseJamJar = new JButton("Purchase");
		purchaseJamJar.setBounds(323, 338, 117, 29);
		window.getContentPane().add(purchaseJamJar);
		
		JLabel strengthPotionAttribute = new JLabel("(Increases damage by 5)");
		strengthPotionAttribute.setForeground(Color.RED);
		strengthPotionAttribute.setFont(new Font("Osaka", Font.PLAIN, 10));
		strengthPotionAttribute.setBounds(177, 273, 123, 26);
		window.getContentPane().add(strengthPotionAttribute);
		
		JLabel JamAtrribute = new JLabel("(Increases health by 5)");
		JamAtrribute.setForeground(Color.RED);
		JamAtrribute.setFont(new Font("Osaka", Font.PLAIN, 10));
		JamAtrribute.setBounds(323, 270, 123, 26);
		window.getContentPane().add(JamAtrribute);
		
		JLabel JarAttribute = new JLabel("(Increases damage by 5)");
		JarAttribute.setForeground(Color.RED);
		JarAttribute.setFont(new Font("Osaka", Font.PLAIN, 10));
		JarAttribute.setBounds(323, 288, 123, 26);
		window.getContentPane().add(JarAttribute);
		
		
	}
}
