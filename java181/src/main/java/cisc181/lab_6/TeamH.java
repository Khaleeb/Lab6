package cisc181.lab_6;

import java.util.ArrayList;

// Team object
public class TeamH {
    protected String teamName;
    protected String teamColor;
    protected ArrayList<Piece> teamPieces;
    protected ToolBox toolBox;

    // Constructor
    public TeamH(String teamName, String teamColor,ArrayList<Piece> teamPieces){
        this.teamName = teamName;
        this.teamColor = teamColor;
        this.teamPieces = teamPieces;
        this.toolBox = new ToolBox(false);
    }
    // Returns team name
    public String getTeamName(){return this.teamName;}
    // Returns team color
    public String getTeamColor(){return this.teamColor;}
    // Returns team pieces
    public ArrayList<Piece> getTeamPieces() {
        return teamPieces;
    }
    // Returns toolbox
    public ToolBox getToolBox(){return this.toolBox;}
    // Returns true if dean is in team pieces
    public boolean containsDean(){
        for (Piece piece : this.getTeamPieces()) {
            if (piece instanceof PieceHeadDean){
                return true;
            }
        }
        return false;
    }

    // Removes pieces from team
    public void removePieceFromTeam(Piece piece){
        teamPieces.remove(piece);
    }
    // Adds piece to team
    public void addPieceToTeam(Piece piece){
        piece.setColor(this.teamColor);
        teamPieces.add(piece);
    }
    public String toString(){
        String retString = "Team " + teamName + " : " + teamColor + "\nPieces : ";
        for(Piece eachPiece : teamPieces){
            retString += eachPiece.toString() + " ";
        }
        retString += "\nTools : " + toolBox.toString();
        return retString;
    }
}