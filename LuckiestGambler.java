/*To find the luckiest and unluckiest day, we need to keep track
 of the daily winnings/losses and then find the day(s) with the maximum and 
 minimum values. Here's an example Java program that does that */
 

package demo;

import java.util.Random;

public class LuckiestGambler {
	// Declaring constants for the stake and bet amounts, 
	//as well as the number of days in the month
	private static final int STAKE = 100;
	private static final int BET = 1;
	private static final int DAYS_IN_MONTH = 20;

	// Creating an instance of the Random class to generate random numbers
	private static final Random rand = new Random();

	// Defining the main method
	public static void main(String[] args) {
	    
	    // Declaring variables to store the total winnings, days won and lost, 
		//and the maximum win and loss
	    int totalWinnings = 0;
	    int totalDaysWon = 0;
	    int totalDaysLost = 0;
	    int maxWin = Integer.MIN_VALUE;
	    int maxWinDay = 0;
	    int maxLoss = Integer.MAX_VALUE;
	    int maxLossDay = 0;

	    // Looping through each day of the month
	    for (int day = 1; day <= DAYS_IN_MONTH; day++) {
	        
	        // Initializing the gambler's stake, daily winnings, and number
	    	//of bets placed
	        int stake = STAKE;
	        int dailyWinnings = 0;
	        int dailyBetCount = 0;

	        // Playing the game until the gambler's stake is either exhausted
	        //or doubled
	        while (stake > 0 && stake < 2 * STAKE) {
	            
	            // Generating a random boolean to determine whether the gambler
	        	//wins or loses the bet
	            dailyBetCount++;
	            boolean win = rand.nextBoolean();
	            if (win) {
	                stake += BET;
	                dailyWinnings += BET;
	            } else {
	                stake -= BET;
	                dailyWinnings -= BET;
	            }
	        }

	        // Updating the total days won and lost based on the daily winnings
	        if (dailyWinnings > 0) {
	            totalDaysWon++;
	        } else if (dailyWinnings < 0) {
	            totalDaysLost++;
	        }

	        // Updating the total winnings and track the maximum win and loss
	        totalWinnings += dailyWinnings;

	        if (dailyWinnings > maxWin) {
	            maxWin = dailyWinnings;
	            maxWinDay = day;
	        }

	        if (dailyWinnings < maxLoss) {
	            maxLoss = dailyWinnings;
	            maxLossDay = day;
	        }

	        // Printing the daily results
	        System.out.printf("Day %d: %s%d, Total Winnings: %s%d%n",
	                day, dailyWinnings >= 0 ? "+" : "-", Math.abs(dailyWinnings),
	                totalWinnings >= 0 ? "+" : "-", Math.abs(totalWinnings));
	    }

	    // Printing the total days won, total days lost, and total winnings
	    System.out.printf("Total Days Won: %d, Total Days Lost: %d, Total Winnings: %s%d%n",
	            totalDaysWon, totalDaysLost, totalWinnings >= 0 ? "+" : "-", Math.abs(totalWinnings));
	    
	    // Printing the luckiest day and the corresponding winnings,
	    //as well as the unluckiest day and the corresponding losses
        System.out.printf("Luckiest Day: %d (Winnings: %s%d)%n", maxWinDay, maxWin >= 0 ? "+" : "-", Math.abs(maxWin));
        System.out.printf("Unluckiest Day: %d (Losses: %s%d)%n", maxLossDay, maxLoss >= 0 ? "+" : "-", Math.abs(maxLoss));
    }
}

