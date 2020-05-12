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

    public boolean validPath(int rowI, int colI, int row, int col) {
        boolean valid;


    }

    public void attack(int firstSpaceRow, int firstSpaceCol, int secondSpaceRow, int secondSpaceCol) {
        speak();
    }
    public void toggleBunker(int firstSpaceRow, int firstSpaceCol, int secondSpaceRow, int secondSpaceCol) {
        speak();
    }
}
