package Design_patterns.Structural.Proxy_Pattern;

public class DatabaseDao implements IDatabaseDao {

    @Override
    public void create(String user, String Data) {
        System.out.println("Created");
    }

    @Override
    public void update(String user, String Data) {
        System.out.println("Updated");
    }

    @Override
    public void delete(String user, String Data) {
        System.out.println("deleted");
    }
}
