package edu.upc.eetac.dsa.models;

public class Product {
    private String productId;
    private String name;
    private double price;
    private double sales;

    public String getProductId(){
        return this.productId;
    }
    public double getPrice(){
        return this.price;
    }
    public String getDescription(){
        return this.name;
    }
    public double getNumSales(){
        return this.sales;
    }
}
