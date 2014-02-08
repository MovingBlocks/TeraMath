package org.terasology.math.geom.test;

import org.terasology.math.geom.ImmutableVector2d;
import org.terasology.math.geom.Tuple2d;

/**
 * @author Immortius
 */
public class ImmutableVector2dTest extends BaseTuple2dTest {
    @Override
    protected Tuple2d createTuple2d(double x, double y) {
        return new ImmutableVector2d(x, y);
    }
}
