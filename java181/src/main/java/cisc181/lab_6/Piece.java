package cisc181.lab_6;

public abstract class Piece {

    protected String symbol;
    protected String color;
    protected boolean hidden; // represents whether this piece is visible or hidden

    public Piece(String symbol, String color){
        this.symbol = symbol;
        this.color = color;
        this.hidden = false;
    }

    // constructor for when color information not available yet
    public Piece(String symbol){
        this(symbol,"");
    }

    public abstract void speak();

    public String getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    //public abstract void validPath();
    public abstract boolean validPath(int firstSpaceRow, int firstSpaceCol,
                                      int secondSpaceRow, int secondSpaceCol);

    public String toString(){
        return color.charAt(0) + "-" + symbol;
    }
}
