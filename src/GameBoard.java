
/**
 * CIS 120 HW09 - TicTacToe Demo
 * (c) University of Pennsylvania
 * Created by Bayley Tuch, Sabrina Green, and Nicolas Corona in Fall 2020.
 */

import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;

/**
 * This class instantiates a TicTacToe object, which is the model for the game.
 * As the user clicks the game board, the model is updated. Whenever the model
 * is updated, the game board repaints itself and updates its status JLabel to
 * reflect the current state of the model.
 * 
 * This game adheres to a Model-View-Controller design framework. This framework
 * is very effective for turn-based games. We STRONGLY recommend you review
 * these lecture slides, starting at slide 8, for more details on
 * Model-View-Controller:
 * https://www.seas.upenn.edu/~cis120/current/files/slides/lec37.pdf
 * 
 * In a Model-View-Controller framework, GameBoard stores the model as a field
 * and acts as both the controller (with a MouseListener) and the view (with its
 * paintComponent method and the status JLabel).
 */
@SuppressWarnings("serial")
public class GameBoard extends JPanel {

    private BlackJack bj; // model for the game
    private JLabel status; // current status text
    private JLabel score;
    private Xhand name;
    private Xhand dealer;
    private int counter;
    private int drawCounter;
    private String username;

    public static final int BOARD_WIDTH = 1200;
    public static final int BOARD_HEIGHT = 600;

    /**
     * Initializes the game board.
     */
    public GameBoard(JLabel statusInit, JLabel scoreInit) {
        JOptionPane.showMessageDialog(null,
                "Welcome to Blackjack" + System.lineSeparator()
                + "You want to beat the dealer's hand without going over 21. "
                + "\nAll you know"
                + " about the dealers hand is the first card (top left corner of game)."
                + " \nYou"
                + " will see your cards on the left side of the screen. "
                + "\nAces can be either"
                + " 1 or 11's, numerical cards are their numerical values, and face cards"
                + " are worth 10. To begin the game you need to deal the cards. "
                + "\nIf you want"
                + " another card and take a risk to get closer to 21 in hopes"
                + " of beating the"
                + " dealer then you can press hit, otherwise you should stand. \nOnce your"
                + " turn is over your score will be saved with your username, and you will"
                + " see in the top left corner if you have won or lost."
                + " If you go over" + "21 you lose!");

        // username can be anything -> NOT case sensitive
        // if empty, then play under guest w/l.
        username = JOptionPane.showInputDialog("Enter your username!");
        if (username.equals("")) {
            username = "Guest";
        }
        System.out.println(username);

        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Enable keyboard focus on the court area.
        // When this component has the keyboard focus, key events are handled by its key
        // listener.
        setFocusable(true);

        // intialize players
        name = new Xhand(0, 250); // new hands with x, y coords
        dealer = new Xhand(600, 250);
        counter = 0; // to make sure can only hit and stand after dealing
        drawCounter = 0; // to help show dealers hand after standing.
        bj = new BlackJack(username, name, dealer); // initializes model for the game
        status = statusInit; // initializes the status JLabel
        score = scoreInit;
    }

    /**
     * (Re-)sets the game to its initial state.
     */
    public void start() { // loading scores
        score.setText("Score: " + bj.getScores().get(0) + " Wins " 
                + bj.getScores().get(1) + " Losses");
    }

    public void hit() {
        if (counter == 1) { // only hit if dealed
            bj.hit(name);
            if (bj.checkBust(name)) { // checking if they bust after each turn
                stand();
            }
            repaint();
        }
    }

    public void stand() {
        if (counter == 1) { // same as hit
            counter = 0;
            drawCounter++; // dealer hand completely revealed
            bj.newHandDealer(dealer); // hits aslong as <= 16 (keeping ace in mind)
            LinkedList<String> winAns = (LinkedList<String>) bj.winCheck(); // returns both labels
            status.setText(winAns.get(0));
            score.setText(winAns.getLast());
            bj.updateFile(username.toUpperCase()); // updating the file with new score
            repaint();
        }

    }

    public void deal() {
        counter++; // hit and stand can now be used
        if (counter == 1) {
            bj.deal();
            status.setText("The dealer has a " + dealer.getCard(0).toString());
            if ((name.getVal() == 11 && name.checkAce()) || (dealer.getVal() == 11 
                    && dealer.checkAce())) { //check players start with blackjack

                stand();
            }
        }
        repaint();

        // Makes sure this component has keyboard/mouse focus
        requestFocusInWindow();
    }

    /**
     * Draws the game board.
     * 
     * There are many ways to draw a game board. This approach will not be
     * sufficient for most games, because it is not modular. All of the logic for
     * drawing the game board is in this method, and it does not take advantage of
     * helper methods. Consider breaking up your paintComponent logic into multiple
     * methods or classes, like Mushroom of Doom.
     */
    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);

        // Draws board grid
        g.drawLine(600, 0, 600, 1400); // middle line

        g.drawString(username, 50, 50); // user label

        g.drawString("Dealer", 650, 50); // deal label

        name.draw(g); // users cards
        if (drawCounter == 1) {
            dealer.draw(g); // rest of dealers card revealed after stand
            drawCounter = 0;
        }

    }

    /**
     * Returns the size of the game board.
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
    }

}