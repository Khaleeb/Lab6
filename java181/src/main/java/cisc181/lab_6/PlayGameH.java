package cisc181.lab_6;
import java.util.*;

public class PlayGameH {

    static Scanner sc = new Scanner(System.in);
    private Game181H game181H;

    public PlayGameH (Game181H game181H) {
        this.game181H = game181H;
    }

    private char getValidActionType() {
        boolean acceptableInput = false;
        System.out.println(game181H.getCurrentTeam());
        System.out.println("Type a character and hit enter to perform an action");
        System.out.println(" Type 'M' to move");
        System.out.println(" Type 'R' to recruit");
        System.out.println(" Type 'A' to attack");
        System.out.println(" Type 'T' to use a Tool");
        System.out.print("ENTER: ");
        char userInput = 'f';
        while (acceptableInput==false){
            if (userInput == 'A' || userInput == 'R' || userInput == 'M' || userInput == 'T'){
                acceptableInput = true;
            }
            else {
                System.out.println("Not valid input");
            }
        }
        return userInput;
    }
    private void nextPlayersAction() {
        boolean acceptable = false;
        while (acceptable == false){
            char action = getValidActionType();

            if(action == 'M' || action == 'R' || action == 'A'){
            System.out.println("Enter row and column of current piece ");
            int fromRow = sc.nextInt();
            int fromCol = sc.nextInt();
            System.out.println("Enter row and column you would like to perform the action on");
            int actionRow = sc.nextInt();
            int actionCol = sc.nextInt();
            if (action == 'A') {
                ActionAttack attack = new ActionAttack(game181H, fromRow, fromCol, actionRow, actionCol);
                if (attack.validAction()) {
                    attack.performAction();
                    acceptable = true;
                } else {
                    System.out.println("Action not valid");
                }
            } else if (action == 'M') {
                System.out.println("You want to move");
                ActionMove move = new ActionMove(game181H, fromRow, fromCol, actionRow, actionCol);
                if (move.validAction()) {
                    move.performAction();
                    acceptable = true;
                } else {
                    System.out.println("Action not valid");
                }
            } else if (action == 'R') {
                ActionRecruit recruit = new ActionRecruit(game181H, fromRow, fromCol, actionRow, actionCol);
                if (recruit.validAction()) {
                    recruit.performAction();
                    acceptable = true;
                } else {
                    System.out.println("Action not valid");
                }
            }
            } else if (action == 'T') {


                
            }
            else {
                System.out.println("Action not valid");
            }
        }

    }

    public void playOurGame() {
        nextPlayersAction();
        System.out.println(game181H);
        while (game181H.isGameEnded() == false) {
            nextPlayersAction();
            System.out.println(game181H);
        }
        System.out.println(game181H.getWinner());
    }

    public static void main(String[] args) {

        // Create 3 pieces for Team A
        Piece nemoA = new PieceSharkBait("Nemo","Red");
        Piece blueHenA = new PieceBlueHen("Hen ","Red",0,0);
        Piece penguinA = new PiecePenguin("Peng","Red",0,0);

        // Create an array list to hold Team A's pieces
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);
        piecesTeamA.add(penguinA);

        // Create 3 pieces for Team B
        Piece nemoB = new PieceSharkBait("Nemo","Green");
        Piece blueHenB = new PieceBlueHen("Hen ","Green",0,0);
        Piece penguinB = new PiecePenguin("Peng","Green",0,0);

        // Create an array list to hold Team B's pieces
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(nemoB);
        piecesTeamB.add(blueHenB);
        piecesTeamB.add(penguinB);

        // Create TeamA and TeamB objects and pass them the array lists of pieces
        TeamH teamA = new TeamH("A", "Red",piecesTeamA);
        TeamH teamB = new TeamH("B",  "Green",piecesTeamB);

        // Create an instance of the game
        Game181H ourGame = new Game181H(4, 4,teamA, teamB);

        // Print Board at start of game
        System.out.println(ourGame.getBoard().toString());
        // Create PlayGame object and play the game
        PlayGameH play = new PlayGameH(ourGame);
        play.playOurGame();

    }
}
