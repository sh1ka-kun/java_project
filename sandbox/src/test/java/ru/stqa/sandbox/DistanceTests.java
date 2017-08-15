package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests
{
    @Test
    public void TestDistance_5()
    {
        Point p = new Point(5,6,1,3);
        Distance d = new Distance(p.distance()[0], p.distance()[1]);
        Assert.assertEquals(d.distance(), 5.0);
    }

    @Test
    public void TestDistance_0()
    {
        Point p = new Point(100,100,100,100);
        Distance d = new Distance(p.distance()[0], p.distance()[1]);
        Assert.assertEquals(d.distance(), 0.0);
    }

    @Test
    public void TestDistance_100()
    {
        Point p = new Point(0,0,100,0);
        Distance d = new Distance(p.distance()[0], p.distance()[1]);
        Assert.assertEquals(d.distance(), 100.0);
    }
}
