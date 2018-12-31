package internetStore;

public class Shoes extends Product{
    private int size;

    public Shoes(String name, int price, int size) {
        super (name, price);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shoes " +
                "size: " + size +
                " " + super.toString ( );
    }
}