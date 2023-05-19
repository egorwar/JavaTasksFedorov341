package org.example;

public class Sneakers {
    private String id;
    private Worker worker;
    private Sole sole;
    private String upperMaterial;

    public Sneakers(){}

    public Sneakers(String id, Worker worker, Sole sole, String upperMaterial){
        this.id = id;
        this.worker = worker;
        this.sole = sole;
        this.upperMaterial = upperMaterial;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public Worker getWorker(){
        return this.worker;
    }

    public void setWorker(Worker worker){
        this.worker = worker;
    }

    public Sole getSole(){
        return this.sole;
    }

    public void setSole(Sole sole){
        this.sole = sole;
    }

    public String getUpperMaterial(){
        return this.upperMaterial;
    }

    public void setUpperMaterial(String upperMaterial){
        this.upperMaterial = upperMaterial;
    }
}
