/**
 * CIS 120 HW09 - TicTacToe Demo
 * (c) University of Pennsylvania
 * Created by Bayley Tuch, Sabrina Green, and Nicolas Corona in Fall 2020.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class sets up the top-level frame and widgets for the GUI.
 * 
 * This game adheres to a Model-View-Controller design framework.  This
 * framework is very effective for turn-based games.  We STRONGLY 
 * recommend you review these lecture slides, starting at slide 8, 
 * for more details on Model-View-Controller:  
 * https://www.seas.upenn.edu/~cis120/current/files/slides/lec37.pdf
 * 
 * In a Model-View-Controller framework, Game initializes the view,
 * implements a bit of controller functionality through the reset
 * button, and then instantiates a GameBoard.  The GameBoard will
 * handle the rest of the game's view and controller functionality, and
 * it will instantiate a TicTacToe object to serve as the game's model.
 */
public class Game implements Runnable {
    public void run() {
        // NOTE: the 'final' keyword denotes immutability even for local variables.

        // Top-level frame in which game components live
        final JFrame frame = new JFrame("Blackjack");
        frame.setLocation(300, 300);

        // Status panel
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.SOUTH);
        final JLabel status = new JLabel("Setting up...");
        status_panel.add(status);

        // Game board
        final GameBoard board = new GameBoard(status);
        board.setLayout(new BorderLayout());
        frame.add(board, BorderLayout.CENTER);

        // Reset button
        JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.SOUTH);
        
        JPanel playerCards = new JPanel();
        
        
        JPanel dealerCards = new JPanel();
        
        JLabel Card1 = new JLabel();
        JLabel Card2 = new JLabel();
        JLabel Card3 = new JLabel();
        JLabel Card4 = new JLabel();
        
        playerCards.add(Card1);
        playerCards.add(Card2);
        
        dealerCards.add(Card3);
        dealerCards.add(Card4);

        
        

        board.add(playerCards, BorderLayout.WEST);
        board.add(dealerCards, BorderLayout.EAST);


        // Note here that when we add an action listener to the reset button, we define it as an
        // anonymous inner class that is an instance of ActionListener with its actionPerformed()
        // method overridden. When the button is pressed, actionPerformed() will be called.
        final JButton reset = new JButton("Deal");
        final JButton hit = new JButton("Hit");
        final JButton stand = new JButton("Stand");

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                board.deal();
            }
        });
        
        hit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                board.hit();
            }
        });
        
        stand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                board.stand();
            }
        });
        control_panel.add(hit);
        control_panel.add(stand);
        control_panel.add(reset);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start the game
        board.start();
    }

    /**
     * Main method run to start and run the game. Initializes the GUI elements specified in Game and
     * runs it. IMPORTANT: Do NOT delete! You MUST include this in your final submission.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}