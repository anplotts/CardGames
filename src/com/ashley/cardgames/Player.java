package com.ashley.cardgames;

import java.util.Stack;

public class Player {
    String name;
    Stack<Card> hand = new Stack<Card>();

    // Takes player's name as input to create a Player
    public Player(String name) {
        this.name = name;
    }

    // Overrides toString to return player's name
    public String toString() {
        return name;
    }

    // Will sort player's hand based on some criteria yet to be determined
    public void sortHand() {

    }

    // Adds card input to player's hand
    public void giveCard(Card card) {
        hand.push(card);
    }

}
