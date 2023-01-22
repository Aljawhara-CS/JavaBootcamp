public abstract class Trip {

    public String getTripNumber() {
        return tripNumber;
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    private String tripNumber;
    private double distance;
    private double speed;

    public int getTime() {
        return time;
    }

    public int time;

    public String getStartTime() {
        return startTime;
    }

    private String startTime;

    public Trip(String tripNumber, double distance, double speed, String startTime) {
        this.tripNumber = tripNumber;
        this.distance = distance;
        this.speed = speed;
        this.startTime = startTime;
    }

    public abstract int calculateDuration();

    public double convertMinToHour(int min)
    {

        return min/60;
    }

    public String calculateArrivalTime()
    {
        double ArrivalTime=  distance/speed;
        this.time = (int)Math.round(ArrivalTime);

        String Text = ""+time;
        return Text;
    }








}
