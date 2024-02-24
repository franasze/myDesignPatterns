package com.apkaSklepu.model;

public interface IProduct {

    int getQuantity();

    void setQuantity(int quantity);

    String getBrand();

    void setBrand(String brand);

    String getExpirationDate();

    void setExpirationDate(String expirationDate);

    String toString();
}
