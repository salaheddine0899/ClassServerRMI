import classroom.ClassImpl;
import classroom.IClass;
import classroom.IStudent;
import classroom.TestImpl;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) {
        try {
            /*IClass class1=new ClassImpl();
            IStudent student1=class1.addStudent(1,"Salah Eddine","ABID");
            IStudent student2=class1.addStudent(1,"Walid","ABID");
            IStudent student3=class1.addStudent(1,"Aomar","ABID");
            student1.addTest("math",18,0.5);
            student1.addTest("physic",16,0.5);
            student2.addTest("math",14,0.5);
            student2.addTest("physic",13,0.5);
            student3.addTest("math",10,0.5);
            student3.addTest("physic",12,0.5);
            System.out.println(class1.calculateClassAvg());*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}