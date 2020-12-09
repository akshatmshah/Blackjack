import java.util.LinkedList;
import java.util.List;


public class Xhand {
    
    private List<Card> hand;
    private int val;
    
    
    public Xhand() {
        hand = new LinkedList<>();
        System.out.println("NEW HAND");
    }
    //val isn't being set correctly
    public List<Card> addCard(Deck deck) {
       Card card = deck.getRandomCard();
       setVal(val + card.getValue());
       System.out.println("ADD CARD: " + card.toString() + " " + val + " Card Value: " + card.getValue());
       hand.add(card);
       return hand;
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
    
}
