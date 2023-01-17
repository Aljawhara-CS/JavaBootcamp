public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Shape obj= new Shape();
        System.out.println(obj.tostring());


        Circle objci = new Circle("Red",false,2.2);
        System.out.println(" Circle Area:" +objci.getArea());
        System.out.println(" Circle Area:" +objci.getPerimeter());
        objci.tostring();



        Rectangle objre= new Rectangle("black",true,2,4);
        System.out.println(" Rectangle Area:" +objre.getArea());
        System.out.println(" Rectangle Area:" +objre.getPerimeter());
        System.out.println( objre.tostring());


        Square objseq= new Square("black",true,2);
        System.out.println(" Square Area:" +objseq.getArea());
        System.out.println(" Square Perimeter:" +objseq.getPerimeter());
        objseq.tostring();







    }
}