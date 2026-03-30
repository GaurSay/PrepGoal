package Design_patterns.Creational.Protoype_Pattern;

public class main {

    public static void main(String[] args) {
        /*
        When we have to make a copy/clone from an existing object which is very expensive.
        Prob 1 - if fields are private
        Prob 2 - very heavy object/ Client has to know all variables and fields,
        Prob 3 - If only few have to be copied and not all.

        Plus - uniformity/consistency of clone() method instead of different names.


        Solution - :

         */

        Student s = new Student("Shubham",30,45);

        Student s2 = (Student) s.clone();
        System.out.println(s2.getName());
    }
}
