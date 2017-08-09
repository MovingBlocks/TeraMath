package com.badlogic.gdx.math;

import java.io.Serializable;

public class Vector4 implements Serializable, Vector<Vector4>{


    public float x;
    public float y;
    public float z;
    public float w;
    public static final Vector4 X = new Vector4(1.0F, 0.0F, 0.0F, 0.0F);
    public static final Vector4 Y = new Vector4(0.0F, 1.0F, 0.0F, 0.0F);
    public static final Vector4 Z = new Vector4(0.0F, 0.0F, 1.0F, 0.0F);
    public static final Vector4 W = new Vector4(0.0F, 0.0F, 0.0F, 1.0F);
    public static final Vector4 Zero = new Vector4(0.0F, 0.0F, 0.0F, 0.0F);
    private static final Matrix4 tmpMat = new Matrix4();


    public Vector4() {}

    public Vector4(float x, float y, float z, float w){
        this.set(x, y, z, w);
    }

    public Vector4(Vector4 vector) {
        this.set(vector.x, vector.y, vector.z, vector.w);
    }

    public Vector4(Vector3 vector, float w) {
        this.set(vector.x, vector.y, vector.z, w);
    }

    @Override
    public Vector4 cpy() {
        return new Vector4(this);
    }

    @Override
    public float len() {
        return (float)Math.sqrt(this.x * this.x + this.y + this.y + this.z * this.z + this.w + this.w);
    }

    @Override
    public float len2() {
        return this.x * this.x + this.y + this.y + this.z * this.z + this.w + this.w;
    }

    @Override
    public Vector4 limit(float limit) {
        return this.limit2(limit * limit);
    }

    @Override
    public Vector4 limit2(float limit2) {
        float len2 = this.len2();
        if(len2 > limit2){
            this.scl((float)Math.sqrt(limit2/len2));
        }
        return this;
    }

    @Override
    public Vector4 setLength(float len) {
        return this.setLength2(len * len);
    }

    @Override
    public Vector4 setLength2(float len2) {
        float oldLen2 = this.len2();
        return oldLen2 != 0.0F && oldLen2 != len2 ? this.scl((float)Math.sqrt((double)(len2 / oldLen2))) : this;
    }

    @Override
    public Vector4 clamp(float min, float max) {
        float len2 = this.len2();
        if (len2 == 0.0F) {
            return this;
        } else {
            float max2 = max * max;
            if (len2 > max2) {
                return this.scl((float)Math.sqrt((double)(max2 / len2)));
            } else {
                float min2 = min * min;
                return len2 < min2 ? this.scl((float)Math.sqrt((double)(min2 / len2))) : this;
            }
        }
    }

    public  Vector4 set(float x ,float y ,float z, float w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    @Override
    public Vector4 set(Vector4 vector) {
        this.x = vector.x;
        this.y = vector.y;
        this.z = vector.z;
        this.w = vector.w;
        return this;
    }

    public  Vector4 sub(float x, float y, float z, float w){
        return this.set(this.x - x, this.y - y, this.z - z, this.w - w);
    }

    @Override
    public Vector4 sub(Vector4 vector) {
        return this.sub(vector.x, vector.y, vector.z, vector.w);
    }

    public Vector4 sub(float value){
        return  this.set(this.x - value, this.y - value, this.z - value, this.w - value);
    }

    @Override
    public Vector4 nor() {
        float len2 = this.len2();
        return len2 != 0.0F && len2 != 1.0F ? this.scl(1.0F / (float)Math.sqrt((double)len2)) : this;
    }

    @Override
    public Vector4 add(Vector4 vector) {
        return this.add(vector.x, vector.y, vector.z, vector.w);
    }

    public  Vector4 add(float value){
        return this.set(this.x + value, this.y + value, this.z + value, this.w + value);
    }

    public  Vector4 add(float x, float y, float z, float w){
        return this.set(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    public static float dot(float x1, float y1, float z1, float w1, float x2, float y2, float z2, float w2) {
        return x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2;
    }

    @Override
    public float dot(Vector4 vector) {
        return this.x * vector.x + this.y * vector.y + this.z + vector.z + this.w * vector.w;
    }

    public  float dot(float x, float y, float z, float w) {
        return  this.x * x + this.y * y + this.z * z + this.w * w;
    }

    @Override
    public Vector4 scl(float scalar) {
        return this.set(this.x * scalar, this.y * scalar, this.z * scalar, this.w * scalar);
    }

    @Override
    public Vector4 scl(Vector4 other) {
        return  this.set(this.x * other.x, this.y * other.y, this.z * other.z, this.w * other.w);
    }

    public  Vector4 scl(float vx, float vy, float vz, float vw) {
        return  this.set(this.x * vx, this.y * vy, this.z * vz, this.w * vw);
    }

    public  static float dst(float x1, float y1, float z1, float w1, float x2, float y2, float z2, float w2){
        float a = x2 - x1;
        float b = y2 - y1;
        float c = z2 - z1;
        float d = w2 - w1;
        return  (float)Math.sqrt((double)(a * a + b * b + c * c + d * d));
    }

    @Override
    public float dst(Vector4 vector) {
        float a = vector.x - this.x;
        float b = vector.y - this.y;
        float c = vector.z - this.z;
        float d = vector.w - this.w;
        return  (float)Math.sqrt((double)(a * a + b * b + c * c + d * d));
    }

    @Override
    public float dst2(Vector4 vector) {
        float a = vector.x - this.x;
        float b = vector.y - this.y;
        float c = vector.z - this.z;
        float d = vector.w - this.w;
        return a * a + b * b + c * c + d * d;
    }

    @Override
    public Vector4 lerp(Vector4 target, float alpha) {
        this.x += alpha * (target.x - this.x);
        this.y += alpha * (target.y - this.y);
        this.z += alpha * (target.z - this.z);
        this.w += alpha * (target.w - this.w);
        return this;
    }

    @Override
    public Vector4 interpolate(Vector4 target, float alpha, Interpolation interpolation) {
        return  this.lerp(target,interpolation.apply(0.0f,1.0f, alpha));
    }

    public Vector4 setFromHyperSphere(float thetaAngle, float phiAngle, float psiAngle)
    {
        float cosPsi = MathUtils.cos(psiAngle);
        float sinPsi  = MathUtils.sin(psiAngle);
        float cosPhi = MathUtils.cos(phiAngle);
        float sinPhi = MathUtils.sin(phiAngle);
        float cosTheta = MathUtils.cos(thetaAngle);
        float sinTheta = MathUtils.sin(thetaAngle);
        return  this.set(sinPsi * sinPhi * cosTheta,sinPsi * sinPhi * sinTheta,sinPsi * cosPhi,cosPsi);
    }

    @Override
    public Vector4 setToRandomDirection() {
        float u = MathUtils.random();
        float v = MathUtils.random();
        float w = MathUtils.random();
        float theta = 6.2831855F * u;
        float phi = (float)Math.acos((double)(2.0F * v - 1.0F));
        float psi = (float)Math.acos((double)(2.0F * w - 1.0f));
        return this.setFromHyperSphere(theta, phi, psi);
    }

    @Override
    public boolean isUnit() {
        return this.isUnit(1.0E-9F);
    }

    @Override
    public boolean isUnit(float margin) {
        return Math.abs(this.len2() - 1.0F) < margin;
    }

    @Override
    public boolean isZero() {
        return this.x == 0.0F && this.y == 0.0F && this.z == 0.0F && this.w == 0.0F;
    }

    @Override
    public boolean isZero(float margin) {
        return this.len2() < margin;
    }

    @Override
    public boolean isOnLine(Vector4 vector, float epsilon) {

        return false;
    }

    @Override
    public boolean isOnLine(Vector4 vector) {
        return false;
    }

    @Override
    public boolean isCollinear(Vector4 vector4, float v) {
        return false;
    }

    @Override
    public boolean isCollinear(Vector4 vector4) {
        return false;
    }

    @Override
    public boolean isCollinearOpposite(Vector4 vector4, float v) {
        return false;
    }

    @Override
    public boolean isCollinearOpposite(Vector4 vector4) {
        return false;
    }

    @Override
    public boolean isPerpendicular(Vector4 vector) {
        return MathUtils.isZero(this.dot(vector));
    }


    @Override
    public boolean isPerpendicular(Vector4 vector, float epsilon) {
        return  MathUtils.isZero(this.dot(vector),epsilon);
    }

    @Override
    public boolean hasSameDirection(Vector4 vector4) {
        return false;
    }

    @Override
    public boolean hasOppositeDirection(Vector4 vector4) {
        return false;
    }

    @Override
    public boolean epsilonEquals(Vector4 other, float epsilon) {
        if(other == null) {
            return  false;
        } else if(Math.abs(other.x - this.x) > epsilon) {
            return  false;
        } else if(Math.abs(other.y - this.y) > epsilon) {
            return  false;
        } else if(Math.abs(other.z - this.z) > epsilon) {
            return  false;
        } else  {
            return Math.abs(other.w - this.w) <= epsilon;
        }

    }

    public boolean epsilonEquals(float x, float y, float z, float epsilon) {
        if(Math.abs(x - this.x) > epsilon) {
            return  false;
        } else if(Math.abs(y - this.y) > epsilon) {
            return  false;
        } else if(Math.abs(z - this.z) > epsilon) {
            return  false;
        } else  {
            return Math.abs(w - this.w) <= epsilon;
        }

    }

    @Override
    public Vector4 mulAdd(Vector4 vec, float scalar) {
        this.x += vec.x * scalar;
        this.y += vec.y * scalar;
        this.z += vec.z * scalar;
        this.w += vec.w * scalar;
        return this;
    }

    @Override
    public Vector4 mulAdd(Vector4 vec, Vector4 mulVec) {
        this.x += vec.x * mulVec.x;
        this.y += vec.y * mulVec.y;
        this.z += vec.z * mulVec.z;
        this.w += vec.w * mulVec.w;
        return this;
    }

    @Override
    public Vector4 setZero() {
        this.x = 0.0F;
        this.y = 0.0F;
        this.z = 0.0F;
        this.w = 0.0F;
        return this;
    }

    @Override
    public String toString() {
        return  "(" + this.x + "," + this.y + "," + this.z + "," + this.w + ")";
    }


}
