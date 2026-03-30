package LowLevelDesign.SnakeAndLadder;


import java.util.Deque;
import java.util.LinkedList;

public class Game {

    private Board board;

    Deque<Player> playersList = new LinkedList<>();
    private Dice dice;
    private GameStatus gameStatus;

    private Player winner;

    public Game(){

        initializeGame();
    }

    private void initializeGame() {


        board = new Board(10, 5,4);
        dice = new Dice(1);
        winner = null;
        gameStatus = GameStatus.IN_PROGRESS;

        addPlayers();
    }

     public void startGame(){
         while(gameStatus == GameStatus.IN_PROGRESS) {

             //check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerTurn.getId() + " current position is: " + playerTurn.getCurrPos());

            //roll the dice
            int diceNumbers = dice.rollDice();

            System.out.println("player :" + playerTurn.getId() + " got dice value : " + diceNumbers);


              //get the new position
            int playerNewPosition = playerTurn.getCurrPos() + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.setCurrPos(playerNewPosition);

            System.out.println("player turn is:" + playerTurn.getId() + " new Position is: " + playerNewPosition);
            //check for winning condition
            if(playerNewPosition >= board.cells.length * board.cells.length-1){

                winner = playerTurn;
                gameStatus = GameStatus.PLAYER_WINS;
            }

        }

        System.out.println("WINNER IS:" + winner.getName() +" - player "+ winner.getId());
     }

    private void addPlayers() {
        Player player1 = new Player(1,"shub", -1);
        Player player2 = new Player(2,"khush", -1);
        playersList.add(player1);
        playersList.add(player2);
    }
    private int jumpCheck (int playerNewPosition) {

        if(playerNewPosition > board.cells.length * board.cells.length-1 ){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }


    public Game(GameBuilder builder){
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.playersList =  builder.players;
        this.board = new Board(builder.dimension,builder.snakeCount,builder.ladderCount);
        this.dice = new Dice(builder.diceCount);
    }

    static GameBuilder builder(){
        return new GameBuilder();
    }

    private Player findPlayerTurn() {

        Player playerTurns = playersList.removeFirst();
        playersList.addLast(playerTurns);
        return playerTurns;
    }

}
