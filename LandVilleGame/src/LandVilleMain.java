/*
 * Programming Fundamentals (COSC2531)
 * Assignment 1: LandVille. 
 * Tutor - Jane
 * s3740472 - Roshan Lakmal - s3740472@student.rmit.edu.au.
 * s3710690 - Guan Jing - s3710690@student.rmit.edu.au.
 * 
 */

import java.util.Scanner;

public class LandVilleMain {

	public static void main(String args[]) {
		
		//Creating the Scanner Object.
		Scanner input = new Scanner(System.in);
		
		//Initialise landRow and landCol to 0.
		int landRow = 0;
		int landCol = 0;

		//Initialise houseRow and houseCol to 0.
		int houseRow = 0;
		int houseCol = 0;
		
		//Initialise menuNum to 0.
		int menuNum = 0;
		
		//Validating landRow.
		do {
			System.out.println("Enter row number of the land: ");
			
			//Validating for String inputs for landRow.
			while (!input.hasNextInt()){
				System.out.println("Row number of the land need to be an integer");
				input.next();
				System.out.println("Enter row number of the land: ");
			}
			
			landRow = input.nextInt();
			
			//Validating for Integer inputs for landRow.
			if (landRow < 3 || landRow > 10) {
				System.out.println("Row should be greater than equal to 3 and less than or equal to 10");
			}
			
		} while (landRow < 3 || landRow > 10);
		
		//Validating landCol.
		do {
			
			System.out.println("Enter column number of the land: ");
			
			//Validating for String inputs for landCol.
			while (!input.hasNextInt()){
				System.out.println("Column number of the land need to be an integer");
				input.next();
				System.out.println("Enter column number of the land: ");
			}
			
			landCol = input.nextInt();
			
			//Validating for Integer inputs for landCol.
			if (landCol < 3 || landCol > 10) {
				System.out.println("Column should be greater than equal to 3 and less than or equal to 10");
			}
			
		} while (landCol < 3 || landCol > 10);
		
		//Creating the LandVille object.
		LandVille myLand = new LandVille(landRow,landCol);
		
		do {
			
			//Printing the menu.
			printMenu();
			
			//Validating for String inputs for menu number.
			while (!input.hasNextInt()){
				System.out.println("Menu number need to be an integer");
				input.next();
				printMenu();
			}
			
			menuNum = input.nextInt();
			
			//Validating for Integer inputs for menu number.
			if (menuNum < 1 || menuNum > 4) {
				System.out.println("Menu should be greater than equal to 1 and less than or equal to 4");
			}
			
			switch (menuNum){
				case 1:
					
					//Checking for existing house.
					if (myLand.isHasHouse()){
						System.out.println("House already exists!");
					} else {
						
						System.out.println("Enter row of the house:");
						
						//Validating for String inputs for houseRow.
						while (!input.hasNextInt()){
							System.out.println("Row number of the house need to be an integer");
							input.next();
							System.out.println("Enter row of the house:");
						}
						
						houseRow = input.nextInt();
						
						System.out.println("Enter column of the house:");
						
						//Validating for String inputs for houseCol.
						while (!input.hasNextInt()){
							System.out.println("Column number of the house need to be an integer");
							input.next();
							System.out.println("Enter column of the house:");
						}
						
						houseCol = input.nextInt();
						
						//Building the house
						myLand.buildHouse(houseRow,houseCol);
					}
					
					//Setting back the menuNum to 0. 
					menuNum = 0;
					
					break;
				case 2:
					
					//Displaying the land.
					myLand.displayLand();
					
					//Setting back the menuNum to 0. 
					menuNum = 0;
					break;
				case 3:
					
					//Clearing the land. 
					myLand.clearLand();
			    	System.out.println("Land cleared");
			    	
			    	//Displaying the land.
			    	myLand.displayLand();
			    	
			    	//Setting back the menuNum to 0. 
					menuNum = 0;
					break;
				case 4:
					
					System.out.println("Program ends.");
					
					//Exiting the program.
					System.exit(0);
					break;
			}
		} while (menuNum < 1 || menuNum > 4);
	}
	
	
	//Printing the menu
	public static void printMenu(){
		System.out.println("Choose from the menu: ");
		System.out.println("1. Build a house");
		System.out.println("2. Display land");
		System.out.println("3. Clear land");
		System.out.println("4. Quite");
		System.out.println("Enter the menu number:");
	}
	
}

