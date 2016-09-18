package com.poker.api.core;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

public class CardTest {

    @Test
    public void testConstructor() {
        System.out.println("card()");
        Card.Suit expSuit = Card.Suit.CLUB;
        Card.Rank expRank = Card.Rank.TWO;
        Card instance = new Card(expSuit, expRank);
        Card.Suit suitResult = instance.getSuit();
        assertEquals(expSuit, suitResult);
        Card.Rank rankResult = instance.getRank();
        assertEquals(expRank, rankResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContructorSuitNull() {
        System.out.println("card(SuitNull)");
        Card.Suit expSuit = null;
        Card.Rank expRank = Card.Rank.TWO;
        Card instance = new Card(expSuit, expRank);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContructorRankNull() {
        System.out.println("card(RankNull)");
        Card.Suit expSuit = Card.Suit.CLUB;
        Card.Rank expRank = null;
        Card instance = new Card(expSuit, expRank);
    }

    private static Card[] getAllCards() {
        Card[] result = new Card[Card.Suit.values().length * Card.Rank.values().length];
        int i = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card c = new Card(suit, rank);
                result[i] = c;
                i++;
            }
        }
        return result;
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Card[] allCards = getAllCards();
        Set<Integer> hashCodes = new HashSet<>(allCards.length);
        for (Card card : allCards) {
            assertThat(hashCodes, not(hasItem(card.hashCode())));
        }
    }

    @Test
    public void testEqualsOtherObjects() {
        System.out.println("equalsOtherObjects");
        Card card = new Card(Card.Suit.CLUB, Card.Rank.ACE);
        assertNotEquals("card: " + card + " != null", card, null); 
        assertNotEquals("card: " + card + " != 0", card, 0); 
        assertNotEquals("card: " + card + " != \"2C\"", card, "2C");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        int i = 0;
        for (Card card0 : getAllCards()) {
            int j = 0;
            for (Card card1 : getAllCards()) {
                if (i == j) {
                    assertEquals(card0, card1);
                }
                j++;
            }
            i++;
        }
    }

    @Test
    public void testEqualsDistinct() {
        System.out.println("equals distinct");
        int i = 0;
        for (Card card0 : getAllCards()) {
            int j = 0;
            for (Card card1 : getAllCards()) {
                if (i != j) {
                    assertNotEquals(card0, card1);
                }
                j++;
            }
            i++;
        }
    }
}
