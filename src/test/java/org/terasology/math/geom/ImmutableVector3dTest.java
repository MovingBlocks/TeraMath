package org.terasology.math.geom;

/**
 * @author Immortius
 * @author Martin Steiger
 */
public class ImmutableVector3dTest extends BaseTuple3dTest {
    @Override
    protected Tuple3d createTuple3d(double x, double y, double z) {
        return new ImmutableVector3d(x, y, z);
    }
}
