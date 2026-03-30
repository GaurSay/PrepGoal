package Design_patterns.Structural.Proxy;

public class ProxyEmployeeDao implements EmployeeDao{

    EmployeeDaoImpl empDaoImpl;

    public ProxyEmployeeDao(){
        empDaoImpl = new EmployeeDaoImpl();
    }

    @Override
    public void create() {
        // If role  == ADMIN
        //  empDaoImpl.create();
        //else
        // throw new Server Exception();
    }
}
