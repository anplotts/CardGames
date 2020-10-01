package com.ashley.cardgames;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What game do you want to play?");

        String gameName = input.nextLine();

        switch (gameName) {
            case "Oh Hell":
                //move to start game method in game class
                int maxNumPlayers = OhHell.getMaxNumPlayers();
                ArrayList<Player> players = new ArrayList<>();

                System.out.println("Enter player names. Enter blank after last player.");

                for (int i = 0; i < maxNumPlayers; i++) {
                    System.out.println("Player " + (i+1));
                    String playerName = input.nextLine();

                    if (playerName.isEmpty()) {
                        break;
                    }
                    Player player = new Player(playerName);
                    players.add(player);
                }

                System.out.println(players); // move to test

                OhHell game = new OhHell(players);
                game.playGame();

                break;
            case "Chess":
                break;
            case "Go Fish":
                System.out.println("No.");
                break;
            default:
                System.out.println("That's a fake game.");
        }
    }
}
