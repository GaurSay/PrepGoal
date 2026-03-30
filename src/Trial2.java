import java.util.HashMap;

public class Trial2 {

    static HashMap<Integer,Integer>  map = new HashMap<>();

    public static void main(String[] args) {




        map.put(1,101);
        map.put(2,102);
        map.put(3,103);
        map.put(4,104);
        map.put(5,105);


        Thread t1 = new Thread(() -> modifyMap());
        Thread t2 = new Thread(() -> modifyMap2());
        t1.start();
        t2.start();
        System.out.println(map);

    }

    private static void modifyMap(){
//        for(HashMap.Entry entry : map.entrySet()){
//            System.out.println(entry.getKey() +  " " + entry.getValue());
//        }
    }

    private static void modifyMap2(){
      for(int i = 0 ; i<5 ;i++){
          map.put(i,100);
      }

    }
}
