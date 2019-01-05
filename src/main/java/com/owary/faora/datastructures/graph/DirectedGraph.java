package com.owary.faora.datastructures.graph;

import com.owary.faora.datastructures.queue.Queue;

import java.util.*;

public class DirectedGraph implements Graph{

    private List<Vertex> vertices;

    public DirectedGraph(){
        this.vertices = new ArrayList<>();
    }

    public void addVertice(Vertex v){
        this.vertices.add(v);
    }

    public List<List<Vertex>> breathFirstSearch(Vertex start){
        // waiting queue
        Queue<Vertex> waitingToBeVisited = new Queue<>(vertices.size());
        // we add the neighbours of start vertex to the queue
        waitingToBeVisited.enqueue(start.getNeighbours());

        // map structure to store levels
        Map<Vertex, Integer> levels = new HashMap<>();
        levels.put(start, 0);
        for (Object v : start.getNeighbours()){
            Vertex vv = (Vertex) v;
            levels.put(vv, 1);
        }

        // real BFS section
        // while there exists an element in queue, continue
        while(!waitingToBeVisited.isEmpty()){
            // pop the last element of queue
            Vertex v = waitingToBeVisited.dequeue();
            // mark it visited
            v.isVisited();
            // loop over its neighbours
            for (Object a : v.getNeighbours()){
                Vertex b = (Vertex) a;
                // if we haven't already visited the neighbour
                if(!b.visited() && !waitingToBeVisited.contains(b)){
                    // enqueue in the waiting queue
                    waitingToBeVisited.enqueue(b);
                    // get its parent's level and add 1, cause the level of the vertex is +1 its parent's
                    Integer lev = levels.get(v)+1;
                    // add it to the levels map
                    levels.put(b, lev);
                }
            }
        }

        // prepare the result
        /**
         * it is a list of the structure as such
          [
            0 : [Vertex]
            1 : [Vertices]
            2 : [Vertices]
            ....
         ]
         where indices correspond to certain levels and the vertices in that level
         0th index contains only the start vertex
         */
        List<List<Vertex>> list = new ArrayList<>();

        // loop over the key set
        levels.keySet().forEach(e->{
            // get the level of the element from map
            Integer lvl = levels.get(e);
            // check if the level is already added to the list, if not, exception is thrown
            try {
                // if index exists, add vertex to its list
                if (list.get(lvl) != null) {
                    list.get(lvl).add(e);
                }
            }catch (IndexOutOfBoundsException ex){
                // if index doesn't exist, create a list and add vertex to it
                List<Vertex> ll = new ArrayList<>();
                ll.add(e);
                // add it to the final list
                list.add(lvl, ll);
            }
        });
        return list;
    }

    @Override
    public void depthFirstSearch(Vertex start) {

    }

}
