import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class JurysCards {

    public Deck gameDeck;
    public ArrayList<ArrayList<Card>> piles; // List of 13 lists each with 4 cards in them

    // Constructor
    public JurysCards( Deck freshDeck ){

        this.gameDeck = freshDeck;
        this.piles = new ArrayList<ArrayList<Card>>();
        for( int i = 0; i < 13; i++ ){
            this.piles.add(new ArrayList<Card>());
        }

    }

    public void forwardsDeal(){

        /**
         *  Take card from start of gameDeck
         *  Add to first pile
         *  Remove card from gameDeck
         *  Increment pile by 1
         *  Repeat steps 13 in total
         * */
        int pilesNumber = 0;

        while (pilesNumber < 13){

            this.piles.get(pilesNumber).add(this.gameDeck.currentDeck.get(0));
            this.gameDeck.currentDeck.remove(0);
            pilesNumber ++;
        }

        //System.out.println(this.piles);

    }

    public void backwardsDeal(){

        int pilesNumber = 12;

        while (pilesNumber >= 0){

            this.piles.get(pilesNumber).add(this.gameDeck.currentDeck.get(0));
            this.gameDeck.currentDeck.remove(0);
            pilesNumber --;
        }

        //System.out.println(this.piles);

    }

    // Deal into 13 piles of 4 cards (4 * 13 = 52)
    // Piles 1 - 13, then 13 - 1, then 1 - 13, then 13 - 1
    public void dealToPiles(){

        forwardsDeal();
        backwardsDeal();
        forwardsDeal();
        backwardsDeal();

        System.out.println("Game deck: " + this.gameDeck);
        System.out.println(this.piles);

    }


    // This should print the 13 piles
    @Override
    public String toString(){

        return this.gameDeck.toString();

    }

    public static void main(String[] args) {

        // Create a fresh deck
        Deck deckOne = new Deck();
        deckOne.setFreshDeck();

        // Create a game
        JurysCards gameOne = new JurysCards(deckOne);

        //System.out.println(deckOne);

        // Randomly cut the deck 12 times
        deckOne.randomTwelveCut();

        System.out.println(deckOne);

        gameOne.dealToPiles();


    }



}
