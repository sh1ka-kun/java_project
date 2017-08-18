package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests
{
    @Test
    public void TestDistance_5()
    {
        Point A = new Point(5,6);
        Point B = new Point(1,3);
        Assert.assertEquals(A.distance(B), 5.0);
    }

    @Test
    public void TestDistance_0()
    {
        Point A = new Point(100,100);
        Point B = new Point(100,100);
        Assert.assertEquals(A.distance(B), 0.0);
    }

    @Test
    public void TestDistance_100()
    {
        Point A = new Point(0,0);
        Point B = new Point(100,0);
        Assert.assertEquals(A.distance(B), 100.0);
    }
}
