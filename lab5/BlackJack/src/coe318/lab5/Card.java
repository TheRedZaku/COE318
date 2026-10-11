package coe318.lab5;

public class Card implements Comparable {
  //Symbolic constants



    //list of suits
  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;
  
  //this originally had DIAMOND as 1, CLUB as 0, I switched it around
  //NVM TA SAID DON'T CHANGE IT

  public final int rank;
  public final int suit;
  public boolean upDown = false; 
  //down is false
  //up is true

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  public Card(int rank, int suit, boolean faceUp) {
    this.rank = rank;
    switch(suit) {
      case 0: 
          this.suit = CLUB;
          break;
      case 1:
          this.suit = DIAMOND;
          break;
      case 2:
          this.suit = HEART;
          break;
      case 3:
          this.suit = SPADE;
          break;
      //switch case to decide the suit based on the user's input
    }
    
    upDown = faceUp; //assume false is down, true is up
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
      return upDown;
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    this.upDown = faceUp;//FIX THIS
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return rank;
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return suit;
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    return true; //FIX THIS
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) {
    
    if (this.rank < c.getRank()) {
        return -1;
    } else if (this.rank == c.getRank() && this.suit == c.getSuit()) {
        return 0;
    } else if (this.rank == c.getRank() && this.suit != c.getSuit()) {
        if (this.suit < c.getSuit()) {
            return -1;
        } else {
            return 1;
        }
    }
    return -2; // this is if it totally breaks and doesn't give any of the expected outputs
    //FIX THIS
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
    
    for (int i = 1; i <= 13; i++) {
        if (rank != 1 && rank != 11 && rank != 12 && rank != 13) {
            if (rank == i) {
                return Integer.toString(i);
            }
        } else {
            return switch (rank) {
                case 1 -> "ACE";
                case 11 -> "JACK";
                case 12 -> "QUEEN";
                default -> "KING";
            }; //different method of organizing single line switch cases
        }
        
    }
    return null; // this is if you can somehow get something that is NONE of the above
  
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
      switch (suit) {
          case DIAMOND:
              return "Diamonds";
          case CLUB:
              return "Clubs";
          case HEART:
              return "Hearts";
          default:
              return "Spades";
      }
      
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {

      if (upDown == false) {
          return "Rank: ? || Suit: ?";
      } else {
          return "Rank: " + getRankString() + " || Suit: " + getSuitString();
      }
//FIX THIS
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}
