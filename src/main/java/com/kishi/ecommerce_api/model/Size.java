package com.kishi.ecommerce_api.model;

public class Size {

    private  String name;
    private int quantity;


    public Size(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void  setQuantity(int quantity){
        this.quantity=quantity;
    }
}
