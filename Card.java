/** This class models a card in a deck of cards.
 * 
 * @author stephanieduy
 *
 */
import java.lang.Enum;
import java.lang.RuntimeException;

public class Card {

/**
 * Enum for all possible card values 
 */
	public enum eCardVal {
		ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), 
		EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), INVALIDVAL(-1);
	
	private final int val;
	eCardVal (int val) {this.val = val;}
	public int getVal () {return val;}
	};
	
/**
 * Enum for all possible card suits
 */
	public enum eCardSuit {
		CLUBS(1), DIAMONDS(2), HEARTS(3), SPADES(4), INVALIDSUIT(-1);
	
		private final int suitVal;
		eCardSuit (int suitVal) {this.suitVal = suitVal;}
		public int getSuitVal () {return suitVal;}
	};

/** 
 * Constructor using enum values.
 * @param CardVal Enum card value
 * @param CardSuit Enum card suit
 */
	Card (eCardVal CardVal, eCardSuit CardSuit) {
		setCardVal (CardVal);
		setCardSuit (CardSuit);
	}

/** 
 * Constructor using integer values.
 * @param CardVal Zero-based card value
 * @param CardSuit Zero-based card suit
 */
	Card (int CardVal, int CardSuit) {
		setCardVal (eCardVal.values()[CardVal]);
		setCardSuit (eCardSuit.values()[CardSuit]);
	}

/** 
 * Current card value
 */
	private eCardVal cardValVar;

/**
 * This function sets the current card's value.
 * @param 	CardVal 	The value we want to set this card to
 * @see 	#getCardVal()
 */
	public void setCardVal (eCardVal CardVal) {
		cardValVar = CardVal;
	}
	
/**
 * This function returns the current card's value.
 * @return 	Returns the current value of this card
 * @see		#setCardVal(eCardVal)
 */
	public eCardVal getCardVal () {
		return (cardValVar);
	}
	
/**
 * This function returns the current card's value as a string
 * @return	String equivalent of current card's value.
 * @see		#getCardValue()
 * @see		#cardValToString(eCardVal)
 */
	public String getCardValAsString () {
		return (cardValToString (cardValVar));
	}
	
/**
 * Current card suit
 */
	private eCardSuit cardSuitVar;
	
/**
 * This function sets the current card's suit.
 * @param 	CardSuit 	The suit to set this card to
 * @see		#getCardSuit()
 */
	public void setCardSuit (eCardSuit CardSuit) {
		cardSuitVar = CardSuit;
	}
	
/**
 * This function returns the current card's suit.
 * @return	cardSuitVar	Current card suit.
 * @see		#setCardSuit(eCardSuit)
 */
	public eCardSuit getCardSuit () {
		return (cardSuitVar);
	}
	
/**
 * This function returns the current card's suit as a string
 * @return	String equivalent of current card's suit.
 * @see		#getCardSuit()
 * @see		#cardSuitToString(eCardSuit)
 */
	public String getCardSuitAsString () {
		return (cardSuitToString (cardSuitVar));
	}

/**
 * True if the card has been dealt, false if it's still in the deck.
 */
	private boolean bHasBeenDealt = false;

/**
 * This function sets the current card's dealt flag.
 * @param hasBeenDealt	true if the card has been dealt, false if it's still in the deck.
 */
	public void setCardDealStatus (boolean hasBeenDealt) {
		bHasBeenDealt = hasBeenDealt;
		}
	
/**
 * This function returns the eCardSuit object passed in as a string
 * @param 	CardSuit	The eCardSuit that we're converting into a string.
 * @return	The string representation of the eCardSuit object.
 * @see		#cardStringToSuit(String)
 */
	public String cardSuitToString (eCardSuit CardSuit) {
		return CardSuit.toString();
	}
	
/**
 * This function converts a string into an eCardSuit
 * @param 	CardSuitString	The string that we're converting into an eCardSuit object
 * @return	The eCardSuit equivalent of the string that's been passed in
 * @see		#cardSuitToString(eCardSuit)
 */
	public eCardSuit cardStringToSuit (String CardSuitString){
		
		try {
			return eCardSuit.valueOf(CardSuitString.toUpperCase());
		}
		catch (IllegalArgumentException iaEx) {
			System.out.println("Failed to convert string to card suit; cannot find matching enum type.");
			return eCardSuit.INVALIDSUIT;
		}
		catch (NullPointerException npEx) {
			System.out.println("Failed to convert string to card suit--enumType or name is null.");
			return eCardSuit.INVALIDSUIT;
		}
	}

/**
 * This function converts an eCardVal object into a string	
 * @param 	CardVal	The eCardVal object that we're converting into a string
 * @return	The string representation of the eCardVal that's been passed in.
 * @see		#cardStringToVal(String)
 */
	public String cardValToString (eCardVal CardVal){
		return CardVal.toString ();
	}
	
/**
 * This function converts a string into an eCardVal object.
 * @param 	CardValString	The string that we're converting into an eCardVal object.
 * @return	The eCardVal object equivalent to the string that's been passed in.
 * @see		#cardValToString(eCardVal)
 */
	public eCardVal cardStringToVal (String CardValString){
		try {
			return eCardVal.valueOf(CardValString.toUpperCase());
		}
		catch (IllegalArgumentException iaEx) {
			System.out.println("Failed to convert string to card suit; cannot find matching enum type.");
			return eCardVal.INVALIDVAL;
		}
		catch (NullPointerException npEx) {
			System.out.println("Failed to convert string to card suit--enumType or name is null.");
			return eCardVal.INVALIDVAL;
		}
	}
}
