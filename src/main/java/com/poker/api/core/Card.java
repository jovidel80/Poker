package com.poker.api.core;

public final class  Card {

    private static final String STRING_RANK_CARDS = "23456789TJQKA";

    public static enum Suit {
        SPADE('♠'), HEART('♥'), DIAMOND('♦'), CLUB('♣');
        private final char c;
        private Suit(char c) {
            this.c = c;
        }
    }
    
    public static enum Rank {
        TWO, TRHEE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }
    
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        if (suit == null) {
            throw new IllegalArgumentException("suit no puede tener un valor nulo");
        }
        if (rank == null) {
            throw new IllegalArgumentException("rank no puede tener un valor nulo");
        }
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        int r = rank.ordinal();
        return STRING_RANK_CARDS.substring(r, r + 1) + suit.c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suit != card.suit) return false;
        return rank == card.rank;

    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + rank.hashCode();
        return result;
    }
}
