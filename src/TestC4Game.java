

/**
 * @file TestC4Game.java
 * @detail A test class for C4Game.java
 * 
 * 		   C4Game.playGame is tested one time(s).
 * 		   C4Game.nextTurn is tested one time(s).
 *         C4Game.winCheck is tested one time(s).
 *         C4Game.init / C4Game.gameLoop runs in an infinite loop and can not be tested in isolation.
 *         
 * @author Tom
 *
 */
public class TestC4Game {
	
	private static final int PLAYER_ONE = 1;
	private static final int PLAYER_TWO = 2;
	
	private static C4Game c4Game;
	
	public static void main(String[] args) {
		
		
		/*
		 * C4Game.playGame Test One
		 * Call the method after a constructor
		 */	
		c4Game = new C4Game();
		
		try {
			c4Game.playGame();
			System.out.println("C4Game.playgame Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("C4Game.playgame Test One Evaluated: Incorrect");
		}
		
		
		/*
		 * C4Game.nextTurn Test One
		 * Call the method for the first time after the game begins
		 * Method only possible if C4Game.playGame succeeds
		 */	
		c4Game = new C4Game();
		try {
			c4Game.playGame();
		} catch (Exception e) {
			System.out.println("C4Game.nextTurn Test One Evaluated: Incorrect");
		}
		
		c4Game.nextTurn();
		if(c4Game.getTurn() == PLAYER_TWO) {
			System.out.println("C4Game.nextTurn Test One Evaluated: Correct");
		} else {
			System.out.println("C4Game.nextTurn Test One Evaluated: Incorrect");
		}
		
		
		/*
		 * C4Game.winCheck Test One
		 * Method called after constructor, so board is empty and there is no winner
		 * Method only possible if C4Game.playGame succeeds
		 */	
		c4Game = new C4Game();
		try {
			c4Game.playGame();
		} catch (Exception e) {
			System.out.println("C4Game.nextTurn Test One Evaluated: Incorrect");
		}
		
		try {
			System.out.println("C4Game.winCheck Expected Output: Evaluated: No Winner");
			c4Game.winCheck();
			System.out.println("C4Game.winCheck Test One Evaluated: Correct");
		} catch (Exception e) {
			System.out.println("C4Game.winCheck Test One Evaluated: Incorrect");
		}
				
		
	}
	
}
