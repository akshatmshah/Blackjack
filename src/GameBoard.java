/**
 * CIS 120 HW09 - TicTacToe Demo
 * (c) University of Pennsylvania
 * Created by Bayley Tuch, Sabrina Green, and Nicolas Corona in Fall 2020.
 */

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * This class instantiates a TicTacToe object, which is the model for the game.
 * As the user clicks the game board, the model is updated.  Whenever the model
 * is updated, the game board repaints itself and updates its status JLabel to
 * reflect the current state of the model.
 * 
 * This game adheres to a Model-View-Controller design framework.  This
 * framework is very effective for turn-based games.  We STRONGLY 
 * recommend you review these lecture slides, starting at slide 8,
 * for more details on Model-View-Controller:  
 * https://www.seas.upenn.edu/~cis120/current/files/slides/lec37.pdf
 * 
 * In a Model-View-Controller framework, GameBoard stores the model as a field
 * and acts as both the controller (with a MouseListener) and the view (with 
 * its paintComponent method and the status JLabel).
 */
@SuppressWarnings("serial")
public class GameBoard extends JPanel {

    private BlackJack bj; // model for the game
    private JLabel status; // current status text
    private Xhand name;
    private Xhand dealer;
    private int counter;
    private String username;

    // Game constants
    public static final int BOARD_WIDTH = 1200;
    public static final int BOARD_HEIGHT = 600;

    /**
     * Initializes the game board.
     */
    public GameBoard(JLabel statusInit) {
        
        username = JOptionPane.showInputDialog("Enter your username!");
        if (username.equals("")) {
            username = "Guest";
        }
        System.out.println(username);
        
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Enable keyboard focus on the court area.
        // When this component has the keyboard focus, key events are handled by its key listener.
        setFocusable(true);
        
        name = new Xhand(50, 250);
        dealer = new Xhand(750, 250);
        counter = 0;
        
        bj = new BlackJack(name, dealer); // initializes model for the game
        status = statusInit; // initializes the status JLabel

        /*
         * Listens for mouseclicks.  Updates the model, then updates the game board
         * based off of the updated model.
         */
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                updateStatus(); // updates the status JLabel
                repaint(); // repaints the game board
            }
        });
        
        
    }
        
    




    /**
     * (Re-)sets the game to its initial state.
     */
    public void start() {
        return;
    }

    
    public void hit() {
        if (counter == 1) {
            bj.hit(name);
        }
        repaint();
    }
    
    public void stand() {
        if (counter == 1) {
            counter = 0;
            bj.newHandDealer(dealer);
            status.setText(bj.winCheck());
        }   
        repaint();
    }
    
    public void deal() {
        status.setText("");
        counter++;
        if (counter == 1) {
            bj.deal();
        }
        repaint();

        // Makes sure this component has keyboard/mouse focus
        requestFocusInWindow();
    }

//    /**
//     * Updates the JLabel to reflect the current state of the game.
//     */
//    private void updateStatus() {
//        status.setText("test");
//        counter = 0;
//    }

    /**
     * Draws the game board.
     * 
     * There are many ways to draw a game board.  This approach
     * will not be sufficient for most games, because it is not 
     * modular.  All of the logic for drawing the game board is
     * in this method, and it does not take advantage of helper 
     * methods.  Consider breaking up your paintComponent logic
     * into multiple methods or classes, like Mushroom of Doom.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draws board grid
        g.drawLine(600, 0, 600, 1400);
        
        g.drawString(username, 50, 50);
        
        g.drawString("Dealer", 650, 50);
        
        
        
        name.draw(g);
        
        dealer.draw(g);
    }

    /**
     * Returns the size of the game board.
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
    }

   
}