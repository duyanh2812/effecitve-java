package Chapter_8_GeneralProgramming;

import java.util.*;

/*
*In summary, the for-each loop provides compelling advantages over the traditional
*for loop in clarity, flexibility, and bug prevention, with no performance penalty.
*Use for-each loops in preference to for loops wherever you can.
*/
public class Item_58_PreferForEachLoopsToTraditionalForLoops {
    static class Card {
        public Card(Suit suit, Rank rank) {

        }
    }

    enum Suit {CLUB, DIAMOND, HEART, SPADE}

    enum Rank {
        ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING
    }

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    public void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : suits) {
            for (Rank rank : ranks) deck.add(new Card(suit, rank));
        }
    }
}
