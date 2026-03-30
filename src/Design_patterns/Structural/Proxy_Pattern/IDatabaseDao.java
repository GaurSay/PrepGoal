package Design_patterns.Structural.Proxy_Pattern;

public interface IDatabaseDao {

    public void create(String user, String Data);
    public void update(String user, String Data);
    public void delete(String user, String Data);
}
