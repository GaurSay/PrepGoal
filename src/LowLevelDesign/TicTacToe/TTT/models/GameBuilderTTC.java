package LowLevelDesign.TicTacToe.TTT.models;

import java.util.List;

public class GameBuilderTTC {
    public int getDimension() {
        return dimension;
    }

    public List<Player> getPlayers() {
        return players;
    }

    private int dimension;
        private List<Player> players;

        public GameBuilderTTC setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilderTTC setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameTTC build(){
            return new GameTTC(this);
        }

}
