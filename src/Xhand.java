import java.awt.Graphics;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Xhand {
    
    private List<Card> hand; //Ordered; Dealer has second card hidden.
    private int val;
    private int x;
    private int y;
    private boolean isAce;
    
    //Constructor testing
    public Xhand() {
        hand = new LinkedList<>();
        this.x = 0;
        this.y = 0;
        isAce = false;
        System.out.println("NEW HAND");
    }
    
    //Constructor GUI for pos
    public Xhand(int x, int y) {
        hand = new LinkedList<>();
        this.x = x;
        this.y = y;
        System.out.println("NEW HAND");
    }
    
    //Add card to foo hand
    public List<Card> addCard(Deck deck) {
       Card card = deck.getRandomCard();
       if (card.getValue() == 1) { //checking if the new card is an ace since its val's can change
           isAce = true;
       }
       setVal(val + card.getValue()); //changing val of hand (increasing)
       System.out.println("ADD CARD: " + card.toString() + " NEW VAL:  " + val 
               + " with Card Value: " + card.getValue());
       hand.add(card); //adding it to the hand
       return new LinkedList<>(hand);
    }
    
    //For testing specific cards
    public List<Card> addSpecificCard(Deck deck, int pos) {
        Card card = deck.getCard(pos);
        if (card.getValue() == 1) {  //check if new card = ace
            isAce = true;
        }
        setVal(val + card.getValue());
        System.out.println("ADD CARD: " + card.toString() + " " + val 
                + " Card Value: " + card.getValue());
        hand.add(card);
        return new LinkedList<>(hand);
     }

    //return val of hand
    public int getVal() {
        return val;
    }

    //change val of hand (new round, new cards, etc)
    public void setVal(int val) {
        System.out.println("HAND VAL UPDATED : " + val);
        this.val = val;
    }
    
    //returns if ace amongst cards -- only care if 1 exists.
    public boolean checkAce() {
        return isAce;
    }
    
    //new deal -> new hand 
    public void clearHand() {
        hand.clear();
        isAce = false;
    }
    
    public Card getCard(int pos) { //present only certain cards in hand.
        return hand.get(pos);
    }
    
    public String toString() {
        return (Arrays.toString(hand.toArray()));
    }
    
    public void draw(Graphics g) { //drawing hands in relative pos.
            g.drawString(toString(), x, y);
        
    }
    
}
