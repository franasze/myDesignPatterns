package com.apkaSklepu.database;

import com.apkaSklepu.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDB {

    private final List<Product> products = new ArrayList<>();
    private static final ProductDB instance = new ProductDB();

    private ProductDB(){
        this.products.add(new Butter("Masło",10,"20 days"));
        this.products.add(new Cheese("Ser",10,"12 days"));
        this.products.add(new Eggs("Jajka",10,"14 days"));
        this.products.add(new Milk("Mleko",10,"4 days"));
        this.products.add(new Mustard("Musztarda",10,"21 days"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public static ProductDB getInstance() {
        return instance;
    }

    public boolean buyProduct(String name, int quantity){
        Optional<Product> product = this.products.stream()
                .filter(p->p.getBrand().equals(name)).findFirst();

        if(product.isPresent() && quantity > 0 && product.get()
                .getIlosc() >= quantity){
            product.get().setIlosc(product.get().getIlosc() - quantity);
            return true;
        }
        return false;
    }
    public boolean changeProductQuantity(String name, int quantity){
        Optional<Product> product = this.products.stream()
                .filter(p->p.getBrand().equals(name)).findAny();
            if(product.isPresent() && product.get().getBrand().equals(name) && quantity >= 0 ){
                product.get().setIlosc(product.get().getIlosc()+quantity);
                return true;
            }
        return false;
    }


}
