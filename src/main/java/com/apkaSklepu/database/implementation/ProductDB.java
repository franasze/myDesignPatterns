package com.apkaSklepu.database.implementation;

import com.apkaSklepu.database.IProductDB;
import com.apkaSklepu.model.*;
import com.apkaSklepu.model.implementation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDB implements IProductDB {

    private final List<IProduct> products = new ArrayList<>();
    private static final ProductDB instance = new ProductDB();

    private ProductDB() {
        this.products.add(new Butter("Butter", 10, "20 days"));
        this.products.add(new Cheese("Cheese", 10, "12 days"));
        this.products.add(new Eggs("Eggs", 10, "14 days"));
        this.products.add(new Milk("Milk", 10, "4 days"));
        this.products.add(new Mustard("Mustard", 10, "21 days"));
    }

    @Override
    public List<IProduct> getProducts() {
        return products;
    }

    @Override
    public boolean buyProduct(String name, int quantity) {
        Optional<IProduct> product = this.products.stream()
                .filter(p -> p.getBrand().equals(name)).findFirst();

        if (product.isPresent() && quantity > 0 && product.get()
                .getQuantity() >= quantity) {
            product.get().setQuantity(product.get().getQuantity() - quantity);
            return true;
        }
        return false;
    }

    @Override
    public boolean changeProductQuantity(String name, int quantity) {
        Optional<IProduct> product = this.products.stream()
                .filter(p -> p.getBrand().equals(name)).findAny();
        if (product.isPresent() && product.get().getBrand().equals(name) && quantity >= 0) {
            product.get().setQuantity(product.get().getQuantity() + quantity);
            return true;
        }
        return false;
    }

    public static ProductDB getInstance() {
        return instance;
    }

}
