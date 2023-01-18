public class MovablePoint implements Movable{


    private int x;
    private int y;
    private  int xSpeed;
    private  int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {

         this.y = this.y-this.ySpeed;
        System.out.println(" Move Y Up="+y);


    }

    @Override
    public void moveDown() {

        this.y= this.y+this.ySpeed;
        System.out.println(" Move Y Down="+y);

    }

    @Override
    public void moveLeft() {
        this.x= this.x-this.xSpeed;
        System.out.println(" Move X Left="+x);


    }

    @Override
    public void moveRight() {
        this.x= this.x+this.xSpeed;
        System.out.println(" Move X Right="+x);



    }
}
