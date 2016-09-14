package com.poker.api.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void insert(Set<Card> cards, Card card) {
        if (!cards.contains(card)) {
            LOGGER.debug("insertamos la carta: {}", card);
            cards.add(card);
        } else {
            LOGGER.debug("la carta: {} ya estaba en el conjunto", card);
        } 
    }
    
    public static void main(String[] args) {
        Set<Card> cards = new HashSet<>();
        Card[] cards2Insert = {new Card(Card.Suit.CLUB, Card.Rank.ACE), 
                new Card(Card.Suit.CLUB, Card.Rank.TWO),
                new Card(Card.Suit.CLUB, Card.Rank.TRHEE),
                new Card(Card.Suit.CLUB, Card.Rank.ACE)
        };
        for (Card card : cards2Insert) {
            insert(cards, card);
        }
    }
}
