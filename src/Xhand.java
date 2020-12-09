import java.awt.Graphics;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Xhand {
    
    private List<Card> hand;
    private int val;
    private int x;
    private int y;
    
    
    public Xhand(int x, int y) {
        hand = new LinkedList<>();
        this.x = x;
        this.y = y;
        System.out.println("NEW HAND");
    }
    
    //val isn't being set correctly
    public List<Card> addCard(Deck deck) {
       Card card = deck.getRandomCard();
       setVal(val + card.getValue());
       System.out.println("ADD CARD: " + card.toString() + " " + val 
               + " Card Value: " + card.getValue());
       hand.add(card);
       return new LinkedList<>(hand);
    }

    public int getVal() {
        if (checkAce() && val > 21) {
            val -= 10;
        }
        return val;
    }

    public void setVal(int val) {
        System.out.println("HAND VAL: " + val);
        this.val = val;
        
        
    }
    
    public boolean checkAce() {
        for(Card card: hand) {
            if (card.getValue() == 11) {
                return true;
            }
        }
        return false;
    }
    
    public void clearHand() {
        hand.clear();
    }
    
    public List<String> toList() {
        LinkedList<String> arr = new LinkedList<>();
        for (Card c: hand) {
        arr.add(c.getcardFace() + " " + c.getSuit());
        }
        return arr;
     }
    
    public String toString() {
        return (Arrays.toString(hand.toArray()));
    }
    
    public void draw(Graphics g) {
            g.drawString(toString(), x, y);
        
    }
    
}
