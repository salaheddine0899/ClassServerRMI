package classroom;

public class TestImpl implements ITest{
    private String label;
    private double note;
    private double coefficient;

    public TestImpl(String label,double note,double coefficient){
        if(coefficient<=0&&coefficient>=1)
            throw new RuntimeException("invalid coefficient!");
        this.label=label;
        this.note=note;
        this.coefficient=coefficient;
    }

    @Override
    public double note() {
        return note;
    }

    @Override
    public String display() {
        return label+": "+note+'*'+coefficient+'\n';
    }

    public double getCoefficient(){
        return coefficient;
    }
}
