package ca.sheridancollege.project;
// this is where you run the game 

import java.util.Scanner;


public class Main {

    public static void main(String[] args){
// create and start game
        GoFishGame game = new GoFishGame("Go Fish!");

        
//add players : 

        System.out.print ("Enter the number of players (between 2 and 4) : ");
        Scanner scanner = new Scanner(System.in);
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); 

   

        for (int i =1; i <= numPlayers; i++) {
            System.out.print("Enter name for player" + i + ": ");
            String playerName = scanner.nextLine();
            GoFishPlayer player = new GoFishPlayer(playerName);
            game.addPlayer(player);
        }

        // start the game 
        game.play();

        //close scanner
        scanner.close();

        }}

    
            
            
            