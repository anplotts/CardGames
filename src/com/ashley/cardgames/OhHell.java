package com.ashley.cardgames;

import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class OhHell {
    List<Player> players;
    Deck deck;

    // Takes player input and creates a new deck for the game
    public OhHell(List<Player> players) {
        this.players = players;
        deck = createDeck();
    }

    // Returns the max number of players for Oh Hell
    public static int getMaxNumPlayers() {
        return 5;
    }

    // Creates a standard deck of cards
    private Deck createDeck() {
        List<String> suits = Arrays.asList("Spades", "Clubs", "Hearts", "Diamonds");
        List<Integer> values = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
        Stack<Card> cards = new Stack<>();
        Card card;
        Deck deck;

        for (String suit : suits) {
            for (Integer value : values) {
                card = new Card(value, suit);
                cards.push(card);
            }
        }

        deck = new Deck(cards);

        return deck;

    }

    // Order of deal doesn't matter
    public void deal(int numCards) {
        for (int i = 0; i < numCards; i++) {
            for (Player player : players) {
                player.giveCard(deck.drawCard());
            }
        }
    }

    public void startGame() {

    }

    // game play
    public void playGame() {
        Random rand = new Random();
        int firstBidder = rand.nextInt(players.size());
        deck.shuffle();
        deal(1);

        for (int round = 0; round < 20; round++) {

            // Shuffle and deal cards
            //Players bid on number of tricks

            int numCardsForRound = 10; //Need to set based on round number, <10 set to round, >10 set to 20-round ??

            for (int hand = 0; hand < numCardsForRound; hand++) {

                // for each hand, players play cards and score until hands are empty
                // play starts with winner of last hand
                // first hand starts with firstBidder

            }
        }
    }


}
