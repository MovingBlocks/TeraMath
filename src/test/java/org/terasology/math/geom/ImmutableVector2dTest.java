package org.terasology.math.geom;

/**
 * @author Immortius
 */
public class ImmutableVector2dTest extends BaseTuple2dTest {
    @Override
    protected Tuple2d createTuple2d(double x, double y) {
        return new ImmutableVector2d(x, y);
    }
}
