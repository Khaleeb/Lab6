package cisc181.lab_6;


public class Game181H extends GameH{

      public Game181H(int numBoardRows, int numBoardColumns, TeamH team1,
                     TeamH team2){
        super(numBoardRows,numBoardColumns,team1,team2);
    }



    public TeamH getWinner(){
        // if one team has no more pieces and the other does - return that team
        if(teamA.containsDean() && !teamB.containsDean()){
            return teamA;
        }
        else if(!teamA.containsDean() && teamB.containsDean()){
            return teamB;
        }
        else{
            return null;
        }
    }

    public boolean isAWinner(){
          return teamA.containsDean() ^ teamB.containsDean();
    }

    public boolean isGameEnded(){
        return !teamA.containsDean() || !teamB.containsDean();
    }
}

