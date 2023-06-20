package com.apkaSklepu.model;

public final class Mustard extends Product{

    public Mustard(String brand,int quantity,String dataWaznosci){
        super(brand, quantity, dataWaznosci);
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append(this.getBrand())
                .append(", ")
                .append(this.getQuantity())
                .append(" products left, expires in ")
                .append(this.getDataWaznosci())
                .toString();
    }
}
