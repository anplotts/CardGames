package com.ashley.cardgames;

import org.junit.jupiter.api.Test;
import java.util.Stack;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    // Checks the the length of the draw pile is still the same as the deck after calling deck.shuffle()
    void shuffleDrawPileLength() {
        Stack<Card> cards = new Stack<>();
        cards.push(new Card(3, "Hearts"));
        cards.push(new Card(11, "Spades"));
        Deck deck = new Deck(cards);
        deck.shuffle();
        assertEquals(deck.drawPile.size(), deck.deck.size());
    }

    @Test
    /* Checks the the draw pile matches the deck after calling deck.initializeDrawPile(),
        converted to string for easier comparison */
    void initializeDrawPileMatchesDeck() {
        Stack<Card> cards = new Stack<>();
        cards.push(new Card(3, "Hearts"));
        Deck deck = new Deck(cards);
        deck.initializeDrawPile();
        assertEquals(deck.drawPile.toString(), deck.deck.toString());
    }

    @Test
    // Checks that the draw pile stack is empty after calling deck.drawCard() on a draw pile with one card
    void drawCardDrawPileEmpty() {
        Stack<Card> cards = new Stack<>();
        cards.push(new Card(3, "Hearts"));
        Deck deck = new Deck(cards);
        deck.initializeDrawPile();
        deck.drawCard();
        assertEquals(deck.drawPile.size(), 0);
    }

    @Test
    // Checks that when drawing a card from a single card deck, the drawn card matches the card in the deck
    void drawCardDrawnCardMatches() {
        Card card = new Card(3, "Hearts");
        Stack<Card> cards = new Stack<>();
        cards.push(card);
        Deck deck = new Deck(cards);
        deck.initializeDrawPile();
        Card drawnCard = deck.drawCard();
        assertEquals(drawnCard.toString(), card.toString());
    }

    @Test
    // Checks that the size of the draw pile changes after calling deck.drawCard()
    void drawCardShuffleDrawPileDeckDifferent() {
        Stack<Card> cards = new Stack<>();
        cards.push(new Card(3, "Hearts"));
        Deck deck = new Deck(cards);
        deck.initializeDrawPile();
        deck.drawCard();
        assertNotEquals(deck.drawPile.size(), deck.deck.size());
    }

    @Test
    // Checks that after calling deck.discard(card), discard pile contains card
    void discardDiscardPileContainsCard() {
        Card card = new Card(3, "Hearts");
        Stack<Card> cards = new Stack<>();
        cards.push(card);
        Deck deck = new Deck(cards);
        deck.discard(card);
        assertTrue(deck.discardPile.contains(card));
    }

    @Test
    void shuffleDiscard() {
    }
}