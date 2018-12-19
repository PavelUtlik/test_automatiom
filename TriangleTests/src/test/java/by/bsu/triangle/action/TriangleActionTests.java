package by.bsu.triangle.action;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.bsu.triangle.exception.TriangleException;

public class TriangleActionTests {
    TriangleAction triangleAction;

    @BeforeMethod
    public void init() {
        triangleAction = new TriangleAction();
    }

    @DataProvider
    Double[][] zeroSides() {
        return new Double[][] { { 0.0, 1.0, 1.0 }, { 1.0, 0.0, 1.0 }, { 1.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0 },
                { 0.0, 1.0, 0.0 }, { 1.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0 } };
    }

    @DataProvider
    Double[][] negativeSides() {
        return new Double[][] { { -1.0, 1.0, 1.0 }, { 1.0, -1.0, 1.0 }, { 1.0, 1.0, -1.0 }, { -1.0, -1.0, 1.0 },
                { -1.0, 1.0, -1.0 }, { 1.0, 1.0, -1.0 }, { -1.0, -1.0, -1.0 } };
    }

    @DataProvider
    Double[][] nullSides() {
        return new Double[][] { { null, 1.0, 1.0 }, { 1.0, null, 1.0 }, { 1.0, 1.0, null }, { null, null, 1.0 },
                { null, 1.0, null }, { 1.0, 1.0, null }, { null, null, null } };
    }

    @DataProvider
    Double[][] naNSides() {
        return new Double[][] { { Double.NaN, 1.0, 1.0 }, { 1.0, Double.NaN, 1.0 }, { 1.0, 1.0, Double.NaN },
                { Double.NaN, Double.NaN, 1.0 }, { Double.NaN, 1.0, Double.NaN }, { 1.0, 1.0, Double.NaN },
                { Double.NaN, Double.NaN, Double.NaN } };
    }

    @DataProvider
    Double[][] negativeInifinitySides() {
        return new Double[][] { { Double.NEGATIVE_INFINITY, 1.0, 1.0 }, { 1.0, Double.NEGATIVE_INFINITY, 1.0 },
                { 1.0, 1.0, Double.NEGATIVE_INFINITY }, { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 1.0 },
                { Double.NEGATIVE_INFINITY, 1.0, Double.NEGATIVE_INFINITY }, { 1.0, 1.0, Double.NEGATIVE_INFINITY },
                { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY } };
    }

    @Test
    public void mainSuccessScenario() {
        Assert.assertTrue(triangleAction.isTrianglePossible(1.1, 1.2, 1.3));
    }

    @Test
    public void mainNegativeScenario() {
        Assert.assertFalse(triangleAction.isTrianglePossible(2.0, 1.0, 4.0));
    }

    @Test
    public void mainSuccessScenarioEquilateralTriangle() {
        Assert.assertTrue(triangleAction.isTrianglePossible(1.0, 1.0, 1.0));
    }

    @Test
    public void mainPositiveScenarioIsoscelesTriangle() {
        Assert.assertTrue(triangleAction.isTrianglePossible(1.0, 1.0, 1.5));
    }

    @Test
    public void mainNegativeScenarioIsoscelesTriangle() {
        Assert.assertFalse(triangleAction.isTrianglePossible(1.0, 1.0, 2.5));
    }

    @Test(dataProvider = "zeroSides", expectedExceptions = { TriangleException.class })
    public void isRejectsZeroLengthSides(Double a, Double b, Double c) {
        triangleAction.isTrianglePossible(a, b, c);
    }

    @Test(dataProvider = "nullSides", expectedExceptions = { TriangleException.class })
    public void isRejectsNullSides(Double a, Double b, Double c) {
        triangleAction.isTrianglePossible(a, b, c);
    }

    @Test(dataProvider = "naNSides", expectedExceptions = { TriangleException.class })
    public void isRejectsNaNSides(Double a, Double b, Double c) {
        triangleAction.isTrianglePossible(a, b, c);
    }

    @Test(dataProvider = "negativeSides", expectedExceptions = { TriangleException.class })
    public void isRejectsNegativeSides(Double a, Double b, Double c) {
        triangleAction.isTrianglePossible(a, b, c);
    }

    @Test(dataProvider = "negativeInifinitySides", expectedExceptions = { TriangleException.class })
    public void isRejectsNegativeInfinitySides(Double a, Double b, Double c) {
        triangleAction.isTrianglePossible(a, b, c);
    }
}
