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
        assertEquals(cards.size(), deck.getDrawPileSize());
    }

    @Test
    // Checks that the draw pile stack is empty after calling deck.drawCard() on a draw pile with one card
    void drawCardDrawPileEmpty() {
        Stack<Card> cards = new Stack<>();
        cards.push(new Card(3, "Hearts"));
        Deck deck = new Deck(cards);
        deck.shuffle();
        deck.drawCard();
        assertEquals(0, deck.getDrawPileSize());
    }

    @Test
    // Checks that when drawing a card from a single card deck, the drawn card matches the card in the deck
    void drawCardDrawnCardMatches() {
        Card card = new Card(3, "Hearts");
        Stack<Card> cards = new Stack<>();
        cards.push(card);
        Deck deck = new Deck(cards);
        deck.shuffle();
        Card drawnCard = deck.drawCard();
        assertEquals(card, drawnCard);
    }

    @Test
    // Checks that after calling deck.discard(card), discard pile contains card
    void discardDiscardPileContainsCard() {
        Card card = new Card(3, "Hearts");
        Stack<Card> cards = new Stack<>();
        cards.push(card);
        Deck deck = new Deck(cards);
        deck.discard(card);
        assertEquals(card, deck.drawFromDiscard());
    }

    @Test
    // Checks that after calling deck.shuffleDiscard(), and then drawing a card from new draw pile, card matches
    void shuffleDiscard() {
        Card card = new Card(3, "Hearts");
        Stack<Card> cards = new Stack<>();
        cards.push(card);
        Deck deck = new Deck(cards);
        deck.discard(card);
        deck.shuffleDiscard();
        Card drawnCard = deck.drawCard();
        assertEquals(card, drawnCard);
    }

    @Test
    // Checks that getDrawPileSize returns the correct value for size of draw pile
    void getDrawPileSize() {
        Card card = new Card(3, "Hearts");
        Stack<Card> cards = new Stack<>();
        cards.push(card);
        Deck deck = new Deck(cards);
        deck.shuffle();
        assertEquals(1, deck.getDrawPileSize());
    }

}