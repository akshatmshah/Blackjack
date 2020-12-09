import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck{
    
    private List<Card> deck;
    private List<Card> removedDeck;
    int counter = 0;
    
    public Deck(int num) {
        deck = new ArrayList<>();
        removedDeck = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            DeckGen();
        }
//        System.out.println(Arrays.toString(deck.toArray()));
    }
    
    
    
    public void DeckGen() {
        Card aceSpade = new Card("Spade", "Ace", 11);
        Card aceClubs = new Card("Clubs", "Ace", 11);
        Card aceHeart = new Card("Heart", "Ace", 11);
        Card aceDiamond = new Card("Diamond", "Ace", 11);
        
        deck.add(aceSpade);
        deck.add(aceClubs);
        deck.add(aceHeart);
        deck.add(aceDiamond);
        
        Card twoSpade = new Card("Spade", "Two", 2);
        Card twoClubs = new Card("Clubs", "Two", 2);
        Card twoHeart = new Card("Heart", "Two", 2);
        Card twoDiamond = new Card("Diamond", "Two", 2);
        
        deck.add(twoSpade);
        deck.add(twoClubs);
        deck.add(twoHeart);
        deck.add(twoDiamond);
        
        Card threeSpade = new Card("Spade", "Three", 3);
        Card threeClubs = new Card("Clubs", "Three", 3);
        Card threeHeart = new Card("Heart", "Three", 3);
        Card threeDiamond = new Card("Diamond", "Three", 3);
        
        deck.add(threeSpade);
        deck.add(threeClubs);
        deck.add(threeHeart);
        deck.add(threeDiamond);
        
        Card fourSpade = new Card("Spade", "Four", 4);
        Card fourClubs = new Card("Clubs", "Four", 4);
        Card fourHeart = new Card("Heart", "Four", 4);
        Card fourDiamond = new Card("Diamond", "Four", 4);
        
        deck.add(fourSpade);
        deck.add(fourClubs);
        deck.add(fourHeart);
        deck.add(fourDiamond);
        
        Card fiveSpade = new Card("Spade", "Five", 5);
        Card fiveClubs = new Card("Clubs", "Five", 5);
        Card fiveHeart = new Card("Heart", "Five", 5);
        Card fiveDiamond = new Card("Diamond", "Five", 5);
        
        deck.add(fiveSpade);
        deck.add(fiveClubs);
        deck.add(fiveHeart);
        deck.add(fiveDiamond);
        
        Card sixSpade = new Card("Spade", "Six", 6);
        Card sixClubs = new Card("Clubs", "Six", 6);
        Card sixHeart = new Card("Heart", "Six", 6);
        Card sixDiamond = new Card("Diamond", "Six", 6);
        
        deck.add(sixSpade);
        deck.add(sixClubs);
        deck.add(sixHeart);
        deck.add(sixDiamond);
        
        Card sevenSpade = new Card("Spade", "Seven", 7);
        Card sevenClubs = new Card("Clubs", "Seven", 7);
        Card sevenHeart = new Card("Heart", "Seven", 7);
        Card sevenDiamond = new Card("Diamond", "Seven", 7);
        
        deck.add(sevenSpade);
        deck.add(sevenClubs);
        deck.add(sevenHeart);
        deck.add(sevenDiamond);
        
        Card eightSpade = new Card("Spade", "Eight", 8);
        Card eightClubs = new Card("Clubs", "Eight", 8);
        Card eightHeart = new Card("Heart", "Eight", 8);
        Card eightDiamond = new Card("Diamond", "Eight", 8);
        
        deck.add(eightSpade);
        deck.add(eightClubs);
        deck.add(eightHeart);
        deck.add(eightDiamond);
        
        Card nineSpade = new Card("Spade", "Nine", 9);
        Card nineClubs = new Card("Clubs", "Nine", 9);
        Card nineHeart = new Card("Heart", "Nine", 9);
        Card nineDiamond = new Card("Diamond", "Nine", 9);
        
        deck.add(nineSpade);
        deck.add(nineClubs);
        deck.add(nineHeart);
        deck.add(nineDiamond);
        
        Card tenSpade = new Card("Spade", "Ten", 10);
        Card tenClubs = new Card("Clubs", "Ten", 10);
        Card tenHeart = new Card("Heart", "Ten", 10);
        Card tenDiamond = new Card("Diamond", "Ten", 10);
        
        deck.add(tenSpade);
        deck.add(tenClubs);
        deck.add(tenHeart);
        deck.add(tenDiamond);
        
        Card jackSpade = new Card("Spade", "jack", 10);
        Card jackClubs = new Card("Clubs", "jack", 10);
        Card jackHeart = new Card("Heart", "jack", 10);
        Card jackDiamond = new Card("Diamond", "jack", 10);
        
        deck.add(jackSpade);
        deck.add(jackClubs);
        deck.add(jackHeart);
        deck.add(jackDiamond);
        
        Card queenSpade = new Card("Spade", "Queen", 10);
        Card queenClubs = new Card("Clubs", "Queen", 10);
        Card queenHeart = new Card("Heart", "Queen", 10);
        Card queenDiamond = new Card("Diamond", "Queen", 10);
        
        deck.add(queenSpade);
        deck.add(queenClubs);
        deck.add(queenHeart);
        deck.add(queenDiamond);
        
        Card kingSpade = new Card("Spade", "Queen", 10);
        Card kingClubs = new Card("Clubs", "Queen", 10);
        Card kingHeart = new Card("Heart", "Queen", 10);
        Card kingDiamond = new Card("Diamond", "Queen", 10);
        
        deck.add(kingSpade);
        deck.add(kingClubs);
        deck.add(kingHeart);
        deck.add(kingDiamond);  
         
    }
   
    //how to make sure previously selected card isn't selected if it isn't in the deck.
    public Card getRandomCard() {
        Collections.shuffle(deck);
        
        Card newCard = deck.get(0);
        
        System.out.print(newCard.toString());
        
        removedDeck.add(newCard);
        deck.remove(newCard);
        
        return newCard;
        
    }
    
   public void deckReset() {
       deck.addAll(removedDeck);
       removedDeck.clear();
   }
   
   
    
}
