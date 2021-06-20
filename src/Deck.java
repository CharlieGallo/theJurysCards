import java.util.*;

/**
 *   Create a fresh deck containing 52 cards - no jokers
 *   For each number between 1-13 and each suit between 1-4
 *   create a card and store in a list as a Card object
 * */

public class Deck {

    public ArrayList<Card> currentDeck;

    // Constructor
    public Deck(){

        this.currentDeck = new ArrayList<Card>();

    }

    // Second Constructor to deal with a shuffled deck
//
//    public Deck( ArrayList<Card> topPile, ArrayList<Card> bottomPile ){
//
//        this.freshPack = new ArrayList<Card>();
//        topPile.addAll(bottomPile);
//
//    }

    public void setFreshDeck(){

        int cards = 0;

        while ( cards < 52 ){

            for( int suit = 1; suit <= 4; suit++ ){

                for( int value = 1; value <= 13; value++ ){

                    //this.freshPack[cards] = new Card(value, suit);
                    this.currentDeck.add(new Card(value, suit));
                    cards++;

                }

            }

        }

    }

    public void randomCut(){

        int deckLength = this.currentDeck.size();

        ArrayList<Card> topPile = new ArrayList<>();
        ArrayList<Card> bottomPile = new ArrayList<>();

        Random rand = new Random();

        Integer split = rand.nextInt(52);
        //System.out.println(split);

        for( int topCard = 0; topCard < split; topCard++ ){
            topPile.add(this.currentDeck.get(topCard));
        }

        for( int bottomCard = split; bottomCard < deckLength; bottomCard++ ){
            bottomPile.add(this.currentDeck.get(bottomCard));
        }

        bottomPile.addAll(topPile);

        Collections.copy(this.currentDeck, bottomPile);

        //System.out.println(this.currentDeck);

        topPile.clear();
        bottomPile.clear();

    }

    public void randomTwelveCut(){

        for (int i = 0; i < 12; i++ ){

            randomCut();

        }

//        int deckLength = this.currentDeck.size();
//
//        ArrayList<Card> topPile = new ArrayList<>();
//        ArrayList<Card> bottomPile = new ArrayList<>();
//
//        Random rand = new Random();
//
//        for (int i = 0; i < 12; i++ ){
//
//            Integer split = rand.nextInt(52);
//            /**
//             *  Go to card in deck at position split.
//             *  Split deck into two piles - top and bottom.
//             *  Bottom pile at start of list, append top pile to end of list
//             *  Update currentDeck.
//             * */
//
//            //System.out.println(split);
//
//            for( int topCard = 0; topCard < split; topCard++ ){
//                topPile.add(this.currentDeck.get(topCard));
//            }
//
//            for( int bottomCard = split; bottomCard < deckLength; bottomCard++ ){
//                bottomPile.add(this.currentDeck.get(bottomCard));
//            }
//
//            //System.out.println(topPile);
//            //System.out.println(bottomPile);
//
//            bottomPile.addAll(topPile);
//
//            Collections.copy(this.currentDeck, bottomPile);
//
//            topPile.clear();
//            bottomPile.clear();
//
//            //System.out.println(this.currentDeck);
//
//            //break;
//
//        }

    }

    /**
     *  ADD METHOD FOR SHUFFLING
     * */

    @Override
    public String toString(){ // checkDeck is a fresh pack

        String allCards = "";
        for ( Card c : this.currentDeck ){
            allCards += String.format("%s \n", c);
        }
        return allCards;
    }

    public static void main(String[] args) {

        Deck one = new Deck();
        one.setFreshDeck();

        System.out.println(one);

        one.randomTwelveCut();

        System.out.println(one);


    }
}
