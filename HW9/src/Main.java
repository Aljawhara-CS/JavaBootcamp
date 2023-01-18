public class Main {
    public static void main(String[] args) {


        Movie objmov= new Movie("The Last Of Us",150,"Neil Druckmann");
        System.out.println(" the movie is on sale for SR"+objmov.getDiscount());
       
        Book objbook= new Book("The Power of Now",60,"Eckhart Tolle");
        System.out.println(" the book is on sale for SR"+ objbook.getDiscount());
        MovablePoint objpo= new MovablePoint(60, 60, 90,  90);
        objpo.moveUp();
        objpo.moveDown();
        objpo.moveLeft();
        objpo.moveRight();


    }
}