package com.ashley.cardgames;

import java.util.*;

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

    // game play
    public void playGame() {
        Random rand = new Random();
        int firstBidder = rand.nextInt(players.size());

        for (int round = 1; round < 20; round++) {
            int numCardsForRound = round < 11 ? 11 - round : round - 9; // Starts by dealing 10, down to 1, then back to 10

            deck.shuffle();
            deal(numCardsForRound);
            Card trumpCard = deck.drawCard();
            System.out.println("Trump is " + trumpCard.suit);
            ArrayList<Integer> bids = getBids(numCardsForRound);


            for (int hand = 0; hand < numCardsForRound; hand++) {

                // for each hand, players play cards and score until hands are empty
                // play starts with winner of last hand
                // first hand starts with firstBidder

            }
        }
    }

    public ArrayList<Integer> getBids(int numCardsForRound) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> bids = new ArrayList<>();
        int totalBids = 0;

        for (int player = 0; player < players.size(); player++) {
            System.out.println(players.get(player).hand);

            if (player == players.size() - 1) {
               int bidAmountNotAllowed = numCardsForRound - totalBids;
                System.out.print(players.get(player).name + ", please submit a bid that is NOT " + bidAmountNotAllowed + ": ");
            }
            else {
                System.out.print(players.get(player).name + ", please submit your bid: ");
            }
            int playerBid = input.nextInt();
            totalBids += playerBid;
            bids.add(playerBid);
        }

        return bids;
    }


}
