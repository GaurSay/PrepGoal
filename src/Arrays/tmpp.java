package Arrays;

public class tmpp {

    public static void main(String[] args) {

        int a = 0;
        student s = new student(23);
        tmpp t = new tmpp();
        t.manipulate(s);
        System.out.println(s.rollno);
    }

    private void manipulate(student s) {
        s = null;
    }
}

class student{
    int rollno ;

    public student(int rollno){
        this.rollno = rollno;
    }

}
