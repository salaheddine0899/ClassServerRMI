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
            /*IStudent student1=class1.addStudent(1,"Salah Eddine","ABID");
            IStudent student2=class1.addStudent(2,"Walid","ABID");
            IStudent student3=class1.addStudent(3,"Aomar","ABID");*/
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/class1",class1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
