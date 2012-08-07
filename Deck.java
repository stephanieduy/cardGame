/**
 * This class models a deck of cards.
 */
import java.util.ArrayList;
import java.util.Random;

public class Deck {
/**
 * Maximum number of cards
 */
	public static int nMaxCards = 52;
	
/**
 * Our deck of cards
 */
	private ArrayList <Card> deck = new ArrayList <Card> (nMaxCards);
	
/**
 * Default constructor. Fills in the deck of cards, assuming a 52-card deck.
 */
	Deck () {	
		// Fill in the deck
		for (int cardVal = 0; cardVal < 13; cardVal++) {
			for (int cardSuit = 0; cardSuit < 4; cardSuit++) {
				deck.add (new Card (cardVal, cardSuit));
				}
		}
	}
	
/**
 * Returns the number of cards left in the deck.	
 * @return	The number of cards left in the deck.
 */
	public int getNumCardsInDeck (){
		return (deck.size ());
	}
		
/**
 * Shuffle deck by swapping two cards at a time.
 */
	public void shuffle () {
		
	Card tempCard1;
	Card tempCard2;
	
	int index_1;
	int index_2;
	
	Random randomGen = new Random ();
	
	for (int cardIndex = 0; cardIndex < nMaxCards; cardIndex++) {
		// Pick a random place to pick a card out off
		index_1 = randomGen.nextInt (deck.size () - 1);
		index_2 = randomGen.nextInt (deck.size () - 1);
		
		// Store the card in a temp location
		tempCard1 = deck.get (index_1);
		tempCard2 = deck.get(index_2);
		
		// Reset the cards that we're shuffling as not dealt.
		tempCard1.setCardDealStatus(false);
		tempCard2.setCardDealStatus(false);
		
		// Swap the two cards
		deck.set(index_1, tempCard2);
		deck.set(index_2, tempCard1);
		}	
	}
	
/**
 * Get card from deck
 * @return	One card from the deck.
 */
	public Card dealCard () {
		Card returnedCard = deck.get(0);
		returnedCard.setCardDealStatus (true);
		
		deck.remove (0);
		return (returnedCard);
	}
}
