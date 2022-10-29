package classroom;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;

public class StudentImpl extends UnicastRemoteObject implements IStudent{
    private String firstName;
    private String lastName;
    int studentNumber;
    private Collection<ITest> tests;

    public StudentImpl(String firstName,String lastName,int studentNumber) throws RemoteException {
        this.firstName=firstName;
        this.lastName=lastName;
        this.studentNumber=studentNumber;
        tests=new ArrayList<>();
    }

    @Override
    public String firstName() throws RemoteException {
        return firstName;
    }

    @Override
    public String lastName() throws RemoteException {
        return lastName;
    }

    @Override
    public int studentNumber() throws RemoteException {
        return studentNumber;
    }

    @Override
    public String displayListTests() throws RemoteException {
        String listTest="";
        for(var test:tests)
            listTest+=test.display();
        return listTest;
    }

    @Override
    public void addTest(String label,double note,double coefficient) throws RemoteException {
        ITest test=new TestImpl(label,note,coefficient);
        tests.add(test);
    }

    @Override
    public double calculateAverage() throws RemoteException {
        double avg=0;
        double coefficients=0;
        for(var test:tests){
            coefficients+=((TestImpl)test).getCoefficient();
            avg+=test.note()*((TestImpl) test).getCoefficient();
        }
        if(coefficients!=1) throw new RuntimeException("number of coefficients is invalid");
        return avg;
    }

    public boolean isStudent(int studentNumber){
        return studentNumber==this.studentNumber;
    }
}
