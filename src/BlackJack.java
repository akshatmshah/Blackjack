
/**
 * CIS 120 HW09 - TicTacToe Demo
 * (c) University of Pennsylvania
 * Created by Bayley Tuch, Sabrina Green, and Nicolas Corona in Fall 2020.
 */

/**
 * This class is a model for TicTacToe.  
 * 
 * This game adheres to a Model-View-Controller design framework.
 * This framework is very effective for turn-based games.  We
 * STRONGLY recommend you review these lecture slides, starting at
 * slide 8, for more details on Model-View-Controller:  
 * https://www.seas.upenn.edu/~cis120/current/files/slides/lec37.pdf
 * a
 * This model is completely independent of the view and controller.
 * This is in keeping with the concept of modularity! We can play
 * the whole game from start to finish without ever drawing anything
 * on a screen or instantiating a Java Swing object.
 * 
 * Run this file to see the main method play a game of TicTacToe,
 * visualized with Strings printed to the console.
 */
public class BlackJack {
    private Xhand player;
    private Xhand dealer;
    private Deck deck;
    /**
     * Constructor sets up game state.
     */
    
    public BlackJack(Xhand player, Xhand dealer) {
        this.player = player;
        this.dealer = dealer;
        deck = new Deck(1);
    }
    
    public void deal() {
        System.out.println("----------------------");
        player.setVal(0);
        dealer.setVal(0);
        for(int i = 0; i < 2; i ++) { 
            player.addCard(deck);
            dealer.addCard(deck);
        }
    }
    
    public void hit(Xhand person) {
        System.out.print("player: ");
        person.addCard(deck);
        checkBust(person);
    }
    
    public void checkBust(Xhand person) {
            if(person.getVal() > 21) {
                winCheck();
            }
    }
    
    public boolean isAce(Xhand person) {
        return (person.checkAce());
    }
    
    public void newHandDealer(Xhand dealer) {
        System.out.println("NEW VAL: " + player.getVal());
        System.out.print("dealer:  ");
        while (dealer.getVal() < 17) {
            System.out.print(dealer.getVal());
            dealer.addCard(deck);
        }
        System.out.print(dealer.getVal());
    }
    
//    public String blackjackCheck(Xhand person) {
//        if (person.getVal() == 21) {
//            return (person + "Blackjack");
//        }
//        return "";
//    }
    
    public String toString(Xhand person) {
        return person.toString();
    }
    
    
    public String winCheck() {
        deck.deckReset();
        int scoreP = player.getVal();
        int scoreD = dealer.getVal();
        
//        System.out.println("Player Score " + scoreP);
//        System.out.println("Dealer Score " + scoreD);

        
        if (scoreP > 21) {
            return "You Lose";
        }
        
        if (scoreD > 21) {
            return "You Win";
        }
        
        if (scoreP > scoreD) {
            return "You Win";
        }else if(scoreP < scoreD) {
            return "You Lose";
        }else {
            return "Push";
        }        
    }

    
//    public static void main(String[] args) {
//        BlackJack t = new BlackJack();
//
//        
//    }
}
