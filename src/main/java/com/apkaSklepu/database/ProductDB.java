package com.apkaSklepu.database;

import com.apkaSklepu.model.*;

public class ProductDB {

    private final Product[] products = new Product[5];

    private static final ProductDB instance = new ProductDB();

    private ProductDB(){
        this.products[0] = new Butter("Masło",10,"20 days");
        this.products[1] = new Cheese("Ser",10,"12 days");
        this.products[2] = new Eggs("Jajka",10,"14 days");
        this.products[3] = new Milk("Mleko",10,"4 days");
        this.products[4] = new Mustard("Musztarda",10,"21 days");
    }
    public Product[] getProducts() {
        return products;
    }

    public static ProductDB getInstance() {
        return instance;
    }

    public boolean buyProduct(String name, int quantity){
        for(Product product : this.products){
            if(product.getBrand().equals(name) &&
                    (quantity >= 0 && quantity <= product.getIlosc())){
                product.setIlosc(product.getIlosc()-quantity);
                return true;
            }
        }
        return false;
    }
    public boolean changeProductQuantity(String name, int quantity){
        for(Product product : this.products){
            if(product.getBrand().equals(name) && quantity >= 0 ){
                product.setIlosc(product.getIlosc()+quantity);
                return true;
            }
        }
        return false;
    }



}
