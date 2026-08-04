package LowLevelDesign.Vending_Machine.Enum;

public enum Note {
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    private final int value;

    Note(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
