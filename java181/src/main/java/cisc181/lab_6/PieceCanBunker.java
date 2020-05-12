package cisc181.lab_6;

public abstract class PieceCanBunker extends Piece{
    protected boolean isBunkered;

    public PieceCanBunker(String symbol, String color){
        super(symbol,color);
        this.isBunkered = false;
    }
    // constructor for when color information not available yet

    public abstract void speak();
    public PieceCanBunker(String symbol){
        this(symbol,"");
    }

    public boolean isBunkered() { return isBunkered; }

    public void toggleBunker(){
        this.isBunkered = !this.isBunkered;
    }

}
