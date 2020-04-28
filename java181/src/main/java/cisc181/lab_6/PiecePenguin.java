package cisc181.lab_6;

public class PiecePenguin extends PieceEggLaying implements Attacker,Recruiter{

    private int numAttacked;

    public PiecePenguin(String symbol, String color, int numEggs, int numAttacked){
        super(symbol, color, numEggs);
        this.numAttacked = numAttacked;
    }

    // constructor for when color information not available yet
    public PiecePenguin(String symbol){
        this(symbol,"",0,0);
    }

    public void speak(){
        System.out.println("Smile and wave boys. Smile and wave.");
    }

    /*
    public void validPath(){
        System.out.println("Slide - piece can move left or right (one or more spaces) and NOT up and down");
        System.out.println("Or it can move one space up or down the board");
    }
    */
    public boolean validPath(int firstSpaceRow, int firstSpaceCol,
                             int secondSpaceRow, int secondSpaceCol){
        boolean valid;
        // compute the difference between from row and to row
        int diffRows = Math.abs(firstSpaceRow - secondSpaceRow);
        // compute the difference between from columns and to column
        int diffCols = Math.abs(firstSpaceCol - secondSpaceCol);
        // Slide - piece can move left or right (one or more spaces) and NOT up and down
        if (diffRows == 0 && diffCols != 0){
            valid = true;
        }
        // Or it can move one space up or down the board
        else if (diffRows == 1 && diffCols == 0){
            valid = true;
        }
        else{
            valid = false;
        }
        return valid;
    }
/*
    public void attack(int fromRow, int fromCol, int toRow, int toCol){
        this.numAttacked++;
        System.out.println("Attack with lasers - other piece removed from game.");
    }
    */

    public void attack(int firstSpaceRow, int firstSpaceCol,
                        int secondSpaceRow, int secondSpaceCol){
        this.incrementNumAttacked();
        speak();
    }

    /*
    public void recruit(int fromRow, int fromCol, int toRow, int toCol){
        System.out.println("You're on my team now! - other piece removed from other team and added to this team.");
    }
    */

    public void recruit(int firstSpaceRow, int firstSpaceCol, int secondSpaceRow, int secondSpaceCol){
        speak();
    }

    public PiecePenguin layEgg(){
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // this creates a new piece that has not laid any eggs
            // and has not attacked any pieces yet it will belong to this team so pass in Color
            return new PiecePenguin(this.symbol, this.color,0,0);
        }
        else{
            return null;
        }
    }

    public int getNumAttacked()  {
        return this.numAttacked;
    }

    public void incrementNumAttacked( ){
        this.numAttacked++;
    }
}

