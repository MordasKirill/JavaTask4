package net.epam.study.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Dish {
    private String category;
    private String name;
    private String price;
    private String filingTime;
    private String region;

    public Dish(){
        super();
    }
    public Dish(String name, String price, String filingTime, String region){
        this.name = name;
        this.price = price;
        this.filingTime = filingTime;
        this.region = region;
    }
    public Dish(String category, String name, String price, String filingTime, String region){
        this.category = category;
        this.name = name;
        this.price = price;
        this.filingTime = filingTime;
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

    public String getFilingTime() {
        return filingTime;
    }
    public String getRegion() {
        return region;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setFilingTime(String filingTime) {
        this.filingTime = filingTime;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Dish details [" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", filing time='" + filingTime + '\'' +
                ", region='" + region + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return Objects.equals(getCategory(), dish.getCategory()) &&
                Objects.equals(getName(), dish.getName()) &&
                Objects.equals(getPrice(), dish.getPrice()) &&
                Objects.equals(getFilingTime(), dish.getFilingTime()) &&
                Objects.equals(getRegion(), dish.getRegion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory(), getName(), getPrice(), getFilingTime(), getRegion());
    }
}
