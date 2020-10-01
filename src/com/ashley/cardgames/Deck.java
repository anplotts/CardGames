package com.ashley.cardgames;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    public Stack<Card> deck;
    public Stack<Card> drawPile; //private - testing private? test public things that use when I have them?
    public Stack<Card> discardPile = new Stack<>(); //private

    // Takes a stack of Card objects as input to create a deck of cards
    public Deck(Stack<Card> deck) {
        this.deck = deck;
    }

    // Creates a draw pile by cloning the deck stack
    public void initializeDrawPile() {  //private
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

    // Will shuffle the discard pile
    public void shuffleDiscard() {

    }
}
