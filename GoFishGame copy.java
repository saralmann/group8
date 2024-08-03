/*package ca.sheridancollege.project;


import java.util.ArrayList;
import java.util.Scanner;

// The class for the Go Fish Game 

public class GoFishGame extends Game {
    private GroupOfCards deck; //the deck of cards



    public GoFishGame(String name){
        super(name);
        deck = new GroupOfCards(52); //the standard deck size 
        initializeDeck(); // sets the cards
        deck.shuffle(); //shuffles the cards
    }

    private void initializeDeck() { 
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    

        for (String suit: suits) {
            for (String rank :  ranks) {
                deck.addCard(new GoFishCard(rank, suit)); // shows the cards given to the player's hand
            }
        }
    }

    public void addPlayer(GoFishPlayer player) { 
        if (getPlayers().size() < 4) { 
            super.addPlayer(player);
        } else {
            System.out.println("No more than 4 players are allowed in this game.");
        }
        
    }

    public void dealCards() {  //method to deal the cards. 
        int cardsToDeal = 5; //the set amount to deal the first round for each player. 
        if (getPlayers().size() == 2) { 
            cardsToDeal = 7; //replenishes the player's hand
        }

        for (int i = 0; i < cardsToDeal; i++) { 
            for (GoFishPlayer player : getPlayers){
                player.addCardToHand(deck.getCards().remove(0)); //replenishes the player's hand
            }
        }
    }

    @Override
    public void play() {
        dealCards();
        Scanner scanner = new Scanner(System.in); //the play is initiated
        boolean gameOver = false; //game is currently being played and not over

        while (!gameOver) { //while game is being played, the round goes player by player
            for (GoFishPlayer player : getPlayers()) {
                System.out.println(player.getName() + " 's turn: "); //it's x's turn
                player.displayHand(); // this is x's hand
                System.out.println("Enter the rank you want to ask for: "); // a "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
                String rank = scanner.nextLine();

                boolean success = false; //right now you're asking for a card match so no guarantee of success
                for (GoFishPlayer opponent : getPlayers()) { //if you're not an opponent this allows you to ask for the card you want 
                    if(opponent != player) {
                        success = player.askForCard(opponent, rank);
                        if (success) break;  // if you get the card huzzah!
                    }
                }

                    if (!success){
                        System.out.println("Go Fish!");
                        if (!deck.getCards().isEmpty()) { //so now that the player has to go fish this allows the player to draw the card at the top of the pile == the card at index 0 in the created array list 
                            player.addCardToHand(deck.getCards().remove(0));
                        } else{
                            System.out.println("The deck is empty!");  // this shows when there's no more cards to pull from 
                        }
                    }

                    ArrayList <GoFishCard> pairs = player.checkForPairs();
                    if (!pairs.isEmpty()) { 
                        System.out.println("You made a pair: " + pairs);    // to check for pairs 
                    }

                    if (player.getHand().isEmpty()) {  //if there is nothing left in the players hand the game is over!
                        gameOver = true;
                        break;
                    }
            }
        }

        declareWinner();
    }

    @Override //how to declare a winner of the game by grabbing the amount of pairs each player has and then seeing which player has more 
    public void declareWinner() { 
        GoFishPlayer winner = null;
        int maxPairs = 0;
        for (GoFishPlayer player : players) {
            int pairs = player.getPairs().size()/2;
            if (pairs > maxPairs) { 
                maxPairs = pairs; 
                winner = player;
            }
        }

        System.out.println("The winner is" + winner.getName() + "with" + maxPairs + "pairs!");
    }

    @Override
    public void displayStatus() { 
        for (GoFishPlayer player : players) { 
            System.out.println(player.getName() + "has" + (player.getPairs().size()/2) + "pairs!");  // displays the pairs the player currently has
        }
    }
}*/