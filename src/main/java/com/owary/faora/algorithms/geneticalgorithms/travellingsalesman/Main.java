package com.owary.faora.algorithms.geneticalgorithms.travellingsalesman;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.*;

public class Main {

    public static ArrayList<City> createRoutesFrom(ArrayList<City> cities){
        ArrayList<City> newList = new ArrayList<>(cities);
        Collections.copy(newList, cities);
        Collections.shuffle(newList, new SecureRandom());
        return newList;
    }

    public static ArrayList<ArrayList<City>> initialPopulation(int popSize, ArrayList<City> cities) {
        ArrayList<ArrayList<City>> routes = new ArrayList<>();
        for (int i = 0; i < popSize; i++) {
            routes.add(createRoutesFrom(cities));
        }
        return routes;
    }

    public static Map<Integer, Fitness> rankRoutes(ArrayList<ArrayList<City>> population) {
        Map<Integer, Fitness> indexFitnessMap = new TreeMap<>();

        for (int i = 0; i < population.size(); i++) {
            indexFitnessMap.put(i, new Fitness(population.get(i)));
        }
        return indexFitnessMap;
    }

    public static ArrayList<Fitness> selection(Map<Integer, Fitness> popRanked, int eliteSize){
        TreeMap<Integer, Fitness> ranked = (TreeMap<Integer, Fitness>) popRanked;
        ArrayList<Fitness> selected = new ArrayList<>();
        for (int i = 0; i < eliteSize; i++) {
            selected.add(ranked.pollFirstEntry().getValue());
        }
        return selected;
    }

    public static ArrayList<City> breed(ArrayList<City> parent1, ArrayList<City> parent2) {
        Random random = new Random();

        City[] child = new City[parent1.size()];

        City[] childC1 = new City[parent1.size()];
        City[] childC2 = new City[parent2.size()];

        int a = random.nextInt(parent1.size());
        int b = random.nextInt(parent1.size());

        int st = Math.min(a, b);
        int end = Math.max(a, b);

        if (st == end) {
            if (end < parent1.size()-1) {
                end++;
            }else if (st >= 1) {
                st--;
            }
        }

        for (int i = st; i <= end; i++) {
            childC1[i] = parent1.get(i);
        }

        ArrayList<City> parent2Copy = new ArrayList<>(parent2);
        Collections.copy(parent2Copy, parent2);

        parent2Copy.removeAll(Arrays.asList(childC1));
        Iterator<City> iterator = parent2Copy.iterator();

        int ix = 0;
        while (iterator.hasNext()) {
            City next = iterator.next();
            if (ix >= st && ix <= end) {
                ix = end+1;
            }
            childC2[ix] = next;
            ix++;
        }

        for (int i = 0; i < childC1.length; i++) {
            City ch = childC1[i] == null ? childC2[i] : childC1[i];
            child[i] = ch;
        }
        return new ArrayList<>(Arrays.asList(child));
    }

    public static ArrayList<ArrayList<City>> breedPopulation(ArrayList<ArrayList<City>> matingPool, int eliteSize) {
        ArrayList<ArrayList<City>> children = new ArrayList<>();

        for (int i = 0; i < eliteSize; i++) {
            children.add(matingPool.get(i));
        }

        Collections.shuffle(matingPool);

        for (int i = 0; i < matingPool.size(); i++) {
            ArrayList<City> breed = breed(matingPool.get(i), matingPool.get(matingPool.size() - i - 1));
            children.add(breed);
        }

        return children;
    }

    public static ArrayList<City> mutate(ArrayList<City> individual, double mutationRate) {
        Random random = new Random();
        for (int swapped = 0; swapped < individual.size(); swapped++) {
            if (random.nextDouble() < mutationRate ){
                int swapWith = random.nextInt(individual.size());

                City cSwapped = individual.get(swapped);
                City cSwapWith = individual.get(swapWith);

                individual.set(swapped, cSwapWith);
                individual.set(swapWith, cSwapped);
            }
        }
        return individual;
    }

    public static ArrayList<ArrayList<City>> mutatePopulation(ArrayList<ArrayList<City>> population, double mutationRate) {
        ArrayList<ArrayList<City>> mutated = new ArrayList<>();
        for (ArrayList<City> cities : population) {
            ArrayList<City> mutate = mutate(cities, mutationRate);
            mutated.add(mutate);
        }
        return mutated;
    }

    public static ArrayList<ArrayList<City>> nextGen(ArrayList<ArrayList<City>> population, int eliteSize, double mutationRate) {
        Map<Integer, Fitness> popRanked     = rankRoutes(population);
        ArrayList<Fitness> selection        = selection(popRanked, eliteSize);

        ArrayList<ArrayList<City>> matingPool = new ArrayList<>();
        for (Fitness fitness : selection) {
            matingPool.add(fitness.getRoute());
        }

        ArrayList<ArrayList<City>> children = breedPopulation(matingPool, eliteSize);
        return mutatePopulation(children, mutationRate);
    }

    public static void geneticAlgo(ArrayList<City> population, int popsize, int eliteSize, double mutationRate, int generations) {
        ArrayList<ArrayList<City>> popul = initialPopulation(popsize, population);

        printDistance("Initial distance", popul.get(0));

        for (int i = 0; i < generations; i++) {
            popul = nextGen(popul, eliteSize, mutationRate);
        }

        printDistance("Final distance", popul.get(0));
    }

    public static void printDistance(String message, ArrayList<City> cities) {
        double total = 0.0;
        for (int i = 0; i < cities.size(); i++) {
            City from  = cities.get(i);
            City to;
            if (i+1 == cities.size()) {
                to = cities.get(0);
            }else {
                to = cities.get(i+1);
            }
            total += from.distanceBetween(to);
        }
        System.out.println(message + " - " + total);
    }

    public static void main(String[] args) {
        Random random = new Random();
//        City c1 = City.withName("a").withCoords(random.nextDouble(), random.nextDouble());
//        City c2 = City.withName("b").withCoords(random.nextDouble(), random.nextDouble());
//        City c3 = City.withName("c").withCoords(random.nextDouble(), random.nextDouble());
//        City c4 = City.withName("d").withCoords(random.nextDouble(), random.nextDouble());
//        City c5 = City.withName("e").withCoords(random.nextDouble(), random.nextDouble());
//        City c6 = City.withName("f").withCoords(random.nextDouble(), random.nextDouble());

        City ca = new City("a",160,189);
        City cb = new City("b",170,188);
        City cc = new City("c",104,118);
        City cd = new City("d",63,149);
        City ce = new City("e",63,177);
        City cf = new City("f",33,185);
        City cg = new City("g",27,178);
        City ch = new City("h",4,180);
        City ci = new City("i",35,118);
        City cj = new City("j",36,37);
        City ck = new City("k",20,9);
        City cl = new City("l",68,26);
        City cm = new City("m",78,22);
        City cn = new City("n",109,49);
        City co = new City("o",131,9);
        City cp = new City("p",176,15);
        City cq = new City("q",139,48);
        City cr = new City("r",139,65);
        City cs = new City("s",160,70);
        City ct = new City("t",191,57);
        City cu = new City("u",181,90);
        City cv = new City("v",195,139);
        City cw = new City("w",197,185);
        City cx = new City("x",184,178);
        City cy = new City("y",176,187);

//        System.out.println(Arrays.asList(   ca, cb, cc, cd, ce, cf,
//                                            cg, ch, ci, cj, ck, cl,
//                                            cm, cn, co, cp, cq, cr,
//                                            cs, ct, cu, cv, cw, cx,
//                                            cy));

        List<City> clist = Arrays.asList(   ca, cb, cc, cd, ce, cf,
                                            cg, ch, ci, cj, ck, cl,
                                            cm, cn, co, cp, cq, cr,
                                            cs, ct, cu, cv, cw, cx,
                                            cy);

        geneticAlgo(new ArrayList<>(clist), 100, 20, 0.6, 500);

    }

}
