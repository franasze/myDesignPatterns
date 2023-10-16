package com.apkaSklepu.model;

public final class Mustard extends Product{

    public Mustard(String brand,int quantity,String expirationDate){
        super(brand, quantity, expirationDate);
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append(this.getBrand())
                .append(", ")
                .append(this.getQuantity())
                .append(" products left, expires in ")
                .append(this.getExpirationDate())
                .toString();
    }
}
