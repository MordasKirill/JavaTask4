package net.epam.study.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Dish {
    private String category;
    private String name;
    private String price;
    private String region;

    public Dish(){
        super();
    }
    public Dish(String name, String price, String region){
        this.name = name;
        this.price = price;
        this.region = region;
    }
    public Dish(String category, String name, String price, String region){
        this.category = category;
        this.name = name;
        this.price = price;
        this.region = region;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getRegion() {
        return region;
    }
    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return Objects.equals(getCategory(), dish.getCategory()) &&
                Objects.equals(getName(), dish.getName()) &&
                Objects.equals(getPrice(), dish.getPrice()) &&
                Objects.equals(getRegion(), dish.getRegion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory(), getName(), getPrice(), getRegion());
    }
}
