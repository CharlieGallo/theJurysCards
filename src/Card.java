
public class Card {

    public int numberValue;
    public int suitValue; // 1 = Spades, 2 = Diamonds, 3 = Clubs, 4 = Hearts
    public String colour;

    // Constructor
    public Card(int numberValue, int suitValue) {

        this.numberValue = numberValue;
        this.suitValue = suitValue;
        if( this.suitValue == 1 | this.suitValue == 3 ){
            this.colour = "black";
        } else {
            this.colour = "red";
        }
    }

    @Override
    public String toString(){

        String suitString = null;
        String numberString = null;

        switch( this.suitValue ){
            case 1:
                suitString = "Spades";
                break;
            case 2:
                suitString = "Diamonds";
                break;
            case 3:
                suitString = "Clubs";
                break;
            case 4:
                suitString = "Hearts";
                break;

        }

        if( this.numberValue == 1 | this.numberValue > 10 ){
            switch( this.numberValue ){
                case 1:
                    numberString = "Ace";
                    break;
                case 11:
                    numberString = "Jack";
                    break;
                case 12:
                    numberString = "Queen";
                    break;
                case 13:
                    numberString = "King";
                    break;
            }
        } else {
            numberString = String.valueOf(this.numberValue);
        }

        return String.format("%s of %s", numberString, suitString);

    }

    public static void main(String[] args) {

        Card one = new Card(11, 4);

        System.out.println(one);

    }

}
