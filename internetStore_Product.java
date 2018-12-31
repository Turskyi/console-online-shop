package internetStore;

import java.io.Serializable;

public abstract class Product implements Serializable {
   private String name;
   private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return  name +
                ", price : " + price;
    }
}