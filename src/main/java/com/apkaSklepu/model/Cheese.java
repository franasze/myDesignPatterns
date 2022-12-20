package com.apkaSklepu.model;

public class Cheese extends Product{

    public Cheese(String brand,int ilosc,String dataWaznosci){
        super(brand, ilosc, dataWaznosci);
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append(this.getBrand())
                .append(",       ")
                .append(this.getIlosc())
                .append(" products left, expires in ")
                .append(this.getDataWaznosci())
                .toString();
    }
}
