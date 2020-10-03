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
                int maxNumPlayers = OhHell.getMaxNumPlayers();
                ArrayList<Player> players = getPlayers(maxNumPlayers, input);
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

    public static ArrayList<Player> getPlayers(int maxNumPlayers, Scanner input) {
        ArrayList<Player> players = new ArrayList<>();

        System.out.println("Enter player names. Enter blank after last player.");

        for (int i = 0; i < maxNumPlayers; i++) {
            System.out.print("Player " + (i+1) + ": ");
            String playerName = input.nextLine();

            if (playerName.isEmpty()) {
                break;
            }
            Player player = new Player(playerName);
            players.add(player);
        }

        return players;
    }
}
