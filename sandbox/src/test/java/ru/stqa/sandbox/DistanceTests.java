package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests
{
    @Test
    public void TestDistance_5()
    {
        Point p = new Point(5,6,1,3);
        Assert.assertEquals(p.distance(), 5.0);
    }

    @Test
    public void TestDistance_0()
    {
        Point p = new Point(100,100,100,100);
        Assert.assertEquals(p.distance(), 0.0);
    }

    @Test
    public void TestDistance_100()
    {
        Point p = new Point(0,0,100,0);
        Assert.assertEquals(p.distance(), 100.0);
    }
}
