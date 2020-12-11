public class Card {

    private int value;
    private String suit;
    private String cardFace;

    // card constructor
    public Card(String suit, String cardFace, int value) {
        this.suit = suit;
        this.cardFace = cardFace;
        this.value = value;
    }

    // eg 1, 5, 9, 10, etc
    public int getValue() {
        return value;
    }

    // eg Clubs, Hearts, etc.
    public String getSuit() {
        return suit;
    }

    // eg Ace, King, etc.
    public String getcardFace() {
        return cardFace;
    }

    public String toString() {
        return (getcardFace() + " of " + getSuit());
    }

}
