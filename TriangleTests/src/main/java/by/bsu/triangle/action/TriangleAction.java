package by.bsu.triangle.action;

import by.bsu.triangle.exception.TriangleException;

public class TriangleAction {
    public boolean isTrianglePossible(Double a, Double b, Double c) {
        if (a == null || b == null || c == null) {
            throw new TriangleException("null side passed");
        }
        if (Double.compare(a, Double.NaN) * Double.compare(b, Double.NaN) * Double.compare(c, Double.NaN) == 0) {
            throw new TriangleException("Not a number passed");
        }
        if (a == 0 || b == 0 || c == 0) {
            throw new TriangleException("Zero side passed");
        }
        if (a == Double.NEGATIVE_INFINITY || b == Double.NEGATIVE_INFINITY || c == Double.NEGATIVE_INFINITY) {
            throw new TriangleException("Negative infinity side passed");
        }
        if (a < 0 || b < 0 || c < 0) {
            throw new TriangleException("Negative length side passed");
        }
        if (a == Double.POSITIVE_INFINITY || b == Double.POSITIVE_INFINITY || c == Double.POSITIVE_INFINITY) {
            throw new TriangleException("Side cannot be of infinity length");
        }
        if (a + b > c && b + c > a && a + c > b) {
            return true;
        }
        return false;
    }
}
