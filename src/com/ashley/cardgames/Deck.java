package com.ashley.cardgames;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private final Stack<Card> deck;
    private Stack<Card> drawPile;
    private Stack<Card> discardPile = new Stack<>();

    // Takes a stack of Card objects as input to create a deck of cards
    public Deck(Stack<Card> deck) {
        this.deck = deck;
    }

    // Creates a draw pile by cloning the deck stack
    private void initializeDrawPile() {
        drawPile = (Stack<Card>)deck.clone();
    }

    // Calls initializeDrawPile to create a draw pile, then shuffles the draw pile
    public void shuffle() {
        initializeDrawPile();
        Collections.shuffle(drawPile);
    }

    // Pops the top card from the draw pile stack and returns it
    public Card drawCard() {
        return drawPile.pop();
    }

    // Adds the card input to the top of the discard pile stack
    public void discard(Card card) {
        discardPile.push(card);
    }

    // Shuffles the discard pile and sets it as the new draw pile, for use when draw pile is empty
    public void shuffleDiscard() {
        Collections.shuffle(discardPile);
        drawPile = discardPile;
        discardPile = new Stack<>();
    }

    // Returns the size of the Draw Pile
    public int getDrawPileSize() {
        return drawPile.size();
    }


    public Card drawFromDiscard() {
        return discardPile.pop();
    }

}
