package com.poker.api.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    
    @Test(expected = IllegalArgumentException.class) public void testContructorSuitNull() {
        System.out.println("card(SuitNull)");
        Card.Suit expSuit = null;
        Card.Rank expRank = Card.Rank.TWO;
        Card instance = new Card(expSuit, expRank);
    }
    @Test(expected = IllegalArgumentException.class) public void testContructorRankNull() {
        System.out.println("card(RankNull)");
        Card.Suit expSuit = Card.Suit.CLUB;
        Card.Rank expRank = null;
        Card instance = new Card(expSuit, expRank);
    }
}
