public class Account {
    // @author Aljawhara

    private String Id;
    private String Name;

    public void setBalance(int balance) {
        Balance = balance;
    }

    private int Balance;


    Account ( String id, String name )
    {
        this.Id=id;
        this.Name=name;
    }
    Account ( String id, String name, int balance )
    {
        this.Id=id;
        this.Name=name;
        this.Balance=balance;
    }

    public String getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }

    public int getBalance() {
        return Balance;
    }

    public int credit( int amount) // withdraw
    {
        if (amount> getBalance())
            System.out.println("The amount that you asked for is not in Your balance account!");
        else {
            setBalance(getBalance()-amount) ;
            System.out.println("Your new account is "+getBalance());
        }

        return  getBalance();
    }

    public int debite( int amount)
    {

        System.out.println("Your account before the process is "+ getBalance());
            setBalance( amount + getBalance());
        System.out.println("Your account After the process is "+ getBalance());


        return  getBalance();
    }


    public int TransferTo( Account FirstAccount,Account anotherAccount, int amount)
    {

       if  (FirstAccount.getBalance()>amount) {
           FirstAccount.credit(amount);
           anotherAccount.debite(amount);
       }
       System.out.println("New balance in a new account is "+ anotherAccount.getBalance());
        return  getBalance();

    }


    public String Tostring ()
    {

        System.out.println(" Name:"+getName());
        System.out.println(" ID:" + getId());
        System.out.println(" balance:" + getBalance());

        return "";
    }

}
