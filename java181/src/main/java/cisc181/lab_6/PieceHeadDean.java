package cisc181.lab_6;

// Piece that implements recruiter, L-shape movement, one per team, win condition+
public class PieceHeadDean extends Piece implements Recruiter {
    public PieceHeadDean(String symbol, String color){
        super(symbol, color);
    }

    public PieceHeadDean(String symbol){
        this(symbol, "");
    }

    // Speak Method
    public void speak() {
        System.out.println("Head Dean Reporting in.");
    }

    // L-Shape Path
    public boolean validPath(int rowI, int colI, int row, int col) {
        return (((Math.abs(row - rowI) == 2) && (Math.abs(col - colI) == 1)) || ((Math.abs(row - rowI) == 1) && (Math.abs(col - colI) == 2)));
    }

    // Recruiter method
    public void recruit(int firstSpaceRow, int firstSpaceCol, int secondSpaceRow, int secondSpaceCol){
        speak();
    }

}
