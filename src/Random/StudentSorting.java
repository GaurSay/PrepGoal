package Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentSorting {


    public static void main(String[] args) {
        student s1 = new student("a1",4);
        student s2 = new student("a2",3);
        student s3 = new student("a3",2);
        student s4 = new student("a4",1);
        List<student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        Collections.sort(list, Comparator.comparingInt(s -> s.rollno));
        for (student s : list) {
            System.out.println(s);
        }
    }

}


class student{
    public student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    String name;
    int rollno;

    @Override
    public String toString() {
        return "Roll No: " + rollno + ", Name: " + name;
    }

}
