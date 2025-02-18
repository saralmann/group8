/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Avleen Kaur Jatana, Saraljit Kaur Mann, Parvatie Persaud; 11 July 2024
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player {

    private String name; //the unique name for this player
    private ArrayList<Card> hand; // the cards in the player's hand
    
    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the cards in the player's hand.
     *
     * @return the player's hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Add a card to the player's hand.
     *
     * @param card the card to add
     */
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    /**
     * Remove a card from the player's hand.
     *
     * @param card the card to remove
     * @return true if the card was removed, false otherwise
     */
    public boolean removeCardFromHand(Card card) {
        return hand.remove(card);
    }

    /**
     * Display the player's hand.
     */
    public void displayHand() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }
    
    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play();

}
