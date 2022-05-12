
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MonsterBattle {

	private JFrame window;
	private JTextField nameTextField;

	private GameEnvironment manager;
	public JLabel nameTextFieldName;
	private MonsterBattle screen;
	public JSlider dayslider;
	public ButtonGroup diffbuttongroup = new ButtonGroup();
	public Object textFieldName;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonsterBattle window = new MonsterBattle();
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
	public MonsterBattle(GameEnvironment incoming) {
		screen = this;
		manager = incoming;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closeMonsterBattle(this);
		
	}
	public MonsterBattle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		window = new JFrame();
		window.setTitle("Monster Battle Setup");
		window.setBounds(100, 100, 578, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome to monster battle!");
		welcomeLabel.setFont(new Font("Baloo", Font.PLAIN, 20));
		welcomeLabel.setBounds(34, 23, 262, 45);
		window.getContentPane().add(welcomeLabel);
		
		JLabel nameLabel = new JLabel("Please enter your name:");
		nameLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		nameLabel.setBounds(34, 68, 377, 45);
		window.getContentPane().add(nameLabel);
		
		
		nameTextField = new JTextField();
		nameTextField.setBounds(237, 77, 155, 26);
		window.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		

		
		nameTextFieldName = new JLabel("How many days do you want to play? (Between 5-15 days)");
		nameTextFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		nameTextFieldName.setFont(new Font("Osaka", Font.PLAIN, 16));
		nameTextFieldName.setBounds(34, 124, 459, 18);
		window.getContentPane().add(nameTextFieldName);
		
		dayslider = new JSlider();
		dayslider.setMajorTickSpacing(1);
		dayslider.setSnapToTicks(true);
		dayslider.setBackground(Color.WHITE);
		dayslider.setToolTipText("5\n");
		dayslider.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		dayslider.setPaintLabels(true);
		dayslider.setPaintTicks(true);
		dayslider.setForeground(Color.BLACK);
		dayslider.setBorder(null);
		dayslider.setValue(15);
		dayslider.setMinorTickSpacing(1);
		dayslider.setMinimum(5);
		dayslider.setMaximum(15);
		dayslider.setBounds(34, 166, 449, 45);
		window.getContentPane().add(dayslider);
		
		//gets day number from slider and sets it in player
		
		
		JLabel defficultyLabel = new JLabel("Select difficulty:");
		defficultyLabel.setFont(new Font("Osaka", Font.PLAIN, 16));
		defficultyLabel.setBounds(34, 268, 136, 16);
		window.getContentPane().add(defficultyLabel);
		
		JRadioButton easyBox = new JRadioButton("Easy");
		easyBox.setSelected(true);
		easyBox.setBounds(182, 264, 128, 23);
		window.getContentPane().add(easyBox);
		
		JRadioButton hardBox = new JRadioButton("Hard");
		hardBox.setBounds(322, 264, 128, 23);
		window.getContentPane().add(hardBox);
		diffbuttongroup.add(easyBox);
		diffbuttongroup.add(hardBox);
		
		JLabel nameErrorlabel = new JLabel("");
		nameErrorlabel.setForeground(Color.RED);
		nameErrorlabel.setBounds(205, 52, 354, 26);
		window.getContentPane().add(nameErrorlabel);
		
		//goes to choose monster screen and if name is not between 3 and 15 chars, throws an error
		JButton chooseMonsterButton = new JButton("Choose Monster");
		chooseMonsterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameTextField.getDocument().getLength() < 3 || (nameTextField.getDocument().getLength() > 15)) {
					nameErrorlabel.setText("Please enter a name between 3 and 15 characters! :(");
	
				}else {
				
				manager.getPlayer().SetDays(dayslider.getValue());
				finishedWindow();
					
				}
			}
				
		});
		chooseMonsterButton.setFont(new Font("Osaka", Font.PLAIN, 16));
		chooseMonsterButton.setBounds(365, 310, 175, 45);
		window.getContentPane().add(chooseMonsterButton);
		
	}
}
