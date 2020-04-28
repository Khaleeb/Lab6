package cisc181.lab_6;

public class PieceBlueHen extends PieceEggLaying implements Attacker{

    private boolean fly;
    private int numAttacked;

    public PieceBlueHen(String symbol, String color, int numEggs, int numAttacked){
        super(symbol,color, numEggs);
        this.numAttacked = numAttacked;
        updateFly();
    }

    // constructor for when color information not available yet
    // and brand new piece that hasn't laid eggs and hasn't attacked
    public PieceBlueHen(String symbol){
        this(symbol,"",0,0);
    }

    public void speak(){
        System.out.println("Go UD!");
    }

    public int getNumAttacked()  {
        return this.numAttacked;
    }
    public boolean canFly ()  {
        return this.fly;
    }

    // need to override because have to call update fly!!
    public void incrementNumEggs( ){
        super.incrementNumEggs();
        updateFly();
    }

    public void incrementNumAttacked( ){
        this.numAttacked++;
        updateFly();
    }
/*
    public void validPath(){
        System.out.println("If can't fly -> can move one space left, or right, or up, or down.\n" +
                "If can fly -> can move to any empty space on board.");
    }
    */


    public boolean validPath(int firstSpaceRow, int firstSpaceCol,
                             int secondSpaceRow, int secondSpaceCol){
        boolean valid;
        // compute the difference between from row and to row
        int diffRows = Math.abs(firstSpaceRow - secondSpaceRow);
        // compute the difference between from columns and to column
        int diffCols = Math.abs(firstSpaceCol - secondSpaceCol);
        // move left or right one space
        if (diffRows == 0 && diffCols == 1){
            valid = true;
        }
        // Or it can move one space up or down the board
        else if (diffRows == 1 && diffCols == 0){
            valid = true;
        }
        else if (fly){
            // can move anywhere
            valid = true;
        }
        else{
            valid = false;
        }
        return valid;
    }
    /*
    public void attack(int fromRow, int fromCol, int toRow, int toCol){
        this.incrementNumAttacked();
        System.out.println("Attacks with claws - other piece removed from game.");
    }
    */

    public void attack(int firstSpaceRow, int firstSpaceCol,
                        int secondSpaceRow, int secondSpaceCol){
        this.incrementNumAttacked();
        speak();
    }

    public PieceBlueHen layEgg(){
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // creates a new piece that has the same number of eggs laid and attacked pieces
            // as this piece
            return new PieceBlueHen(this.symbol,this.color,this.numEggs,this.numAttacked);
        }
        else{
            return null;
        }
    }

    private void updateFly( ) {
        if (this.numEggs < MAX_EGGS) {
            this.fly = true;
        } else if (this.numAttacked == 0) {
            this.fly = true;
        } else {
            this.fly = false;
        }
    }
}
