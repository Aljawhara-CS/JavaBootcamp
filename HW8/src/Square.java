public class Square extends Rectangle {

    public double getSide() {
        return getWidth();
    }

    public void setSide(double width) {
        setWidth(width);
    }

    private double side;
    public Square(String color, boolean filled, double side) {
        super(color, filled, side,side);
    }

    public Square(double side) {
        setWidth(side);
    }


    public Square() {
        getWidth();

    }
    public double getArea()
    {
        double Area= getSide()*getSide();
        return Area;

    }

    public double getPerimeter()
    {

        double Perimeter= (getSide())*4;

        return Perimeter;

    }
   public String tostring()

    {

        System.out.println("A Square with side="+ getSide() +" which is a subclass of " + super.tostring());

        return "";
    }


}
