/**
 * This class implements a simple guess-the-card game using the Deck and Card classes.
 */

import java.io.*;
import java.util.Arrays;

public class guessTheCard {

	public static void main (String [] args){
	
	// Shuffle the deck
	Deck deck = new Deck ();	
	deck.shuffle ();
	
	boolean keepPlaying = true;
	
	while (keepPlaying) {
		// Deal out a card
		Card cardToGuess = deck.dealCard();
		System.out.print ("What card did I pull from the deck? (card value/suit)");
		
//  Open up standard input
	    BufferedReader bRead = new BufferedReader (new InputStreamReader (System.in));
	
	    String rawInput = null;
	    String[] cardGuessed;
	
//  Read user input
	    try {
	       rawInput = bRead.readLine ();
	    } 
	    
	    catch (IOException ioe) {
	       System.out.println ("IO error trying to read your guess!");
	       System.exit (1);
	    }
	    
// Expected inputs
	    cardGuessed = rawInput.split("[/]+");
		System.out.println("cardGuessed = " + Arrays.toString(cardGuessed));
		
// Parse and validate response
		if (cardToGuess.getCardValAsString ().equals(cardGuessed[0].toUpperCase()) 
				&& cardToGuess.getCardSuitAsString().equals(cardGuessed[1].toUpperCase())) {
			System.out.println("You guessed correctly!");
			}
		
		else if (cardToGuess.getCardValAsString ().equals(cardGuessed[0].toUpperCase())) {
			System.out.println("You guessed the value correctly, but not the suit. The card was "
					+ cardToGuess.getCardValAsString () + " of " + cardToGuess.getCardSuitAsString());
			}
		
		else if (cardToGuess.getCardSuitAsString().equals(cardGuessed[1].toUpperCase())) {
			System.out.println ("You guessed the suit correctly, but not the value. The card was "
					+ cardToGuess.getCardValAsString () + " of " + cardToGuess.getCardSuitAsString());
			}
		
		else {
			System.out.println("You guessed incorrectly. The card was " 
					+ cardToGuess.getCardValAsString () + " of " + cardToGuess.getCardSuitAsString());
			}
		
// Play again?
		System.out.print ("Would you like to play again? (y/n)");
		try {
		    rawInput = bRead.readLine ();
		    } 
		
		catch (IOException ioe) {
		       System.out.println ("IO error trying to read your input!");
		       System.exit (1);
		    }
		
		if (rawInput.toLowerCase().startsWith("n")) {
			keepPlaying = false;
			
			// Try to close the file stream
			try {
				bRead.close ();
			}
			
			catch (IOException ioe) {
			   System.out.println ("IO error trying to close the file stream.");
			   System.exit (1);
			}
			
			System.exit (0);
		}
		
		if (keepPlaying) {
			// Out of cards--reset our deck
			if (deck.getNumCardsInDeck() <= 0) {
				deck.shuffle();
			}
		}
		
		}	// End keepPlaying
	}	// End main
}
