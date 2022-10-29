import classroom.ClassImpl;
import classroom.IClass;
import classroom.IStudent;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Locale;

public class ServerRMI {
    public static void main(String[] args) {
        try {
            IClass class1=new ClassImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/class1",class1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
