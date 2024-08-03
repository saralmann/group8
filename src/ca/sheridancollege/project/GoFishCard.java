package ca.sheridancollege.project;
// a class to for the card of the Go Fish Game. 
public class GoFishCard extends Card {

    private final String rank; // rank of card "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
    private final String suit; // suit of the card  {"Hearts", "Diamonds", "Clubs", "Spades"

    public GoFishCard(String rank, String suit){
        this.rank =  rank;
        this.suit = suit;
    }

    @Override // translates the chosen card into a string message 
    public String toString() { 
        return rank + "of" + suit;
    }

    @Override
    public boolean equals(Card card){
        if (card instanceof GoFishCard) { 
            GoFishCard goFishCard = (GoFishCard) card;
            return this.rank.equals(goFishCard.rank);
        }
        return false;
    }

    @Override
    public int getRank() { // grabs the rank from the dictionary shown above
        switch (rank) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "Jack": return 11;
            case "Queen": return 12;
            case "King": return 13;
            case "Ace": return 14;
            default: throw new IllegalArgumentException("Invalid card rank: " + rank);

    }
}
    }
