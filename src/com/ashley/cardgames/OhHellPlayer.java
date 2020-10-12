package com.ashley.cardgames;

public class OhHellPlayer extends Player implements Comparable<OhHellPlayer> {

    private int currentBid;
    private int numTricksWon;
    private Card lastPlayedCard;
    private int score;

    public OhHellPlayer(String name) {
        super(name);
    }

    public int compareTo(OhHellPlayer other) {
        return Integer.compare(score, other.score);
    }

    public void setBid(int bid) {
        currentBid = bid;
    }

    public Card playCard(int cardIndex) {
        lastPlayedCard = hand.remove(cardIndex);
        return lastPlayedCard;
    }

    public Card getLastPlayedCard() {
        return lastPlayedCard;
    }

    public void resetTricks() {
        numTricksWon = 0;
    }

    public void incrementTricks() {
        numTricksWon++;
    }

    public int getBid() {
        return currentBid;
    }

    public int getTricks() {
        return numTricksWon;
    }

    public void increaseScore(int scoreForRound) {
        score += scoreForRound;
    }

    public String displayHandForPlayerTurn(boolean isFirstPlayer, boolean isTrumpBroken, String trumpSuit, String leadSuit) {
        StringBuilder cardList = new StringBuilder();
        boolean containsLeadSuit = hand.stream().anyMatch(card -> card.suit.equals(leadSuit));
        boolean handAllTrump = hand.stream().allMatch(card -> card.suit.equals(trumpSuit));

        for (int index = 0; index < hand.size(); index++) {
            if (isFirstPlayer && !isTrumpBroken && hand.get(index).suit.equals(trumpSuit) && !handAllTrump) {
                continue;
            }

            if (!isFirstPlayer && containsLeadSuit && !hand.get(index).suit.equals(leadSuit)) {
                continue;
            }

            cardList.append(index).append(": ").append(hand.get(index)).append(System.lineSeparator());
        }


        return cardList.toString();
    }
}
