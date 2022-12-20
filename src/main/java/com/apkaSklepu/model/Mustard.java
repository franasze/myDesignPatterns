package com.apkaSklepu.model;

public class Mustard extends Product{

    public Mustard(String brand,int ilosc,String dataWaznosci){
        super(brand, ilosc, dataWaznosci);
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append(this.getBrand())
                .append(", ")
                .append(this.getIlosc())
                .append(" products left, expires in ")
                .append(this.getDataWaznosci())
                .toString();
    }
}
