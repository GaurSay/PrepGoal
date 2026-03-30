package Design_patterns.Creational.Protoype_Pattern;

public class Student implements Prototype{

    private String name;
    private int age;
    private int roll_no;

    Student(String name,int age,int roll_no){
        this.age= age;
        this.name = name;
        this.roll_no = roll_no;
    }


    @Override
    public Prototype clone() {
        return new Student(name,age,roll_no);
    }

    public String getName(){
        return this.name;
    }
}
