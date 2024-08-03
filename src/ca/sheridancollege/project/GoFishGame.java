package ca.sheridancollege.project;
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

    @Override
    public void play(){
        if(super.getPlayers().isEmpty()){
            System.out.println("No players in the game");
            return;
        }

        dealCards();
        boolean gameOver = false;

    try( Scanner scanner = new Scanner(System.in)){
        
        while (!gameOver) {
            for (Player p : super.getPlayers()) {
                if (p instanceof GoFishPlayer){
                    GoFishPlayer player = (GoFishPlayer) p;
                
                System.out.println(player.getName() + "'s turn:");
                player.displayHand();

                System.out.print("Enter the rank you want to ask for: ");
                String rank = scanner.nextLine();

                boolean success = false;
                for (Player opponent : super.getPlayers()) {
                    if (opponent instanceof GoFishPlayer && opponent != player) {
                        GoFishPlayer goFishOpponent = (GoFishPlayer) opponent;
                        success = player.askForCard(goFishOpponent, rank);
                        if (success) break;
                    }
                }

                if (!success) {
                    System.out.println("Go Fish!");
                    if (!deck.getCards().isEmpty()) {
                        player.addCardToHand(deck.getCards().remove(0));
                    } else {
                        System.out.println("The deck is empty!");
                    }
                }

                ArrayList<GoFishCard> pairs = player.checkForPairs();
                if (!pairs.isEmpty()) {
                    System.out.println("You made a pair: " + pairs);
                }

                if (player.getHand().isEmpty()) {
                    gameOver = true;
                    break;
                }
            }
        }
    }
}

    declareWinner();
    
    }


    

        private void dealCards() {
            int numberOfCardsPerPlayer = 5; // Example number of cards per player
            for (Player player : getPlayers()) {
                if (player instanceof GoFishPlayer) {
                    GoFishPlayer goFishPlayer = (GoFishPlayer) player;
                    for (int i = 0; i < numberOfCardsPerPlayer; i++) {
                        if (!deck.getCards().isEmpty()) {
                            goFishPlayer.addCardToHand(deck.getCards().remove(0));
                        } else {
                            System.out.println("The deck is empty!");
                            break;
                        }
                    }
                }
            }
        }
    
        @Override
        public void declareWinner() {
            // Example logic to declare the winner
            String winner = determineWinner();
            System.out.println("The winner is: " + winner);
        }
    
        @Override
        public void displayStatus() {
            // Example logic to display the current status of the game
            System.out.println("Game Status:");
            for (Player player : getPlayers()) {
                if (player instanceof GoFishPlayer) {
                    GoFishPlayer goFishPlayer = (GoFishPlayer) player;
                    System.out.println(goFishPlayer.getName() + " has " + goFishPlayer.getHand().size() + " cards.");
                }
            }
        }
    
        // Example method to determine the winner
        private String determineWinner() {
            // Implement your logic to determine the winner
            // For simplicity, this example just returns the name of the first player
            if (!getPlayers().isEmpty()) {
                return getPlayers().get(0).getName();
            }
            return "No players";
        }
    }
