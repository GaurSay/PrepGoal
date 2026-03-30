package LowLevelDesign.TicTacToe.TTT.models;

import LowLevelDesign.TicTacToe.TTT.Enums.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class GameTTC {

    private Board board;
    private List<Player> players;
    private List<Move> moves;

    private GameStatus gameStatus;

    private int nextPlayerIndex;


    public static GameBuilderTTC getBuilder(){
        return new GameBuilderTTC();
    }

    public GameTTC(GameBuilderTTC builder) {
        this.players = builder.getPlayers();
//        this.board = builder.get;
//        this.gameStatus = GameStatus.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.moves = new ArrayList<>();
//        this.gameWinningStrategiesEnumList = builder.gameWinningStrategiesList;
//        this.gameWinningStrategies = new ArrayList<>();

//        for (GameWinningStrategies gameWinningStrategies1: gameWinningStrategiesEnumList) {
//            this.gameWinningStrategies.add(GameWinningStrategyFactory.getStrategyForEnum(gameWinningStrategies1, builder.dimension));
//        }
    }


}
