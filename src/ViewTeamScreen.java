
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewTeamScreen {

	private JFrame window;
	private GameEnvironment manager;

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
		
		JLabel lblNewLabel = new JLabel("Your Team");
		lblNewLabel.setBounds(26, 6, 118, 34);
		lblNewLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finshedWindow();
			}
		});
		btnNewButton.setBounds(411, 317, 144, 44);
		btnNewButton.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(btnNewButton);
		
		JButton monst1 = new JButton(manager.getPlayer().GetMonsters().get(0).GetMonsterName());
		monst1.setBounds(26, 52, 169, 55);
		window.getContentPane().add(monst1);
		
		JButton monst2 = new JButton("");
		if (manager.getPlayer().GetMonsters().size() == 2) {
			monst2.setText(manager.getPlayer().GetMonsters().get(1).GetMonsterName());
		}
		monst2.setBounds(207, 52, 169, 55);
		window.getContentPane().add(monst2);
		
		
		JButton monst3 = new JButton("");
		monst3.setBounds(386, 52, 169, 55);
		window.getContentPane().add(monst3);
		if (manager.getPlayer().GetMonsters().size() == 3) {
			monst2.setText(manager.getPlayer().GetMonsters().get(1).GetMonsterName());
			monst3.setText(manager.getPlayer().GetMonsters().get(2).GetMonsterName());
		}
		
		JLabel lblNewLabel_1 = new JLabel("Health: " + manager.getPlayer().GetMonsters().get(0).GetHealth());
		lblNewLabel_1.setBounds(26, 119, 169, 21);
		lblNewLabel_1.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Health:");
		lblNewLabel_1_1.setBounds(207, 119, 169, 21);
		lblNewLabel_1_1.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(lblNewLabel_1_1);
		if (manager.getPlayer().GetMonsters().size() == 2) {
			lblNewLabel_1_1.setText("Health: " + manager.getPlayer().GetMonsters().get(1).GetHealth());
		}
		
		JLabel lblNewLabel_1_2 = new JLabel("Health:");
		lblNewLabel_1_2.setBounds(386, 119, 169, 21);
		lblNewLabel_1_2.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(lblNewLabel_1_2);
		if (manager.getPlayer().GetMonsters().size() == 3) {
			lblNewLabel_1_1.setText("Health: " + manager.getPlayer().GetMonsters().get(1).GetHealth());
			lblNewLabel_1_2.setText("Health: " + manager.getPlayer().GetMonsters().get(2).GetHealth());
		}
		
		JLabel lblNewLabel_1_3 = new JLabel("Damage: " + manager.getPlayer().GetMonsters().get(0).GetDamage());
		lblNewLabel_1_3.setBounds(26, 152, 169, 21);
		lblNewLabel_1_3.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Damage:");
		lblNewLabel_1_3_1.setBounds(207, 152, 169, 21);
		lblNewLabel_1_3_1.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(lblNewLabel_1_3_1);
		if (manager.getPlayer().GetMonsters().size() == 2) {
			lblNewLabel_1_3_1.setText("Damage: " + manager.getPlayer().GetMonsters().get(1).GetDamage());
		}
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Damage:");
		lblNewLabel_1_3_2.setBounds(386, 152, 169, 21);
		lblNewLabel_1_3_2.setFont(new Font("Osaka", Font.PLAIN, 16));
		window.getContentPane().add(lblNewLabel_1_3_2);
		if (manager.getPlayer().GetMonsters().size() == 3) {
			lblNewLabel_1_3_1.setText("Damage: " + manager.getPlayer().GetMonsters().get(1).GetDamage());
			lblNewLabel_1_3_2.setText("Damage: " + manager.getPlayer().GetMonsters().get(2).GetDamage());
		}
		
		JButton btnNewButton_1_3 = new JButton("Apply Health potion");
		btnNewButton_1_3.setBounds(26, 185, 169, 34);
		window.getContentPane().add(btnNewButton_1_3);
		
		JButton btnNewButton_1_3_1 = new JButton("Apply Strength  potion");
		btnNewButton_1_3_1.setBounds(26, 219, 169, 34);
		window.getContentPane().add(btnNewButton_1_3_1);
		
		JButton btnNewButton_1_3_2 = new JButton("Apply JamJar");
		btnNewButton_1_3_2.setBounds(26, 252, 169, 34);
		window.getContentPane().add(btnNewButton_1_3_2);
		
		JButton btnNewButton_1_3_3 = new JButton("Apply Health potion");
		btnNewButton_1_3_3.setBounds(196, 185, 169, 34);
		window.getContentPane().add(btnNewButton_1_3_3);
		
		JButton btnNewButton_1_3_4 = new JButton("Apply Health potion");
		btnNewButton_1_3_4.setBounds(377, 185, 169, 34);
		window.getContentPane().add(btnNewButton_1_3_4);
		
		JButton btnNewButton_1_3_1_1 = new JButton("Apply Strength  potion");
		btnNewButton_1_3_1_1.setBounds(196, 219, 169, 34);
		window.getContentPane().add(btnNewButton_1_3_1_1);
		
		JButton btnNewButton_1_3_1_2 = new JButton("Apply Strength  potion");
		btnNewButton_1_3_1_2.setBounds(377, 219, 169, 34);
		window.getContentPane().add(btnNewButton_1_3_1_2);
		
		JButton btnNewButton_1_3_2_1 = new JButton("Apply JamJar");
		btnNewButton_1_3_2_1.setBounds(196, 252, 169, 34);
		window.getContentPane().add(btnNewButton_1_3_2_1);
		
		JButton btnNewButton_1_3_2_2 = new JButton("Apply JamJar");
		btnNewButton_1_3_2_2.setBounds(377, 252, 169, 34);
		window.getContentPane().add(btnNewButton_1_3_2_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Available items:");
		lblNewLabel_1_4.setFont(new Font("Osaka", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(26, 296, 169, 21);
		window.getContentPane().add(lblNewLabel_1_4);
	}
}
