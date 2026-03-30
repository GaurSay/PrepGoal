package Threading;

public class Computer {
//
//Class Computer with ramSize=16, diskSize=512
//String modelName
//modelName is mandatory
//int
//diskSize and ramSize are intgeres

    private int Id;
    private String modelName;
    private int ramSize = 16;
    private int diskSize = 512;

    public Computer(String modelName){
        this.modelName = modelName;
    }
    public Computer(String modelName,int ramSize,int diskSize){
         this.modelName = modelName;
         this.ramSize = ramSize;
         this.diskSize = diskSize;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }


}
