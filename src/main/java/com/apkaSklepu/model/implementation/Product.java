package com.apkaSklepu.model.implementation;

import com.apkaSklepu.model.IProduct;

public sealed class Product implements IProduct permits Butter,Cheese,Eggs,Mustard,Milk  {

    private int quantity;
    private String brand;
    private String expirationDate;

    public Product(String brand,int quantity,String expirationDate){
        this.brand = brand;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

     @Override
    public int getQuantity() {
        return quantity;
    }
     @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     @Override
    public String getBrand() {
        return brand;
    }
     @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }
     @Override
    public String getExpirationDate() {
        return expirationDate;
    }
    @Override
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
     @Override
    public String toString(){
        return new StringBuilder()
                .append(this.getBrand())
                .append(",     ")
                .append(this.getQuantity())
                .append(" products left, expires in ")
                .append(this.getExpirationDate())
                .toString();
    }
}
