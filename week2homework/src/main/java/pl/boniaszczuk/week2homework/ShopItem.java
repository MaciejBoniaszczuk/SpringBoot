package pl.boniaszczuk.week2homework;

import java.math.BigDecimal;

public class ShopItem {
    private String name;
    private BigDecimal price;

    public ShopItem(String name, BigDecimal price) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
