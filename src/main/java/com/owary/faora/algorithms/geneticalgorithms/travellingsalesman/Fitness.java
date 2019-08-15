package com.owary.faora.algorithms.geneticalgorithms.travellingsalesman;

import java.util.ArrayList;

public class Fitness implements Comparable<Fitness>{

    private ArrayList<City> route;
    private double distance;
    private double fitness;

    public Fitness(ArrayList<City> route) {
        this.route = route;
        this.distance = 0.0;
        this.fitness = 0.0;
        routeFitness();
    }

    public double routeDistance() {
        if (distance == 0.0) {
            double tmpDist = 0.0;
            City from;
            City to;
            for (int i = 0; i < route.size(); i++) {
                from = route.get(i);
                if (i+1 == route.size()){
                    to = route.get(0);
                }else {
                    to = route.get(i + 1);
                }
                tmpDist += from.distanceBetween(to);
            }
            distance = tmpDist;
        }
        return distance;
    }

    public double routeFitness() {
        return fitness == 0.0 ? fitness : 1 / routeDistance();
    }

    @Override
    public int compareTo(Fitness o) {
        if (o.fitness > this.fitness) {
            return -1;
        }else if (o.fitness < this.fitness) {
            return 1;
        }
        return 0;
    }

    public ArrayList<City> getRoute() {
        return route;
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "route=" + route +
                ", distance=" + distance +
                ", fitness=" + fitness +
                '}';
    }
}
