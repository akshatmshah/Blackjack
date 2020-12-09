public class Card {
    
    private int value;
    private String suit;
    private String cardFace;
    
    public Card(String suit, String cardFace, int value) {
        this.suit = suit;
        this.cardFace = cardFace;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public String getcardFace() {
        return cardFace;
    }
    
    public String toString() { 
        return (getcardFace()+ " " + getSuit()+ " " + getValue() + ", " );
    }
    
    
}
