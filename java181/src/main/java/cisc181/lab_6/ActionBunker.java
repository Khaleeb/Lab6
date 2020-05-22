package cisc181.lab_6;

// Action Bunker class, used by department dean
public class ActionBunker extends Action{

    public ActionBunker(Game181H game, int rowF, int colF, int rowT, int colT) {
        super(game, rowF, colF, rowT, colT);
    }

    // valid action if piece can bunker
    @Override
    public boolean validAction() {
        Piece piece = game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece();
        return piece instanceof PieceCanBunker; // Check if piece can bunker
    }

    // Sets piece to bunkered
    @Override
    public void performAction() {
        if(validAction()) {
            PieceCanBunker piece = (PieceCanBunker)game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece();
            piece.toggleBunker();
            game.changeTurn();
        }
    }

}
