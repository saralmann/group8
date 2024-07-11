/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>(size);
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
    
    /**
     * Add a card to the group
     *
     * @param card the card to add
     */
    public void addCard(Card card) {
        if (cards.size() < size) {
            cards.add(card);
        } else {
            System.out.println("Group is full, cannot add more cards.");
        }
    }
    
    /**
     * Remove a card from the group
     *
     * @param card the card to remove
     * @return true if the card was removed, false otherwise
     */
    public boolean removeCard(Card card) {
        return cards.remove(card);
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Sort the cards in the group
     */
    public void sort() {
        Collections.sort(cards, (card1, card2) -> card1.toString().compareTo(card2.toString()));
    }
}//end class
