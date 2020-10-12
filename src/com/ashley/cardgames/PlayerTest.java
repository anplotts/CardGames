package com.ashley.cardgames;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    // Tests the sorting of the hand
    void sortHand() {
        Player player = new Player("Player 1");
        player.giveCard(new Card(3, "Hearts"));
        player.giveCard(new Card(9, "Diamonds"));
        player.giveCard(new Card(13, "Clubs"));
        player.giveCard(new Card(6, "Spades"));
        player.sortHand();
        assertEquals("[[13,Clubs], [9,Diamonds], [6,Spades], [3,Hearts]]", player.getHandAsString());
    }

    @Test
    // Checks that when drawing a card, the given card matches what was in the deck
    void giveCardHandMatches() {
        Card card = new Card(3, "Hearts");
        Player player = new Player("Ashley");
        player.giveCard(card);
        assertEquals("[[3,Hearts]]", player.getHandAsString());
    }

    @Test
    // Checks that playCard plays the card from the correct index of the player's hand
    void playCard() {
        Player player = new Player("Ashley");
        Card card = new Card(3, "Hearts");
        player.giveCard(card);
        Card playedCard = player.playCard(0);
        assertEquals(card, playedCard);
    }
}