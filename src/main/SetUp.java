package main;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class SetUp {
	
	private GameEnvironment manager;
	private MonsterBattle screen;

	public SetUp(GameEnvironment incomingManager, MonsterBattle setupScreen) {
		manager = incomingManager;
		screen = setupScreen;
		setName();
		setDays();
		setDifficulty();
	}
	
	private String getName() {
		String name = ((AbstractButton) screen.textFieldName).getText();
		return name;
	}

	public void setName() {
		manager.getPlayer().SetName(this.getName());
		
	}
	private int getDays() {
		int days = screen.dayslider.getValue();
		return days;
	}
	public void setDays() {
		manager.getPlayer().SetDays(this.getDays());
	}
	public String getSelectedButton(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			
			if (button.isSelected()) {
				return button.getText();
				
			}
			
		}
		return null;			
		
	}
	public String getDifficulty() {
		return getSelectedButton(screen.diffbuttongroup);
	}
	public void setDifficulty() {
		switch(getDifficulty().toLowerCase()) {
			case "easy":
				manager.getPlayer().SetDifficulty(1);
				break;
			case "hard":
				manager.getPlayer().SetDifficulty(2);
				break;
		}
	}

}
