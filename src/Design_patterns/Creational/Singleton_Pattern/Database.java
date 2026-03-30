package Design_patterns.Creational.Singleton_Pattern;

public class Database {

    public static volatile Database obj = null;

    private Database(){
    }


    // Double Checked Locking based Java implementation of
    // singleton design pattern
    private static Database getInstance() {
        if(obj == null){
            // To make thread safe
            synchronized(Database.class){

                // check again as multiple threads
                // can reach above step
                if(obj == null){
                    obj = new Database();
                }
            }
        }
        return obj;
    }
}

//    We have declared the obj volatile which ensures that multiple threads offer the obj variable
//        correctly when it is being initialized to the Singleton instance.
//        This method drastically reduces the overhead of calling the synchronized method every time.
