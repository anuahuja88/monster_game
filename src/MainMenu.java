
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

public class MainMenu {

	private JFrame window;
	private GameEnvironment manager;
	private MainMenu screen;

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
		window.setBounds(100, 100, 578, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(23, 58, 229, 97);
		window.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel coinLabel = new JLabel("Coins: " + manager.getPlayer().GetCoins());
		coinLabel.setBounds(10, 6, 267, 23);
		panel.add(coinLabel);
		coinLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		
		JLabel lblCurrentDau = new JLabel("Current day: " + manager.getPlayer().GetCurrentDay());
		lblCurrentDau.setBounds(10, 38, 267, 23);
		panel.add(lblCurrentDau);
		lblCurrentDau.setFont(new Font("Osaka", Font.PLAIN, 16));
		
		JLabel lblDaysRemaining = new JLabel("Days remaining: " + (manager.getPlayer().GetDays()- manager.getPlayer().GetCurrentDay() ));
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
		VisitStoreButton.setBounds(422, 284, 150, 38);
		window.getContentPane().add(VisitStoreButton);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.GoToSleep(screen);
				finishedWindow();
				manager.launchMainMenu();
			}
		});
		
		btnSleep.setFont(new Font("Osaka", Font.PLAIN, 16));
		btnSleep.setBounds(422, 334, 150, 38);
		window.getContentPane().add(btnSleep);
		
		JLabel lblNewLabel = new JLabel("Choose a team to battle");
		lblNewLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 161, 253, 38);
		window.getContentPane().add(lblNewLabel);
		
	
		
		JButton battle_1_Button = new JButton();
		battle_1_Button.setText("Team 1");
		battle_1_Button.setFont(new Font("Osaka", Font.PLAIN, 16));
		battle_1_Button.setBounds(6, 211, 117, 82);
		window.getContentPane().add(battle_1_Button);
		
		JButton btnBattle = new JButton("Team 2");
		btnBattle.setFont(new Font("Osaka", Font.PLAIN, 16));
		btnBattle.setBounds(135, 211, 117, 82);
		window.getContentPane().add(btnBattle);
		
		JButton btnBattle_1 = new JButton("Team 3");
		btnBattle_1.setFont(new Font("Osaka", Font.PLAIN, 16));
		btnBattle_1.setBounds(264, 211, 117, 82);
		window.getContentPane().add(btnBattle_1);
		
		JLabel health1Label = new JLabel("Total Health:");
		health1Label.setFont(new Font("Osaka", Font.PLAIN, 14));
		health1Label.setBounds(10, 293, 117, 31);
		window.getContentPane().add(health1Label);
		
		JLabel lblDamage = new JLabel("Total Damage:");
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
		
		JLabel health1Label_1 = new JLabel("Total Health: " + manager.ViewPossibleBattles(screen).get(0).getTotalHealth());
		health1Label_1.setFont(new Font("Osaka", Font.PLAIN, 14));
		health1Label_1.setBounds(135, 294, 117, 31);
		window.getContentPane().add(health1Label_1);
		
		JLabel health1Label_2 = new JLabel("Total Health: " );
		health1Label_2.setFont(new Font("Osaka", Font.PLAIN, 14));
		health1Label_2.setBounds(264, 294, 117, 31);
		window.getContentPane().add(health1Label_2);
		
		JLabel lblDamage_1 = new JLabel("Total Damage:");
		lblDamage_1.setFont(new Font("Osaka", Font.PLAIN, 14));
		lblDamage_1.setBounds(135, 321, 123, 31);
		window.getContentPane().add(lblDamage_1);
		
		JLabel lblDamage_2 = new JLabel("Total Damage:");
		lblDamage_2.setFont(new Font("Osaka", Font.PLAIN, 14));
		lblDamage_2.setBounds(264, 321, 123, 31);
		window.getContentPane().add(lblDamage_2);
	}
}
