import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class BlackJack {
    private Xhand player;
    private Xhand dealer;
    private Deck deck;
    private int win; // track w/l ratio
    private int lost;

    /**
     * Constructor sets up game state.
     */

    public BlackJack(String name, Xhand player, Xhand dealer) {
        win = 0;
        lost = 0;

        name = name.trim();
        if (!checkPlayer(name.toUpperCase())) { // checking if player already has a saved score
            newPlayer(name.toUpperCase());
        }
        this.player = player;
        this.dealer = dealer;
        deck = new Deck(1); // Only one deck used
    }

    public boolean checkPlayer(String name) {
        String line;

        try {
            File myFile = new File("./files/highscores.txt");
            myFile.createNewFile();
            BufferedReader bufferReader = new BufferedReader(
                    new FileReader("./files/highscores.txt"));
            while ((line = bufferReader.readLine()) != null) { // player has score -> load w/l
                String[] arr = line.split(" ");
                if (arr[0].equals(name)) {
                    win = Integer.parseInt(arr[1]);
                    lost = Integer.parseInt(arr[2]);
                    bufferReader.close();
                    return true;
                }
            }
            bufferReader.close();
            return false; // new player needs to be created + added to scores file.
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Integer> getScores() { // help display updated scores to GUI
        LinkedList<Integer> scores = new LinkedList<>();

        scores.add(win);
        scores.add(lost);

        return new LinkedList<Integer>(scores);
    }

    public void deal() { // new round -> deal
        System.out.println("----------------------");
        player.setVal(0);
        dealer.setVal(0);
        player.clearHand();
        dealer.clearHand();
        for (int i = 0; i < 2; i++) {
            player.addCard(deck);
            dealer.addCard(deck);
        }
        
    }

    public void hit(Xhand person) {
        System.out.print("player: ");
        person.addCard(deck);
    }

    public boolean checkBust(Xhand person) {
        if (person.getVal() > 21) { // to check if they busted after each hit
            return true;
        }
        return false;
    }

    public void newHandDealer(Xhand dealer) { // dealer always hits on <= 16
        while (dealer.getVal() < 17) {
            if (dealer.checkAce() && dealer.getVal() + 10 == 21) { // ace being used as 11
                break;
            }
            dealer.addCard(deck);
        }
        System.out.println("PLAYER SCORE: " + player.getVal());
        System.out.println("DEALER SCORE:  " + dealer.getVal());
    }

    public int getDealerHand() {
        return dealer.handSize();
    }

    public List<String> winCheck() {

        List<String> data = new LinkedList<>();
        String returnString = null;

        deck.deckReset(); // add cards back in

        // checking if one ace should be used as 11 or 1
        if (player.getVal() + 10 <= 21 && player.checkAce()) {
            player.setVal(player.getVal() + 10);
        }

        if (dealer.getVal() + 10 <= 21 && dealer.checkAce()) {
            dealer.setVal(dealer.getVal() + 10);
        }

        int scoreP = player.getVal();
        int scoreD = dealer.getVal();

        System.out.println(scoreP + " " + scoreD);

        // eval final scores
        if (scoreP > 21) {
            lost += 1;
            returnString = "You Lose";
        } else if (scoreD > 21) {
            win += 1;
            returnString = "You Win";

        } else if (scoreP > scoreD) {
            win += 1;
            returnString = "You Win";
        } else if (scoreP < scoreD) {
            lost += 1;
            returnString = "You Lose";
        } else if (scoreP == scoreD) {
            returnString = "Push";
        }

        // return to update labels
        data.add(returnString);
        data.add("Score : " + win + " Wins " + lost + " Loses");
        return new LinkedList<>(data);
    }

    // adding new player to txt
    public void newPlayer(String name) {
        try {
            FileWriter fw = new FileWriter("./files/highscores.txt", true);
            StringWriter writer = new StringWriter();
            writer.write(name + " " + 0 + " " + 0); // new player starts with 0 wins, 0 loses
            fw.write(writer.toString() + System.lineSeparator());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateFile(String name) {
        try {
            // storing name and corresponding w/l ratio
            TreeMap<String, String> newLines = new TreeMap<>();
            BufferedReader bufferReader = new BufferedReader(
                    new FileReader("./files/highscores.txt"));

            String line = bufferReader.readLine();

            System.out.println("FIRST LINE: " + line);

            // adding all the names, w/l to a map where those are key, value respectively
            while (line != null) {
                String[] eachLine = line.split(" ");
                newLines.put(eachLine[0], eachLine[1] + " " + eachLine[2]);
                line = bufferReader.readLine();
            }

            bufferReader.close();

            System.out.println("ENTRY1: " + newLines.entrySet());
            System.out.println("KEY1: " + newLines.keySet());

            // changing the desired lines
            newLines.replace(name, win + " " + lost);

            // del old file making new one (FileWriter does by default ig)
            FileWriter fw = new FileWriter("./files/highscores.txt");

            // readding them to new file with updated information
            for (Entry<String, String> entry : newLines.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                fw.write(entry.getKey() + " " + entry.getValue() + System.lineSeparator());
                System.out.println("Done");
                fw.flush();
            }

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
