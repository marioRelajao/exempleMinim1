package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Order;
import edu.upc.eetac.dsa.models.Product;
import edu.upc.eetac.dsa.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class ProductManagerImpl  implements ProductManager{
    List<Product> products;
    HashMap<String, User> users;
    Queue<Order> orders;

    @Override
    public List<Product> productsByPrice() {
        List<Product> list = new ArrayList<>(this.products);
        list.sort((Product p1, Product p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        return list;
    }

    public List<Product> productsBySales(){
        List<Product> list = new ArrayList<>(this.products);
        list.sort((Product p1, Product p2) -> Double.compare(p1.getNumSales(), p2.getNumSales()));
        return list;
    }

    @Override
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public Order processOrder() {
        Order o = this.orders.poll();
        String userID = o.getUserId();
        User user = this.getUser(userID);
        user.addOrder(o);

        for(Order.LP lp: o.lps()){
            incNumSales(lp.getProductId(), lp.getQuantity());
        }
        return o;
    }

    @Override
    public List<Order> ordersByUser(String userId) {
        User user = this.users.get(userId);
        return user.orders();
    }

    @Override
    public void addUser(String s, String name, String surname) {
        this.users.add(s,name,surname);
    }

    @Override
    public void addProduct(String productId, String name, double price) {
        this.products.add(productId,name);
    }

    @Override
    public Product getProduct(String productId) {
        return this.products.get(productId);
    }

    @Override
    public int numUsers() {
        return 0;
    }

    @Override
    public int numProducts() {
        return 0;
    }

    @Override
    public int numOrders() {
        return 0;
    }

    @Override
    public int numSales(String b001) {
        return 0;
    }

}
