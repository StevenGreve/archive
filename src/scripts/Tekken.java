import java.util.Random;
import java.util.Scanner;

public class Tekken {

	static Scanner scan;
	static int characterSelection;
	static boolean characterSelected;
	final static int maxHp = 200;
	static int enemyWins, playerWins;
	static long roundStartTime;
	

	static String playerName;
	static int playerHealth;
	
	static String nPAttack1;
	static String nPAttack2;
	static String nPAttack3;
	static String nPAttack4;
	
	static int valueAP1;
	static int valueAP2;
	static int valueAP3;
	static int valueAP4;
	
	static String enemyName;
	static int enemyHealth;
	
	static String nEAttack1;
	static String nEAttack2;
	static String nEAttack3;
	static String nEAttack4;
	
	static int valueAE1;
	static int valueAE2;
	static int valueAE3;
	static int valueAE4;
	
	public static void main(String[] args) {
		
		String message = "Welcome to the King of Iron Fist Tournament 7!";
	       
        System.out.println("----------------------------------------------");
        typewriterIntro(message, 50);
        System.out.println("\n----------------------------------------------");
       
        
        GameStart();

	}
	
	
	public static void GameStart() {
		
		characterSelected = false;
		enemyWins = 0;
		playerWins = 0;
		System.out.println("\nCharacter Select: \n");
        System.out.println("1. Jin Kazama");
        System.out.println("2. Kazuya Mishima");
        System.out.println("3. Heihachi Mishima");
        System.out.println("4. Devil Jin");
        System.out.println("5. Sergei Dragunov");
        System.out.println("6. Bryan Fury");
        System.out.println("7. Jack-7");
        System.out.println("\nPress Number to Select a Player! \n");
        
        scan = new Scanner(System.in);
        characterSelection = scan.nextInt();
//        so lang kein character ausgesucht while schleife
        while(!characterSelected) {
        	if(characterSelection < 1 || characterSelection > 7) {       
        		System.out.println("Invalid Option! Select a number between 1-7!");
        		characterSelection = scan.nextInt();
        	} else if (characterSelection >=1 && characterSelection <=7) {
//        		while schleife beenden
        		characterSelected = true;
//        		character initialisieren
        		initializeCharacter();
        	}
        }
//        gegener initialisieren
        initializeEnemy();
        RoundStart();
	}
	private static void RoundStart() {
//		Runden Start immer volles Leben setzten
		playerHealth = maxHp;
		enemyHealth = maxHp;
		Random randomBool = new Random();
		System.out.println("\nYou have "+ playerWins + " win/s!");
		System.out.println("Your enemy has " + enemyWins + " win/s!\n");
		roundStartTime = System.currentTimeMillis();
		if(randomBool.nextBoolean()) {
        	System.out.println("You have the first Attack!\n");
//        	random bool true -> playerAttack
        	PlayerAttack();
        }else {
        	System.out.println("Your enemy has the first Attack!\n");
//        	random bool false -> enemyAttack
        	enemyAttack();
        }
	}
	private static void PlayerAttack() {
//		wenn noch keine 60 sekunden vergangen if ausgeführt
		if(System.currentTimeMillis() - roundStartTime < 60000) {
			System.out.println("Player Health: " + playerHealth);
		
			System.out.println("Enemy Health: " + enemyHealth + "\n");
			System.out.println("Choose an Attack!\n");
			System.out.println("1: " + nPAttack1);
			System.out.println("2 " + nPAttack2);
			System.out.println("3: " + nPAttack3);
			System.out.println("4: " + nPAttack4);
//			wie bei charakter auswahl
			boolean attackSelected = false;
			int attack = scan.nextInt();
			while(!attackSelected) {
				if(attack < 1 || attack > 4) {       
					System.out.println("Invalid Option! Select a number between 1-4!");
					attack = scan.nextInt();
				} else if (attack >=1 && attack <=4) {
					attackSelected = true;
					if(attack == 1) {
						System.out.println("You have choosen: " + nPAttack1 + "\n");
						enemyHealth -= valueAP1;
					}else if(attack == 2) {
						System.out.println("You have choosen: " + nPAttack2 + "\n");
						enemyHealth -= valueAP2;
					}
					else if(attack == 3) {
						System.out.println("You have choosen: " + nPAttack3 + "\n");
						enemyHealth -= valueAP3;
					}
					else if(attack == 4) {
						System.out.println("You have choosen: " + nPAttack4 + "\n");
						enemyHealth -= valueAP4;
					}
				}
				}
//			wenn leben > 0 enemyAttack sonst GameOver
        		if(enemyHealth > 0) {
        			enemyAttack();
        		} else {
        			GameOver();
        		}
//        		wenn 60 sekunden vorbei GameOver
		}else {
			GameOver();
		}
	}
	private static void enemyAttack() {
//		wie playerttack
		if(System.currentTimeMillis() - roundStartTime < 60000) {
			Random random = new Random();
			int eA = random.nextInt(4);
			if(eA == 0) {
				playerHealth -= valueAE1;
				System.out.println("Your enemy has choosen: " + nEAttack1);
			}else if(eA == 1) {
				playerHealth -= valueAE2;
				System.out.println("Your enemy has choosen: " + nEAttack2);
			}else if(eA == 2) {
				playerHealth -= valueAE3;
				System.out.println("Your enemy has choosen: " + nEAttack3);
			}
			else if(eA == 3) {
				playerHealth -= valueAE4;
				System.out.println("Your enemy has choosen: " + nEAttack4);
			}
			if(playerHealth > 0) {
	    		PlayerAttack();
	    	} else {
	    		GameOver();
	    	}	
		
		}else {
			GameOver();
		}
	}
	public static void GameOver() {
		if(enemyHealth <= 0) {
			playerWins++;
			if(playerWins >= 2) {
				System.out.println("You have won this game!");
			}
			else {
				System.out.println("You have won this round! Next round starts!");
//				neue Runde starten
				RoundStart();
			}	
		}
		else if(playerHealth <= 0) {
			enemyWins++;
			if (enemyWins >= 2) {
				System.out.println("You have lost this game!");
			} else {
				System.out.println("You have lost this round! Next round starts!");
				RoundStart();
			}
		} 
//		wenn beide noch leben haben muss Zeit abgelaufen sein. Daher Time Expired und eine neue Runde
		else {
			System.out.println("Time expired! Nobody gets a Point. Next round starts!");
			RoundStart();
		}
		System.out.println("\nPress 1 to play again or 9 to close the game!");
		int tmp = scan.nextInt();
//		selbe while schleife
		boolean optionSelected = false;
		while(!optionSelected) {
			if(tmp == 1 || tmp == 9) {
				if(tmp == 1) {
//					neues Spiel starten
					GameStart();
				}
				if(tmp == 9) {
//					programm beenden
					System.exit(0);
				}
				optionSelected = true;
			}else {
				System.out.println("Invalid Option! Type 1 to play again or 9 to close the game!");
				tmp = scan.nextInt();
		}
		}
	}
	private static void initializeCharacter() {
//		characterSelection checken und entsprechende Werte and setPlayerValues übergeben
		if(characterSelection == 1) {
			setPlayerValues("Jin Kazama", "HighRightRoundhouse" , 18, "LeftAxeKick", 20, "ElectricWindHookFist", 30, "RightLowRoundhouse", 18);	
		}
		else if (characterSelection == 2){
			setPlayerValues("Kazuya Mishima", "TsunamiKick" , 26, "ElectricWindGodFist", 20, "AbolishingFist", 22, "SpinningDemonToLeftHook", 33);	
		}
		else if (characterSelection == 3){
			setPlayerValues("Heihachi Mishima", "RightSplitsKick" , 15, "Eishomon", 25, "ElectricWindGodFist2", 23, "DemonUppercut", 30);
		}
		else if (characterSelection == 4){
			setPlayerValues("Devil Jin", "WraithKick" , 21, "Samsara", 22, "ElectricWindGodFist3", 35, "MaliciousMace", 15);	
		}
		else if (characterSelection == 5){
			setPlayerValues("Sergei Dragunov", "BlizzardHammer" , 26, "RussianAssault", 25, "SlicingSobat", 21, "Razer", 17);	
		}
		else if (characterSelection == 6){
			setPlayerValues("Bryan Fury", "OrbitalHeelKick" , 22, "JetUpper", 20, "MachineGunPunches", 40, "HatchetKick", 21);	
		}
		else if (characterSelection == 7){
			setPlayerValues("Jack-7", "JabToStunningHook" , 15, "Jackhammer", 30, "PistonGunAssault", 27, "MachinegunBlast", 13);
		}
		System.out.println("You have choosen: " + playerName + "\n");
	}
	public static void setPlayerValues(String name, String attack1, int value1, String attack2, int value2, String attack3, int value3, String attack4, int value4 ) {		
//		übergebene Werte des Charakters auf Variablen übertragen
		playerName = name;
		playerHealth = maxHp;
		nPAttack1 = attack1;
		nPAttack2 = attack2;
		nPAttack3 = attack3;
		nPAttack4 = attack4;
		
		valueAP1 = value1;
		valueAP2 = value2;
		valueAP3 = value3;
		valueAP4 = value4;
	}
	public static void initializeEnemy() {
//		selbe wie initializeCharachter
		Random random = new Random();
		int randomInt = random.nextInt(7);
		
		if(randomInt == 0) {
			setEnemyValues("Jin Kazama", "HighRightRoundhouse", 18, "LeftAxeKick", 20, "ElectricWindHookFist", 30, "RightLowRoundhouse", 18);
		} 
		else if(randomInt == 1) {
			setEnemyValues("Kazuya Mishima", "TsunamiKick", 26, "ElectricWindGodFist", 20, "AbolishingFist", 22, "SpinningDemonToLeftHook", 33);
		}
		else if(randomInt == 2) {
			setEnemyValues("Bryan Fury", "OrbitalHeelKick", 22, "JetUpper", 20, "MachineGunPunches", 40, "HatchetKick", 21);
		}
		else if(randomInt == 3) {
			setEnemyValues("Jack-7", "JabToStunningHook", 15, "Jackhammer", 30, "PistonGunAssault", 27, "MachinegunBlast", 13);
		}
		else if(randomInt == 4) {
			setEnemyValues("Sergei Dragunov", "BlizzardHammer ", 26, "RussianAssault", 25, "SlicingSobat", 21, "Razer", 17);
		}
		else if(randomInt == 5) {
			setEnemyValues("Heihachi Mishima", "RightSplitsKick", 15, "Eishomon", 25, "ElectricWindGodFist2", 23, "DemonUppercut", 30);
		}
		else if(randomInt == 6) {
			setEnemyValues("Devil Jin", "WraithKick", 21, "Samsara", 22, "ElectricWindGodFist3", 35, "MaliciousMace", 15);
		}
		System.out.println("Your Enemy is: " + enemyName);
	}
	public static void setEnemyValues(String name, String attack1, int value1, String attack2, int value2, String attack3, int value3, String attack4, int value4) {
//		selbe wie setPlayerValues
		enemyName = name;
		enemyHealth = maxHp;
		nEAttack1 = attack1;
		nEAttack2 = attack2;
		nEAttack3 = attack3;
		nEAttack4 = attack4;
		
		valueAE1 = value1;
		valueAE2 = value2;
		valueAE3 = value3;
		valueAE4 = value4;
	}
	public static void typewriterIntro(String message, long millisecondsPerCharacter)
    {
        for (int i=0; i < message.length(); i++)
        {
            System.out.print(message.charAt(i));
            try
            {
                Thread.sleep(millisecondsPerCharacter);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
