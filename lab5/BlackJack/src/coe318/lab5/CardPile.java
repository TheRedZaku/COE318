package coe318.lab5;
/**
 *
 * @Kevin L
 */

import java.util.ArrayList;


/**
 * A pile of cards.
 *
 */
public class CardPile{
    //Instance variables
    private ArrayList<Card> cards;

    public CardPile() {
        cards = new ArrayList<Card>();
        //Initialize the instance variable.
    }
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card card) {
        cards.add(card);
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() {
        
        //int randomCard = (int) (Math.random() * cards.size() - 1);
        return cards.remove((int) (Math.random() * cards.size())); //Math.random gives a random double from 0 (inc) to 1 (exc)
        //multiplying by cards.size gives you a double that gets truncated to match
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
        //FIX THIS
        String list = new String();
        for (int i = 0; i < cards.size(); i++) {
            list += cards.get(i);
        }
        return list + "\n"; //this \n just makes the spacing a little neater
    }
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true)); //2 of diamonds
        p.add(new Card(3, 2, true)); //3 of hearts
        p.add(new Card(4, 3, false));//4 of spades
        p.add(new Card(14, 1, true));//ace of diamonds
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());

        }
    }


}