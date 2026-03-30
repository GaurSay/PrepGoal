package Design_patterns.Creational.Singleton_Pattern;

public class Singleton {


/*
    Allows you to restrict creating only 1 object of its created at MAX, ex - Logger
    Classes which use shared resources behind the scenes
    1. we make constructor private
    2. make getInstance() method but to call make it static
    3. make object declaration and initialisation also static JVM executes a static initializer- at the time of class loading
      this works and handles concurrency


      4 ways to implement singleton
      1.) Eager Instantiation

      class Singleton
    {
        private static Singleton obj = new Singleton();
        private Singleton() {}

        public static Singleton getInstance()
        {
            return obj;
        }
    }



      2.) lazy


      class Singleton{
        private static Singleton obj;
        private Singleton() {}

        public static Singleton getInstance()
        {
            if( obj ==null ) {
            {
             obj = new Singleton();
             }

            return obj;
        }
    }



      3.) synchronized - very expensive as locking is done which is very expensive


      class Singleton{
        private static Singleton obj;
        private Singleton() {}

        public static synchronized Singleton getInstance()
        {
            if( obj ==null ) {
            {
                 obj = new Singleton();
            }

            return obj;
        }
    }

      4.) double lock
 Static initializer based Java implementation of
 singleton design pattern

    , but problems (1.) app startup is very slow
                    2. -- if any information I need at class load that is not available - if we want to pass some info in database object

                    //  Double Checked Locking mechanism
 */

    public static void main(String[] args) {
//        public static volatile Database obj = null;
//
//    private Database(){
//        }
//
//
//        // Double Checked Locking based Java implementation of
//        // singleton design pattern
//        private static Database getInstance() {
//            if(obj == null){
//                // To make thread safe
//                synchronized(Database.class){
//
//                    // check again as multiple threads
//                    // can reach above step
//                    if(obj == null){
//                        obj = new Database();
//                    }
//                }
//            }
//            return obj;
//        }
//    }

    }


}
