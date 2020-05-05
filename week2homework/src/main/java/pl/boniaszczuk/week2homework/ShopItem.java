package pl.boniaszczuk.week2homework;

public class ShopItem {
    private String name;
    private double price;

    public ShopItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public ShopItem() {
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

    @Override
    public String toString() {
        return "ShopItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
