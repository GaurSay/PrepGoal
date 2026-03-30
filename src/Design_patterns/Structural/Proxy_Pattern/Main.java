package Design_patterns.Structural.Proxy_Pattern;

public class Main {
    /*
    3 reasons to use proxy :

    1 - Blacklisting requests - API , params filter
    2 - caching
    3 - pre and post - processing

     */
    public static void main(String[] args) {
        DatabaseDaoProxy databaseDaoProxy = new DatabaseDaoProxy();
        databaseDaoProxy.create("Admin","hey");
        databaseDaoProxy.create("User","hey");
    }


}
