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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;
import org.terasology.math.algo.PathFinder.DefaultEdge;
import org.terasology.math.algo.PathFinder.Edge;
import org.terasology.math.algo.PathFinder.Path;


/**
 * Tests the {@link PathFinder} class.
 */
public class PathFinderTest {

    private final Vertex fra = new Vertex("Frankfurt");
    private final Vertex man = new Vertex("Mannheim");
    private final Vertex wrz = new Vertex("Wuerzburg");
    private final Vertex stu = new Vertex("Stuttgart");
    private final Vertex kas = new Vertex("Kassel");
    private final Vertex kar = new Vertex("Karlsruhe");
    private final Vertex erf = new Vertex("Erfurt");
    private final Vertex nrn = new Vertex("Nuernberg");
    private final Vertex aug = new Vertex("Augsburg");
    private final Vertex muc = new Vertex("Muenchen");
    private final Vertex lon = new Vertex("London");  // not in the graph

    private final Collection<Edge<Vertex>> edges = Collections.unmodifiableList(Arrays.asList(
        new DefaultEdge<Vertex>(fra, man, 85),
        new DefaultEdge<Vertex>(fra, wrz, 217),
        new DefaultEdge<Vertex>(fra, kas, 173),
        new DefaultEdge<Vertex>(man, kar, 80),
        new DefaultEdge<Vertex>(wrz, erf, 186),
        new DefaultEdge<Vertex>(wrz, nrn, 103),
        new DefaultEdge<Vertex>(stu, nrn, 183),
        new DefaultEdge<Vertex>(kar, aug, 250),
        new DefaultEdge<Vertex>(kas, muc, 502),
        new DefaultEdge<Vertex>(aug, muc, 84),
        new DefaultEdge<Vertex>(nrn, muc, 167)));

    @Test
    public void testUnconstrainedFraMuc() {
        PathFinder<Vertex> dijkstra = new PathFinder<Vertex>(edges, true);
        Path<Vertex> path = dijkstra.computePath(fra, muc, Double.MAX_VALUE).get();

        Assert.assertEquals(487, path.getLength(), 0.01);
        Assert.assertEquals(fra, path.getStart());
        Assert.assertEquals(fra, path.getSequence().get(0));
        Assert.assertEquals(wrz, path.getSequence().get(1));
        Assert.assertEquals(nrn, path.getSequence().get(2));
        Assert.assertEquals(muc, path.getEnd());
        Assert.assertEquals(muc, path.getSequence().get(3));

        Assert.assertEquals(path.getLength(), path.getDistance(muc), 0.01);
    }

    @Test
    public void testUndirectedMucFra() {
        PathFinder<Vertex> dijkstra = new PathFinder<Vertex>(edges, false);
        Path<Vertex> path = dijkstra.computePath(muc, fra, Double.MAX_VALUE).get();

        Assert.assertEquals(487, path.getLength(), 0.01);
        Assert.assertEquals(muc, path.getStart());
        Assert.assertEquals(wrz, path.getSequence().get(2));
        Assert.assertEquals(nrn, path.getSequence().get(1));
        Assert.assertEquals(fra, path.getEnd());
    }

    @Test
    public void testConstrainedFraMuc() {
        PathFinder<Vertex> dijkstra = new PathFinder<Vertex>(edges, true);
        Assert.assertFalse(dijkstra.computePath(fra, muc, 450).isPresent());
    }

    @Test
    public void testDirectedMucFra() {
        PathFinder<Vertex> dijkstra = new PathFinder<Vertex>(edges, true);
        Assert.assertFalse(dijkstra.computePath(muc, fra, Double.MAX_VALUE).isPresent());
    }

    @Test
    public void testDegenerated() {
        PathFinder<Vertex> dijkstra = new PathFinder<Vertex>(Collections.emptyList(), true);
        Assert.assertFalse(dijkstra.computePath(muc, fra, Double.MAX_VALUE).isPresent());

        Path<Vertex> singleVertexPath = dijkstra.computePath(muc, muc, Double.MAX_VALUE).get();
        Assert.assertEquals(muc, singleVertexPath.getStart());
        Assert.assertEquals(muc, singleVertexPath.getEnd());
        Assert.assertEquals(0, singleVertexPath.getLength(), 0);
    }

    @Test
    public void testDisconnected() {
        PathFinder<Vertex> dijkstra = new PathFinder<Vertex>(edges, true);
        Assert.assertFalse(dijkstra.computePath(muc, lon, Double.MAX_VALUE).isPresent());
        Assert.assertFalse(dijkstra.computePath(lon, fra, Double.MAX_VALUE).isPresent());
    }

    private static class Vertex {
        private final String name;

        public Vertex(String n) {
            this.name = n;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
