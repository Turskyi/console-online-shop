package internetStore;

public class Smartphone extends Product {
    private String storage;
    public Smartphone(String name, int price, String storage){
        super(name,price);
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Smartphone " +
                "storage: '" + storage + '\'' +
                " " + super.toString ( );
    }
}

