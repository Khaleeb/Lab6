package cisc181.lab_6;

public abstract class PieceEggLaying extends Piece {

    protected int numEggs;
    final public static int MAX_EGGS =2;

    public PieceEggLaying(String symbol, String color, int numEggs){
        super(symbol,color);
        this.numEggs = numEggs;
    }
    // constructor for when color information not available yet
    // and brand new piece that hasn't laid eggs
    public PieceEggLaying(String symbol){
        this(symbol,"",0);
    }

    public int getNumEggs()  {
        return this.numEggs;
    }

    public void incrementNumEggs( ){
        this.numEggs++;
    }

    public abstract PieceEggLaying layEgg();
}
