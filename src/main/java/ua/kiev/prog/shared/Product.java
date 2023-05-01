package ua.kiev.prog.shared;

import java.util.ArrayList;
import java.util.List;

public class Product {
    @Id
    private int id;

    private String name;
    private String vendorCode;
    private double price;

    public Product() {
    }

    public Product(String name, String vendorCode, double price) {
        this.name = name;
        this.vendorCode = vendorCode;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static List<Product> randomBDProducts() {
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Product p = new Product("prod" + i, "12345" + i * 10, 200.5 + i * 10);
            list.add(p);
        }
        return list;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vendorCode=" + vendorCode +
                ", price=" + price +
                '}';
    }
}
