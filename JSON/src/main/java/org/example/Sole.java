package org.example;

public class Sole {
    private String material;
    private int size;

    private String producer;

    public Sole(){}

    public Sole(String material, int size, String producer){
        this.material = material;
        this.size = size;
        this.producer = producer;
    }

    public String getMaterial(){
        return this.material;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    public int getSize(){
        return this.size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public String getProducer(){
        return this.producer;
    }

    public void setProducer(String producer){
        this.producer = producer;
    }

}
