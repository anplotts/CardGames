package com.ashley.cardgames;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private String name;
    protected ArrayList<Card> hand = new ArrayList<>();

    // Takes player's name as input to create a Player
    public Player(String name) {
        this.name = name;
    }

    // Overrides toString to return player's name
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    // Sorts players hand by suit, then value
    public void sortHand() {
        hand.sort(HandSorter.instance);
    }

    // Adds card input to player's hand
    public void giveCard(Card card) {
        hand.add(card);
    }

    // Returns the players hand as a string
    public String getHandAsString() {
        return hand.toString();
    }

    public Card playCard(int cardIndex) {
        return hand.remove(cardIndex);
    }

}
