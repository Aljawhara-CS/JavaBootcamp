public class Employee {
 // @author Aljawhara
    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public double getSalary() {
        return Salary;
    }

    String Id;
    String Name;


    double Salary;

    Employee( String id,String name, double salary )
    {
        this.Id=id;
        this.Name=name;
        this.Salary= salary;

    }

    public  double Annual_Sallary()

    {
       double Annual_Sallary =0;
        Annual_Sallary= getSalary()*12;

        return Annual_Sallary;
    }
    public void setSalary(double salary) {
        Salary = salary;
    }

    public  double raise_salary( double percentage)
    {
        double raise_salary;
        double value;

        System.out.println(" Your Basic Salay is "+ getSalary());

        value=percentage/100;

        raise_salary= getSalary()*value;
        System.out.println(" Your raise_salary will be "+ raise_salary);
        setSalary(getSalary()+raise_salary);

        return getSalary();
    }

    public  String Tostring( )
    {

        System.out.println("Name:" + getName());
        System.out.println("Salary:"+ getSalary());
        return "";
    }


}
