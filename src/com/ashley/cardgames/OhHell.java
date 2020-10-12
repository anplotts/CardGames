package com.ashley.cardgames;

import java.util.*;

public class OhHell {
    List<OhHellPlayer> players;
    Deck deck;

    // Takes player input and creates a new deck for the game
    public OhHell(List<OhHellPlayer> players) {
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

    // Order of deal doesn't matter, sorts each player's hands after dealing cards - clubs, diamonds, spades, hearts
    public void deal(int numCards) {
        for (int i = 0; i < numCards; i++) {
            for (Player player : players) {
                player.giveCard(deck.drawCard());
            }
        }

        for (Player player : players) {
            player.sortHand();
        }

    }

    // Asks players for bids and adds each bid to an array - index corresponds with player number
    public void setBidsForRound(int numCardsForRound, int firstBidder) {
        Scanner input = new Scanner(System.in);
        int totalBids = 0;

        for (int index = 0; index < players.size(); index++) {
            OhHellPlayer currentPlayer = players.get((index + firstBidder) % players.size());
            System.out.println(currentPlayer.getHandAsString());

            if (index == players.size() - 1 && totalBids <= numCardsForRound ) {
                int bidAmountNotAllowed = numCardsForRound - totalBids;
                System.out.print(currentPlayer.getName() + ", please submit a bid that is NOT " + bidAmountNotAllowed + ": ");
            }
            else {
                System.out.print(currentPlayer.getName() + ", please submit your bid: ");
            }
            int playerBid = input.nextInt();
            totalBids += playerBid;
            currentPlayer.setBid(playerBid);
        }
    }

    public OhHellPlayer determineWinnerOfHand(String trumpSuit, String leadCardSuit) {
        var playersCopy = new ArrayList<>(players);
        playersCopy.sort(new OhHellHandWinner(trumpSuit, leadCardSuit));

        return playersCopy.get(playersCopy.size() - 1);
    }

    // game play, need to limit what card can be played in each hand
    public void playGame() {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int firstBidder = rand.nextInt(players.size());

        for (int round = 1; round < 20; round++) {
            int numCardsForRound = round < 11 ? 11 - round : round - 9; // Starts by dealing 10, down to 1, then back to 10

            for (OhHellPlayer player : players) {
                player.resetTricks();
            }

            deck.shuffle();
            deal(numCardsForRound);
            String leadSuit = "";
            Card trumpCard = deck.drawCard();
            System.out.println("Trump is " + trumpCard.suit);
            boolean isTrumpBroken = false;

            setBidsForRound(numCardsForRound, firstBidder);

            int startingIndex = firstBidder;


            for (int hand = 0; hand < numCardsForRound; hand++) {
                for (int index = 0; index < players.size(); index++) {
                    OhHellPlayer currentPlayer = players.get((index + startingIndex) % players.size());
                    System.out.println(currentPlayer.getName() + ", please enter the index of the card you wish to play.");
                    System.out.println(currentPlayer.displayHandForPlayerTurn(index == 0, isTrumpBroken, trumpCard.suit, leadSuit));
                    Card playedCard = currentPlayer.playCard(input.nextInt());

                    if (playedCard.suit.equals(trumpCard.suit)) {
                        isTrumpBroken = true;
                    }

                    if (index == 0) {
                        leadSuit = playedCard.suit;
                    }
                }

                OhHellPlayer winnerOfHand = determineWinnerOfHand(trumpCard.suit, leadSuit);
                winnerOfHand.incrementTricks();
                startingIndex = players.indexOf(winnerOfHand);
            }

            firstBidder++;

            for (OhHellPlayer player : players) {
                if (player.getBid() == player.getTricks()) {
                    player.increaseScore((10 +player.getTricks()));
                }
            }
        }

        var playersCopy = new ArrayList<>(players);
        Collections.sort(playersCopy);
        Player winner = playersCopy.get(players.size() - 1);
        System.out.println("Winner is " + winner);
    }




}
