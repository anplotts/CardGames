package com.ashley.cardgames;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void sortHand() {
    }

    @Test
    // Checks that when drawing a card, the given card matches what was in the deck
    void giveCardHandMatches() {
        Card card = new Card(3, "Hearts");
        Player player = new Player("Ashley");
        player.giveCard(card);
        assertTrue(player.hand.contains(card));
    }


}