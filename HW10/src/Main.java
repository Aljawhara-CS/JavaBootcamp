public class Main {
    public static void main(String[] args) {

        Train obj= new Train("123456789",500,3,"13");

        System.out.println("------ Trip info ------------- ");
        System.out.println("The ID number:"+obj.getTripNumber());
        System.out.println("The Speed on Train is :"+obj.getSpeed());
        System.out.println("The distance is:"+obj.getDistance());
        System.out.println("The Start time on:"+obj.getStartTime()+":00");
        System.out.println("The Arrival Time on: "+obj.calculateArrivalTime()+":00");
      //  System.out.println("Converting mints to hour:"+ obj.convertMinToHour(obj.getTime()) +" Hours");
        System.out.println("The duration is "+ obj.convertMinToHour(obj.calculateDuration()) + " Hours");
        System.out.println("The price will is "+ obj.Calculate_Price("VIP") );

        System.out.println("----------------------------- ");



    }
}