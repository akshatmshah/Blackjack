import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


/** 
 *  You can use this file (and others) to test your
 *  implementation.
 */

public class GameTest {

    @Test
    public void normalConditions() {
        Xhand player1 = new Xhand();
        Xhand dealer = new Xhand();
        Deck deck = new Deck(1);

        BlackJack bj = new  BlackJack("", player1, dealer);
        
        player1.addSpecificCard(deck, 0);
        player1.addSpecificCard(deck, 32);
        
        dealer.addSpecificCard(deck, 30);
        dealer.addSpecificCard(deck, 36);
        
        assertEquals(10, player1.getVal());
        assertFalse(deck.equals(new Deck(1)));
                
        assertTrue(bj.winCheck().get(0).equals("You Win"));
        
        deck.deckReset();
        
        assertEquals(52, deck.deckSize());
        
        player1.setVal(0);
        dealer.setVal(0);

        player1.addSpecificCard(deck, 0);
        player1.addSpecificCard(deck, 34);
        
        dealer.addSpecificCard(deck, 1);
        dealer.addSpecificCard(deck, 36);
        
        assertEquals(11, player1.getVal());
        assertEquals(11, dealer.getVal());
        
        assertEquals(dealer.getVal(), player1.getVal());
        
        assertEquals("Push", bj.winCheck().get(0));
        
        deck.deckReset();
        
        assertEquals(52, deck.deckSize());
        
        player1.setVal(0);
        dealer.setVal(0);

        player1.addSpecificCard(deck, 32);
        player1.addSpecificCard(deck, 33);
        
        dealer.addSpecificCard(deck, 48);
        dealer.addSpecificCard(deck, 40);
        
        assertEquals(20, player1.getVal());
        assertEquals(11, dealer.getVal());
        
        assertEquals("You Lose", bj.winCheck().get(0));
    }
    

}
