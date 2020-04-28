package cisc181.lab_6;


public class Game181H extends GameH{

      public Game181H(int numBoardRows, int numBoardColumns, TeamH team1,
                     TeamH team2){
        super(numBoardRows,numBoardColumns,team1,team2);
    }

    public TeamH getWinner(){
        // if one team has no more pieces and the other does - return that team
        if(teamA.getTeamPieces().size() == 0 && teamB.getTeamPieces().size() != 0){
            return teamB;
        }
        else if(teamA.getTeamPieces().size() != 0 && teamB.getTeamPieces().size() == 0){
            return teamA;
        }
        else{
            return null;
        }
    }
    public boolean isAWinner(){
        return teamA.getTeamPieces().size() == 0 ^ teamB.getTeamPieces().size() == 0;
    }
    public boolean isGameEnded(){
        return teamA.getTeamPieces().size() == 0 || teamB.getTeamPieces().size() == 0;
    }
}
