public class Circle extends Shape{


    private double radius;

    public Circle(String color, boolean filled, double radius) {

        super(color, filled);
        this.radius = radius;
    }
    public Circle(double radius) {

        this.radius = radius;
    }

    public Circle() {

        this.radius = 1.0;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea()
    {
        double PI = 3.142;
        return PI * (getRadius()*getRadius());

    }

    public double getPerimeter()
    {
        double PI = 3.142;

        double Perimeter=(2*getRadius()*PI);
        return Perimeter;

    }

    @Override
    public String tostring() {

        System.out.println("A Circle with radius="+ getRadius()+" which is a subclass of " + super.tostring());
        return "";
    }
}
