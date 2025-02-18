/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Avleen Kaur Jatana, Saraljit Kaur Mann, Parvatie Persaud; 11 July 2024
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public abstract class Card {
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public abstract String toString();

    /**
     * Compare this card with another card.
     *
     * @param card the card to compare with
     * @return true if the cards are equal, false otherwise
     */
    public abstract boolean equals(Card card);

    /**
     * Get the rank of the card.
     *
     * @return the rank of the card
     */
    public abstract int getRank();
}
