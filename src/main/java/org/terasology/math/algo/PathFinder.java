/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.math.algo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Function;

/**
 * Performs single pair shortest path computations without heuristics. Based on the choice of cost
 * and heuristic function, this is equivalent to <b>Dijkstra's algorithm</b> (cost only, no heuristic),
 * <b>Best-First-Search</b> (no cost, heuristic only) and <b>A*</b> (both cost and heuristic).
 * As Best-First-Search ignores the distance already traveled it does not necessarily generate the shortest path.
 * <p>
 * Only monotonous heuristic functions that never over-estimate the distance to the end node can be used.
 * One prominent example is the Euclidean distance (the beeline).
 * Admissible function that are not monotonous are not supported.
 * @param <V> the vertex class
 */
public class PathFinder<V> {

    private final Function<V, ? extends Collection<? extends Edge<V>>> edgeFunc;

    /**
     * @param edges a collection of edges
     * @param directed true if the edges are directed
     */
    public PathFinder(Collection<? extends Edge<V>> edges, boolean directed) {

        Map<V, Collection<Edge<V>>> sourceMap = new HashMap<>();

        for (Edge<V> e : edges) {
            sourceMap.computeIfAbsent(e.getStart(), a -> new ArrayList<>()).add(e);
            if (!directed) {
                sourceMap.computeIfAbsent(e.getEnd(), a -> new ArrayList<>()).add(e);
            }
        }

        edgeFunc = e -> sourceMap.getOrDefault(e, Collections.emptySet());
    }

    /**
     * @param edgeFunc a function that maps a vertex to all connected edges. Must not return <code>null</code>
     *                 for every reachable vertex.
     */
    public PathFinder(Function<V, ? extends Collection<? extends Edge<V>>> edgeFunc) {
        this.edgeFunc = edgeFunc;
    }

    /**
     * Searches for the shortest path between two vertices.
     * Does not use a heuristic, i.e. it is equivalent to Dijkstra's algorithm.
     * @param start the start vertex
     * @param end the target vertex
     * @return the shortest path between the two, if it exists
     */
    public Optional<Path<V>> computePath(V start, V end) {
        return computePath(start, end, Double.MAX_VALUE, v -> 0d);
    }

    /**
     * Searches for the shortest path between two vertices up to a certain maximum distance around start.
     * A monotonous heuristic is used to estimate the distance to the end node.
     * This is equivalent to the A* algorithm if edge costs are sensible, Best-First-Search otherwise.
     * @param start the start vertex
     * @param end the target vertex
     * @param heuristic a heuristic function that estimates the cost to <code>end</code>.
     * @return the shortest path between the two, if it exists
     */
    public Optional<Path<V>> computePath(V start, V end, Function<V, Double> heuristic) {
        return computePath(start, end, Double.MAX_VALUE, heuristic);
    }

    /**
     * Searches for the shortest path between two vertices up to a certain maximum distance around start.
     * Does not use a heuristic, i.e. it is equivalent to Dijkstra's algorithm.
     * @param start the start vertex
     * @param end the target vertex
     * @param maxDist the threshold distance
     * @return the shortest path between the two, if it exists
     */
    public Optional<Path<V>> computePath(V start, V end, double maxDist) {
        return computePath(start, end, maxDist, v -> 0d);
    }

    /**
     * Searches for the shortest path between two vertices up to a certain maximum distance around start.
     * A monotonous heuristic is used to estimate the distance to the end node.
     * This is equivalent to the A* algorithm if edge costs are sensible, Best-First-Search otherwise.
     * The function must not over-estimate the distance to the end node.
     * @param start the start vertex
     * @param end the target vertex
     * @param maxDist the threshold distance
     * @param heuristic a heuristic function that estimates the cost to <code>end</code>.
     * @return the shortest path between the two, if it exists
     */
    public Optional<Path<V>> computePath(V start, V end, double maxDist, Function<V, Double> heuristic) {

        Map<V, Double> dists = new HashMap<>();

        Comparator<V> comp = (a, b) -> {
            Double distA = dists.get(a) + heuristic.apply(a);
            Double distB = dists.get(b) + heuristic.apply(b);
            return (int) (distA - distB);
        };

        PriorityQueue<V> queue = new PriorityQueue<V>(comp);      // also known as "Open List"

        Set<V> seen = new HashSet<>();                            // nodes that have been completed ("Closed List")
        Map<V, V> prevs = new HashMap<>();                        // shortest hops to the start node

        dists.put(start, 0d);
        queue.add(start);

        while (!queue.isEmpty()) {

            V v = queue.poll();                                   // vertex with smallest cost/distance

            if (!seen.contains(v))  {
                seen.add(v);

                double dist = dists.get(v);
                if (dist > maxDist) {                             // if closest vertex is too far away, abort now
                    return Optional.empty();
                }

                if (v.equals(end)) {
                    List<V> path = createPath(end, prevs);        // compute and return path if end node was found
                    return Optional.of(new Path<V>(path, dists));
                }

                Collection<? extends Edge<V>> edges = edgeFunc.apply(v);
                for (Edge<V> edge : edges) {
                    V dest = edge.getOther(v);                    // always edge.getEnd() for directed graphs

                    Double destDist = dists.get(dest);

                    double edgeCost = edge.getCost();             // TODO: compute only if destDist != null
                    if (edgeCost <= 0) {
                        throw new IllegalArgumentException("cost must be larger than 0");
                    }

                    // check if shorter path was found
                    if (destDist == null || destDist > dist + edgeCost) {
                        dists.put(dest, dist + edgeCost);
                        prevs.put(dest, v);
                        queue.add(dest);
                    }
                }
            }
        }
        return Optional.empty();
    }

    private List<V> createPath(V end, Map<V, V> prevs) {
        V p = end;
        ArrayList<V> path = new ArrayList<>();
        // iterating from end to start
        while (p != null) {
            path.add(p);
            p = prevs.get(p);
        }
        Collections.reverse(path);
        return path;
    }

    public static final class Path<V> {

        private final List<V> sequence;                      // unmodifiable!
        private final Map<V, Double> distances;              // unmodifiable!

        Path(List<V> path, Map<V, Double> dists) {
            this.distances = Collections.unmodifiableMap(dists);
            this.sequence = Collections.unmodifiableList(path);
        }

        /**
         * @return the full length of the path
         */
        public double getLength() {
            return distances.get(getEnd());
        }

        /**
         * @return the first entry of the sequence
         */
        public V getStart() {
            return sequence.get(0);
        }

        /**
         * @return the last entry of the sequence
         */
        public V getEnd() {
            return sequence.get(sequence.size() - 1);
        }

        /**
         * @return the entire path sequence (unmodifiable)
         */
        public List<V> getSequence() {
            return sequence;
        }

        /**
         * Returns the distance between a given vertex and the start vertex.
         * @param v the vertex of interest
         * @return the distance to start
         * @throws IllegalArgumentException if <code>v</code> does not lie on the path and no entry is present
         */
        public double getDistance(V v) {
            Double dist = distances.get(v);
            if (dist == null) {
                throw new IllegalArgumentException("Vertex '" + v + "' does not lie on the path");
            }
            return dist.doubleValue();
        }
    }

    /**
     * Describes a weighted edge. No assumptions on directions are made.
     * @param <V> the vertex class
     */
    public interface Edge<V> {

        /**
         * @return one end of the vertex / the start vertex for directed edges
         */
        V getStart();

        /**
         * @return one end of the vertex / the end vertex for directed edges
         */
        V getEnd();

        /**
         * @param v one vertex of the edge
         * @return the opposing vertex of the edge
         * @throws IllegalArgumentException e if <code>v</code> is not part of the edge
         */
        default V getOther(V v) {
            if (getStart().equals(v)) {
                return getEnd();
            }
            if (getEnd().equals(v)) {
                return getStart();
            }
            throw new IllegalArgumentException("Vertex not part of the edge");
        }

        /**
         * @return a positive number that describes the weight/cost/length of the edge
         */
        double getCost();
    }

    /**
     * The default implementation of {@link PathFinder.Edge}.
     * Stores all parameter in fields and provides them through getters.
     * @param <V> the vertex class.
     */
    public static class DefaultEdge<V> implements Edge<V> {

        private final V source;
        private final V dest;
        private final double cost;

        public DefaultEdge(V source, V dest, double cost) {
            if (cost <= 0) {
                throw new IllegalArgumentException("cost must be larger than 0");
            }

            this.source = source;
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public V getStart() {
            return source;
        }

        @Override
        public V getEnd() {
            return dest;
        }

        @Override
        public double getCost() {
            return cost;
        }
    }
}
