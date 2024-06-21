package com.domain;

public class Product {
    private int id;
    private String name;
    private double purchasePrice;
    private double price;
    private String sort;
    private int inventory;
    private int number;
    private String url;

    private int status;

    public Product(int id, String name, double purchasePrice, double price, String sort, int inventory, int number, String url, int status) {
        this.id = id;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.price = price;
        this.sort = sort;
        this.inventory = inventory;
        this.number = number;
        this.url = url;
        this.status = status;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", price=" + price +
                ", sort='" + sort + '\'' +
                ", inventory=" + inventory +
                ", number=" + number +
                ", url='" + url + '\'' +
                ", status=" + status +
                '}';
    }
}
