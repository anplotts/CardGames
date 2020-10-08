package com.ashley.cardgames;

public class Card {
    int value;
    String suit;

    // Creates a Card given a suit and value input
    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    // Overrides toString for easier viewing of cards
    // Output for player value 11-14 needs to be jack-ace
    public String toString() {
        return "[" + value + "," + suit + "]";
    }

    // Override equals method for decks that have multiple of one card - equatable?
}
