public class Car extends Trip{

    private double price;

    public Car(String tripNumber, double distance, double speed, String startTime, double price) {
        super(tripNumber, distance, speed, startTime);
        this.price = price;
    }

    public double Calculate_Price (String Trip_type)
    {
        // pouns
        this.price=2000;

        if (Trip_type=="Rent")
            this.price= price+15000;


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
