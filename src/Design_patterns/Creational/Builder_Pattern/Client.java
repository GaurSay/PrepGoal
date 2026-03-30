package Design_patterns.Creational.Builder_Pattern;

public class Client {

    public static void main(String args[]){
        Student s = Student.getBuilder().setAge(20).setName("shubham").setId(27).setUniversity("VIT").build();
        // 1. if many optional parameter and maybe only 1 mandatory , constructor will be clumsy and big.
        // 2. have small constructors with whatever we want to build with -- this will result in many constructors.
        // 3. step by step object creation
        // 4. dis-adv code duplicate lines increased
        System.out.printf(s.getName());

    }
}
