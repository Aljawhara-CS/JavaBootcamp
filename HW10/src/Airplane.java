public class Airplane extends Trip {

    private double price;

    public Airplane(String tripNumber, double distance, double speed, String startTime, double price) {
        super(tripNumber, distance, speed, startTime);
        this.price = price;
    }


    public double Calculate_Price (String Trip_type)
    {
        // pouns
        this.price=2000;

        if (Trip_type=="First Class")
            this.price= price+15000;
        if (Trip_type=="Business Class")
            this.price= price+3500;
        else  if (Trip_type=="Economy Class")
            this.price=price;

        return price;
    }


    @Override
    public int calculateDuration() {

        int Start= Integer.parseInt(getStartTime());
        int End=Integer.parseInt(calculateArrivalTime());

        //difference of finishing time and starting time
        return End-Start;    }
}
