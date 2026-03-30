package LowLevelDesign.SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GameBuilder {

    int dimension;
    int diceCount;
    int snakeCount;
    int ladderCount;
    Deque<Player> players = new LinkedList<>();

        public GameBuilder setSnakeCount(int snakeCount) {
            this.snakeCount = snakeCount;
             return this;
        }

        public GameBuilder setLadderCount(int ladderCount) {
            this.ladderCount = ladderCount;
             return this;
        }

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setDiceCount(int diceCount) {
            this.diceCount = diceCount;
            return this;
        }

        public GameBuilder setPlayers(Deque<Player> players) {
            this.players = players;
            return this;
        }

        public Game build(){
            return new Game(this);
        }


}
