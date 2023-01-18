public abstract class Product {

    private  String name;
    private double price;

    public Product() {
        this.name = name;
        this.price = price;
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount(){


        //25%
        double percentage= 0.20;
        double subtract= percentage*getPrice();
        double discount=getPrice()-subtract;

        return discount;
    }



}
