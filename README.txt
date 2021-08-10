=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: _______
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. Collections: I used a linked list to represent the deck. This simulates a real deck
  that is first in order, but is then shuffled. I also used a linked list for each hand to simulate 
  the order that the hands would be in. For the dealer, this would make it easy to get the first
  card and show it to the player. Linkedlist were very useful when return data aswell because
  I would know which data is in which position.

  2. I created a highscores.txt file that tracks all the scores that registered players have. When
  the game is first started, it will check for a registered player and load their w/l. If a 
  player isn't within this file, then a new player with the score 0 - 0 (w/l respectively) will be
  created. After each turn, a player's w/l is updated, so the player can quit whenever they want.

  3. I created an dynamic card class to represent each of the individual cards that a deck 
  makes up. I can't simply create private instance variables for these cards because they have 
  different information, although they are set up the same. A king will have the type of king, 
  rank king, and value of 10, while another king could be the same rank (king) and value 
  but be a different type (spade instead of heart).A private instance variable would not be capable 
  of having all these different attributes that each card would have.
  
  I redesigned my GameBoard to work from the tictactoe completely so it works specifically for
  my BlackJack game.
  

  4. I created a testable component that worked around the core game state (beating the dealer by
  getting close to 21). I created methods that would draw specific cards in order to make sure I 
  could test how my game would function when presented different scenarios. I tested how the dealer
  reacted to hard 17s, win, lose, draw, blackjack off draw, updating scores, file loading, and
  aces.

=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
  
  1. Blackjack
  		The blackjack class is the main game state. Here, I created methods for standard gameplay.
  		For example, like in blackjack, you can hit, stand, deal, check the winner, etc. 
  2. Xhand
        The blackjack class uses this when dealing, hitting, standing, checking winners, etc.
        This class has all the features that a person's hand would have 
  3. Card
  		This card class is an abstract class that has the standard methods for each card that will
  		go into the deck of cards.
  4. Deck
  		This class has all the cards in a deck. I have methods that let me do standard deck 
  		operations such as shuffling and picking a random cards or picking a specific card.
  5. Gameboard
  		This instantiates my blackjack object and models the game. It uses game.java to 
  		do specific functions when buttons are pressed. The board is updated and changed
  		in this class.
  6. Game
  		This is where all the top level widgets are created and setup for the GUI.

- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
  
  I had a really hard time editing my high scores file. I struggled with this because I had to
  take all the lines and rewrite them to a new file in order to be atomic. I also really struggled
  with making sure that some classes only had methods and features unique to that class. I had
  to rewrite a lot of methods within my blackjack class because it would do things that my hand 
  class should only be able to do.
  
  I was stuck on creating my deck constructor for so long because I wasn't sure how to effectively
  create all the cards in a concise way. 


- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
  
  I think my design is alright. I should have changed the way I used the cards in the deck. I think
  my current method needs to be shorter and more concise. I think I divided my classes up pretty
  well. The Game uses GameObj which uses Blackjack which uses the Xhand which uses the Deck which 
  uses the Cards. There is a clear order of heirarchy in which these different classes interact
  with another.
  
  I think I did pretty good to make new that my private state was encapsulated. Whenever I would
  return a list I made sure to return a new linked list. I think my deck constructor could be 
  created in a more efficient process. I could not figure out what to do for this. So, if I could 
  refactor I would think about this more.



========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.

  https://en.wikipedia.org/wiki/Blackjack
  
  https://docs.oracle.com/javase/8/docs/api/