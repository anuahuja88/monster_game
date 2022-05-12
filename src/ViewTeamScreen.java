
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;

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
		lblNewLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		lblNewLabel.setBounds(26, 6, 118, 34);
		window.getContentPane().add(lblNewLabel);
		
		JLabel lblAvailableMonsters = new JLabel("Available monsters");
		lblAvailableMonsters.setFont(new Font("Osaka", Font.PLAIN, 16));
		lblAvailableMonsters.setBounds(26, 175, 170, 34);
		window.getContentPane().add(lblAvailableMonsters);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.setFont(new Font("Osaka", Font.PLAIN, 16));
		btnNewButton.setBounds(411, 317, 144, 44);
		window.getContentPane().add(btnNewButton);
	}
}
