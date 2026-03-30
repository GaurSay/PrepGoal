package LowLevelDesign.SnakeAndLadder;

public class Player {

    private int Id;

    private String name;
    private int currPos;

    public Player(int id, String name, int currPos) {
        Id = id;
        this.name = name;
        this.currPos = currPos;
    }




    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrPos() {
        return currPos;
    }

    public void setCurrPos(int currPos) {
        this.currPos = currPos;
    }
}
