package internetStore;

public class Leptop extends Product{
    private int year;

    public Leptop(String name, int price,int year) {
        super (name, price);
        this.year = year;
    }

    @Override
    public String toString() {
        return "Leptop " +
                "year: " + year +
                " " + super.toString ( );
    }
}
