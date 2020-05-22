package cisc181.lab_6;
public class PieceSharkBait extends Piece implements Recruiter{

    public PieceSharkBait(String symbol, String color) {
        super(symbol, color);
    }

    // constructor for when color information is not available yet
    public PieceSharkBait(String symbol) {
        this(symbol, "");
    }

    public void speak() {
        System.out.println("Shark bait oooh ha haa!");
    }

    /* old
    public void validPath() {
        System.out.println("can move 2 spaces diagonally");
    }
    */
    public boolean validPath(int firstSpaceRow, int firstSpaceCol,
                             int secondSpaceRow, int secondSpaceCol) {

        boolean valid;
        // compute the difference between from row and to row
        int diffRows = Math.abs(firstSpaceRow - secondSpaceRow);
        // compute the difference between from columns and to column
        int diffCols = Math.abs(firstSpaceCol - secondSpaceCol);
        // piece can move diagonally 2 spaces (2 to left or right and 2 up or down)
        if ((diffRows == 2) && (diffCols == 2)){
            valid = true;
        }
        else{
            valid = false;
        }
        return valid;
    }

    public void recruit(int firstSpaceRow, int firstSpaceCol,
                        int secondSpaceRow, int secondSpaceCol){
        speak();

    }
    /*
    public void recruit(int fromRow, int fromCol, int toRow, int toCol) {
        System.out.println("You're on my team now! - other piece removed from other team and added to this team.");
    }
    */
}
