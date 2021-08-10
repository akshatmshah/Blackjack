import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.*;

/**
 * You can use this file (and others) to test your implementation.
 */

public class GameTest {

    @Test
    public void normalConditions() {
        Xhand player1 = new Xhand();
        Xhand dealer = new Xhand();
        Deck deck = new Deck(1);

        BlackJack bj = new BlackJack("", player1, dealer);

        player1.addSpecificCard(deck, 0); // Ace of Spade
        player1.addSpecificCard(deck, 32); // Nine of Clubs

        dealer.addSpecificCard(deck, 30); // Eight of Diamond
        dealer.addSpecificCard(deck, 36); // Ten of Diamond

        assertEquals(10, player1.getVal());
        assertFalse(deck.equals(new Deck(1)));

        assertTrue(bj.winCheck().get(0).equals("You Win")); // 20 > 18 You Win

        deck.deckReset();

        assertEquals(52, deck.deckSize());

        player1.setVal(0);
        dealer.setVal(0);
        player1.clearHand();
        dealer.clearHand();

        player1.addSpecificCard(deck, 0); // Ace of Clubs
        player1.addSpecificCard(deck, 34); // Ten of Heart

        dealer.addSpecificCard(deck, 1); // Ace of Diamond
        dealer.addSpecificCard(deck, 36); // Jack of Diamond

        assertEquals(11, player1.getVal());
        assertEquals(11, dealer.getVal());

        assertEquals(dealer.getVal(), player1.getVal());

        assertEquals("Push", bj.winCheck().get(0)); // 21 = 21 PUSH

        deck.deckReset();

        assertEquals(52, deck.deckSize());

        player1.setVal(0);
        dealer.setVal(0);
        player1.clearHand();
        dealer.clearHand();

        player1.addSpecificCard(deck, 32); // Ten of Clubs
        player1.addSpecificCard(deck, 33); // Jack of Clubs

        dealer.addSpecificCard(deck, 48); // Ace of Diamond
        dealer.addSpecificCard(deck, 40); // King of Hearts

        assertEquals(20, player1.getVal());
        assertEquals(11, dealer.getVal());

        assertEquals("You Lose", bj.winCheck().get(0));
    }

    @Test
    public void fileCheck() {
        Xhand player1 = new Xhand();
        Xhand dealer = new Xhand();
        Deck deck = new Deck(1);

        // edge case with leading and trailing ""'s
        BlackJack bj = new BlackJack("  Lydia ", player1, dealer);
        LinkedList<Integer> arr = new LinkedList<>();
        arr.add(200);
        arr.add(0);
        assertEquals(arr, bj.getScores());

        player1.addSpecificCard(deck, 0);
        player1.addSpecificCard(deck, 1); // val should be 2 until checking win, 12 after

        dealer.setVal(0);

        assertEquals(2, player1.getVal());

        assertEquals("You Win", bj.winCheck().get(0));

        assertEquals(12, player1.getVal()); // when ace >= 1

    }

    @Test
    public void fileCheckCaseSens() {
        Xhand player1 = new Xhand();
        Xhand dealer = new Xhand();
        Deck deck = new Deck(1);

        // case sensitive
        BlackJack bj = new BlackJack("LYdiA", player1, dealer);
        LinkedList<Integer> arr = new LinkedList<>();
        arr.add(200);
        arr.add(0);
        assertEquals(arr, bj.getScores());

        player1.addSpecificCard(deck, 0);
        player1.addSpecificCard(deck, 1); // val should be 2 until checking win, 12 after

        dealer.setVal(0);

        assertEquals(2, player1.getVal());

        assertEquals("You Win", bj.winCheck().get(0));

        assertEquals(12, player1.getVal());

    }

    // dealing with aces correctly test
    @Test
    public void aceCheckAndNewPlayer() {
        Xhand player1 = new Xhand();
        Xhand dealer = new Xhand();
        Deck deck = new Deck(1);

        BlackJack bj = new BlackJack("", player1, dealer);

        LinkedList<Integer> arr = new LinkedList<>();
        LinkedList<Integer> arr1 = new LinkedList<>();

        arr.add(0);
        arr.add(0);

        arr1.add(1);
        arr1.add(0);

        player1.addSpecificCard(deck, 0);
        player1.addSpecificCard(deck, 1); // val should be 2 until checking win, 11 after

        dealer.setVal(0);

        assertEquals(2, player1.getVal());

        assertEquals(arr, bj.getScores());

        List<String> win = bj.winCheck();

        assertEquals("You Win", win.get(0));

        assertEquals("Score : " + 1 + " Wins " + 0 + " Loses", win.get(1));

        assertEquals(12, player1.getVal());

        assertEquals(arr1, bj.getScores());

    }

    // stand on hard17
    @Test
    public void dealHard17() {
        Xhand player1 = new Xhand();
        Xhand dealer = new Xhand();

        BlackJack bj = new BlackJack("", player1, dealer);

        dealer.setVal(17); // hard 17
        player1.setVal(0);

        bj.newHandDealer(dealer);

        assertEquals(17, dealer.getVal());
    }

}
