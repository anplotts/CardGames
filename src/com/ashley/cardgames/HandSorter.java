package com.ashley.cardgames;

import java.util.Comparator;

public class HandSorter implements Comparator<Card> {

    public static HandSorter instance = new HandSorter();

    //enums make comparisons easier ??? change

    public int compare(Card card1, Card card2) {
        if (card1.suit.equals(card2.suit)) {
            return Integer.compare(card1.value, card2.value);
        }

        if (card1.suit.equals("Hearts") || card2.suit.equals("Clubs")) {
            return 1;
        }

        if (card1.suit.equals("Clubs") || card2.suit.equals("Hearts")) {
            return -1;
        }

        if (card1.suit.equals("Diamonds")) {
            return -1;
        }

        return 1;
    }
}
