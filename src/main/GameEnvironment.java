package main;
import java.util.ArrayList;
import java.util.Scanner;

public class GameEnvironment {
	private Player player = new Player();
	private Store store = new Store();
	private ArrayList<Monster> monstersInStore = new ArrayList<Monster>();
	private PossibleBattles battles = new PossibleBattles(player);
	private Scanner input = new Scanner(System.in);
	private Boolean firstVisitOfTheDay = true;
	private Boolean hasFoughtToday = false;
	
	private MainMenu menu;
	private Battle battle = new Battle(player, player);
	
	public GameEnvironment() {
		launchMonsterBattle();
	}
	public Player getPlayer() {
		return player;
	}
	public PossibleBattles getBattles() {
		return battles;
	}
	public void setBattles(PossibleBattles battles) {
		this.battles = battles;
	}
	public Boolean getHasFoughtToday() {
		return hasFoughtToday;
	}
	public void setHasFoughtToday(Boolean hasFoughtToday) {
		this.hasFoughtToday = hasFoughtToday;
	}
	public Battle getBattle() {
		return battle ;
	}
	public void printSetupOptions() {

		
		// set the player name if not in the range needed asks again
		System.out.println("Welcome to Monster Battle! \nPlease enter your name:");
		String tempName = input.nextLine();
		while (tempName.length() < 3 || tempName.length() > 15 || tempName.matches("^[a-zA-Z]*$") == false) {
			System.out.println("Please enter a name between 3 and 15 characters");
			tempName = input.nextLine();
		}
		player.setName(tempName);
		System.out.println("Your name is " + player.getName());
		
		// set the days the player plays if not in range ask again
		System.out.println("How many days do you want to play? (Between 5 and 15)");
		int tempDays = input.nextInt();
		while (tempDays < 5 || tempDays > 15) {
			System.out.println("Please enter a integer between 5 and 15");
			
			tempDays = input.nextInt();
		}
		player.setDays(tempDays);
		System.out.println("You selected " + player.getDays() + " days");
		
		
		// set the player difficulty if not 1 or 2 ask again 
		System.out.println("What difficulty do you want to play at? (type '1' of easy or '2' for hard");
		int tempDifficulty = input.nextInt();
		while (tempDifficulty < 1 || tempDifficulty > 2) {
			System.out.println("Please enter a difficulty between 1 and 2");
			tempDifficulty = input.nextInt();
		}
		player.setDifficulty(tempDifficulty);
		System.out.println("you selected a difficulty of " + player.getDifficuluty());
		
		
		//Create a list of monsters for the player to chose from and add the one they chose also give the player 3 coins to pay 
		System.out.println("Select you frist monster, dont worry we gave you three coins\n");
		player.changeCoins(13);
		

		System.out.println(store.MonsterListString());
		int monsterSlected = input.nextInt();
		while(monsterSlected < 1 || monsterSlected > 4) {
			System.out.println("Please enter a valid number between 1 and 4");
			monsterSlected = input.nextInt();
		}
		store.buyMonsterSelected(player, monsterSlected - 1);
		store.EmptyStore();
		
		
	}
	
	//main game prints out the main options for the game letting the player chose actions and checks if their monsters are still availed to continue play
	public void mainGame() {
		//check if the player has any monster in there monster list if not end the game
		if(player.getMonsters().size() == 0) {
			endGame(false);
		}
		
		
		int selection;
		System.out.println("1: View game progress \n2: Visit Shop \n3: View team \n4: View inventory \n5: Veiw possible battles \n6: Go to sleep");
		selection = input.nextInt();
		// check if the int is something in range, if not ask again
		while(selection < 1 || selection >6) {
			System.out.println("Please select an initiger between 1 and 5");
			selection = input.nextInt();
		}
		
		if(selection == 1) {
			veiwGameProgress();
		}
		
		if(selection == 2) {
			visitShop();
		}
		
		if(selection == 3) {
			viewTeam();
		}
		
		if(selection == 4) {
			ViewInventory();
		}

		if(selection ==5){
			getBattles().getPossibleBattles();
		}
		if(selection == 6){
			//goToSleep(menu);

		}
	}
	
	
	//print Amount of gold, current day and number of days remaining 
	public void veiwGameProgress() {
		System.out.println("Progress:\nCurrent Day:" + player.getCurrentDay() + 
				"\nDays left: " + (player.getDays() - player.getCurrentDay()) + 
				"\nCurrent Coins: " + player.getCoins());
		
		mainGame();
	}
	
	
	public void visitShop() {
		int selected; 
		if (firstVisitOfTheDay == true) {
			store.createMonsterList();
			store.createItemList();
			firstVisitOfTheDay = false;
		}
		
		System.out.println(store);
		
		selected = input.nextInt();
		
		while(selected < 1 || selected > 7) {
			System.out.println("Plese select between 1 and 7");
			selected = input.nextInt();
		}
		
		if(selected <= 3) {     
			store.buyMonsterSelected(player, selected - 1);   // -1 to index with monster list correctly 
		}
		
		if(selected >= 4 && selected != 7) {      // 7 is the int to go back to the main menu so should not be included in the if statement
			store.buyItemSelected(player, selected - 4);  // -4 to index with the item list correctly
		}
		
		
		mainGame();
	}
	
	
	// print monsters in players monster list
	public void viewTeam() {
		System.out.println("Your Team:\n " + player.monstersTeamString());
		mainGame();
	}
	
	// print the monster and item list from the player, allow the player to apply an item to a monster
	public void ViewInventory() {
		ArrayList<Item> items = player.getItems();
		
		System.out.println("Select an item to apply: \n" + player.itemListString() + (items.size() + 1) + ": Return to main menu");
		int itemSelected = input.nextInt();
		while(itemSelected < 1 || itemSelected > items.size() + 1) {   // added one on to size because that is the option to go back to the main menu
			System.out.println("Please enter a number between 1 and " + (items.size() + 1));
			itemSelected = input.nextInt();
		}
		
		if(itemSelected < items.size() + 1) {   //only allows to apply an item if the selected number is not to return 
			int count = 0;
			for(Monster monster : player.getMonsters()) {
				count++;
				System.out.println(count + ": " + monster);
			}
			
			int monsterSelected = input.nextInt();
			while(monsterSelected < 1 || monsterSelected > player.getMonsters().size()) {
				System.out.println("Please select a number between 1 and " + player.getMonsters().size());
				monsterSelected = input.nextInt();
			}
			
			player.getMonsters().get(monsterSelected - 1).changeHealth(items.get(itemSelected - 1).getHealthAmount());   //apply the item to the monster selected stats
			player.getMonsters().get(monsterSelected - 1).changeDamage(items.get(itemSelected - 1).getDamageAmount());
		}
		
		mainGame();
	}
	
	// create three different player objects with monsters attributes depending on the day, allow the player to battle one 
	//public ArrayList <Player> viewPossibleBattles() {
	
	//	System.out.println(battles);
	//	int selection = input.nextInt();
	//	if(selection < 1 || selection > 3) {
	//		System.out.println("Please enter a number between 1 and 3");
	//		selection = input.nextInt();
	//	}
	//	Player enemy = battles.getEnemyPlayer(selection - 1);  //-1 to index with a list correctly 
	//	battle(player, enemy);

	//return battles.getPossibleBattles();
	//}
	
	// Determine who would win between two players one the real player the other the player object created in ViewPossibleBattles method
	public void battle(Player player, Player playerAI) {
		Battle battle = new Battle(player, playerAI);
		battle.StartBattle();
		String battleOutCome = battle.battleOutcomeString();
		System.out.println(battleOutCome);
		hasFoughtToday = true;
		//mainGame();
	}
	
	// if a battle has happened increase the current day, if the current day is the max amount end the game, run chance of a random event 

	public void goToSleep(BattleScreen screen) {
		if(hasFoughtToday) {
			if(player.getCurrentDay() + 1 > player.getDays()){
				endGame(true);
			}
			player.addDay();
			hasFoughtToday = false;
			randomEvent();
			//mainGame();
			
		}else {
			System.out.println("you have to fight at least once to go to sleep");
			//mainGame();
		}
		
	}
	
	public void randomEvent() {

		RandomEvent randomEvent = new RandomEvent(player);
		randomEvent.choseRandomMethod();

		
	}

	public void endGame(boolean wonGame){
		if (wonGame) {
			System.out.println("Congratulations you lasted " + player.getDays());
		}else {
			System.out.println("Game over lmao \nyou lasted " + player.getCurrentDay() + "corngratualtions!!!");
		}
		

	}
	
	public Store getStore() {
		return store;
	}

	public void launchMonsterBattle(){
		MonsterBattle setupWindow = new MonsterBattle(this);
	}
	public void closeMonsterBattle(MonsterBattle setupWindow) {
		setupWindow.closeWindow();
		launchMonsterScreen();
	}
	public void launchMonsterScreen() {
		MonsterScreen chooseMonsterWindow = new MonsterScreen(this);
		
	}
	public void closeMonsterScreen(MonsterScreen chooseMonsterWindow) {
		chooseMonsterWindow.closeWindow();
		launchMainMenu();
	}
	public void launchMainMenu() {
		MainMenu mainWindow = new MainMenu(this);

	}
	public void closeMainMenu(MainMenu mainWindow) {
		mainWindow.closeWindow();
	}
	public static void main(String[] args) throws InterruptedException {
		GameEnvironment ge= new GameEnvironment();
		ge.printSetupOptions();
		ge.mainGame();
    }
	public void closeViewTeamScreen(ViewTeamScreen viewTeamScreen) {
		viewTeamScreen.closeWindow();
		launchMainMenu();
		
	}
	public void launchViewTeamScreen() {
		ViewTeamScreen teamScreen = new ViewTeamScreen(this);
		
	}
	public void launchStoreScreen() {
		StoreScreen storeScreen = new StoreScreen(this);
		
	}
	public void closeStoreScreen(StoreScreen storeScreen) {
		storeScreen.closeWindow();
		launchMainMenu();
		
	}
	public void launchBattleScreen() {
		BattleScreen battleScreen = new BattleScreen(this);
	}
	public void closeBattleScreen(BattleScreen battleScreen) {
		battleScreen.closeWindow();
		launchMainMenu();
	}

	
}
