public class Rectangle extends Shape {


    private double width;
    private  double length;

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }


    public Rectangle() {
        this.width = 1.0;
        this.length = 1.0;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }


    public double getArea()
    {
       double Area= getLength()*getWidth();
        return Area;

    }

    public double getPerimeter()
    {
        //محيط المستطيل = 2 × (الطول + العرض)

        double Perimeter= (getWidth()+getLength())*2;

        return Perimeter;

    }
    public String tostring() {

        String text = "A Rectangle with width "+ getWidth()+" and length="+ getLength()+", which is a subclass of "
                + super.tostring();

        return text;
    }



}
