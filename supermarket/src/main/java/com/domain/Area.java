package com.domain;

public class Area {
    private int area_id;
    private int parent_id;
    private String name;

    public Area(int area_id, int parent_id, String name) {
        this.area_id = area_id;
        this.parent_id = parent_id;
        this.name = name;
    }

    public Area() {
    }

    @Override
    public String toString() {
        return "Area{" +
                "area_id=" + area_id +
                ", parent_id=" + parent_id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
