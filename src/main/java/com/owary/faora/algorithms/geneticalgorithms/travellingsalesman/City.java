package com.owary.faora.algorithms.geneticalgorithms.travellingsalesman;

public class City {

    private double x;
    private double y;

    private String name;

    public City(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public City(String name) {
        this.name = name;
    }

    public double distanceBetween(City city){
        double a1 = city.x - this.x;
        double a2 = city.y - this.y;
        return Math.sqrt(a1*a1 + a2*a2);
    }

    public static City withName(String name) {
        return new City(name);
    }

    public City withCoords(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public String toString() {
        return "City{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
