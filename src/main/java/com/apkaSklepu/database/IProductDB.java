package com.apkaSklepu.database;

import com.apkaSklepu.model.IProduct;

import java.util.List;

public interface IProductDB {
    List<IProduct> getProducts();

    boolean buyProduct(String name, int quantity);

    boolean changeProductQuantity(String name, int quantity);

}
