package cisc181.lab_6;

public class PieceDepartmentDean extends PieceCanBunker implements Attacker, Bunkerer{

    public PieceDepartmentDean(String symbol, String color) {
        super(symbol, color);
    }

    //constructor for when the color information is not available yet
    public PieceDepartmentDean (String symbol) {
        this(symbol, "");
    }

    public void speak() {
        System.out.println("You will not escape my wrath!");
    }

    public boolean validPath(int firstSpaceRow, int firstSpaceCol, int secondSpaceRow, int secondSpaceCol) {
        boolean valid;
        // compute the difference between from row and to row
        int diffRows = Math.abs(firstSpaceRow - secondSpaceRow);
        // compute the difference between from columns and to column
        int diffCols = Math.abs(firstSpaceCol - secondSpaceCol);
        if (diffRows == 0 && diffCols == 1){
            valid = true;
        }
        // Or it can move one space up or down the board
        else if (diffRows == 1 && diffCols == 0){
            valid = true;
        }

    }

    public void attack(int firstSpaceRow, int firstSpaceCol, int secondSpaceRow, int secondSpaceCol) {
        speak();
    }
    public void toggleBunker(int firstSpaceRow, int firstSpaceCol, int secondSpaceRow, int secondSpaceCol) {
        speak();
    }
}
