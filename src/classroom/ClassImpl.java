package classroom;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;

public class ClassImpl extends UnicastRemoteObject implements IClass{

    Collection<IStudent>students;

    public ClassImpl() throws RemoteException {
        students=new ArrayList<>();
    }

    @Override
    public IStudent addStudent(int studentNumber, String firstName, String lastName) throws RemoteException {
        IStudent student=new StudentImpl(firstName,lastName,studentNumber);
        students.add(student);
        return student;
    }

    @Override
    public IStudent getStudentByNumber(int studentNumber) throws RemoteException {
        for(var student:students){
            if(((StudentImpl)student).isStudent(studentNumber))
                return student;
        }
        throw new RuntimeException("Student Not found");
    }

    @Override
    public double calculateClassAvg() throws RemoteException {
        double avg=0;
        for (var student:students)
            avg+=student.calculateAverage();
        return avg/students.size();
    }
}
