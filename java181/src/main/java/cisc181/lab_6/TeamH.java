package cisc181.lab_6;

import java.util.ArrayList;


public class TeamH {
    protected String teamName;
    protected String teamColor;
    protected ArrayList<Piece> teamPieces;
    protected ToolBox toolBox;

    public TeamH(String teamName, String teamColor,ArrayList<Piece> teamPieces){
        this.teamName = teamName;
        this.teamColor = teamColor;
        this.teamPieces = teamPieces;
        this.toolBox = new ToolBox(false);
    }
    public String getTeamName(){return this.teamName;}
    public String getTeamColor(){return this.teamColor;}
    public ArrayList<Piece> getTeamPieces() {
        return teamPieces;
    }
    public ToolBox getToolBox(){return this.toolBox;}

    public void removePieceFromTeam(Piece piece){
        teamPieces.remove(piece);
    }
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