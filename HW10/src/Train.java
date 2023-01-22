public class Train extends Trip {

    private double price;

    public Train(String tripNumber, double distance, double speed, String startTime) {
        super(tripNumber, distance, speed, startTime);
        this.price = price;
    }

    public double Calculate_Price (String Trip_type)
    {
        // pouns
        this.price=1000;

 if (Trip_type=="VIP")
     this.price= price+500;
 else  if (Trip_type=="Economy")
     this.price=price;

     return price;
    }

    @Override
    public int calculateDuration() {

        int Start= Integer.parseInt(getStartTime());
        int End=Integer.parseInt(calculateArrivalTime());

        //difference of finishing time and starting time
        return End-Start;
    }
}
