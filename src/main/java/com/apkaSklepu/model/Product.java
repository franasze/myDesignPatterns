package com.apkaSklepu.model;

 public sealed class Product permits Butter,Cheese,Eggs,Mustard,Milk{

    private int quantity;
    private String brand;
    private String expirationDate;

    public Product(String brand,int quantity,String expirationDate){
        this.brand = brand;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

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
