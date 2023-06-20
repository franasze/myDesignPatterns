package com.apkaSklepu.model;

 public sealed class Product permits Butter,Cheese,Eggs,Mustard,Milk{

    private int quantity;
    private String brand;
    private String dataWaznosci;

    public Product(String brand,int quantity,String dataWaznosci){
        this.brand = brand;
        this.quantity = quantity;
        this.dataWaznosci = dataWaznosci;
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

    public String getDataWaznosci() {
        return dataWaznosci;
    }

    public void setDataWaznosci(String dataWaznosci) {
        this.dataWaznosci = dataWaznosci;
    }

    public String toString(){
        return new StringBuilder()
                .append(this.getBrand())
                .append(",     ")
                .append(this.getQuantity())
                .append(" products left, expires in ")
                .append(this.getDataWaznosci())
                .toString();
    }
}
