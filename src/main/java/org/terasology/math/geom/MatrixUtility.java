/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.math.geom;

import java.nio.FloatBuffer;

/**
 * Collection of matrix utilities.
 *
 */
public final class MatrixUtility {

    private MatrixUtility() {
    }

    public static Matrix4f createViewMatrix(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        return createViewMatrix(new Vector3f(eyeX, eyeY, eyeZ), new Vector3f(centerX, centerY, centerZ), new Vector3f(upX, upY, upZ));
    }

    public static Matrix4f createViewMatrix(Vector3f eye, Vector3f center, Vector3f up) {
        Matrix4f m = new Matrix4f();

        Vector3f f = new Vector3f();
        f.sub(center, eye);

        f.normalize();
        up.normalize();

        Vector3f s = new Vector3f();
        s.cross(f, up);
        s.normalize();

        Vector3f u = new Vector3f();
        u.cross(s, f);
        u.normalize();

        m.m00 = s.x;
        m.m10 = s.y;
        m.m20 = s.z;
        m.m30 = 0;
        m.m01 = u.x;
        m.m11 = u.y;
        m.m21 = u.z;
        m.m31 = 0;
        m.m02 = -f.x;
        m.m12 = -f.y;
        m.m22 = -f.z;
        m.m32 = 0;
        m.m03 = 0;
        m.m13 = 0;
        m.m23 = 0;
        m.m33 = 1;

        m.m30 = -eye.x;
        m.m31 = -eye.y;
        m.m32 = -eye.z;

        m.transpose();

        return m;
    }

    public static Matrix4f createOrthogonalProjectionMatrix(float left, float right, float top, float bottom, float near, float far) {
        Matrix4f m = new Matrix4f();

        float lateral = right - left;
        float vertical = top - bottom;
        float forward = far - near;
        float tx = -(right + left) / (right - left);
        float ty = -(top + bottom) / (top - bottom);
        float tz = -(far + near) / (far - near);

        m.m00 = 2.0f / lateral;
        m.m10 = 0.0f;
        m.m20 = 0.0f;
        m.m30 = tx;
        m.m01 = 0.0f;
        m.m11 = 2.0f / vertical;
        m.m21 = 0.0f;
        m.m31 = ty;
        m.m02 = 0.0f;
        m.m12 = 0.0f;
        m.m22 = -2.0f / forward;
        m.m32 = tz;
        m.m03 = 0.0f;
        m.m13 = 0.0f;
        m.m23 = 0.0f;
        m.m33 = 1.0f;

        m.transpose();

        return m;
    }

    public static Matrix4f createPerspectiveProjectionMatrix(float fovY, float aspectRatio, float zNear, float zFar) {
        Matrix4f m = new Matrix4f();

        float f = 1.0f / (float) Math.tan(fovY * 0.5f);

        m.m00 = f / aspectRatio;
        m.m10 = 0;
        m.m20 = 0;
        m.m30 = 0;
        m.m01 = 0;
        m.m11 = f;
        m.m21 = 0;
        m.m31 = 0;
        m.m02 = 0;
        m.m12 = 0;
        m.m22 = (zFar + zNear) / (zNear - zFar);
        m.m32 = (2 * zFar * zNear) / (zNear - zFar);
        m.m03 = 0;
        m.m13 = 0;
        m.m23 = -1;
        m.m33 = 0;

        m.transpose();

        return m;
    }

    public static Matrix3f calcNormalMatrix(Matrix4f mv) {
        Matrix3f result = new Matrix3f();
        result.m00 = mv.m00;
        result.m10 = mv.m10;
        result.m20 = mv.m20;
        result.m01 = mv.m01;
        result.m11 = mv.m11;
        result.m21 = mv.m21;
        result.m02 = mv.m02;
        result.m12 = mv.m12;
        result.m22 = mv.m22;

        result.invert();
        result.transpose();
        return result;
    }
}
