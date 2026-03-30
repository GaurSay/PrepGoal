package Design_patterns.Structural.Proxy_Pattern;

public class DatabaseDaoProxy implements  IDatabaseDao{

    private DatabaseDao databaseDao;

    public DatabaseDaoProxy(){
        databaseDao = new DatabaseDao();
    }

    @Override
    public void create(String user, String Data) {
        if(user.equals("Admin")){
            databaseDao.create(user,Data);
        }
        else{
            System.out.println("Not authorized");
        }
    }

    @Override
    public void update(String user, String Data) {

    }

    @Override
    public void delete(String user, String Data) {

    }
}
