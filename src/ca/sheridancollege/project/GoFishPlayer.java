package ca.sheridancollege.project;

import java.util.ArrayList;

// a class for the go fish game player

public class GoFishPlayer extends Player {

    private ArrayList<GoFishCard> pairs; //initialise the pairs list 

    public GoFishPlayer (String name){
        super(name);
        pairs = new ArrayList<>();
    }
    
    @Override 
    public void play() {  // logic for player's turn goes here found in main class. 
        
    }

    /* check for pairs in player's hand and
     * @param opponent being asked
     * @param the rank being asked about
     * @return true if opponent has one or more of the card requested 
     *
     */

    public boolean askForCard(GoFishPlayer opponent, String rank){
        boolean found = false; 
        ArrayList<Card> opponentHand = opponent.getHand();
        
        for (int i=0; i < opponentHand.size(); i++) { //searches through opponents hand of cards
            GoFishCard card = (GoFishCard) opponentHand.get(i);
            if (card.toString().contains(rank)) { 
                addCardToHand(opponentHand.remove(i));
                found = true;
                i--; // now the hand has -1 
            }

        }

        if (found) {
            System.out.println(opponent.getName() + "gave you one or more" + rank + "s.");
        }
        else { 
            System.out.println(opponent.getName() + "says, Go Fish!");
        }

        return found;
        }


        /*
         * check for the pairs in the players hand and removes then 
         * @return the list of pairs found 
         */
    

    public ArrayList<GoFishCard> checkForPairs (){
        ArrayList<GoFishCard> foundPairs = new ArrayList<>();
        ArrayList<Card> hand = getHand();

        for (int i = 0; i < hand.size(); i++){
            GoFishCard card1 = (GoFishCard) hand.get(i);
            for (int j = i + 1; j < hand.size(); j++) {
                GoFishCard card2 = (GoFishCard) hand.get(j);
                if (card1.equals(card2)) { 
                    foundPairs.add(card1);
                    foundPairs.add(card2);
                    hand.remove(j);
                    hand.remove(i);
                    i--;
                    break;
                }
            }
        }
        pairs.addAll(foundPairs); //adds the found pairs to the player's pairs status
        return foundPairs;
    }
}