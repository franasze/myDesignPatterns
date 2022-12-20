package com.apkaSklepu.model;

 public class Product {

    private int ilosc;
    private String brand;
    private String dataWaznosci;

    public Product(String brand,int ilosc,String dataWaznosci){
        this.brand = brand;
        this.ilosc = ilosc;
        this.dataWaznosci = dataWaznosci;
    }

    public Product(){

    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
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
                .append(this.getIlosc())
                .append(" products left, expires in ")
                .append(this.getDataWaznosci())
                .toString();
    }
}
