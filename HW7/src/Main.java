import java.util.Scanner;

public class Main {
    // @author Aljawhara

    public static void main(String[] args) {


        Scanner obj= new Scanner(System.in);
        int num= 0;
        Account account = new Account("1","Aljawhara",10000);
        Account accountTwo = new Account("2","Amal",20000);

        Employee objEmloyee= new Employee("1","Aljawhara",15000);

        System.out.println( "ID:"+account.getId());
        System.out.println( "Name:"+account.getName());
        System.out.println( "Balance:"+account.getBalance());

        System.out.println( "Enter The amount that you want to withdrow :");
        num= obj.nextInt();
        account.credit(num);

        System.out.println( "Enter The amount that you want to debite :");
        num= obj.nextInt();
        account.debite(num);

        System.out.println( "Enter the amount that you want to transfer:");
        num= obj.nextInt();
        account.TransferTo(account,accountTwo,num);



        objEmloyee.Tostring();
        objEmloyee.Annual_Sallary();
        objEmloyee.raise_salary(30);
        System.out.println(" Your Salary  after raising is "+ objEmloyee.getSalary());


    /*    System.out.println( " Chose the account that you want transfer from:");

        System.out.println( " Chose the account that you want transfer To:");

        System.out.println( " Enter the amount that you want to transfer:");
        num= obj.nextInt();
        account.debite(num);*/



    }
}